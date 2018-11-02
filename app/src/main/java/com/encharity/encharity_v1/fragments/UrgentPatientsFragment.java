package com.encharity.encharity_v1.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.encharity.encharity_v1.PatientDetailsActivity;
import com.encharity.encharity_v1.R;
import com.encharity.encharity_v1.entities.UrgentPatient;
import com.encharity.encharity_v1.recyclerViewAdapter.UrgentPatientsAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class UrgentPatientsFragment extends Fragment {


    public UrgentPatientsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView allPatientsRecycler = (RecyclerView)inflater.inflate(R.layout.fragment_urgent, container,
                false);



        String[] cities = new String[UrgentPatient.URGENT_PATIENTS.length];
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
        }

        UrgentPatientsAdapter adapter = new UrgentPatientsAdapter(adultsNames,adultsImages,adultsCategory,
                adultsDescription,totalTenge,fundsPercentage,daysLeft,cities);
        allPatientsRecycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        allPatientsRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new UrgentPatientsAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(),PatientDetailsActivity.class);
                intent.putExtra(PatientDetailsActivity.EXTRA_PATIENT_ID, position);
                getActivity().startActivity(intent);
            }
        });

        return allPatientsRecycler;
    }

}
