package com.ivangy.justiceleague.model;

import com.ivangy.justiceleague.MainActivity;

public class Equipment {

    private String equipmentName;
    private String equipmentDesc;
    private String equipmentUsage;

    public Equipment(String equipmentName, String equipmentDesc, String equipmentUsage) {
        this.equipmentName = equipmentName;
        this.equipmentDesc = equipmentDesc;
        this.equipmentUsage = equipmentUsage;

        MainActivity.allEquipments.add(new Equipment(equipmentName, equipmentDesc, equipmentUsage));
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentDesc() {
        return equipmentDesc;
    }

    public void setEquipmentDesc(String equipmentDesc) {
        this.equipmentDesc = equipmentDesc;
    }

    public String getEquipmentUsage() {
        return equipmentUsage;
    }

    public void setEquipmentUsage(String equipmentUsage) {
        this.equipmentUsage = equipmentUsage;
    }
}
