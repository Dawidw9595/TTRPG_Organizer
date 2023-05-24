package com.example.rollapp.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rollapp.R;

public class postacHolder extends RecyclerView.ViewHolder {

    TextView nazwa;
    TextView rasa;
    TextView plec;
    TextView wiek;


    public postacHolder(@NonNull View itemView) {
        super(itemView);
        nazwa = itemView.findViewById(R.id.postaclistaprzedmiotow_nazwa);
        rasa = itemView.findViewById(R.id.postaclistaprzedmiotow_rasa);
        plec = itemView.findViewById(R.id.postaclistaprzedmiotow_plec);
        wiek = itemView.findViewById(R.id.postaclistaprzedmiotow_wiek);
    }
}
