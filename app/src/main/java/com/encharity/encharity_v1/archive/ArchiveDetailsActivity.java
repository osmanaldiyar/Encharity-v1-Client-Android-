package com.encharity.encharity_v1.archive;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.encharity.encharity_v1.R;

public class ArchiveDetailsActivity extends AppCompatActivity {

    public final static String EXTRA_ARCHIVE_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archive_details);

        int patientId = (Integer)getIntent().getExtras().getInt(EXTRA_ARCHIVE_ID);

        String title = Archive.archiveItems[patientId].getTitle();
        TextView textView = (TextView)findViewById(R.id.archive_details_title);
        textView.setText(title);

        int archiveImage = Archive.archiveItems[patientId].getPhotoId();
        ImageView archiveImageView = (ImageView)findViewById(R.id.archive_details_photo);
        archiveImageView.setImageDrawable(ContextCompat.getDrawable(this,archiveImage));
        archiveImageView.setContentDescription(title);

        String archiveDescription = Archive.archiveItems[patientId].getDescription();
        TextView archiveDescriptionTxt = (TextView) findViewById(R.id.archive_details_description);
        archiveDescriptionTxt.setText(archiveDescription);
    }
}
