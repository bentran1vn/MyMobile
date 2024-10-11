package com.example.myapplication.model;

public class ResponseModel<Item> {
    private Value<Item> value;
    private boolean isSuccess;
    private boolean isFailure;
    private Error error;

    // Getters and setters
    public Value<Item> getValue() {
        return value;
    }

    public void setValue(Value<Item> value) {
        this.value = value;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public boolean isFailure() {
        return isFailure;
    }

    public void setFailure(boolean failure) {
        isFailure = failure;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}

