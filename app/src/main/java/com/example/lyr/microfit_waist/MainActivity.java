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

import com.example.lyr.microfit_waist.Home.MainPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.li_program)
    LinearLayout li_program;
    @BindView(R.id.li_record)
    LinearLayout li_record;
    @BindView(R.id.li_admin)
    LinearLayout li_admin;
    @BindView(R.id.li_set)
    LinearLayout li_set;
    @BindView(R.id.line_program)
    LinearLayout line_program;
    @BindView(R.id.line_record)
    LinearLayout line_record;
    @BindView(R.id.line_admin)
    LinearLayout line_admin;
    @BindView(R.id.line_set)
    LinearLayout line_set;

    private MainPagerAdapter mPagerAdapter;
    private int mSelectedPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        li_program.setOnClickListener(mclicklistener);
        li_program.setTag(0);
        li_record.setOnClickListener(mclicklistener);
        li_record.setTag(1);
        li_admin.setOnClickListener(mclicklistener);
        li_admin.setTag(2);
        li_set.setOnClickListener(mclicklistener);
        li_set.setTag(3);

        mPagerAdapter = new MainPagerAdapter(getSupportFragmentManager());

        vp.setAdapter(mPagerAdapter);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mSelectedPosition = position;

                line_change(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    View.OnClickListener mclicklistener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            int tag = (int) v.getTag();

            line_change(tag);

            vp.setCurrentItem(tag);

        }
    };


    public void line_change(int num){
        switch (num){
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

}




