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

import java.util.List;

public class PatientsAdapter extends RecyclerView.Adapter<PatientsAdapter.ViewHolder> {

    /*private String captions[];
    private int[] imageIds;
    private String categories[];
    private String descriptions[];
    private String totalTenges[];
    private String fundedPercents[];
    private String daysLeft[];
    private String cities[];*/
    private List<Patient> patientsList;
    private Listener listener;

    public interface Listener{
        void onClick(int position);
    }

    public void setListener(Listener listener){
        this.listener =  listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;

        public ViewHolder(CardView v){
            super(v);
            cardView = v;
        }


    }

    public void setPatientsList(List<Patient> patientsList) {
        this.patientsList = patientsList;
        notifyDataSetChanged();
    }

    public PatientsAdapter(List<Patient> patientsList/*String[] captions, int[] imageIds, String[] categories, String[] descriptions,
                           String[] totalTenges, String[] fundedPercents, String[] daysLeft, String[] cities*/) {
        this.patientsList = patientsList;
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

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        CardView cv = (CardView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_patient,
                viewGroup,false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder,final int i) {

        CardView cardView = viewHolder.cardView;

        ImageView imageView = (ImageView)cardView.findViewById(R.id.patient_image);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(),R.drawable.kid1/*patientsList.get(i).getPhotoId()*/);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(patientsList.get(i).getFullname());

        TextView textView = (TextView)cardView.findViewById(R.id.patient_fullname);
        textView.setText(patientsList.get(i).getFullname());
        TextView categoriesTextView = (TextView)cardView.findViewById(R.id.patient_category);
        categoriesTextView.setText(patientsList.get(i).getCategory());
        TextView descriptionsTextView = (TextView)cardView.findViewById(R.id.patient_description);
        descriptionsTextView.setText(patientsList.get(i).getDescription());
        TextView totalTengeTextView = (TextView)cardView.findViewById(R.id.totalTenge);
        totalTengeTextView.setText(patientsList.get(i).getTotalTenge());
        TextView fundedPercentTextView = (TextView)cardView.findViewById(R.id.fundedPercent);
        fundedPercentTextView.setText(patientsList.get(i).getFundedPercent()+"%");
        TextView daysLeftTextView = (TextView)cardView.findViewById(R.id.daysLeft);
        daysLeftTextView.setText(patientsList.get(i).getDaysLeft());
        TextView citiesTextView = (TextView)cardView.findViewById(R.id.city);
        citiesTextView.setText(patientsList.get(i).getCity());
        ProgressBar progressBar = (ProgressBar)cardView.findViewById(R.id.progressBar);
        progressBar.setProgress(Integer.parseInt(patientsList.get(i).getFundedPercent()));


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
    public int getItemCount() {
        return patientsList.size();
    }


}
