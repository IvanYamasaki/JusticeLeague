package com.ivangy.justiceleague.model;

import com.ivangy.justiceleague.MainActivity;

import java.util.ArrayList;
import java.util.Date;

public class Villain extends Character {

    private ArrayList<Hero> rivals;
    private ArrayList<String>  hidingPlace;
    private ArrayList<Date> dateAttack;

    public Villain(String name, String codename, String specie, ArrayList<String> skills, ArrayList<String> vulnerabilities, ArrayList<Equipment> equipment, ArrayList<Hero> rivals, ArrayList<String> hidingPlace, ArrayList<Date> dateAttack) {
        super(name, codename, specie, skills, vulnerabilities, equipment);
        this.rivals = rivals;
        this.hidingPlace = hidingPlace;
        this.dateAttack = dateAttack;

        MainActivity.listVillainName.add(name);
        MainActivity.listVillainCodename.add(codename);
        MainActivity.listVillainSpecie.add(specie);
        MainActivity.listVillainSkills.add(skills.toString());
        MainActivity.listVillainVulnerabilities.add(vulnerabilities.toString());
        MainActivity.listVillainHPlace.add(hidingPlace.toString());
        MainActivity.listVillainDateAttack.add(dateAttack.toString());
    }

    public ArrayList<Hero> getRivals() {
        return rivals;
    }

    public ArrayList<String> getHidingPlace() {
        return hidingPlace;
    }

    public ArrayList<Date> getDateAttack() {
        return dateAttack;
    }
}
