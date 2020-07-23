package com.ivangy.justiceleague.ui.hero;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
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

    int SKILLS_KEY = 4, VULNERABILITIES_KEY = 5, EQUIPMENT_KEY=6, HEROES_KEY=2;

    // RecyclerList names
    public static ArrayList<String> recyclerNameEquipment = new ArrayList<>(), tempListNameEquipment = new ArrayList<>(), tempListSkills = new ArrayList<>(), tempListVulnerabilities = new ArrayList<>();
    public ArrayList<Equipment> listEquipments = new ArrayList<>();
    public ArrayList<String> listNameHeroes, listCodenameHeroes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hero_insert, container, false);

        final TextInputEditText txtName = view.findViewById(R.id.txtName), txtCodename = view.findViewById(R.id.txtCodename), txtSpecie = view.findViewById(R.id.txtSpecie), txtSkill = view.findViewById(R.id.txtSkill), txtAccessLvl = view.findViewById(R.id.txtAccessLvl), txtVulnerability = view.findViewById(R.id.txtVulnerabilities);
        final Button btnInsert = view.findViewById(R.id.btnRegister);
        final ImageButton btnAddSkill = view.findViewById(R.id.btnAddSkill), btnAddVulnerability = view.findViewById(R.id.btnAddVulnerabilities);
        final Spinner spinnerEquipment = view.findViewById(R.id.spinnerEquipment);

        recyclerSkill = view.findViewById(R.id.recyclerSkill);
        recyclerVulnerabilities = view.findViewById(R.id.recyclerVulnerabilities);
        recyclerEquipment = view.findViewById(R.id.recyclerEquipment);
        Recycler.setConfig(getActivity(), recyclerSkill, recyclerVulnerabilities, recyclerEquipment);

        recyclerSkill.setAdapter(new CommonAdapter(tempListSkills, SKILLS_KEY));
        recyclerVulnerabilities.setAdapter(new CommonAdapter(tempListVulnerabilities, VULNERABILITIES_KEY));
        recyclerEquipment.setAdapter(new CommonAdapter(recyclerNameEquipment, EQUIPMENT_KEY));

        if (MainActivity.allEquipments.size() != 0) {
            MainActivity.allEquipments.forEach(e -> tempListNameEquipment.add(e.getEquipmentName()));
            if (tempListNameEquipment.get(0).equals("No equipment registered"))
                tempListNameEquipment.remove(0);
            if (!tempListNameEquipment.get(0).equals("Select an Equipment"))
                tempListNameEquipment.add(0, "Select an Equipment");
        } else
            tempListNameEquipment.add(0, "No equipment registered");

        btnAddSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Recycler.setCommonAdapter(getActivity(), recyclerSkill, tempListSkills, txtSkill.getText().toString(), SKILLS_KEY);
                cls(txtSkill);
            }
        });
        btnAddVulnerability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Recycler.setCommonAdapter(getActivity(), recyclerVulnerabilities, tempListVulnerabilities, txtVulnerability.getText().toString(), VULNERABILITIES_KEY);
                cls(txtVulnerability);
            }
        });

        ArrayAdapter<String> adapterEquipment = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, tempListNameEquipment);
        adapterEquipment.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEquipment.setAdapter(adapterEquipment);

        spinnerEquipment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    Recycler.setCommonAdapter(getActivity(), recyclerEquipment, recyclerNameEquipment, spinnerEquipment.getSelectedItem().toString(), 0);
                    spinnerEquipment.setSelection(0);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listEquipments = new ArrayList<>(MainActivity.allEquipments.stream().filter(e -> tempListNameEquipment.contains(e.getEquipmentName())).collect(Collectors.toList()));
                MainActivity.allHeroes.add(new Hero(txtName.getText().toString(), txtCodename.getText().toString(), txtSpecie.getText().toString(), tempListSkills, tempListVulnerabilities, listEquipments, Integer.valueOf(txtAccessLvl.getText().toString())));

                listNameHeroes= new ArrayList<>();
                listCodenameHeroes= new ArrayList<>();

                MainActivity.allHeroes.forEach(hn-> listNameHeroes.add(hn.getName()));
                MainActivity.allHeroes.forEach(hc ->  listCodenameHeroes.add(hc.getCodename()));

                Recycler.setCharacterAdapter(HeroDataFragment.recyclerView, listNameHeroes, listCodenameHeroes, HEROES_KEY);
                Toast.makeText(getActivity(), "Hero registered", Toast.LENGTH_SHORT);

                spinnerEquipment.setSelection(0);
                cls(txtAccessLvl, txtCodename, txtName, txtSkill, txtSpecie, txtVulnerability);
                clear(tempListSkills, tempListNameEquipment, tempListVulnerabilities);
                notifyData(recyclerSkill, recyclerEquipment, recyclerVulnerabilities, HeroDataFragment.recyclerView);
            }
        });
        return view;
    }

    public void cls(TextInputEditText... txt) {
        Arrays.asList(txt).forEach(t -> t.setText(""));
    }

    public void clear(ArrayList... ar){
        Arrays.asList(ar).forEach(a -> a.clear());
    }

    public void notifyData(RecyclerView... rec){
        Arrays.asList(rec).forEach(r->r.getAdapter().notifyDataSetChanged());
    }
}
