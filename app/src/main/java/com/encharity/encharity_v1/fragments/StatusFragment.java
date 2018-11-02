package com.encharity.encharity_v1.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.encharity.encharity_v1.entities.Status;

/**
 * A simple {@link Fragment} subclass.
 */
public class StatusFragment extends ListFragment {


    public StatusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayAdapter<Status> arrayAdapter = new ArrayAdapter<>(inflater.getContext(),
                android.R.layout.simple_list_item_1, Status.statusArray);

        setListAdapter(arrayAdapter);

        return super.onCreateView(inflater,container,savedInstanceState);
    }

}
