package com.example.lyr.microfitwaist.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lyr.microfitwaist.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EMSActivity extends AppCompatActivity {

    @BindView(R.id.progressbar_ds)
    ProgressBar progressbarDs;
    @BindView(R.id.minus_ds)
    ImageButton minusDs;
    @BindView(R.id.txt_ds)
    TextView txtDs;
    @BindView(R.id.plus_ds)
    ImageButton plusDs;
    @BindView(R.id.progressbar_dh)
    ProgressBar progressbarDh;
    @BindView(R.id.minus_dh)
    ImageButton minusDh;
    @BindView(R.id.txt_dh)
    TextView txtDh;
    @BindView(R.id.plus_dh)
    ImageButton plusDh;
    @BindView(R.id.progressbar_ha)
    ProgressBar progressbarHa;
    @BindView(R.id.minus_ha)
    ImageButton minusHa;
    @BindView(R.id.txt_ha)
    TextView txtHa;
    @BindView(R.id.plus_ha)
    ImageButton plusHa;
    @BindView(R.id.progressbar_hb)
    ProgressBar progressbarHb;
    @BindView(R.id.minus_hb)
    ImageButton minusHb;
    @BindView(R.id.txt_hb)
    TextView txtHb;
    @BindView(R.id.plus_hb)
    ImageButton plusHb;
    @BindView(R.id.back)
    ImageButton btnBack;



    //프로그래스 값
    int ds,dh,ha,hb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ems);
        ButterKnife.bind(this);

        minusDs.setOnClickListener(clicklistener);
        minusDs.setTag(0);
        minusDh.setOnClickListener(clicklistener);
        minusDh.setTag(1);
        minusHa.setOnClickListener(clicklistener);
        minusHa.setTag(2);
        minusHb.setOnClickListener(clicklistener);
        minusHb.setTag(3);
        plusDs.setOnClickListener(clicklistener);
        plusDs.setTag(4);
        plusDh.setOnClickListener(clicklistener);
        plusDh.setTag(5);
        plusHa.setOnClickListener(clicklistener);
        plusHa.setTag(6);
        plusHb.setOnClickListener(clicklistener);
        plusHb.setTag(7);

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

            ds = Integer.parseInt(txtDs.getText().toString());
            dh = Integer.parseInt(txtDh.getText().toString());
            ha = Integer.parseInt(txtHa.getText().toString());
            hb = Integer.parseInt(txtHb.getText().toString());

            if(tag==0 || tag==4){
                setProgress(tag,0,4,ds,"ds");
            }else if(tag==1 || tag==5){
                setProgress(tag,1,5,dh,"dh");
            }else if(tag==2 || tag==6){
                setProgress(tag,2,6,ha,"ha");
            }else if(tag==3 || tag==7){
                setProgress(tag,3,7,hb,"hb");
            }
        }
    };

    public void setProgress(int tag, int minus, int plus, int num, String type){
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
                progressbarDs.setProgress(num);
                txtDs.setText(Integer.toString(num));
                break;
            case "dh":
                progressbarDh.setProgress(num);
                txtDh.setText(Integer.toString(num));
                break;
            case "ha":
                progressbarHa.setProgress(num);
                txtHa.setText(Integer.toString(num));
                break;
            case "hb":
                progressbarHb.setProgress(num);
                txtHb.setText(Integer.toString(num));
                break;
        }
    }
}
