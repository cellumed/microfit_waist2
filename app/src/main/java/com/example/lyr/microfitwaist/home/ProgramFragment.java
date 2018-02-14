package com.example.lyr.microfitwaist.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lyr.microfitwaist.R;

import java.util.ArrayList;

/**
 * Created by lyr on 2018. 2. 12..
 */

public class ProgramFragment extends BaseFragment {

    private ListView listview;
    MainItemAdapter mainItemAdapter = null;

    //아이템 리스트
    private ArrayList<String> itemList;
    //아이템 이미지 리스트
    private ArrayList<Integer> itemImg;
    //아이템 선택되었을 때 이미지 리스트
    private ArrayList<Integer> selectedItemImg;
    //리스트아이템 뷰
    ImageView imageView;
    TextView txtMain;
    TextView txtSub;

    String[] itemText;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        @SuppressLint("InflateParams")
        View view = LayoutInflater.from(context).inflate(R.layout.adminfragment, null);

        itemList = new ArrayList<String>();
        itemImg = new ArrayList<Integer>();
        selectedItemImg = new ArrayList<Integer>();
        itemList.add("EMS,EMS");
        itemList.add("EMG,EMG");
        itemList.add("IMU,IMU");
        itemImg.add(R.drawable.ic_ems);
        itemImg.add(R.drawable.ic_emg);
        itemImg.add(R.drawable.ic_imu);
        selectedItemImg.add(R.drawable.ic_ems_press);
        selectedItemImg.add(R.drawable.ic_emg_press);
        selectedItemImg.add(R.drawable.ic_imu_press);

        listview = (ListView) view.findViewById(R.id.list_admin);

        mainItemAdapter = new MainItemAdapter(getLayoutInflater(), itemList,itemImg);
        listview.setAdapter(mainItemAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position){
                    case 0 :
                        Intent intent = new Intent(getActivity() , EMSActivity.class);
                        startActivity(intent);
                }
            }
        });

        return view;
    }
    class MainItemAdapter extends BaseAdapter {
        ArrayList<String> itemList;
        ArrayList<Integer> itemImg;
        LayoutInflater inflater;


        // 생성자
        public MainItemAdapter(LayoutInflater inflater, ArrayList<String> itemList,ArrayList<Integer> itemImg) {
            this.itemList = itemList;
            this.itemImg = itemImg;
            this.inflater = inflater;

        }

        // 총 개수를 리턴함.
        @Override
        public int getCount() {
            return itemList.size();
        }

        // 해당 위치의 object를 리턴함.
        @Override
        public Object getItem(int position) {
            return itemList.get(position);
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

            imageView = (ImageView) convertView.findViewById(R.id.item_img);
            txtMain = (TextView) convertView.findViewById(R.id.item_mtxt);
            txtSub = (TextView) convertView.findViewById(R.id.item_txt);

            itemText = itemList.get(position).split(",");

            imageView.setImageResource(itemImg.get(position));
            txtMain.setText(itemText[0]);
            txtSub.setText(itemText[1]);

            return convertView;
        }
    }

}

