package com.example.manco.myapplication.HttpController;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
/**
 * Created by Marjan, Tim, Robin, Khaled on 2016-10-17.
 */
public class HttpClient {
    private static OkHttpClient client = new OkHttpClient();

    public static OkHttpClient getHttpClient() {
        return client;
    }

    public static void makeRequest(String url, Callback callback) {
        Request request = new Request.Builder().url(url).build();

        HttpClient.getHttpClient().newCall(request).enqueue(callback);
    }
}
