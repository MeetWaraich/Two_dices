package com.example.twodices;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.twodices.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    int computerResultTotal=0;
    int yourResultTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.play.setOnClickListener(view->{
                Random random = new Random();
                int randomNumber1 = random.nextInt(6-1)+1;
                int randomNumber2 = random.nextInt(6-1)+1;

                switch (randomNumber1){
                    case 1:
                        binding.computerDice.setImageResource(R.drawable.dice1);
                        break;
                    case 2:
                        binding.computerDice.setImageResource(R.drawable.dice2);
                        break;
                    case 3:
                        binding.computerDice.setImageResource(R.drawable.dice3);
                        break;
                    case 4:
                        binding.computerDice.setImageResource(R.drawable.dice4);
                        break;
                    case 5:
                        binding.computerDice.setImageResource(R.drawable.dice5);
                        break;
                    case 6:
                        binding.computerDice.setImageResource(R.drawable.dice6);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + randomNumber1);
                }

                switch (randomNumber2){
                    case 1:
                        binding.yourDice.setImageResource(R.drawable.dice1);
                        break;
                    case 2:
                        binding.yourDice.setImageResource(R.drawable.dice2);
                        break;
                    case 3:
                        binding.yourDice.setImageResource(R.drawable.dice3);
                        break;
                    case 4:
                        binding.yourDice.setImageResource(R.drawable.dice4);
                        break;
                    case 5:
                        binding.yourDice.setImageResource(R.drawable.dice5);
                        break;
                    case 6:
                        binding.yourDice.setImageResource(R.drawable.dice6);
                        break;
                    default:
                        throw new IllegalStateException("Error:faulty value " + randomNumber2);
                }


                computerResultTotal += randomNumber1;
                yourResultTotal += randomNumber2;

                binding.computerResult.setText(String.valueOf(computerResultTotal));
                binding.yourResult.setText(String.valueOf(yourResultTotal));

            if (computerResultTotal >= 20) {
                Toast.makeText(this, "Oops..You Lose,Computer Wins", Toast.LENGTH_LONG).show();
                computerResultTotal=0;
                yourResultTotal=0;

            }
            if (yourResultTotal>=20) {
                Toast.makeText(this, "Congratulation,You are the Winner", Toast.LENGTH_SHORT).show();
                computerResultTotal=0;
                yourResultTotal=0;
            }

        });

    }
}