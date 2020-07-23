package com.ivangy.justiceleague.dll;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ivangy.justiceleague.MainActivity;
import com.ivangy.justiceleague.adapter.CommonAdapter;
import com.ivangy.justiceleague.model.Equipment;

import java.util.ArrayList;
import java.util.Arrays;

public class Recycler {

    public Recycler() {
    }

    public static void setConfig(Context context, RecyclerView... recyclerViews) {
//        Arrays.asList(recyclerViews).forEach(recycler -> {
//                recycler.setLayoutManager(new LinearLayoutManager(context));
//        recycler.addItemDecoration(new DividerItemDecoration(context, LinearLayout.VERTICAL));
//        recycler.setHasFixedSize(true);
//        });

        for( RecyclerView r : recyclerViews) {
            r.setLayoutManager(new LinearLayoutManager(context));
            r.addItemDecoration(new DividerItemDecoration(context, LinearLayout.VERTICAL));
            r.setHasFixedSize(true);
        }
    }

    public static void setCommonAdapter(Context context, RecyclerView recycler, ArrayList<String> list, String text) {
        if (!text.isEmpty()) {
            list.add(text);
            recycler.setAdapter(new CommonAdapter(list));
        }else
        Toast.makeText(context, "The field is empty", Toast.LENGTH_SHORT).show();
    }

    public static void setCharacterAdapter(Context context, RecyclerView recycler, ArrayList<String> list, String text) {
        if (!text.isEmpty()) {
            list.add(text);
            recycler.setAdapter(new CommonAdapter(list));
        }else
        Toast.makeText(context, "The field is empty", Toast.LENGTH_SHORT).show();
    }

    public static void addDataEquipment(Context context, RecyclerView recycler, ArrayList<String> list) {
            recycler.setAdapter(new CommonAdapter(list));

    }

    public static void setNotifyDataChanged(){

    }


}
