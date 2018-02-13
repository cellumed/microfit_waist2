package com.example.lyr.microfit_waist;

import android.content.Intent;
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
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.lyr.microfit_waist.Home.MainPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.back)
    ImageButton back;
    @BindView(R.id.li_connect)
    LinearLayout li_connect;
    @BindView(R.id.li_program)
    LinearLayout li_program;
    @BindView(R.id.li_set)
    LinearLayout li_set;
    @BindView(R.id.line_connect)
    LinearLayout line_connect;
    @BindView(R.id.line_program)
    LinearLayout line_program;
    @BindView(R.id.line_set)
    LinearLayout line_set;

    private MainPagerAdapter mPagerAdapter;
    private int mSelectedPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

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


        Intent intent = getIntent();
        if(intent != null){
            int home_num = intent.getIntExtra("home_num",0);
            Log.d("TAG","HOME에서 넘어온 데이터 : "+home_num);
            line_change(home_num);
            vp.setCurrentItem(home_num);

        }

        li_connect.setOnClickListener(mclicklistener);
        li_connect.setTag(0);
        li_program.setOnClickListener(mclicklistener);
        li_program.setTag(1);
        li_set.setOnClickListener(mclicklistener);
        li_set.setTag(2);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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
                line_connect.setBackgroundResource(R.color.colorAccent);
                line_program.setBackgroundResource(R.color.colorPrimary);
                line_set.setBackgroundResource(R.color.colorPrimary);
                break;
            case 1:
                line_connect.setBackgroundResource(R.color.colorPrimary);
                line_program.setBackgroundResource(R.color.colorAccent);
                line_set.setBackgroundResource(R.color.colorPrimary);
                break;
            case 2:
                line_connect.setBackgroundResource(R.color.colorPrimary);
                line_program.setBackgroundResource(R.color.colorPrimary);
                line_set.setBackgroundResource(R.color.colorAccent);
                break;
        }
    }

}




