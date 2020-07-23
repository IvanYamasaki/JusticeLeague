package com.ivangy.justiceleague.ui.equipment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.ivangy.justiceleague.MainActivity;
import com.ivangy.justiceleague.R;

public class EquipmentInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment_info);

        final TextView lblName = findViewById(R.id.lblName), lblDesc = findViewById(R.id.lblCodename), lblUsage = findViewById(R.id.lblUsage);
        Bundle bundle = getIntent().getExtras();
        int pos = bundle.getInt("position");

        lblName.setText(MainActivity.allEquipments.get(pos).getEquipmentName());
        lblUsage.setText(MainActivity.allEquipments.get(pos).getEquipmentUsage());
        lblDesc.setText(MainActivity.allEquipments.get(pos).getEquipmentDesc());

    }
}