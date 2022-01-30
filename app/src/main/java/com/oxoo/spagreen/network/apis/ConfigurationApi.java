package com.oxoo.spagreen.network.apis;

import com.oxoo.spagreen.network.model.Configuration;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ConfigurationApi {

    @GET("config")
    Call<Configuration> getConfigurationData(@Header("API-KEY") String apiKey);
}

