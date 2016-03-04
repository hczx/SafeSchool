package com.show.jam.safeschool.api.service;

import com.show.jam.safeschool.model.Feed;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 99165 on 2016/3/2.
 */
public interface FeedService {
    @GET("/feeds")
    Call<ArrayList<Feed>> getFeedsWith(@Query("max-id") String maxId,
                                       @Query("since-id") String sinceId, @Query("page_size") int pageSize);
}
