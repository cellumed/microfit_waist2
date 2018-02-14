package com.example.lyr.microfitwaist.home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lyr.microfitwaist.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotiActivity extends AppCompatActivity {


    @BindView(R.id.noti_y)
    Button btnOk;
    @BindView(R.id.noti_n)
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noti);

        ButterKnife.bind(this);

        if(Build.VERSION.SDK_INT >= 21){
            getWindow().setStatusBarColor(Color.argb(255,9,46,87));
        }

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotiActivity.this, MainActivity.class);
                NotiActivity.this.startActivity(intent);
                NotiActivity.this.finish();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
