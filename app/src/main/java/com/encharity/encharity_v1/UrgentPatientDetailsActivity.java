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

import com.encharity.encharity_v1.api.APIUtils;
import com.encharity.encharity_v1.api.UrgentPatientService;
import com.encharity.encharity_v1.entities.UrgentPatient;
import com.encharity.encharity_v1.fragments.InvestmentsCardViewFragment;
import com.encharity.encharity_v1.fragments.StatusCardViewFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UrgentPatientDetailsActivity extends AppCompatActivity {

    public static String EXTRA_URGENT_PATIENT_ID = "urgentdetailsid";
    private UrgentPatient urgentPatient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urgent_patient_details);


        final InvestmentsCardViewFragment fragment = new InvestmentsCardViewFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.investments_card_viewContainer,fragment);
        transaction.commit();

        StatusCardViewFragment fragment2 = new StatusCardViewFragment();
        FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
        transaction2.replace(R.id.urgent_status_updates_card_viewContainer,fragment2);
        transaction2.commit();

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //



        UrgentPatientService urgentPatientService = APIUtils.getUrgentPatientService();
        int urgentPatientId = (Integer)getIntent().getExtras().getInt(EXTRA_URGENT_PATIENT_ID) + 1;
        Call<UrgentPatient> repos = urgentPatientService.getUrgentPatient(urgentPatientId);

        repos.enqueue(new Callback<UrgentPatient>() {
            @Override
            public void onResponse(Call<UrgentPatient> call, Response<UrgentPatient> response) {
                Toast.makeText(getApplicationContext(), String.format("OK"), Toast.LENGTH_SHORT).show();
                if(response.isSuccessful()) {
                    urgentPatient = response.body();
                    //recyclerAdapter.setNotesList(patientsList);

                    //
                    String patientName = urgentPatient.getUrgentFullname();
                    TextView textView = (TextView)findViewById(R.id.urgent_patient_fullname);
                    textView.setText(patientName);

                    //int patientImage = patientList.get(patientId.intValue()).getPhotoId();
                    ImageView patientImageView = (ImageView)findViewById(R.id.urgent_patient_image);
                    patientImageView.setImageDrawable(ContextCompat.getDrawable(UrgentPatientDetailsActivity.this,R.drawable.kid1));
                    patientImageView.setContentDescription(patientName);

                    String patientCategory = urgentPatient.getUrgentCategory();
                    TextView categoryTxt = (TextView) findViewById(R.id.urgent_patient_category);
                    categoryTxt.setText(patientCategory);

                    String patientDescription = urgentPatient.getUrgentDescription();
                    TextView descriptionTxt = (TextView) findViewById(R.id.urgent_patient_description);
                    descriptionTxt.setText(patientDescription);

                    String totalTenge = urgentPatient.getUrgentTotalTenge();
                    TextView totalTengeTxt = (TextView) findViewById(R.id.urgent_totalTenge);
                    totalTengeTxt.setText(totalTenge);

                    String fundedPercent = urgentPatient.getUrgentFundedPercent();
                    TextView fundedPercentTxt = (TextView) findViewById(R.id.urgent_fundedPercent);
                    fundedPercentTxt.setText(fundedPercent);

                    String daysLeft = urgentPatient.getUrgentDaysLeft();
                    TextView daysLeftTxt = (TextView) findViewById(R.id.urgent_daysLeft);
                    daysLeftTxt.setText(daysLeft);

                    String city = urgentPatient.getUrgentCity();
                    TextView cityTxt = (TextView) findViewById(R.id.urgent_city);
                    cityTxt.setText(city);
                    //
                }
            }

            @Override
            public void onFailure(Call<UrgentPatient> call, Throwable t) {
                Toast.makeText(getApplicationContext(), String.format("Please, check internet connection."), Toast.LENGTH_SHORT).show();
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
