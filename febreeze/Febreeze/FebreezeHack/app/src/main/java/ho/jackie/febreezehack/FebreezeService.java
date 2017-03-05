package ho.jackie.febreezehack;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 * Created by JH on 3/4/17.
 */

public interface FebreezeService {

    @POST("test1")
    Call<Void> changeLightColor();

    @POST("test2")
    Call<Void> activateMotionSensor();

    @FormUrlEncoded
    @POST("controller/vacation")
    Call<Void> sendLocation(@Field("location") String location, @Field("duration") int duration, @Field("temp") double temp);
}
