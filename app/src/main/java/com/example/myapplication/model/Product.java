package com.example.myapplication.model;

public class Product {
    private String id;
    private String name;
    private int price;
    private int sku;
    private int sold;
    private int discountSold;
    private int discountPercent;
    private String coverImage;
    private int rating;
    private String vendorName;
    private String vendorAvatarImage;

    public Product(String id, String name, int price, int sku, int sold, int discountSold, int discountPercent, String coverImage, int rating, String vendorName, String vendorAvatarImage) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sku = sku;
        this.sold = sold;
        this.discountSold = discountSold;
        this.discountPercent = discountPercent;
        this.coverImage = coverImage;
        this.rating = rating;
        this.vendorName = vendorName;
        this.vendorAvatarImage = vendorAvatarImage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public int getDiscountSold() {
        return discountSold;
    }

    public void setDiscountSold(int discountSold) {
        this.discountSold = discountSold;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorAvatarImage() {
        return vendorAvatarImage;
    }

    public void setVendorAvatarImage(String vendorAvatarImage) {
        this.vendorAvatarImage = vendorAvatarImage;
    }
}
