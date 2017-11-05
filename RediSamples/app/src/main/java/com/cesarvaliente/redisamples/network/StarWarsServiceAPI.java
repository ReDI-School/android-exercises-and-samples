package com.cesarvaliente.redisamples.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StarWarsServiceAPI {

    @GET("people/")
    Call<People> people(@Query("page") int page);

    @GET("people/{peopleId}/")
    Call<Creature> creature(@Path("peopleId") String peopleId);
}
