package com.example.lyr.microfit_waist.Home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lyr.microfit_waist.R;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by lyr on 2018. 2. 12..
 */

public class AdminFragment extends BaseFragment {

    private ListView listview;
    MainItemAdapter madapter = null;

    //아이템 리스트
    private ArrayList<String> item_list;
    //아이템 이미지 리스트
    private ArrayList<Integer> item_img;
    //아이템 선택되었을 때 이미지 리스트
    private ArrayList<Integer> item_img_select;
    //리스트아이템 뷰
    ImageView item_imgview;
    TextView item_mtxt;
    TextView item_txt;

    String[] str_item;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        @SuppressLint("InflateParams")
        View view = LayoutInflater.from(context).inflate(R.layout.adminfragment, null);

        item_list = new ArrayList<String>();
        item_img = new ArrayList<Integer>();
        item_img_select = new ArrayList<Integer>();
        item_list.add("EMS,EMS");
        item_list.add("EMG,EMG");
        item_list.add("IMU,IMU");
        item_img.add(R.drawable.ic_ems);
        item_img.add(R.drawable.ic_emg);
        item_img.add(R.drawable.ic_imu);
        item_img_select.add(R.drawable.ic_ems_press);
        item_img_select.add(R.drawable.ic_emg_press);
        item_img_select.add(R.drawable.ic_imu_press);

        listview = (ListView) view.findViewById(R.id.list_admin);

        madapter = new MainItemAdapter(getLayoutInflater(), item_list,item_img);
        listview.setAdapter(madapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0 :
                        Intent intent = new Intent(getActivity() , Act_EMS.class);
                        startActivity(intent);
                }
            }
        });

        return view;
    }
    class MainItemAdapter extends BaseAdapter {
        ArrayList<String> item_list;
        ArrayList<Integer> item_img;
        LayoutInflater inflater;


        // 생성자
        public MainItemAdapter(LayoutInflater inflater, ArrayList<String> item_list,ArrayList<Integer> item_img) {
            this.item_list = item_list;
            this.item_img = item_img;
            this.inflater = inflater;

        }

        // 총 개수를 리턴함.
        @Override
        public int getCount() {
            return item_list.size();
        }

        // 해당 위치의 object를 리턴함.
        @Override
        public Object getItem(int position) {
            return item_list.get(position);
        }

        // 위치값을 리턴함.
        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = inflater.inflate(R.layout.listview_item, null);
            }

            item_imgview = (ImageView) convertView.findViewById(R.id.item_img);
            item_mtxt = (TextView) convertView.findViewById(R.id.item_mtxt);
            item_txt = (TextView) convertView.findViewById(R.id.item_txt);

            str_item = item_list.get(position).split(",");

            item_imgview.setImageResource(item_img.get(position));
            item_mtxt.setText(str_item[0]);
            item_txt.setText(str_item[1]);

//            convertView.setOnTouchListener(new View.OnTouchListener() {
//
//                @Override
//                public boolean onTouch(View view, MotionEvent motionEvent) {
//                    if(motionEvent.getAction()== MotionEvent.ACTION_DOWN){
//                        item_imgview.setImageResource(item_img_select.get(position));
//                        item_mtxt.setTextColor(Color.argb(255,198,255,0));
//                    }else if(motionEvent.getAction()== MotionEvent.ACTION_UP){
//                        item_imgview.setImageResource(item_img.get(position));
//                        item_mtxt.setTextColor(Color.WHITE);
//                    }
//                    return false;
//                }
//            });

            return convertView;
        }
    }

}

