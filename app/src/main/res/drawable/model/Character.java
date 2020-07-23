package com.ivangy.justiceleague.model;

import java.util.ArrayList;

public abstract class Character{

    private String name, codename, specie;
    private ArrayList<String> skills, vulnerabilities;
    private ArrayList<Equipment> equipment;

    public Character( String name, String codename, String specie, ArrayList<String> skills, ArrayList<String> vulnerabilities, ArrayList<Equipment> equipment) {
        this.name = name;
        this.codename = codename;
        this.specie = specie;
        this.skills = skills;
        this.vulnerabilities = vulnerabilities;
        this.equipment = equipment;
    }

    public String getName() {
        return name;
    }
    public String getCodename() {
        return codename;
    }
    public String getSpecie() {
        return specie;
    }
    public ArrayList<String> getSkills() {
        return skills;
    }
    public ArrayList<String> getVulnerabilities() {
        return vulnerabilities;
    }
    public ArrayList<Equipment> getEquipment() {
        return equipment;
    }
}
