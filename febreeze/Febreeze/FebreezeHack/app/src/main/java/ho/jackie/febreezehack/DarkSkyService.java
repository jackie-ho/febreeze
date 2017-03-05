package ho.jackie.febreezehack;

import android.database.Observable;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by JH on 3/4/17.
 */

public interface DarkSkyService {

    public static final String SECRET = "e06e0214c10468638ae1e5c503784d97";

    @GET("{secret}/{lat},{lon}")
    rx.Observable<DarkSkyModel> weather(@Path("secret") String secret, @Path("lat") String lat, @Path("lon") String lon);
}
