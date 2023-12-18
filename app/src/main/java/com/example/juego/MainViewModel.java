package com.example.juego;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<Integer> player1TouchCount = new MutableLiveData<>(0);
    private MutableLiveData<Integer> player2TouchCount = new MutableLiveData<>(0);
    private MutableLiveData<GameOverState> gameOverState = new MutableLiveData<>();

    public LiveData<Integer> getPlayer1TouchCount() {
        return player1TouchCount;
    }

    public LiveData<Integer> getPlayer2TouchCount() {
        return player2TouchCount;
    }

    public LiveData<GameOverState> getGameOverState() {
        return gameOverState;
    }

    public void incrementPlayer1TouchCount() {
        int count = player1TouchCount.getValue() != null ? player1TouchCount.getValue() + 1 : 1;
        player1TouchCount.setValue(count);
        checkGameOverState();
    }

    public void incrementPlayer2TouchCount() {
        int count = player2TouchCount.getValue() != null ? player2TouchCount.getValue() + 1 : 1;
        player2TouchCount.setValue(count);
        checkGameOverState();
    }

    private void checkGameOverState() {
        if (player1TouchCount.getValue() != null && player1TouchCount.getValue() >= 10) {
            gameOverState.setValue(new GameOverState(1, player1TouchCount.getValue()));
        } else if (player2TouchCount.getValue() != null && player2TouchCount.getValue() >= 10) {
            gameOverState.setValue(new GameOverState(2, player2TouchCount.getValue()));
        }
    }

    public String getTouchCount() {
        return null;
    }

    public void incrementTouchCount() {
    }

    public static class GameOverState {
        private int winner;
        private int result;

        public GameOverState(int winner, int result) {
            this.winner = winner;
            this.result = result;
        }

        public int getWinner() {
            return winner;
        }

        public int getResult() {
            return result;
        }
    }
}