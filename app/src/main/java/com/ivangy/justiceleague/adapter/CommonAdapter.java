package com.ivangy.justiceleague.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ivangy.justiceleague.MainActivity;
import com.ivangy.justiceleague.R;
import com.ivangy.justiceleague.model.Equipment;
import com.ivangy.justiceleague.model.Villain;
import com.ivangy.justiceleague.ui.equipment.EquipmentDataFragment;
import com.ivangy.justiceleague.ui.equipment.EquipmentInsertFragment;
import com.ivangy.justiceleague.ui.hero.HeroInsertFragment;
import com.ivangy.justiceleague.ui.villain.VillainInsertFragment;

import java.util.ArrayList;

public class CommonAdapter extends RecyclerView.Adapter<CommonAdapter.MyViewHolder> {

    ArrayList<String> list;
    int listId;

    public CommonAdapter(ArrayList<String> list, int listId) {
        this.list = list;
        this.listId = listId;
    }

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

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView lblResult;
        ImageButton btnDell;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            lblResult = itemView.findViewById(R.id.lblResult);
            btnDell = itemView.findViewById(R.id.btnDell);

            btnDell.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listId == 1) {
                        MainActivity.allEquipments.remove(getAdapterPosition());
                    }
                    if (listId == 2)
                        MainActivity.allHeroes.remove(getAdapterPosition());
                    if (listId == 4) {
                        HeroInsertFragment.tempListSkills.remove(getAdapterPosition());
                    }
                    if (listId == 5) {
                        HeroInsertFragment.tempListVulnerabilities.remove(getAdapterPosition());
                    }
                    if (listId == 6) {
                        HeroInsertFragment.recyclerNameEquipment.remove(getAdapterPosition());
                    }
                    if (listId == 7) {
                        VillainInsertFragment.tempListVulnerabilities.remove(getAdapterPosition());
                    }
                    if (listId == 8) {
                        VillainInsertFragment.tempListDateAttack.remove(getAdapterPosition());
                    }
                    if (listId == 9) {
                        VillainInsertFragment.tempListHPlace.remove(getAdapterPosition());
                    }
                    if (listId == 10) {
                        VillainInsertFragment.tempListSkills.remove(getAdapterPosition());
                    }
                    if (listId == 12)
                        VillainInsertFragment.recyclerNameRivals.remove(getAdapterPosition());

                    notifyDataSetChanged();
                }
            });
        }
    }
}
