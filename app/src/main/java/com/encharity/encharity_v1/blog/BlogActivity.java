package com.encharity.encharity_v1.blog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.encharity.encharity_v1.R;
import com.encharity.encharity_v1.archive.Archive;
import com.encharity.encharity_v1.archive.ArchiveAdapter;
import com.encharity.encharity_v1.archive.ArchiveDetailsActivity;

public class BlogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.blog_recycler_view);

        int[] photos = new int[Blog.blogItems.length];
        String[] titles = new String[Blog.blogItems.length];
        String[] descriptions = new String[Blog.blogItems.length];
        for(int i = 0; i < Blog.blogItems.length;i++){
            photos[i] = Blog.blogItems[i].getPhotoId();
            titles[i] = Blog.blogItems[i].getTitle();
            descriptions[i] = Blog.blogItems[i].getDescription();
        }


        BlogAdapter blogAdapter = new BlogAdapter(photos,titles,descriptions);
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
