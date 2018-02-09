package com.example.lyr.microfit_waist;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {


//    @BindView(R.id.vp)
//    ViewPager vp;
//    @BindView(R.id.li_program)
//    LinearLayout li_program;
//    @BindView(R.id.li_record)
//    LinearLayout li_record;
//    @BindView(R.id.li_admin)
//    LinearLayout li_admin;
//    @BindView(R.id.li_set)
//    LinearLayout li_set;
//    @BindView(R.id.line_program)
//    LinearLayout line_program;
//    @BindView(R.id.line_record)
//    LinearLayout line_record;
//    @BindView(R.id.line_admin)
//    LinearLayout line_admin;
//    @BindView(R.id.line_set)
//    LinearLayout line_set;


    ViewPager vp;
    LinearLayout li_program;
    LinearLayout li_record;
    LinearLayout li_admin;
    LinearLayout li_set;
    LinearLayout line_program;
    LinearLayout line_record;
    LinearLayout line_admin;
    LinearLayout line_set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp = (ViewPager)findViewById(R.id.vp);
        li_program = (LinearLayout)findViewById(R.id.li_program);
        li_record = (LinearLayout)findViewById(R.id.li_record);
        li_admin = (LinearLayout)findViewById(R.id.li_admin);
        li_set = (LinearLayout)findViewById(R.id.li_set);

        line_program = (LinearLayout)findViewById(R.id.line_program);
        line_record = (LinearLayout)findViewById(R.id.line_record);
        line_admin = (LinearLayout)findViewById(R.id.line_admin);
        line_set = (LinearLayout)findViewById(R.id.line_set);


        li_program.setOnClickListener(mclicklistener);
        li_program.setTag(0);
        li_record.setOnClickListener(mclicklistener);
        li_record.setTag(1);
        li_admin.setOnClickListener(mclicklistener);
        li_admin.setTag(2);
        li_set.setOnClickListener(mclicklistener);
        li_set.setTag(3);


//        vp.setAdapter(new pagerAdapter(getSupportFragmentManager()));
//
//        vp.setCurrentItem(0);


    }

    View.OnClickListener mclicklistener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            int tag = (int) v.getTag();

            switch (tag){
                case 0:
                    line_program.setBackgroundResource(R.color.colorAccent);
                    line_record.setBackgroundResource(R.color.colorPrimary);
                    line_admin.setBackgroundResource(R.color.colorPrimary);
                    line_set.setBackgroundResource(R.color.colorPrimary);
                    break;
                case 1:
                    line_program.setBackgroundResource(R.color.colorPrimary);
                    line_record.setBackgroundResource(R.color.colorAccent);
                    line_admin.setBackgroundResource(R.color.colorPrimary);
                    line_set.setBackgroundResource(R.color.colorPrimary);
                    break;
                case 2:
                    line_program.setBackgroundResource(R.color.colorPrimary);
                    line_record.setBackgroundResource(R.color.colorPrimary);
                    line_admin.setBackgroundResource(R.color.colorAccent);
                    line_set.setBackgroundResource(R.color.colorPrimary);
                    break;
                case 3:
                    line_program.setBackgroundResource(R.color.colorPrimary);
                    line_record.setBackgroundResource(R.color.colorPrimary);
                    line_admin.setBackgroundResource(R.color.colorPrimary);
                    line_set.setBackgroundResource(R.color.colorAccent);
                    break;
            }
        }
    };

    private class pagerAdapter extends FragmentStatePagerAdapter
    {
        public pagerAdapter(android.support.v4.app.FragmentManager fm)
        {
            super(fm);
        }
        @Override
        public android.support.v4.app.Fragment getItem(int position)
        {
            switch(position)
            {
                case 0:

                    return new vp_program();

                default:
                    return null;
            }
        }
        @Override
        public int getCount()
        {
            return 4;
        }
    }


    public static class vp_program extends Fragment
    {
        public vp_program()
        {
        }

        @Override
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
            Log.d("TAG","DDDD");
            RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.activity_vp_program, container, false);
            return layout;
        }
    }



}




