package com.encharity.encharity_v1.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.encharity.encharity_v1.PatientDetailsActivity;
import com.encharity.encharity_v1.R;
import com.encharity.encharity_v1.api.PatientService;
import com.encharity.encharity_v1.entities.Patient;
import com.encharity.encharity_v1.recyclerViewAdapter.PatientsAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class PatientsFragment extends Fragment {

    List<Patient> patientsList;

    public PatientsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView patientRecycler = (RecyclerView)inflater.inflate(R.layout.fragment_patients, container,
                false);
        patientsList = new ArrayList<>();

        /*String[] kidsNames = new String[Patient.PATIENTS.length];
        int[] kidsImages = new int[Patient.PATIENTS.length];
        String[] kidsCategory = new String[Patient.PATIENTS.length];
        String[] kidsDescription = new String[Patient.PATIENTS.length];
        String[] totalTenge = new String[Patient.PATIENTS.length];
        String[] fundsPercentage = new String[Patient.PATIENTS.length];
        String[] daysLeft = new String[Patient.PATIENTS.length];
        String[] cities = new String[Patient.PATIENTS.length];

        for(int i = 0; i < Patient.PATIENTS.length; i++){
            kidsNames[i] = Patient.PATIENTS[i].getFullname();
            kidsImages[i] = Patient.PATIENTS[i].getPhotoId();
            kidsCategory[i] = Patient.PATIENTS[i].getCategory();
            kidsDescription[i] = Patient.PATIENTS[i].getDescription();
            totalTenge[i] = Patient.PATIENTS[i].getTotalTenge();
            fundsPercentage[i] = Patient.PATIENTS[i].getFundedPercent();
            daysLeft[i] = Patient.PATIENTS[i].getDaysLeft();
            cities[i] = Patient.PATIENTS[i].getCity();
        }*/

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.195:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PatientService patientService = retrofit.create(PatientService.class);
        Call<List<Patient>> repos = patientService.getAllPatients();

        final PatientsAdapter adapter = new PatientsAdapter(patientsList/*kidsNames,kidsImages,kidsCategory,
                kidsDescription,totalTenge,fundsPercentage,daysLeft,cities*/);

        repos.enqueue(new Callback<List<Patient>>() {
            @Override
            public void onResponse(Call<List<Patient>> call, Response<List<Patient>> response) {
                Toast.makeText(getActivity(), String.format("OK"), Toast.LENGTH_SHORT).show();
                if(response.isSuccessful()) {
                    patientsList = response.body();
                    adapter.setPatientsList(patientsList);
                }
            }

            @Override
            public void onFailure(Call<List<Patient>> call, Throwable t) {
                Toast.makeText(getActivity(), String.format("KO"), Toast.LENGTH_SHORT).show();
            }

        });


        patientRecycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        patientRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new PatientsAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(),PatientDetailsActivity.class);
                intent.putExtra(PatientDetailsActivity.EXTRA_PATIENT_ID, position);
                getActivity().startActivity(intent);
            }
        });

        return patientRecycler;
    }

}
