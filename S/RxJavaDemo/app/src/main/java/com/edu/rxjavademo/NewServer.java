package com.edu.rxjavademo;

import com.edu.rxjavademo.model.gitmodel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2016/11/17.
 */

public class NewServer {
    /**
     * 根据newsid获取对应的资讯数据
     * 如果不需要转换成Json数据,可以用了ResponseBody;
     * @param newsId
     * @return call
     */
    @GET("News/{newsId}")
    Call<gitmodel> getNews(@Path("newsId") String newsId);
}
