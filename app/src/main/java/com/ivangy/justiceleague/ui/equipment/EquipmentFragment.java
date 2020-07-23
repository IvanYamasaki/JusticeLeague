package com.ivangy.justiceleague.ui.equipment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ivangy.justiceleague.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;


public class EquipmentFragment extends Fragment {

    private SmartTabLayout viewPagerTabLayout;
    private ViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_equipment, container, false);

        viewPagerTabLayout = view.findViewById(R.id.viewPagerTabLayout);
        viewPager = view.findViewById(R.id.viewPager);

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getChildFragmentManager(),
                FragmentPagerItems.with(getActivity())
                        .add("Register", EquipmentInsertFragment.class)
                        .add("Data", EquipmentDataFragment.class)
                        .create());

        viewPager.setAdapter(adapter);
        viewPagerTabLayout.setViewPager(viewPager);

        return view;
    }
}