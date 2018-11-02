package com.encharity.encharity_v1.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.encharity.encharity_v1.R;
import com.encharity.encharity_v1.entities.Investment;


/**
 * A simple {@link Fragment} subclass.
 */
public class InvestmentsFragment extends ListFragment {


    public InvestmentsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {

        ArrayAdapter<Investment> arrayAdapter = new ArrayAdapter<>(inflater.getContext(),
                android.R.layout.simple_list_item_1,Investment.investmentsArray);

        setListAdapter(arrayAdapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
