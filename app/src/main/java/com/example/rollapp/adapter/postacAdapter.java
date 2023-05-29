package com.example.rollapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rollapp.R;
import com.example.rollapp.model.postac;

import java.util.ArrayList;
import java.util.List;

public class postacAdapter extends RecyclerView.Adapter<postacHolder> {

    private List<postac> postacList;

    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(postac postac);
    }

    public postacAdapter(ArrayList<postac> postacList, OnItemClickListener listener)
    {
        this.postacList = postacList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public postacHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.postac_lista_przedmiotow, parent, false);
        return new postacHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull postacHolder holder, int position) {
        postac postac = postacList.get(position);
        holder.nazwa.setText(postac.getNazwa_postaci());
        holder.rasa.setText(postac.getRasa());
        holder.plec.setText(postac.getPlec());
        holder.wiek.setText(String.valueOf(postac.getWiek()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(postac);
            }
        });
    }

    @Override
    public int getItemCount() {
        return postacList.size();
    }
}
