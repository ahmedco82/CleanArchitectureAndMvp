package com.ahmedco.samplecleanarchitecture.ui;

public interface LoginView {
    void showProgress();
    void hideProgress();
    void showError(String error);
}