package com.encharity.encharity_v1.api;

import com.encharity.encharity_v1.entities.UrgentPatient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UrgentPatientService {

    @GET("allPatients/urgentPatients")
    Call<List<UrgentPatient>> getAllUrgentPatients();

    @GET("allPatients/urgentPatients/{id}")
    Call<UrgentPatient> getUrgentPatient(@Path("id") int id);

}
