package com.encharity.encharity_v1;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.encharity.encharity_v1.fragments.InvestmentsFragment;

public class AllInvestmentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_investments);

        InvestmentsFragment investmentsFragment = new InvestmentsFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.all_investments_container, investmentsFragment);
        transaction.commit();

    }



}
