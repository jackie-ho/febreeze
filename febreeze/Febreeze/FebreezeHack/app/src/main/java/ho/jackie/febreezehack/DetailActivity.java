package ho.jackie.febreezehack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.piasy.rxandroidaudio.PlayConfig;
import com.github.piasy.rxandroidaudio.RxAudioPlayer;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class DetailActivity extends AppCompatActivity {

    ImageView circleImage;
    ImageView detailImage;
    RecyclerView moreLikeRecycler;
    RxAudioPlayer mAudioPlayer;

    TextView lightText;
    TextView tempText;
    TextView windText;
    TextView humidityText;
    TextView scentText;
    TextView soundText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailImage = (ImageView) findViewById(R.id.detail_image);
        circleImage = (ImageView) findViewById(R.id.circle_image);
        lightText = (TextView) findViewById(R.id.light_text);
        tempText = (TextView) findViewById(R.id.temp_text);
        windText = (TextView) findViewById(R.id.wind_text);
        humidityText = (TextView) findViewById(R.id.humidity_text);
        scentText = (TextView) findViewById(R.id.scent_text);
        soundText = (TextView) findViewById(R.id.sound_text);
        moreLikeRecycler = (RecyclerView) findViewById(R.id.more_like_list);

        Picasso.with(this)
                .load("https://media-cdn.tripadvisor.com/media/photo-s/0d/7c/ee/53/big-sur.jpg")
                .transform(new CircleTransform())
                .into(circleImage);

        moreLikeRecycler.setLayoutManager(new GridLayoutManager(this, 3));
        moreLikeRecycler.setAdapter(new DetailRecyclerAdapter(this));

        mAudioPlayer = RxAudioPlayer.getInstance();

        circleImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiManager.getInstance().changeLight().enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(DetailActivity.this, "PURPLE LIGHT", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
            }
        });
        detailImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiManager.getInstance().motionSensor().enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(DetailActivity.this, "MOTION SENSOR", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAudioPlayer.play(
                PlayConfig
                        .res(getApplicationContext(), R.raw.rainforest_ambience)
                        .looping(true) // loop or not
                        .leftVolume(1.0F) // left volume
                        .rightVolume(1.0F) // right volume
                        .build())
                .subscribeOn(Schedulers.io())
                .subscribe();

        displayWeather("Sichuan National Park");
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAudioPlayer.stopPlay();
    }

    private void displayWeather(String location){
        ApiManager
                .getInstance()
                .geocode(location)
                .observeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())
                .flatMap(new Func1<GeocodeResult, Observable<DarkSkyModel>>() {
                    @Override
                    public Observable<DarkSkyModel> call(GeocodeResult geocodeResult) {
                        if (geocodeResult.results != null && geocodeResult.results.size() > 0) {
                            LatLng latLng = geocodeResult.results.get(0).getGeometry().getLocation();
                            return ApiManager.getInstance().weather(latLng.getLat(), latLng.getLon());
                        }
                        return Observable.empty();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DarkSkyModel>() {
                    @Override
                    public void onCompleted() {
                        Log.v("Detail", "weather completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                            Log.e("detail", e.getMessage());
                    }

                    @Override
                    public void onNext(DarkSkyModel darkSkyModel) {
                        displayWeather(darkSkyModel);
                    }
                });
    }

    private void displayWeather(DarkSkyModel darkSkyModel) {
        if (darkSkyModel != null) {
            Weather weather = darkSkyModel.getCurrently();
            lightText.setText("LIGHT: " + weather.getCloudCover());
            tempText.setText("TEMP: " + weather.getTemperature()+"F");
            humidityText.setText("HUMIDITY: " + weather.getHumidity()+"%");
            windText.setText("WIND: "+ weather.getWindSpeed()+"MPH");

            int duration = weather.getWindSpeed() >= 5 ? 15 : 0;
            ApiManager.getInstance().sendWeather("Sichuan National Park", duration, weather.getTemperature())
                    .enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {

                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {

                        }
                    });
        }
    }
}
