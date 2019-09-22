package com.jy.gxh.day03homework01.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jy.gxh.day03homework01.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpecialFragment extends Fragment {


    public SpecialFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_special, container, false);
        return view;
    }

}
