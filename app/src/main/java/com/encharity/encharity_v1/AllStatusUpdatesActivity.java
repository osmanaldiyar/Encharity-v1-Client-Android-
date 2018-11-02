package com.encharity.encharity_v1;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.encharity.encharity_v1.fragments.StatusFragment;

public class AllStatusUpdatesActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_status);

        StatusFragment statusUpdateFragment = new StatusFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.all_status_updates_container,statusUpdateFragment);
        transaction.commit();
    }
}
