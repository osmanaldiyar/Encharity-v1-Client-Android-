package com.encharity.encharity_v1.api;

public class APIUtils {

    private APIUtils(){
    };

    public static final String API_URL = "http://192.168.1.195:8080/";

    public static ArchiveService getArchiveService(){
        return RetrofitClient.getClient(API_URL).create(ArchiveService.class);
    }
    public static BlogService getBlogService(){
        return RetrofitClient.getClient(API_URL).create(BlogService.class);
    }
    public static PatientService getPatientService(){
        return RetrofitClient.getClient(API_URL).create(PatientService.class);
    }
    public static UrgentPatientService getUrgentPatientService(){
        return RetrofitClient.getClient(API_URL).create(UrgentPatientService.class);
    }
    public static InvestmentService getInvestmentService(){
        return RetrofitClient.getClient(API_URL).create(InvestmentService.class);
    }


}
