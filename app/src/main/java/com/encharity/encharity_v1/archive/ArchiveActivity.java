package com.encharity.encharity_v1.archive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.encharity.encharity_v1.R;

public class ArchiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archive);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.archive_recycler_view);

        int[] photos = new int[Archive.archiveItems.length];
        String[] titles = new String[Archive.archiveItems.length];
        String[] descriptions = new String[Archive.archiveItems.length];
        for(int i = 0; i < Archive.archiveItems.length;i++){
            photos[i] = Archive.archiveItems[i].getPhotoId();
            titles[i] = Archive.archiveItems[i].getTitle();
            descriptions[i] = Archive.archiveItems[i].getDescription();
        }


        ArchiveAdapter archiveAdapter = new ArchiveAdapter(photos,titles,descriptions);
        recyclerView.setAdapter(archiveAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        archiveAdapter.setListener(new ArchiveAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(ArchiveActivity.this,ArchiveDetailsActivity.class);
                intent.putExtra(ArchiveDetailsActivity.EXTRA_ARCHIVE_ID, position);
                startActivity(intent);
            }
        });

    }



}
