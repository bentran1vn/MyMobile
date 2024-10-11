package com.example.myapplication.api;

import com.example.myapplication.model.Product;
import com.example.myapplication.model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ProductServices {
    String PRODUCTS = "products";

    @GET(PRODUCTS)
    Call<ResponseModel<Product>> getAllProduct(
            @Query("pageIndex") int page,
            @Query("pageSize") int pageSize
    );
}
