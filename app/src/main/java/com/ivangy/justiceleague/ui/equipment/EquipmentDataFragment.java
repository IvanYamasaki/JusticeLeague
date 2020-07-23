package com.ivangy.justiceleague.ui.equipment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.ivangy.justiceleague.MainActivity;
import com.ivangy.justiceleague.R;
import com.ivangy.justiceleague.dll.Recycler;
import com.ivangy.justiceleague.dll.RecyclerItemClickListener;

import java.util.ArrayList;

public class EquipmentDataFragment extends Fragment {

    public static RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_equipment_data, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        Recycler.setConfig(getActivity(), recyclerView);

        ArrayList<String> equipmentsName= new ArrayList<>();
        MainActivity.allEquipments.forEach(equipment -> equipmentsName.add(equipment.getEquipmentName()));

        Recycler.addDataEquipment(getActivity(), recyclerView, equipmentsName,1);

        recyclerView.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                Toast.makeText(getActivity(), "Texto", Toast.LENGTH_SHORT);

                return false;
            }
        });



        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getActivity(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), EquipmentInfo.class);
                intent.putExtra("position", position);
                //startActivity(intent);
            }
            @Override
            public void onLongItemClick(View view, int position) {

            }
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }
        ));
        return view;
    }

}