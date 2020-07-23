package com.ivangy.justiceleague.model;

import com.ivangy.justiceleague.MainActivity;

import java.util.ArrayList;

public class Hero extends Character {

    private int accessLevel;

    public Hero(String name, String codename, String specie, ArrayList<String> skills, ArrayList<String> vulnerabilities, ArrayList<Equipment> equipment, int accessLevel) {
        super(name, codename, specie, skills, vulnerabilities, equipment);
        this.accessLevel = accessLevel;

        MainActivity.allHeroes.add(new Hero(name, codename, specie, skills, vulnerabilities, equipment, accessLevel));
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }
}
