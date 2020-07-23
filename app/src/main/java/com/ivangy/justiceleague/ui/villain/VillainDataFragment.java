package com.ivangy.justiceleague.ui.villain;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ivangy.justiceleague.MainActivity;
import com.ivangy.justiceleague.R;
import com.ivangy.justiceleague.dll.Recycler;
import com.ivangy.justiceleague.model.Equipment;
import com.ivangy.justiceleague.ui.hero.HeroDataFragment;
import com.ivangy.justiceleague.ui.hero.HeroInsertFragment;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class VillainDataFragment extends Fragment {

    int VILLAIN_KEY = 13;

    public static RecyclerView recyclerView;
    public ArrayList<Equipment> listEquipments = new ArrayList<>();
    public ArrayList<String> listNameVillain = new ArrayList<>(), listCodenameVillain = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_villain_data, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        Recycler.setConfig(getActivity(), recyclerView);

        listEquipments = new ArrayList<>(MainActivity.allEquipments.stream().filter(e -> HeroInsertFragment.tempListNameEquipment.contains(e.getEquipmentName())).collect(Collectors.toList()));
        MainActivity.allVillains.forEach(hn -> listNameVillain.add(hn.getName()));
        MainActivity.allVillains.forEach(hc -> listCodenameVillain.add(hc.getCodename()));
        if (listNameVillain.size() != 0) {
            Recycler.setCharacterAdapter(recyclerView, listNameVillain, listCodenameVillain, VILLAIN_KEY);
        }
        return view;
    }
}