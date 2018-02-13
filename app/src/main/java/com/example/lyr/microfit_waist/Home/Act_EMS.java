package com.example.lyr.microfit_waist.Home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lyr.microfit_waist.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Act_EMS extends AppCompatActivity {

    @BindView(R.id.progressbar_ds)
    ProgressBar progressbar_ds;
    @BindView(R.id.minus_ds)
    ImageButton minus_ds;
    @BindView(R.id.txt_ds)
    TextView txt_ds;
    @BindView(R.id.plus_ds)
    ImageButton plus_ds;
    @BindView(R.id.progressbar_dh)
    ProgressBar progressbar_dh;
    @BindView(R.id.minus_dh)
    ImageButton minus_dh;
    @BindView(R.id.txt_dh)
    TextView txt_dh;
    @BindView(R.id.plus_dh)
    ImageButton plus_dh;
    @BindView(R.id.progressbar_ha)
    ProgressBar progressbar_ha;
    @BindView(R.id.minus_ha)
    ImageButton minus_ha;
    @BindView(R.id.txt_ha)
    TextView txt_ha;
    @BindView(R.id.plus_ha)
    ImageButton plus_ha;
    @BindView(R.id.progressbar_hb)
    ProgressBar progressbar_hb;
    @BindView(R.id.minus_hb)
    ImageButton minus_hb;
    @BindView(R.id.txt_hb)
    TextView txt_hb;
    @BindView(R.id.plus_hb)
    ImageButton plus_hb;

    //프로그래스 값
    int ds,dh,ha,hb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__ems);
        ButterKnife.bind(this);

        minus_ds.setOnClickListener(mclicklistener);
        minus_ds.setTag(0);
        minus_dh.setOnClickListener(mclicklistener);
        minus_dh.setTag(1);
        minus_ha.setOnClickListener(mclicklistener);
        minus_ha.setTag(2);
        minus_hb.setOnClickListener(mclicklistener);
        minus_hb.setTag(3);
        plus_ds.setOnClickListener(mclicklistener);
        plus_ds.setTag(4);
        plus_dh.setOnClickListener(mclicklistener);
        plus_dh.setTag(5);
        plus_ha.setOnClickListener(mclicklistener);
        plus_ha.setTag(6);
        plus_hb.setOnClickListener(mclicklistener);
        plus_hb.setTag(7);



    }
    View.OnClickListener mclicklistener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            int tag = (int) v.getTag();

            ds = Integer.parseInt(txt_ds.getText().toString());
            dh = Integer.parseInt(txt_dh.getText().toString());
            ha = Integer.parseInt(txt_ha.getText().toString());
            hb = Integer.parseInt(txt_hb.getText().toString());

            if(tag==0 || tag==4){
                SetProgress(tag,0,4,ds,"ds");
            }else if(tag==1 || tag==5){
                SetProgress(tag,1,5,dh,"dh");
            }else if(tag==2 || tag==6){
                SetProgress(tag,2,6,ha,"ha");
            }else if(tag==3 || tag==7){
                SetProgress(tag,3,7,hb,"hb");
            }
        }
    };

    public void SetProgress(int tag, int minus, int plus, int num, String type){
        if(tag==minus){
            if(num>0){
                num--;
            }
        }else if(tag==plus){
            if(num<100){
                num++;
            }
        }
        switch (type){
            case "ds":
                Log.d("tag","qqqqq "+num);
                progressbar_ds.setProgress(num);
                txt_ds.setText(Integer.toString(num));
                break;
            case "dh":
                progressbar_dh.setProgress(num);
                txt_dh.setText(Integer.toString(num));
                break;
            case "ha":
                progressbar_ha.setProgress(num);
                txt_ha.setText(Integer.toString(num));
                break;
            case "hb":
                progressbar_hb.setProgress(num);
                txt_hb.setText(Integer.toString(num));
                break;
        }
    }
}
