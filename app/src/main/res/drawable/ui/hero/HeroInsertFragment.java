package com.ivangy.justiceleague.ui.hero;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.ivangy.justiceleague.MainActivity;
import com.ivangy.justiceleague.R;
import com.ivangy.justiceleague.adapter.CommonAdapter;
import com.ivangy.justiceleague.dll.Recycler;
import com.ivangy.justiceleague.model.Equipment;
import com.ivangy.justiceleague.model.Hero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HeroInsertFragment extends Fragment {
    RecyclerView recyclerSkill, recyclerVulnerabilities, recyclerEquipment;
    ArrayList<String> tempListSkills = new ArrayList<>(), tempListVulnerabilities = new ArrayList<>();
    ArrayList<Equipment> tempListNameEquipment = new ArrayList<>();

    ArrayList<String> nameEquipments = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //MainActivity.allEquipments.forEach(equipment -> tempListNameEquipment.add(equipment.getEquipmentName()));
        //tempListNameEquipment.add(0, "Select an Equipment");
        tempListNameEquipment = MainActivity.allEquipments;
    }

    @Override
    public void onStart() {
        super.onStart();
        recyclerSkill.setAdapter(new CommonAdapter(tempListSkills));
        recyclerVulnerabilities.setAdapter(new CommonAdapter(tempListVulnerabilities));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hero_insert, container, false);

        final TextInputEditText txtName = view.findViewById(R.id.txtName), txtCodename = view.findViewById(R.id.txtCodename), txtSpecie = view.findViewById(R.id.txtSpecie), txtSkill = view.findViewById(R.id.txtSkill), txtAccessLvl = view.findViewById(R.id.txtAccessLvl), txtVulnerability = view.findViewById(R.id.txtVulnerabilities);
        final Button btnInsert = view.findViewById(R.id.btnRegister);
        final ImageButton btnAddSkill = view.findViewById(R.id.btnAddSkill), btnAddVulnerability = view.findViewById(R.id.btnAddVulnerabilities);
        final Spinner spinnerEquipment = view.findViewById(R.id.spinnerEquipment);

        recyclerSkill = view.findViewById(R.id.recyclerSkill);
        recyclerVulnerabilities = view.findViewById(R.id.recyclerVulnerabilities);
        recyclerEquipment = view.findViewById(R.id.recyclerEquipment);

        Recycler.setConfig(getActivity(), recyclerSkill, recyclerVulnerabilities);

        MainActivity.allEquipments.forEach(equip -> nameEquipments.add(equip.getEquipmentName()));



        btnAddSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempListSkills.add(txtSkill.getText().toString());
                Recycler.setCommonAdapter(getActivity(), recyclerSkill, tempListSkills, txtSkill.getText().toString());
            }
        });

        btnAddVulnerability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempListVulnerabilities.add(txtVulnerability.getText().toString());
                Recycler.setCommonAdapter(getActivity(), recyclerVulnerabilities, tempListVulnerabilities, txtVulnerability.getText().toString());
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                List<Equipment> equipmentsList = MainActivity.allEquipments.stream().filter(eq ->{
//                    eq.getEquipmentName().equals(spinnerEquipment.getSelectedItem())
//                }).collect(Collectors.toList());
//
//                ArrayList<Equipment> equipmentsLists;
//                tempListNameEquipment.forEach(name -> equipmentsLists = MainActivity.allEquipments.stream().filter(eq -> eq.getEquipmentName().equals(name)).collect(Collectors.toList()));
//
                ArrayList<Equipment> equipments = new ArrayList<>();
                MainActivity.allEquipments.forEach(objEquipment-> {
                    if(tempListNameEquipment.contains(objEquipment.getEquipmentName()))
                        equipments.add(objEquipment);
                });

                Hero hero = new Hero(txtName.getText().toString(), txtCodename.getText().toString(), txtSpecie.getText().toString(), tempListSkills, tempListVulnerabilities, equipments, Integer.valueOf(txtAccessLvl.getText().toString()));
            }
        });

        ArrayAdapter<String> adapterEquipment = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, nameEquipments);
        adapterEquipment.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEquipment.setAdapter(adapterEquipment);

        spinnerEquipment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0)
                    Recycler.setCommonAdapter(getActivity(), recyclerEquipment, nameEquipments, spinnerEquipment.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        return view;
    }
}
