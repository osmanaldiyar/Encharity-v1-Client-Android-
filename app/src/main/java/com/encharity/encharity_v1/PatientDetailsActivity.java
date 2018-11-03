package com.encharity.encharity_v1;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.encharity.encharity_v1.api.PatientService;
import com.encharity.encharity_v1.entities.Patient;
import com.encharity.encharity_v1.fragments.InvestmentsCardViewFragment;
import com.encharity.encharity_v1.fragments.StatusCardViewFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class PatientDetailsActivity extends AppCompatActivity{

    public static String EXTRA_PATIENT_ID = "id";
    private Patient patient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);


        InvestmentsCardViewFragment fragment = new InvestmentsCardViewFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.investments_card_viewContainer,fragment);
        transaction.commit();

        StatusCardViewFragment fragment2 = new StatusCardViewFragment();
        FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
        transaction2.replace(R.id.status_updates_card_viewContainer,fragment2);
        transaction2.commit();

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.195:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PatientService patientService = retrofit.create(PatientService.class);
        int patientId = (Integer)getIntent().getExtras().getInt(EXTRA_PATIENT_ID);
        Call<Patient> repos = patientService.getPatient(patientId);

        repos.enqueue(new Callback<Patient>() {
            @Override
            public void onResponse(Call<Patient> call, Response<Patient> response) {
                Toast.makeText(getApplicationContext(), String.format("OK"), Toast.LENGTH_SHORT).show();
                if(response.isSuccessful()) {
                    patient = response.body();
                    //recyclerAdapter.setNotesList(patientsList);

                    //
                    String patientName = patient.getFullname();
                    TextView textView = (TextView)findViewById(R.id.patient_fullname);
                    textView.setText(patientName);

                    //int patientImage = patientList.get(patientId.intValue()).getPhotoId();
                    ImageView patientImageView = (ImageView)findViewById(R.id.patient_image);
                    patientImageView.setImageDrawable(ContextCompat.getDrawable(PatientDetailsActivity.this,R.drawable.kid1));
                    patientImageView.setContentDescription(patientName);

                    String patientCategory = patient.getCategory();
                    TextView categoryTxt = (TextView) findViewById(R.id.patient_category);
                    categoryTxt.setText(patientCategory);

                    String patientDescription = patient.getDescription();
                    TextView descriptionTxt = (TextView) findViewById(R.id.patient_description);
                    descriptionTxt.setText(patientDescription);

                    String totalTenge = patient.getTotalTenge();
                    TextView totalTengeTxt = (TextView) findViewById(R.id.totalTenge);
                    totalTengeTxt.setText(totalTenge);

                    String fundedPercent = patient.getFundedPercent();
                    TextView fundedPercentTxt = (TextView) findViewById(R.id.fundedPercent);
                    fundedPercentTxt.setText(fundedPercent);

                    String daysLeft = patient.getDaysLeft();
                    TextView daysLeftTxt = (TextView) findViewById(R.id.daysLeft);
                    daysLeftTxt.setText(daysLeft);

                    String city = patient.getCity();
                    TextView cityTxt = (TextView) findViewById(R.id.city);
                    cityTxt.setText(city);
                    //
                }
            }

            @Override
            public void onFailure(Call<Patient> call, Throwable t) {
                Toast.makeText(getApplicationContext(), String.format("KO"), Toast.LENGTH_SHORT).show();
            }

        });

        //




        /*int patientId = (Integer)getIntent().getExtras().getInt(EXTRA_PATIENT_ID);


        String patientName = Patient.PATIENTS[patientId].getFullname();
        TextView textView = (TextView)findViewById(R.id.patient_fullname);
        textView.setText(patientName);

        int patientImage = Patient.PATIENTS[patientId].getPhotoId();
        ImageView patientImageView = (ImageView)findViewById(R.id.patient_image);
        patientImageView.setImageDrawable(ContextCompat.getDrawable(this,patientImage));
        patientImageView.setContentDescription(patientName);

        String patientCategory = Patient.PATIENTS[patientId].getCategory();
        TextView categoryTxt = (TextView) findViewById(R.id.patient_category);
        categoryTxt.setText(patientCategory);

        String patientDescription = Patient.PATIENTS[patientId].getDescription();
        TextView descriptionTxt = (TextView) findViewById(R.id.patient_description);
        descriptionTxt.setText(patientDescription);

        String totalTenge = Patient.PATIENTS[patientId].getTotalTenge();
        TextView totalTengeTxt = (TextView) findViewById(R.id.totalTenge);
        totalTengeTxt.setText(totalTenge);

        String fundedPercent = Patient.PATIENTS[patientId].getFundedPercent();
        TextView fundedPercentTxt = (TextView) findViewById(R.id.fundedPercent);
        fundedPercentTxt.setText(fundedPercent);

        String daysLeft = Patient.PATIENTS[patientId].getDaysLeft();
        TextView daysLeftTxt = (TextView) findViewById(R.id.daysLeft);
        daysLeftTxt.setText(daysLeft);

        String city = Patient.PATIENTS[patientId].getCity();
        TextView cityTxt = (TextView) findViewById(R.id.city);
        cityTxt.setText(city);*/



    }

    public void onClickDonate(View view){

    }

}
