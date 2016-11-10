package com.blog.singleton;

import com.blog.rest.WpApi;

import retrofit.RestAdapter;

/**
 * Created by Tosin Onikute on 4/21/16.
 */
public class RestClient {

    private static WpApi REST_CLIENT;
    private static String BASE_URL = "http://roismedia.com/testapp";

    public RestClient() {}

    public static WpApi getInstance() {
        if (REST_CLIENT == null) {
            setupRestClient();
        }
        return REST_CLIENT;
    }


    private static void setupRestClient() {
        RestAdapter restAdapter = new RestAdapter.Builder()
        .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(BASE_URL)
                .build();
        REST_CLIENT = restAdapter.create(WpApi.class);
    }
}
