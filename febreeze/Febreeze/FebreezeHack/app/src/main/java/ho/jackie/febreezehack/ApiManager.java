package ho.jackie.febreezehack;

import android.database.Observable;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by JH on 3/4/17.
 */

public class ApiManager {

    private static ApiManager instance;

    private Retrofit myRetrofit;
    private Retrofit weatherRetrofit;
    private Retrofit geocodeRetrofit;
    private OkHttpClient client;

    private ApiManager(){
        Retrofit.Builder builder = new Retrofit.Builder();

        HttpLoggingInterceptor logger = new HttpLoggingInterceptor();
        logger.setLevel(HttpLoggingInterceptor.Level.BODY);

        client = new OkHttpClient.Builder()
                .addInterceptor(logger)
                .build();

        builder.baseUrl("http://febreze.herokuapp.com/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();

        myRetrofit = builder.build();

        weatherRetrofit = builder
                .baseUrl("https://api.darksky.net/forecast/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        geocodeRetrofit = builder.baseUrl("https://maps.googleapis.com/maps/api/geocode/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


    }

    public static ApiManager getInstance() {
        if (instance == null) {
            instance = new ApiManager();
        }
        return instance;
    }

    public Call<Void> changeLight(){
        return myRetrofit.create(FebreezeService.class).changeLightColor();
    }

    public Call<Void> motionSensor(){
        return myRetrofit.create(FebreezeService.class).activateMotionSensor();
    }

    public rx.Observable<DarkSkyModel> weather(String lat, String lon){
        return weatherRetrofit.create(DarkSkyService.class).weather(DarkSkyService.SECRET,lat,lon);
    }

    public rx.Observable<GeocodeResult> geocode(String address) {
        return geocodeRetrofit.create(GoogleGeocodeService.class).geocode(address, GoogleGeocodeService.KEY);
    }

    public Call<Void> sendWeather(String location, int duration, double temp) {
        return myRetrofit.create(FebreezeService.class).sendLocation(location,duration,temp);
    }


}
