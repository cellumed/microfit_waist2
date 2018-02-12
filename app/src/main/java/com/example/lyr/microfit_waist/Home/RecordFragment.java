package com.example.lyr.microfit_waist.Home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lyr.microfit_waist.R;

import java.util.ArrayList;

/**
 * Created by lyr on 2018. 2. 12..
 */

public class RecordFragment extends BaseFragment {

    private TextView mTextView;
    private ArrayList<String> mTexts;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTexts = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        @SuppressLint("InflateParams")
        View view = LayoutInflater.from(context).inflate(R.layout.recordfragment, null);




        return view;
    }

}
