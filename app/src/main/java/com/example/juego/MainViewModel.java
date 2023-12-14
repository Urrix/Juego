package com.example.juego;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private int player1TouchCount = 0;
    private int player2TouchCount = 0;

    public void incrementPlayer1TouchCount() {
        player1TouchCount++;
    }

    public void incrementPlayer2TouchCount() {
        player2TouchCount++;
    }

    public int getPlayer1TouchCount() {
        return player1TouchCount;
    }

    public int getPlayer2TouchCount() {
        return player2TouchCount;
    }

    public void incrementTouchCount() {
    }

    public String getTouchCount() {
        return null;
    }
}
