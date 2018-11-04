package com.encharity.encharity_v1.blog;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.encharity.encharity_v1.R;
import com.encharity.encharity_v1.api.APIUtils;
import com.encharity.encharity_v1.api.BlogService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BlogDetailsActivity extends AppCompatActivity {
    public final static String EXTRA_BLOG_ID = "id";
    private Blog blog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archive_details);

        //


        BlogService blogService = APIUtils.getBlogService();
        int blogId = (Integer)getIntent().getExtras().getInt(EXTRA_BLOG_ID) + 1;
        Call<Blog> repos = blogService.getBlog(blogId);

        repos.enqueue(new Callback<Blog>() {
            @Override
            public void onResponse(Call<Blog> call, Response<Blog> response) {
                Toast.makeText(getApplicationContext(), String.format("OK"), Toast.LENGTH_SHORT).show();
                if(response.isSuccessful()) {
                    blog = response.body();

                    String blogTitle = blog.getBlogTitle();
                    TextView blogTextView = (TextView)findViewById(R.id.blog_details_title);
                    blogTextView.setText(blogTitle);

                    int blogImage = blog.getBlogPhotoId();
                    ImageView blogImageView = (ImageView)findViewById(R.id.blog_details_photo);
                    blogImageView.setImageDrawable(ContextCompat.getDrawable(BlogDetailsActivity.this,blogImage));
                    blogImageView.setContentDescription(blogTitle);

                    String blogDescription = blog.getBlogDescription();
                    TextView blogDescriptionTxt = (TextView) findViewById(R.id.blog_details_description);
                    blogDescriptionTxt.setText(blogDescription);

                }
            }

            @Override
            public void onFailure(Call<Blog> call, Throwable t) {
                Toast.makeText(getApplicationContext(), String.format("Please, check internet connection."), Toast.LENGTH_SHORT).show();
            }

        });
        //

    }
}
