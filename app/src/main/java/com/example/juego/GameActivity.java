package com.example.juego;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

public class GameActivity extends AppCompatActivity {

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

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
}
