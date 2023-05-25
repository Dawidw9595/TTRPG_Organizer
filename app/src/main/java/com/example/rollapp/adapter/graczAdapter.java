package com.example.rollapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rollapp.R;
import com.example.rollapp.model.user;

import java.util.List;

public class graczAdapter extends RecyclerView.Adapter<graczHolder> {

    private List<user> userlist;

    public graczAdapter(List<user> userlist)
    {
        this.userlist = userlist;
    }

    @NonNull
    @Override
    public graczHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gracz_lista_przedmiotow, parent, false);
         return new graczHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull graczHolder holder, int position) {
         user user = userlist.get(position);
         holder.nick.setText(user.getNick());
         holder.imie.setText(user.getImie());
    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }
}
