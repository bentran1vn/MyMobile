package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.api.ProductServices;
import com.example.myapplication.model.Product;
import com.example.myapplication.model.ResponseModel;
import com.example.myapplication.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductPage extends AppCompatActivity {

    ProductServices productServices;
    private RecyclerView recyclerView;
    private ProductAdapter itemAdapter;
    private List<Product> itemList = new ArrayList<>();

    private int currentPage = 1;
    private boolean isLoading = false;
    private boolean isLastPage = false;
    private static final int PAGE_SIZE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_page);

        productServices = ProductRepository.getProductService();

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        itemAdapter = new ProductAdapter(itemList);
        recyclerView.setAdapter(itemAdapter);

        // Set up the scroll listener for pagination
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();
                int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();

                if (!isLoading && !isLastPage) {
                    if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                            && firstVisibleItemPosition >= 0) {
                        loadNextPage(); // Load more data when reaching the end
                    }
                }
            }
        });

        // Load the first page of data
        loadNextPage();
    }

    private void loadNextPage() {
        isLoading = true; // Set loading to true to prevent multiple calls

        // Make an API call to load the products for the current page
        Call<ResponseModel<Product>> call = productServices.getAllProduct(currentPage, PAGE_SIZE);
        call.enqueue(new Callback<ResponseModel<Product>>() {
            @Override
            public void onResponse(Call<ResponseModel<Product>> call, Response<ResponseModel<Product>> response) {
                List<Product> products = response.body().getValue().getItems();
                if (products == null || products.isEmpty()) {
                    isLastPage = true; // No more pages if there are no products
                    return;
                }

                itemList.addAll(products);
                itemAdapter.notifyDataSetChanged();
                currentPage++; // Increment the current page

                // Check if this is the last page
                if (products.size() < PAGE_SIZE) {
                    isLastPage = true;
                }
                isLoading = false; // Reset loading state
            }

            @Override
            public void onFailure(Call<ResponseModel<Product>> call, Throwable t) {
                // Handle failure
                t.printStackTrace();
                isLoading = false; // Reset loading state on failure
            }
        });
    }
}