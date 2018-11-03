package com.encharity.encharity_v1.blog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.encharity.encharity_v1.R;
import com.encharity.encharity_v1.api.BlogService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BlogActivity extends AppCompatActivity {

    private List<Blog> blogList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.blog_recycler_view);
        blogList = new ArrayList<>();

        /*int[] photos = new int[Blog.blogItems.length];
        String[] titles = new String[Blog.blogItems.length];
        String[] descriptions = new String[Blog.blogItems.length];
        for(int i = 0; i < Blog.blogItems.length;i++){
            photos[i] = Blog.blogItems[i].getPhotoId();
            titles[i] = Blog.blogItems[i].getTitle();
            descriptions[i] = Blog.blogItems[i].getDescription();
        }*/

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.195:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BlogService blogService = retrofit.create(BlogService.class);
        Call<List<Blog>> repos = blogService.getAllBlogItems();

        final BlogAdapter blogAdapter = new BlogAdapter(blogList);

        //
        repos.enqueue(new Callback<List<Blog>>() {
            @Override
            public void onResponse(Call<List<Blog>> call, Response<List<Blog>> response) {
                Toast.makeText(getApplicationContext(), String.format("OK"), Toast.LENGTH_SHORT).show();
                if(response.isSuccessful()) {
                    blogList = response.body();
                    blogAdapter.setBlogList(blogList);
                }
            }

            @Override
            public void onFailure(Call<List<Blog>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), String.format("KO"), Toast.LENGTH_SHORT).show();
            }

        });
        //

        recyclerView.setAdapter(blogAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        blogAdapter.setListener(new BlogAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(BlogActivity.this,BlogDetailsActivity.class);
                intent.putExtra(BlogDetailsActivity.EXTRA_BLOG_ID, position);
                startActivity(intent);
            }
        });

    }



}
