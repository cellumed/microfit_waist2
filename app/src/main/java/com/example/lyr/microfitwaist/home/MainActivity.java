package com.example.lyr.microfitwaist.home;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.lyr.microfitwaist.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.back)
    ImageButton btnBack;
    @BindView(R.id.li_connect)
    LinearLayout liConnect;
    @BindView(R.id.li_program)
    LinearLayout liProgram;
    @BindView(R.id.li_set)
    LinearLayout liSet;
    @BindView(R.id.line_connect)
    LinearLayout lineConnect;
    @BindView(R.id.line_program)
    LinearLayout lineProgram;
    @BindView(R.id.line_set)
    LinearLayout lineSet;

    private MainPagerAdapter mainPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        vp.setAdapter(mainPagerAdapter);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                lineChange(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        liConnect.setOnClickListener(clicklistener);
        liConnect.setTag(0);
        liProgram.setOnClickListener(clicklistener);
        liProgram.setTag(1);
        liSet.setOnClickListener(clicklistener);
        liSet.setTag(2);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    View.OnClickListener clicklistener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            int tag = (int) v.getTag();

            lineChange(tag);

            vp.setCurrentItem(tag);

        }
    };


    public void lineChange(int num){
        switch (num){
            case 0:
                lineConnect.setBackgroundResource(R.color.colorAccent);
                lineProgram.setBackgroundResource(R.color.colorPrimary);
                lineSet.setBackgroundResource(R.color.colorPrimary);
                break;
            case 1:
                lineConnect.setBackgroundResource(R.color.colorPrimary);
                lineProgram.setBackgroundResource(R.color.colorAccent);
                lineSet.setBackgroundResource(R.color.colorPrimary);
                break;
            case 2:
                lineConnect.setBackgroundResource(R.color.colorPrimary);
                lineProgram.setBackgroundResource(R.color.colorPrimary);
                lineSet.setBackgroundResource(R.color.colorAccent);
                break;
        }
    }

}




