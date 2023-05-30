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
    private OnItemClickListener listener;

    public graczAdapter()
    {
        this.userlist = userlist;
    }

    public void setGracze(List<user> userlist) {
        this.userlist = userlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public graczHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gracz_lista_przedmiotow, parent, false);
         return new graczHolder(view);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull graczHolder holder, int position) {
         user user = userlist.get(position);
         holder.nick.setText(user.getNick());
         holder.imie.setText(user.getImie());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(user);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public interface OnItemClickListener {
        void onItemClick(user user);
    }
}
