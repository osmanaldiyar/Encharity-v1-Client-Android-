package com.encharity.encharity_v1.archive;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.encharity.encharity_v1.R;
import com.encharity.encharity_v1.api.APIUtils;
import com.encharity.encharity_v1.api.ArchiveService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ArchiveActivity extends AppCompatActivity {

    private List<Archive> archiveList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archive);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.archive_recycler_view);
        archiveList = new ArrayList<>();

        /*int[] photos = new int[Archive.archiveItems.length];
        String[] titles = new String[Archive.archiveItems.length];
        String[] descriptions = new String[Archive.archiveItems.length];
        for(int i = 0; i < Archive.archiveItems.length;i++){
            photos[i] = Archive.archiveItems[i].getPhotoId();
            titles[i] = Archive.archiveItems[i].getTitle();
            descriptions[i] = Archive.archiveItems[i].getDescription();
        }*/




        ArchiveService archiveService = APIUtils.getArchiveService();
        Call<List<Archive>> repos = archiveService.getAllArchiveItems();

        final ArchiveAdapter archiveAdapter = new ArchiveAdapter(archiveList);

        repos.enqueue(new Callback<List<Archive>>() {
            @Override
            public void onResponse(Call<List<Archive>> call, Response<List<Archive>> response) {
                Toast.makeText(getApplicationContext(), String.format("OK"), Toast.LENGTH_SHORT).show();
                if(response.isSuccessful()) {
                    archiveList = response.body();
                    archiveAdapter.setArchiveList(archiveList);
                }
            }

            @Override
            public void onFailure(Call<List<Archive>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), String.format("Please, check internet connection."), Toast.LENGTH_SHORT).show();
            }

        });

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
