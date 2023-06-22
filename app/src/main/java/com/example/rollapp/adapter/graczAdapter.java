package com.example.rollapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rollapp.R;
import com.example.rollapp.gracze;
import com.example.rollapp.model.postac;
import com.example.rollapp.model.user;

import java.util.List;

public class graczAdapter extends RecyclerView.Adapter<graczHolder> {

    private List<user> userlist;

    private List<postac> postacie;

    public void setPostacie(List<postac> postacie) {
        this.postacie = postacie;
    }
    private OnItemClickListener listener;

    public graczAdapter(List<user> gracze, List<postac> postacie) {
        this.gracze = gracze;
    }

    public void setGracze(List<user> userlist) {
        this.userlist = userlist;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public graczHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gracz_lista_przedmiotow, parent, false);
        return new graczHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        user gracz = gracze.get(position);
        holder.nickTextView.setText(gracz.getNick());
        holder.imieTextView.setText(gracz.getImie());

        // Wyświetl listę postaci dla danego użytkownika
        List<postac> postacieGracza = gracz.getListaPostaci();
        if (postacieGracza != null && !postacieGracza.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (postac postac : postacieGracza) {
                stringBuilder.append(postac.getNazwa()).append(", ");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 2); // Usuń ostatni przecinek i spację
            holder.postacieTextView.setText(stringBuilder.toString());
        } else {
            holder.postacieTextView.setText("Brak postaci");
        }
    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public interface OnItemClickListener {
        void onItemClick(user user);
    }
}
