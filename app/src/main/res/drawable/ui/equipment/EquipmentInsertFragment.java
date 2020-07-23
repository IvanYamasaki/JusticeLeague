package com.ivangy.justiceleague.ui.equipment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.ivangy.justiceleague.MainActivity;
import com.ivangy.justiceleague.R;
import com.ivangy.justiceleague.model.Equipment;

public class EquipmentInsertFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_equipment_insert, container, false);

        final TextInputEditText txtName = view.findViewById(R.id.txtName), txtDesc = view.findViewById(R.id.txtDesc), txtUsage = view.findViewById(R.id.txtUsage);
        Button btnRegister = view.findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(txtName.getText().toString().isEmpty() || txtDesc.getText().toString().isEmpty() || txtUsage.getText().toString().isEmpty())) {
                    new Equipment(txtName.getText().toString(), txtDesc.getText().toString(), txtUsage.getText().toString());
                    EquipmentDataFragment.recyclerView.getAdapter().notifyDataSetChanged();
                    Toast.makeText(getActivity(), "Equipment registered", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getActivity(), "All fields are required", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}