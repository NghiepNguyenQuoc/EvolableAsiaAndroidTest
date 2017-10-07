package com.nghiepnguyen.evolableasiaandroidtest.networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nghiep Nguyen on 30-Sep-17.
 */

public class ApiClient {
    private static final String TAG = "ApiClient";

    public static final String BASE_URL = "https://restcountries.eu/rest/v2/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
