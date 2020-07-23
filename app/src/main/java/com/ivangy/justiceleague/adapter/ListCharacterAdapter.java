package com.ivangy.justiceleague.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ivangy.justiceleague.MainActivity;
import com.ivangy.justiceleague.R;

import java.util.ArrayList;

public class ListCharacterAdapter extends RecyclerView.Adapter<ListCharacterAdapter.MyViewHolder> {

    ArrayList<String> listName, listCodename;
    int id;

    public ListCharacterAdapter(ArrayList<String> listName, ArrayList<String> listCodename, int id) {
        this.listName = listName;
        this.listCodename = listCodename;
        this.id = id;
        Log.d("AK", listName.toString());
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_info_character, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.d("CURRENT I", String.valueOf(position));
        holder.lblName.setText(listName.get(position));
        holder.lblCodename.setText(listCodename.get(position));
    }

    @Override
    public int getItemCount() {
        return listName.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView lblName, lblCodename;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            lblName = itemView.findViewById(R.id.lblName);
            lblCodename = itemView.findViewById(R.id.lblCodename);
        }
    }
}
