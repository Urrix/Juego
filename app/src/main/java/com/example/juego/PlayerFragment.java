package com.example.juego;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
<<<<<<< HEAD

=======
import androidx.lifecycle.ViewModelProvider;
>>>>>>> feature/ViewModel

public class PlayerFragment extends Fragment {

    private MainViewModel viewModel;
    private int playerId;
    private TextView touchCountTextView;

    public PlayerFragment(int playerId) {
        this.playerId = playerId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player, container, false);

        final TextView touchCountTextView = view.findViewById(R.id.touchCountTextView);

        LiveData<Integer> touchCountLiveData;
        if (playerId == 1) {
            AtouchCountLiveData = viewModel.getPlayer1TouchCount();
        } else {
            touchCountLiveData = viewModel.getPlayer2TouchCount();
        }

        touchCountLiveData.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer count) {
                touchCountTextView.setText("Player " + playerId + " Count: " + count);
<<<<<<< HEAD

                if (count >= 10) {
                    touchCountTextView.setText("Player " + playerId + " wins!");
                    view.setOnTouchListener(null);
                    showCongratulationsToast(playerId);
                }
=======
            }
        });

        viewModel.getGameOverState().observe(getViewLifecycleOwner(), new Observer<MainViewModel.GameOverState>() {
            @Override
            public void onChanged(MainViewModel.GameOverState gameOverState) {
                int winner = gameOverState.getWinner();
                int result = gameOverState.getResult();
                showGameOverMessage(winner, result);
>>>>>>> feature/ViewModel
            }
        });

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (playerId == 1) {
                    viewModel.incrementPlayer1TouchCount();
                } else {
                    viewModel.incrementPlayer2TouchCount();
                }
                return true;
            }
        });

        return view;
    }

<<<<<<< HEAD


    private void showCongratulationsToast(int playerId) {
        String message = "¡Felicidades, Jugador " + playerId + "!";
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
=======
    private void showGameOverMessage(int winner, int result) {
        String message = "Game Over!\nPlayer " + winner + " wins with a score of " + result;
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show();
>>>>>>> feature/ViewModel
    }
}