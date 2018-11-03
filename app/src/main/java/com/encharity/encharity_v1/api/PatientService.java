package com.encharity.encharity_v1.api;

import com.encharity.encharity_v1.entities.Patient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PatientService {

    @GET("allPatients/patients")
    Call<List<Patient>> getAllPatients();

    @GET("allPatients/patients/{id}")
    Call<Patient> getPatient(@Path("id") int id);

}
