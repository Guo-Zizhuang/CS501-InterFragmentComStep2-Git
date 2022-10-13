package com.example.cs501_hw5p1_interfragmentcommunication;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements fragmentPasser.fragmentPasserListener,fragmentReceiver.fragmentReceiverListener{
    private fragmentPasser fragmentPasser;
    private fragmentReceiver fragmentReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentPasser = new fragmentPasser();
        fragmentReceiver = new fragmentReceiver();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_Passer, fragmentPasser)
                .replace(R.id.fragment_Receiver, fragmentReceiver)
                .commit();

    }

    @Override
    public void onInputPasserSent(CharSequence input) {
        fragmentReceiver.updateTextView(input);
    }

    @Override
    public void onInputReceiverSent(CharSequence input) {

    }
}