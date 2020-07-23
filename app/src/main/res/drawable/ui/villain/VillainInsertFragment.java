package com.ivangy.justiceleague.ui.villain;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;
import com.ivangy.justiceleague.MainActivity;
import com.ivangy.justiceleague.R;
import com.ivangy.justiceleague.dll.Recycler;

import java.util.ArrayList;

public class VillainInsertFragment extends Fragment {
    RecyclerView recyclerSkill, recyclerVulnerabilities, recyclerHPlace, recyclerDateAttack, recyclerEquipment, recyclerRivals;
    ArrayList<String> tempListEquipments = new ArrayList<>(), tempListRivals = new ArrayList<>();

    ArrayList<String> nameEquipment = new ArrayList<>(), nameRival = new ArrayList<>();
    ArrayList<String> tempSkills = new ArrayList<>(), tempVulnerabilities = new ArrayList<>(), tempDateAttack = new ArrayList<>(), tempHPlace = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity.allEquipments.forEach(equip -> nameEquipment.add(equip.getEquipmentName()));
        MainActivity.allHeroes.forEach(hero -> nameRival.add(hero.getName()));


        updateSpinner(tempListEquipments, nameEquipment, "Select an Equipment");
        updateSpinner(tempListRivals, nameRival, "Select a Rival");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_villain_insert, container, false);
        final TextInputEditText txtName = view.findViewById(R.id.txtName), txtCodename = view.findViewById(R.id.txtCodename), txtSpecie = view.findViewById(R.id.txtSpecie), txtSkill = view.findViewById(R.id.txtSkill), txtVulnerability = view.findViewById(R.id.txtVulnerabilities), txtHPlace = view.findViewById(R.id.txtHPlace), txtDateAttack = view.findViewById(R.id.txtDateAttack);
        final ImageButton btnAddSkill = view.findViewById(R.id.btnAddSkill), btnAddVulnerability = view.findViewById(R.id.btnAddVulnerabilities), btnAddHPlace = view.findViewById(R.id.btnAddHPlace), btnAddDateAttack = view.findViewById(R.id.btnAddDateAttack);
        final Spinner spinnerEquipment = view.findViewById(R.id.spinnerEquipment), spinnerRivals = view.findViewById(R.id.spinnerRivals);

        recyclerDateAttack = view.findViewById(R.id.recyclerDateAttack);
        recyclerEquipment = view.findViewById(R.id.recyclerEquipment);
        recyclerHPlace = view.findViewById(R.id.recyclerHPlace);
        recyclerRivals = view.findViewById(R.id.recyclerRivals);
        recyclerSkill = view.findViewById(R.id.recyclerSkill);
        recyclerVulnerabilities = view.findViewById(R.id.recyclerVulnerabilities);

        Recycler.setConfig(getActivity(), recyclerSkill, recyclerDateAttack, recyclerVulnerabilities, recyclerHPlace, recyclerEquipment, recyclerRivals);

        btnAddSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Recycler.setCommonAdapter(getActivity(), recyclerSkill, tempSkills, txtSkill.getText().toString());
            }
        });

        btnAddVulnerability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Recycler.setCommonAdapter(getActivity(), recyclerVulnerabilities, tempVulnerabilities, txtVulnerability.getText().toString());
            }
        });
        btnAddDateAttack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Recycler.setCommonAdapter(getActivity(), recyclerDateAttack, tempDateAttack, txtDateAttack.getText().toString());
            }
        });
        btnAddHPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Recycler.setCommonAdapter(getActivity(), recyclerHPlace, tempHPlace, txtHPlace.getText().toString());
            }
        });

        ArrayAdapter<String> adapterEquipment = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, nameEquipment);
        adapterEquipment.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEquipment.setAdapter(adapterEquipment);

        spinnerEquipment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0)
                    Recycler.setCommonAdapter(getActivity(), recyclerEquipment, tempListEquipments, spinnerEquipment.getSelectedItem().toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        ArrayAdapter<String> adapterRivals = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, tempListRivals);
        adapterRivals.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRivals.setAdapter(adapterRivals);

        spinnerRivals.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0)
                    Recycler.setCommonAdapter(getActivity(), recyclerRivals, tempListRivals, spinnerRivals.getSelectedItem().toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        return view;
    }

    public void updateSpinner(ArrayList tempList, ArrayList<String> list, String defaultText){
        tempList.clear();
        tempList = list;
        tempList.add(0, defaultText);
    }
}