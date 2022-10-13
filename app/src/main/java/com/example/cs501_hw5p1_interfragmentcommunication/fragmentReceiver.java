package com.example.cs501_hw5p1_interfragmentcommunication;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class fragmentReceiver extends Fragment {
    private fragmentReceiverListener listener;
    private TextView textView;
    private MediaPlayer catSound;
    private MediaPlayer cowSound;
    private MediaPlayer lionSound;
    private MediaPlayer dogSound;
    private MediaPlayer sheepSound;



    public interface fragmentReceiverListener{
        void onInputReceiverSent(CharSequence input);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_receiver, container, false);
        catSound = MediaPlayer.create(getActivity(),R.raw.catsound);
        cowSound = MediaPlayer.create(getActivity(),R.raw.cowsound);
        lionSound = MediaPlayer.create(getActivity(),R.raw.lionsound);
        dogSound = MediaPlayer.create(getActivity(),R.raw.dogsound);
        sheepSound = MediaPlayer.create(getActivity(),R.raw.sheepsound);
        textView = v.findViewById(R.id.textView_receiver);
        return v;
    }

    public void updateTextView(CharSequence newText){
        textView.setText(newText);
        if (newText == "cat"){
            textView.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.cat));
            catSound.start();
        }else if(newText == "cow"){
            textView.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.cow));
            cowSound.start();
        } else if(newText == "lion"){
            textView.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.lion));
            lionSound.start();
        }else if(newText == "sheep"){
            textView.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.sheep));
            sheepSound.start();
        }else if(newText == "dog"){
            textView.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.dog));
            dogSound.start();
        }

    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof fragmentReceiverListener){
            listener = (fragmentReceiverListener) context;
        }else{
            throw new RuntimeException(context.toString() + "need implement fragmentReceiverListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}