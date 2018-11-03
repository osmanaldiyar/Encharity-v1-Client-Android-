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

import com.encharity.encharity_v1.R;
import com.encharity.encharity_v1.UrgentPatientDetailsActivity;
import com.encharity.encharity_v1.api.UrgentPatientService;
import com.encharity.encharity_v1.entities.UrgentPatient;
import com.encharity.encharity_v1.recyclerViewAdapter.UrgentPatientsAdapter;

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
public class UrgentPatientsFragment extends Fragment {

    private List<UrgentPatient> urgentPatientList;

    public UrgentPatientsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView urgentPatientsRecycler = (RecyclerView)inflater.inflate(R.layout.fragment_urgent, container,
                false);
        urgentPatientList = new ArrayList<>();


        /*String[] cities = new String[UrgentPatient.URGENT_PATIENTS.length];
        String[] daysLeft = new String[UrgentPatient.URGENT_PATIENTS.length];
        String[] fundsPercentage = new String[UrgentPatient.URGENT_PATIENTS.length];
        String[] totalTenge = new String[UrgentPatient.URGENT_PATIENTS.length];
        String[] adultsDescription = new String[UrgentPatient.URGENT_PATIENTS.length];
        String[] adultsCategory = new String[UrgentPatient.URGENT_PATIENTS.length];
        String[] adultsNames = new String[UrgentPatient.URGENT_PATIENTS.length];
        int[] adultsImages = new int[UrgentPatient.URGENT_PATIENTS.length];

        for(int i = 0; i < UrgentPatient.URGENT_PATIENTS.length; i++){
            adultsNames[i] = UrgentPatient.URGENT_PATIENTS[i].getFullname();
            adultsImages[i] = UrgentPatient.URGENT_PATIENTS[i].getPhotoId();
            adultsCategory[i] = UrgentPatient.URGENT_PATIENTS[i].getCategory();
            adultsDescription[i] = UrgentPatient.URGENT_PATIENTS[i].getDescription();
            totalTenge[i] = UrgentPatient.URGENT_PATIENTS[i].getTotalTenge();
            fundsPercentage[i] = UrgentPatient.URGENT_PATIENTS[i].getFundedPercent();
            daysLeft[i] = UrgentPatient.URGENT_PATIENTS[i].getDaysLeft();
            cities[i] = UrgentPatient.URGENT_PATIENTS[i].getCity();
        }*/

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.195:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UrgentPatientService urgentPatientService = retrofit.create(UrgentPatientService.class);
        Call<List<UrgentPatient>> repos = urgentPatientService.getAllUrgentPatients();

        final UrgentPatientsAdapter adapter = new UrgentPatientsAdapter(urgentPatientList/*adultsNames,adultsImages,adultsCategory,
                adultsDescription,totalTenge,fundsPercentage,daysLeft,cities*/);

        repos.enqueue(new Callback<List<UrgentPatient>>() {
            @Override
            public void onResponse(Call<List<UrgentPatient>> call, Response<List<UrgentPatient>> response) {
                Toast.makeText(getActivity(), String.format("OK"), Toast.LENGTH_SHORT).show();
                if(response.isSuccessful()) {
                    urgentPatientList = response.body();
                    adapter.setUrgentPatientsList(urgentPatientList);
                }
            }

            @Override
            public void onFailure(Call<List<UrgentPatient>> call, Throwable t) {
                Toast.makeText(getActivity(), String.format("KO"), Toast.LENGTH_SHORT).show();
            }

        });

        urgentPatientsRecycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        urgentPatientsRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new UrgentPatientsAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(),UrgentPatientDetailsActivity.class);
                intent.putExtra(UrgentPatientDetailsActivity.EXTRA_URGENT_PATIENT_ID, position);
                getActivity().startActivity(intent);
            }
        });

        return urgentPatientsRecycler;
    }

}
