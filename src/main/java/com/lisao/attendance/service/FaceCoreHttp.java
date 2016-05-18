package com.lisao.attendance.service;

import com.lisao.attendance.config.ConstantValues;
import okhttp3.*;

import java.io.IOException;

/**
 * Created by lisao on 2016/5/2.
 */
public class FaceCoreHttp {
    private static FaceCoreHttp mInstance;
    private static OkHttpClient client;

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    private FaceCoreHttp() {
        client = new OkHttpClient();
    }

    public static FaceCoreHttp getInstance() {
        if (mInstance == null) {
            synchronized (FaceCoreHttp.class) {
                mInstance = new FaceCoreHttp();
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
        return response.body().string();
    }

    public String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(compilerUrl(url))
                .get()
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }


    private String compilerUrl(String url) {
        url = ConstantValues.FACECORE_SERVER + url;
        url = url + "?appkey=" + ConstantValues.FACECORE_KEY;
        return url;
    }


}
