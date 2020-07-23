package com.ivangy.justiceleague.ui.equipment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ivangy.justiceleague.MainActivity;
import com.ivangy.justiceleague.R;
import com.ivangy.justiceleague.dll.Recycler;

import java.util.ArrayList;

public class EquipmentDataFragment extends Fragment {

    public static RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_equipment_data, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        Recycler.setConfig(getActivity(), recyclerView);

        ArrayList<String> equipmentsName= new ArrayList<>();
        MainActivity.allEquipments.forEach(equipment -> equipmentsName.add(equipment.getEquipmentName()));

        Recycler.addDataEquipment(getActivity(), recyclerView, equipmentsName);
        return view;
    }

}