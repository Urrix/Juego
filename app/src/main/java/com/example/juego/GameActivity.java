package com.example.juego;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


public class GameActivity extends AppCompatActivity {

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        // Observar el estado de "Game Over"
        viewModel.getGameOverState().observe(this, gameOverState -> {
            int winner = gameOverState.getWinner();
            int result = gameOverState.getResult();
            showGameOverDialog(winner, result);
        });

        if (savedInstanceState == null) {
            PlayerFragment player1Fragment = new PlayerFragment(1);
            PlayerFragment player2Fragment = new PlayerFragment(2);

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragmentContainerLeft, player1Fragment);
            fragmentTransaction.add(R.id.fragmentContainerRight, player2Fragment);

            fragmentTransaction.commit();
        }
    }

    private void showGameOverDialog(int winner, int result) {
        String message = "Game Over!\nPlayer " + winner + " wins with a score of " + result;

        new AlertDialog.Builder(this)
                .setTitle("Game Over")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, (dialog, which) -> {
                    // Puedes realizar alguna acción adicional si es necesario
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}