package com.example.rollapp.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rollapp.R;

public class graczHolder extends RecyclerView.ViewHolder {
    TextView nick, imie;

    public graczHolder(@NonNull View itemView){
        super(itemView);
        nick = itemView.findViewById(R.id.graczlistaprzedmiotow_nick);
        imie = itemView.findViewById(R.id.graczlistaprzedmiotow_imie);
    }
}
