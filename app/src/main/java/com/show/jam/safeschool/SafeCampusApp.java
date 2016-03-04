package com.show.jam.safeschool;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.show.jam.safeschool.model.User;
import com.smartydroid.android.starter.kit.*;
import com.smartydroid.android.starter.kit.BuildConfig;
import com.smartydroid.android.starter.kit.account.Account;
import com.smartydroid.android.starter.kit.app.StarterKitApp;
import com.smartydroid.android.starter.kit.retrofit.RetrofitBuilder;

import java.io.IOException;

/**
 * Created by 99165 on 2016/3/2.
 */
public class SafeCampusApp extends StarterKitApp {

    @Override
    public void onCreate() {
        new StarterKit.Builder()
                .setDebug(BuildConfig.DEBUG)
                .build();
        super.onCreate();

//        init api service
        new RetrofitBuilder.Builder()
//                .accept(Profile.API_ACCEPT)
                .baseUrl(Profile.API_ENDPOINT)
                .build();
        Fresco.initialize(this);
    }

    @Override
    public Account accountFromJson(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return (Account) mapper.readValue(json, User.class);
        }catch (IOException e){
            //Nothing to do
        }
        return null;
    }

    @Override
    public String accept() {
        return null;
    }
}
