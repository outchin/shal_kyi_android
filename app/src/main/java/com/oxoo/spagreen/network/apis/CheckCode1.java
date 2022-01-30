package com.oxoo.spagreen.network.apis;

import com.oxoo.spagreen.models.home_content.checkCodeModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface CheckCode1 {
 
    @GET("checkCode4")
    Call<List<checkCodeModel>> checkCode(@Query("API-KEY") String apiKey,
                                         @Query("code") String code,
                                         @Query("device_id") String device_id);

}
