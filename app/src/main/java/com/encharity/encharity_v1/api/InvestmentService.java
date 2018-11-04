package com.encharity.encharity_v1.api;

import com.encharity.encharity_v1.entities.Investment;
import com.encharity.encharity_v1.entities.Patient;
import com.encharity.encharity_v1.entities.UrgentPatient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface InvestmentService {

    @GET("allInvestments/investments/")
    Call<List<Investment>> getAllInvestmentItems();

    @GET("allInvestments/investment/{id}")
    Call<Investment> getInvestment(@Path("id") Long id);

}
