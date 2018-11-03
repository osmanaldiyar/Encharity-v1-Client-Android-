package com.encharity.encharity_v1.api;

import com.encharity.encharity_v1.archive.Archive;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ArchiveService {

    @GET("archive/")
    Call<List<Archive>> getAllArchiveItems();

    @GET("archive/{id}")
    Call<Archive> getArchive(@Path("id") int id);

}
