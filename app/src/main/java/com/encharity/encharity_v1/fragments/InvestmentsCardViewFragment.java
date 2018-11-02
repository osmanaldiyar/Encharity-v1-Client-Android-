package com.encharity.encharity_v1.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.encharity.encharity_v1.AllInvestmentsActivity;
import com.encharity.encharity_v1.PatientDetailsActivity;
import com.encharity.encharity_v1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InvestmentsCardViewFragment extends Fragment implements View.OnClickListener{


    public InvestmentsCardViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.viewAllInvestmentsButton:
                Intent intent = new Intent(getActivity(),AllInvestmentsActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        InvestmentsFragment fragment = new InvestmentsFragment();

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.detailsFragment_FrameLayout,fragment);
        transaction.commit();

        View layout = inflater.inflate(R.layout.fragment_investments_card_view,container,false);

        Button viewAllBtn = (Button)layout.findViewById(R.id.viewAllInvestmentsButton);
        viewAllBtn.setOnClickListener(this);

        return layout;
    }

}
