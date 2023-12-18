package com.example.juego;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class PlayerFragment extends Fragment {

    private MainViewModel viewModel;
    private int playerId;
    private TextView touchCountTextView;

    public PlayerFragment(int playerId) {
        this.playerId = playerId;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player, container, false);

        final TextView touchCountTextView = view.findViewById(R.id.touchCountTextView);

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (playerId == 1) {
                    viewModel.incrementPlayer1TouchCount();
                    int player1Count = viewModel.getPlayer1TouchCount();
                    touchCountTextView.setText("Player " + playerId + " Count: " + player1Count);

                    if (player1Count >= 10) {
                        // Detener el conteo y mostrar el mensaje de victoria
                        touchCountTextView.setText("Player " + playerId + " wins!");
                        v.setOnTouchListener(null); // Deshabilitar el listener para evitar más toques

                        // Mostrar la notificación (Toast) de felicitaciones
                        showCongratulationsToast(playerId);
                    }
                } else if (playerId == 2) {
                    viewModel.incrementPlayer2TouchCount();
                    int player2Count = viewModel.getPlayer2TouchCount();
                    touchCountTextView.setText("Player " + playerId + " Count: " + player2Count);

                    if (player2Count >= 10) {
                        // Detener el conteo y mostrar el mensaje de victoria
                        touchCountTextView.setText("Player " + playerId + " wins!");
                        v.setOnTouchListener(null);
                        showCongratulationsToast(playerId);
                    }
                }
                return true;
            }
        });

        return view;
    }

    private void showCongratulationsToast(int playerId) {
        String message = "¡Felicidades, Jugador " + playerId + "!";
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
    }
}