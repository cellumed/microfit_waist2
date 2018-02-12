package com.example.lyr.microfit_waist.Home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lyr.microfit_waist.MainActivity;
import com.example.lyr.microfit_waist.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Act_noti extends AppCompatActivity {


    @BindView(R.id.noti_y)
    Button noti_y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_noti);

        ButterKnife.bind(this);

        if(Build.VERSION.SDK_INT >= 21){
            getWindow().setStatusBarColor(Color.argb(255,9,46,87));
        }

        noti_y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Act_noti.this,MainActivity.class);
                Act_noti.this.startActivity(intent);
                Act_noti.this.finish();
            }
        });

    }
}
