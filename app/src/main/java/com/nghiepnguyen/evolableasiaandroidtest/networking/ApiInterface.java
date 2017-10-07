package com.nghiepnguyen.evolableasiaandroidtest.networking;

import com.nghiepnguyen.evolableasiaandroidtest.model.CountryModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Nghiep Nguyen on 30-Sep-17.
 */

public interface ApiInterface {
    @GET("all")
    Call<List<CountryModel>> getAllCountriesByQuery();

    @GET("name/{name}")
    Call<List<CountryModel>> getCountryByName(@Path("name") String name);

    @GET("/name/{name}?fullText=true")
    Call<List<CountryModel>> getCountryByFullName(@Path("name") String name);

    @GET("alpha/{code}")
    Call<List<CountryModel>> getAllCountryISO_3166_1_2(@Path("code") String code);
}
