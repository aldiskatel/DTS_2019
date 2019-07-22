package kominfo.go.id.direction.network;

import kominfo.go.id.direction.response.ResponseRoute;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServices {
    //https://maps.googleapis.com/maps/api/directions/
    // json?origin=Cirebon,ID&destination=Jakarta,ID&api_key=YOUR_API_KEY
    @GET("json")
    Call<ResponseRoute> request_route(
            @Query("origin") String origin,
            @Query("destination") String destination,
            @Query("key") String api_key
    );
}
