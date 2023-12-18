package com.example.juego;

import androidx.lifecycle.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<Integer> player1TouchCount = new MutableLiveData<>(0);
    private MutableLiveData<Integer> player2TouchCount = new MutableLiveData<>(0);

    public LiveData<Integer> getPlayer1TouchCount() {
        return player1TouchCount;
    }

    public LiveData<Integer> getPlayer2TouchCount() {
        return player2TouchCount;
    }

    public void incrementPlayer1TouchCount() {
        int count = player1TouchCount.getValue() != null ? player1TouchCount.getValue() + 1 : 1;
        player1TouchCount.setValue(count);
    }

    public void incrementPlayer2TouchCount() {
        int count = player2TouchCount.getValue() != null ? player2TouchCount.getValue() + 1 : 1;
        player2TouchCount.setValue(count);
    }

    public void incrementTouchCount() {
    }

    public String getTouchCount() {
        return null;
    }
}

