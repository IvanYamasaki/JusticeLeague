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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.ivangy.justiceleague.MainActivity;
import com.ivangy.justiceleague.R;
import com.ivangy.justiceleague.adapter.CommonAdapter;
import com.ivangy.justiceleague.dll.Recycler;
import com.ivangy.justiceleague.model.Equipment;
import com.ivangy.justiceleague.model.Hero;
import com.ivangy.justiceleague.model.Villain;
import com.ivangy.justiceleague.ui.hero.HeroDataFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Collectors;

public class VillainInsertFragment extends Fragment {
    RecyclerView recyclerSkill, recyclerVulnerabilities, recyclerHPlace, recyclerDateAttack, recyclerEquipment, recyclerRivals;

    public static ArrayList<String> recyclerNameEquipment = new ArrayList<>(), tempListNameEquipment = new ArrayList<>(),
            recyclerNameRivals = new ArrayList<>(), tempListRivals = new ArrayList<>(), tempListHPlace = new ArrayList<>(),
            tempListSkills = new ArrayList<>(), tempListVulnerabilities = new ArrayList<>();
    public static ArrayList<String>  tempListDateAttack = new ArrayList<>();

    public ArrayList<Equipment> listEquipments = new ArrayList<>();
    private ArrayList<String> listNameVillains, listCodenameVillains;
    private ArrayList<Hero> listRivals = new ArrayList<>();

    int VULNERABILITIES_KEY_V = 7, DATE_ATTACK_KEY = 8, HPLACE_KEY = 9, SKILLS_KEY_V = 10, EQUIPMENT_KEY_V = 11, RIVALS_KEY_V = 12;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_villain_insert, container, false);
        final TextInputEditText txtName = view.findViewById(R.id.txtName), txtCodename = view.findViewById(R.id.txtCodename), txtSpecie = view.findViewById(R.id.txtSpecie), txtSkill = view.findViewById(R.id.txtSkill), txtVulnerability = view.findViewById(R.id.txtVulnerabilities), txtHPlace = view.findViewById(R.id.txtHPlace), txtDateAttack = view.findViewById(R.id.txtDateAttack);
        final ImageButton btnAddSkill = view.findViewById(R.id.btnAddSkill), btnAddVulnerability = view.findViewById(R.id.btnAddVulnerabilities), btnAddHPlace = view.findViewById(R.id.btnAddHPlace), btnAddDateAttack = view.findViewById(R.id.btnAddDateAttack);
        final Spinner spinnerEquipment = view.findViewById(R.id.spinnerEquipment), spinnerRivals = view.findViewById(R.id.spinnerRivals);
        final Button btnInsert = view.findViewById(R.id.btnRegister);

        recyclerSkill = view.findViewById(R.id.recyclerSkill);
        recyclerDateAttack = view.findViewById(R.id.recyclerDateAttack);
        recyclerEquipment = view.findViewById(R.id.recyclerEquipment);
        recyclerHPlace = view.findViewById(R.id.recyclerHPlace);
        recyclerRivals = view.findViewById(R.id.recyclerRivals);
        recyclerVulnerabilities = view.findViewById(R.id.recyclerVulnerabilities);

        recyclerSkill.setAdapter(new CommonAdapter(tempListSkills, SKILLS_KEY_V));
        recyclerVulnerabilities.setAdapter(new CommonAdapter(tempListVulnerabilities, VULNERABILITIES_KEY_V));
        recyclerEquipment.setAdapter(new CommonAdapter(recyclerNameEquipment, EQUIPMENT_KEY_V));
        recyclerRivals.setAdapter(new CommonAdapter(recyclerNameRivals, RIVALS_KEY_V));

        if (MainActivity.allEquipments.size() != 0) {
            MainActivity.allEquipments.forEach(e -> tempListNameEquipment.add(e.getEquipmentName()));
            if (tempListNameEquipment.get(0).equals("No equipment registered"))
                tempListNameEquipment.remove(0);
            if (!tempListNameEquipment.get(0).equals("Select an Equipment"))
                tempListNameEquipment.add(0, "Select an Equipment");
        } else
            tempListNameEquipment.add(0, "No equipment registered");

        if (MainActivity.allHeroes.size() != 0) {
            MainActivity.allHeroes.forEach(e -> tempListRivals.add(e.getName()));
            if (tempListRivals.get(0).equals("No Hero registered"))
                tempListRivals.remove(0);
            if (!tempListRivals.get(0).equals("Select the rival Hero"))
                tempListRivals.add(0, "Select the rival Hero");
        } else
            tempListRivals.add(0, "No Hero registered");


        Recycler.setConfig(getActivity(), recyclerSkill, recyclerDateAttack, recyclerVulnerabilities, recyclerHPlace, recyclerEquipment, recyclerRivals);

        btnAddSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Recycler.setCommonAdapter(getActivity(), recyclerSkill, tempListSkills, txtSkill.getText().toString(), SKILLS_KEY_V);
            }
        });
        btnAddVulnerability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Recycler.setCommonAdapter(getActivity(), recyclerVulnerabilities, tempListVulnerabilities, txtVulnerability.getText().toString(), VULNERABILITIES_KEY_V);
            }
        });
        btnAddDateAttack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Recycler.setCommonAdapter(getActivity(), recyclerDateAttack, tempListDateAttack, txtDateAttack.getText().toString(), DATE_ATTACK_KEY);
            }
        });
        btnAddHPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Recycler.setCommonAdapter(getActivity(), recyclerHPlace, tempListHPlace, Objects.requireNonNull(txtHPlace.getText()).toString(), HPLACE_KEY);
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

        ArrayAdapter<String> adapterRivals = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, tempListRivals);
        adapterRivals.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRivals.setAdapter(adapterRivals);

        spinnerRivals.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    Recycler.setCommonAdapter(getActivity(), recyclerRivals, recyclerNameRivals, spinnerRivals.getSelectedItem().toString(), 0);
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
                listRivals = new ArrayList<>(MainActivity.allHeroes.stream().filter(e -> tempListNameEquipment.contains(e.getName())).collect(Collectors.toList()));


                MainActivity.allVillains.add(new Villain(txtName.getText().toString(), txtCodename.getText().toString(), txtSpecie.getText().toString(), tempListSkills, tempListVulnerabilities, listEquipments, listRivals, tempListHPlace, tempListDateAttack));

                listNameVillains= new ArrayList<>();
                listCodenameVillains= new ArrayList<>();

                MainActivity.allVillains.forEach(hn-> listNameVillains.add(hn.getName()));
                MainActivity.allVillains.forEach(hc ->  listCodenameVillains.add(hc.getCodename()));

                Recycler.setCharacterAdapter(VillainDataFragment.recyclerView, listNameVillains, listCodenameVillains, RIVALS_KEY_V);
                Toast.makeText(getActivity(), "Villain registered", Toast.LENGTH_SHORT);

                spinnerEquipment.setSelection(0);
                cls(txtCodename, txtName, txtSkill, txtSpecie, txtVulnerability);
                clear(tempListSkills, tempListNameEquipment, tempListVulnerabilities);
                notifyData(recyclerSkill, recyclerEquipment, recyclerVulnerabilities, VillainDataFragment.recyclerView);
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