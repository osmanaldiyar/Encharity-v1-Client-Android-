package com.encharity.encharity_v1.recyclerViewAdapter;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.encharity.encharity_v1.R;
import com.encharity.encharity_v1.entities.Patient;
import com.encharity.encharity_v1.entities.UrgentPatient;

import java.util.List;

public class UrgentPatientsAdapter extends RecyclerView.Adapter<UrgentPatientsAdapter.ViewHolder>{

    /*private String[] captions;
    private int[] imageIds;
    private String[] categories;
    private String[] descriptions;
    private String[] totalTenges;
    private String[] fundedPercents;
    private String[] daysLeft;
    private String[] cities;*/
    private List<UrgentPatient> urgentPatientsList;
    private Listener listener;

    public UrgentPatientsAdapter(List<UrgentPatient> urgentPatientsList/*String[] captions, int[] imageIds, String[] categories,
                                 String[] descriptions, String[] totalTenges, String[] fundedPercents,
                                 String[] daysLeft, String[] cities*/) {
        this.urgentPatientsList = urgentPatientsList;
        notifyDataSetChanged();
        /*this.captions = captions;
        this.imageIds = imageIds;
        this.categories = categories;
        this.descriptions = descriptions;
        this.totalTenges = totalTenges;
        this.fundedPercents = fundedPercents;
        this.daysLeft = daysLeft;
        this.cities = cities;*/
    }

    public interface Listener{
        void onClick(int position);
    }



    public void setListener(Listener listener){
        this.listener =  listener;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {


        private CardView cardView;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }

    }

    public void setUrgentPatientsList(List<UrgentPatient> urgentPatientsList) {
        this.urgentPatientsList = urgentPatientsList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        CardView cardView = (CardView) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_urgent_patient, viewGroup, false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i){
        CardView cardView = viewHolder.cardView;

        ImageView imageView = (ImageView)cardView.findViewById(R.id.adults_patient_image);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), R.drawable.kid2);
        imageView.setImageDrawable(drawable);
        //imageView.setContentDescription(captions[i]);

        TextView textView = (TextView)cardView.findViewById(R.id.adults_patient_fullname);
        textView.setText(urgentPatientsList.get(i).getUrgentFullname());
        TextView categoriesTextView = (TextView)cardView.findViewById(R.id.adults_patient_category);
        categoriesTextView.setText(urgentPatientsList.get(i).getUrgentCategory());
        TextView descriptionsTextView = (TextView)cardView.findViewById(R.id.adults_patient_description);
        descriptionsTextView.setText(urgentPatientsList.get(i).getUrgentDescription());
        TextView totalTengeTextView = (TextView)cardView.findViewById(R.id.adults_totalTenge);
        totalTengeTextView.setText(urgentPatientsList.get(i).getUrgentTotalTenge());
        TextView fundedPercentTextView = (TextView)cardView.findViewById(R.id.adults_fundedPercent);
        fundedPercentTextView.setText(urgentPatientsList.get(i).getUrgentFundedPercent()+"%");
        TextView daysLeftTextView = (TextView)cardView.findViewById(R.id.adults_daysLeft);
        daysLeftTextView.setText(urgentPatientsList.get(i).getUrgentDaysLeft());
        TextView citiesTextView = (TextView)cardView.findViewById(R.id.adults_city);
        citiesTextView.setText(urgentPatientsList.get(i).getUrgentCity());
        ProgressBar progressBar = (ProgressBar)cardView.findViewById(R.id.adults_progressBar);
        progressBar.setProgress(Integer.parseInt(urgentPatientsList.get(i).getUrgentFundedPercent()));

        cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.onClick(i);
                }
            }
        });

    }

    @Override
    public int getItemCount(){
        return urgentPatientsList.size();
    }

    public void setValues(){

    }

}
