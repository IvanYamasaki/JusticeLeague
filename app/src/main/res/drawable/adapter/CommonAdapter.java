package com.ivangy.justiceleague.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ivangy.justiceleague.R;

import java.util.ArrayList;

public class CommonAdapter extends RecyclerView.Adapter<CommonAdapter.MyViewHolder> {

    ArrayList<String> list;

    public CommonAdapter(ArrayList<String> list) { this.list = list; }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout_common, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.lblResult.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView lblResult;
        ImageButton btnDell;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            lblResult = itemView.findViewById(R.id.lblResult);
            btnDell = itemView.findViewById(R.id.btnDell);

            btnDell.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list.remove(getAdapterPosition());

                    notifyDataSetChanged();
                }
            });
        }
    }
}
