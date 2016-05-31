package com.lisao.attendance.service;

import com.lisao.attendance.config.ConstantValues;
import okhttp3.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;

/**
 * Created by lisao on 2016/5/2.
 */
public class FaceCoreHttp {
    private static FaceCoreHttp mInstance;
    private URLConnection connection;
    private static OkHttpClient client;


    public static final MediaType JSON
            = MediaType.parse("application/json;charset=utf-8");

    private FaceCoreHttp() {
        client = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
    }

    public static FaceCoreHttp getInstance() {
        if (mInstance == null) {
            synchronized (FaceCoreHttp.class) {
                if (mInstance == null) {
                    mInstance = new FaceCoreHttp();
                }
            }
        }
        return mInstance;
    }

    public String post(String url, String params) throws IOException {
        RequestBody body = RequestBody.create(JSON, params);
        Request request = new Request.Builder()
                .url(compilerUrl(url))
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        String result = response.body().string();
        response.close();
        return result;
    }

    public String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(compilerUrl(url))
                .get()
                .build();
        Response response = client.newCall(request).execute();
        String result = response.body().string();
        response.close();
        return result;
    }


    private String compilerUrl(String url) {
        url = ConstantValues.FACECORE_SERVER + url;
        url = url + "?appkey=" + ConstantValues.FACECORE_KEY;
        return url;
    }

}
