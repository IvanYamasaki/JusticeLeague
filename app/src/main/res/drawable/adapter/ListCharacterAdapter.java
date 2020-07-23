package com.ivangy.justiceleague.adapter;

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

    ArrayList<String> list;

    public ListCharacterAdapter(ArrayList<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_info_character, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.lblName.setText(MainActivity.listVillainName.get(position));
        holder.lblCodename.setText(MainActivity.listVillainCodename.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView lblName, lblCodename;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            lblName = itemView.findViewById(R.id.lblResult);
            lblCodename = itemView.findViewById(R.id.btnDell);
        }
    }
}
