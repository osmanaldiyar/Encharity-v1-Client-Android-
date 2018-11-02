package com.encharity.encharity_v1.blog;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.encharity.encharity_v1.R;
import com.encharity.encharity_v1.archive.Archive;

public class BlogDetailsActivity extends AppCompatActivity {
    public final static String EXTRA_BLOG_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archive_details);

        int patientId = (Integer)getIntent().getExtras().getInt(EXTRA_BLOG_ID);

        String blogTitle = Blog.blogItems[patientId].getTitle();
        TextView blogTextView = (TextView)findViewById(R.id.blog_details_title);
        blogTextView.setText(blogTitle);

        int blogImage = Blog.blogItems[patientId].getPhotoId();
        ImageView blogImageView = (ImageView)findViewById(R.id.blog_details_photo);
        blogImageView.setImageDrawable(ContextCompat.getDrawable(this,blogImage));
        blogImageView.setContentDescription(blogTitle);

        String blogDescription = Blog.blogItems[patientId].getDescription();
        TextView blogDescriptionTxt = (TextView) findViewById(R.id.blog_details_description);
        blogDescriptionTxt.setText(blogDescription);
    }
}
