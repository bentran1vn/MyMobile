package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.model.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ItemViewHolder> {
    private List<Product> itemList;

    public ProductAdapter(List<Product> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_product_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Product product = itemList.get(position);
        holder.textViewName.setText(product.getName());
        holder.textViewPrice.setText("$" + product.getPrice());
        holder.textViewVendor.setText(product.getVendorName());
        holder.ratingBar.setRating(product.getRating());

        // Use Glide to load the product's cover image
        Glide.with(holder.itemView.getContext())
                .load(product.getCoverImage())
                .placeholder(R.drawable.image_1) // Optional placeholder
                .error(R.drawable.image_1) // Optional error image
                .into(holder.imageViewCover);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewPrice, textViewVendor;
        RatingBar ratingBar;
        ImageView imageViewCover;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            textViewVendor = itemView.findViewById(R.id.textViewVendor);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            imageViewCover = itemView.findViewById(R.id.imageViewCover);
        }
    }
}
