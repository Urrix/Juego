package com.example.juego;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class PlayerFragment extends Fragment {

    private MainViewModel viewModel;
    private int playerId;

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

        view.setOnTouchListener((v, event) -> {
            if (playerId == 1) {
                viewModel.incrementPlayer1TouchCount();
                touchCountTextView.setText("Player " + playerId + " Count: " + viewModel.getPlayer1TouchCount());
            } else if (playerId == 2) {
                viewModel.incrementPlayer2TouchCount();
                touchCountTextView.setText("Player " + playerId + " Count: " + viewModel.getPlayer2TouchCount());
            }
            return true;
        });

        return view;
    }
}
