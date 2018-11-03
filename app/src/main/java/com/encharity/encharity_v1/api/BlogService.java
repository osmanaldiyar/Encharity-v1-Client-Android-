package com.encharity.encharity_v1.api;

import com.encharity.encharity_v1.blog.Blog;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BlogService {

    @GET("blog/")
    Call<List<Blog>> getAllBlogItems();

    @GET("blog/{id}")
    Call<Blog> getBlog(@Path("id") int id);

}
