package com.example.com.sightsofegypt;

import android.app.Application;

import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.example.com.sightsofegypt.data.api.Constant;
import com.example.com.sightsofegypt.data.api.Service;
import com.example.com.sightsofegypt.data.model.DaoMaster;
import com.example.com.sightsofegypt.data.model.DaoSession;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class App extends Application {

    public static Service service;
    public static DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        mDaoSession = new DaoMaster(
                new DaoMaster.DevOpenHelper(this, "sights.db").getWritableDb()).newSession();

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
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setFontAttrId(R.attr.fontPath)
                .build());
    }
}
