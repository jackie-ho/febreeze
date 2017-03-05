package ho.jackie.febreezehack;

import android.database.Observable;

import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by JH on 3/4/17.
 */

public interface GoogleGeocodeService {

    String KEY = "AIzaSyB1BOC3YrbaiuF7B-8TQj7-seS0q3KIvgA";

    @GET("json")
    rx.Observable<GeocodeResult> geocode(@Query("address") String address, @Query("key") String key);
}
