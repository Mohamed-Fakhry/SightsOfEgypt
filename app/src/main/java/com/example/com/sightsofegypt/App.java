package com.example.com.sightsofegypt;

import android.app.Application;

import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.example.com.sightsofegypt.service.Constant;
import com.example.com.sightsofegypt.service.Service;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    public static Service service;

    @Override
    public void onCreate() {
        super.onCreate();

//        initCalligraphyConfig();
        createApi();
    }

    private void createApi() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(Service.class);
    }

    private void initCalligraphyConfig() {
//        CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
//                .setDefaultFontPath(getString(R.string.font_name))
//                .setFontAttrId(R.attr.fontPath)
//                .build());
    }

}
