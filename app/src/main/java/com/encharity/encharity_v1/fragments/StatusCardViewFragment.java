package com.encharity.encharity_v1.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.encharity.encharity_v1.AllStatusUpdatesActivity;
import com.encharity.encharity_v1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StatusCardViewFragment extends Fragment implements View.OnClickListener {


    public StatusCardViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.viewAllStatusUpdatesButton){
            Intent intent = new Intent(getActivity(), AllStatusUpdatesActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        StatusFragment fragment = new StatusFragment();

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.statusListView_container,fragment);
        transaction.commit();

        View layout = inflater.inflate(R.layout.fragment_status_card_view,container,false);

        Button viewAllStatusBtn = (Button)layout.findViewById(R.id.viewAllStatusUpdatesButton);
        viewAllStatusBtn.setOnClickListener(this);

        return layout;
    }

}
