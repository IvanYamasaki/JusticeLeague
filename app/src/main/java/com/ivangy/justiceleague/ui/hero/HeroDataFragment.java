package com.ivangy.justiceleague.ui.hero;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ivangy.justiceleague.MainActivity;
import com.ivangy.justiceleague.R;
import com.ivangy.justiceleague.adapter.ListCharacterAdapter;
import com.ivangy.justiceleague.dll.Recycler;
import com.ivangy.justiceleague.model.Equipment;
import com.ivangy.justiceleague.model.Hero;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class HeroDataFragment extends Fragment {

    int HEROES_KEY = 11;

    public ArrayList<Equipment> listEquipments = new ArrayList<>();
    public ArrayList<String> listNameHeroes = new ArrayList<>(), listCodenameHeroes = new ArrayList<>();
    public static RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hero_data, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        Recycler.setConfig(getActivity(), recyclerView);

        listEquipments = new ArrayList<>(MainActivity.allEquipments.stream().filter(e -> HeroInsertFragment.tempListNameEquipment.contains(e.getEquipmentName())).collect(Collectors.toList()));
        MainActivity.allHeroes.forEach(hn -> listNameHeroes.add(hn.getName()));
        MainActivity.allHeroes.forEach(hc -> listCodenameHeroes.add(hc.getCodename()));
        if (listNameHeroes.size() != 0) {
            Recycler.setCharacterAdapter(HeroDataFragment.recyclerView, listNameHeroes, listCodenameHeroes, HEROES_KEY);
            recyclerView.getAdapter().notifyDataSetChanged();
        }

        return view;
    }
}