package com.jy.gxh.day03homework01.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jy.gxh.day03homework01.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class StateFragment extends Fragment {


    private View view;
    /**
     * Hello blank fragment
     */
    private TextView mTvContent;

    public StateFragment() {  // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_state, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mTvContent = (TextView) view.findViewById(R.id.tv_content);
        Bundle bundle = getArguments();
        String content = bundle.getString("content");
        mTvContent.setText(content);
    }
}
