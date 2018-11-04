package com.encharity.encharity_v1.archive;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.encharity.encharity_v1.R;
import com.encharity.encharity_v1.api.APIUtils;
import com.encharity.encharity_v1.api.ArchiveService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ArchiveDetailsActivity extends AppCompatActivity {

    public final static String EXTRA_ARCHIVE_ID = "archiveid";
    private Archive archive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archive_details);


        //


        ArchiveService archiveService = APIUtils.getArchiveService();
        int archiveId = (Integer)getIntent().getExtras().getInt(EXTRA_ARCHIVE_ID) + 1;
        Call<Archive> repos = archiveService.getArchive(archiveId);

        repos.enqueue(new Callback<Archive>() {
            @Override
            public void onResponse(Call<Archive> call, Response<Archive> response) {
                Toast.makeText(getApplicationContext(), String.format("OK"), Toast.LENGTH_SHORT).show();
                if(response.isSuccessful()) {
                    archive = response.body();

                    String title = archive.getArchiveTitle();
                    TextView textView = (TextView)findViewById(R.id.archive_details_title);
                    textView.setText(title);

                    int archiveImage = archive.getArchivePhotoId();
                    ImageView archiveImageView = (ImageView)findViewById(R.id.archive_details_photo);
                    archiveImageView.setImageDrawable(ContextCompat.getDrawable(ArchiveDetailsActivity.this,archiveImage));
                    archiveImageView.setContentDescription(title);

                    String archiveDescription = archive.getArchiveDescription();
                    TextView archiveDescriptionTxt = (TextView) findViewById(R.id.archive_details_description);
                    archiveDescriptionTxt.setText(archiveDescription);
                }
            }

            @Override
            public void onFailure(Call<Archive> call, Throwable t) {
                Toast.makeText(getApplicationContext(), String.format("Please, check internet connection."), Toast.LENGTH_SHORT).show();
            }

        });
        //


    }
}
