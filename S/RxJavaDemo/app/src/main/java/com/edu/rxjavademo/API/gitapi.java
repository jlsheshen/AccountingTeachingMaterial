package com.edu.rxjavademo.API;

import com.edu.rxjavademo.model.gitmodel;

import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2016/11/17.
 */

public interface gitapi {
    @GET("/users/{user}")      // here is the other url part.best way is to start using /
    public void getFeed(@Path("user") String user, Callback<gitmodel> response);
    // string user is for passing values from edittext for eg: user=basil2style,google
    // response is the response from the server which is now in the POJO
}
