package com.show.jam.safeschool.api;

import com.show.jam.safeschool.api.service.FeedService;
import com.smartydroid.android.starter.kit.retrofit.RetrofitBuilder;

import retrofit2.Retrofit;

/**
 * Created by 99165 on 2016/3/2.
 */
public class ApiSevice {

    public static FeedService createFeedService(){
        return retrofit().create(FeedService.class);
    }

    private static Retrofit retrofit(){
        return RetrofitBuilder.get().retrofit();
    }
}
