package com.example.myapplication.repository;

import com.example.myapplication.api.ApiClient;
import com.example.myapplication.api.ProductServices;

public class ProductRepository {
    public static ProductServices getProductService(){
        return ApiClient.getClient().create(ProductServices.class);
    }
}
