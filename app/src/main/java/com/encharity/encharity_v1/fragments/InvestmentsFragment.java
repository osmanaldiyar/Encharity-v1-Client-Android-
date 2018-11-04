package com.encharity.encharity_v1.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.encharity.encharity_v1.api.APIUtils;
import com.encharity.encharity_v1.api.InvestmentService;
import com.encharity.encharity_v1.entities.Investment;
import com.encharity.encharity_v1.entities.Patient;
import com.encharity.encharity_v1.entities.UrgentPatient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class InvestmentsFragment extends ListFragment {

    private List<Investment> investmentList;

    public InvestmentsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {

        InvestmentService investmentService = APIUtils.getInvestmentService();
        Call<List<Investment>> repos;
        repos = investmentService.getAllInvestmentItems();


        repos.enqueue(new Callback<List<Investment>>() {
            @Override
            public void onResponse(Call<List<Investment>> call, Response<List<Investment>> response) {
                Toast.makeText(getActivity(), String.format("OK"), Toast.LENGTH_SHORT).show();
                if(response.isSuccessful()) {
                    investmentList = response.body();
                    ArrayAdapter<Investment> arrayAdapter = new ArrayAdapter<>(inflater.getContext(),
                            android.R.layout.simple_list_item_1,investmentList);

                    setListAdapter(arrayAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Investment>> call, Throwable t) {
                Toast.makeText(getActivity(), String.format("Please, check internet connection."), Toast.LENGTH_SHORT).show();
            }

        });



        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
