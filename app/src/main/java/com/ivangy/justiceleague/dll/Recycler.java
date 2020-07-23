package com.ivangy.justiceleague.dll;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ivangy.justiceleague.MainActivity;
import com.ivangy.justiceleague.adapter.CommonAdapter;
import com.ivangy.justiceleague.adapter.ListCharacterAdapter;
import com.ivangy.justiceleague.model.Equipment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Recycler {

    public Recycler() {
    }

    public static void setConfig(Context context, RecyclerView... recyclerViews) {
        Arrays.asList(recyclerViews).forEach(r -> {
            r.setLayoutManager(new LinearLayoutManager(context));
            r.addItemDecoration(new DividerItemDecoration(context, LinearLayout.VERTICAL));
            r.setHasFixedSize(true);
        });
    }

    public static void setCommonAdapter(Context context, RecyclerView recycler, ArrayList<String> list, String text, int listId) {
        if (!text.isEmpty()) {
            list.add(text);
            recycler.setAdapter(new CommonAdapter(list, listId));
        } else
            Toast.makeText(context, "The field is empty", Toast.LENGTH_SHORT).show();
    }

    public static void setCharacterAdapter(Context context, RecyclerView recycler, ArrayList<String> listName, ArrayList<String> listCodename, String name, String codename, int id) {
        if (!name.isEmpty() || codename.isEmpty()) {
            listName.add(name);
            listCodename.add(codename);
            recycler.setAdapter(new ListCharacterAdapter(listName, listCodename, id));
        } else
            Toast.makeText(context, "The field is empty", Toast.LENGTH_SHORT).show();
    }

    public static void setCharacterAdapter(RecyclerView recycler, ArrayList<String> listName, ArrayList<String> listCodename, int id) {
        recycler.setAdapter(new ListCharacterAdapter(listName, listCodename, id));
    }

    public static void addDataEquipment(Context context, RecyclerView recycler, ArrayList<String> list, int listId) {
        recycler.setAdapter(new CommonAdapter(list, listId));

    }

}
