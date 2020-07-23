package com.ivangy.justiceleague.model;

import com.ivangy.justiceleague.MainActivity;

import java.util.ArrayList;
import java.util.Date;

public class Villain extends Character {

    private ArrayList<Hero> rivals;
    private ArrayList<String>  hidingPlace;
    private ArrayList<String> dateAttack;

    public Villain(String name, String codename, String specie, ArrayList<String> skills, ArrayList<String> vulnerabilities, ArrayList<Equipment> equipment, ArrayList<Hero> rivals, ArrayList<String> hidingPlace, ArrayList<String> dateAttack) {
        super(name, codename, specie, skills, vulnerabilities, equipment);
        this.rivals = rivals;
        this.hidingPlace = hidingPlace;
        this.dateAttack = dateAttack;

        MainActivity.allVillains.add(this);
    }

    public ArrayList<Hero> getRivals() {
        return rivals;
    }

    public ArrayList<String> getHidingPlace() {
        return hidingPlace;
    }

    public ArrayList<String> getDateAttack() {
        return dateAttack;
    }
}
