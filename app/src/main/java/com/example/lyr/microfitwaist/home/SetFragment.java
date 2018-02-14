package com.example.lyr.microfitwaist.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lyr.microfitwaist.R;

import java.util.ArrayList;

/**
 * Created by lyr on 2018. 2. 12..
 */

public class SetFragment extends BaseFragment {

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
        View view = LayoutInflater.from(context).inflate(R.layout.setfragment, null);

        itemList = new ArrayList<String>();
        itemImg = new ArrayList<Integer>();
        selectedItemImg = new ArrayList<Integer>();
        itemList.add("사용자 정보 설정,사용자 정보를 입력합니다");
        itemList.add("자료추출,자료를 추출합니다");
        itemList.add("초기화,시스템 초기화를 진행합니다");
        itemList.add("정보,정보를 확인합니다");
        itemImg.add(R.drawable.ic_user);
        itemImg.add(R.drawable.ic_sample);
        itemImg.add(R.drawable.ic_reset);
        itemImg.add(R.drawable.ic_info);
        selectedItemImg.add(R.drawable.ic_user_press);
        selectedItemImg.add(R.drawable.ic_sample_press);
        selectedItemImg.add(R.drawable.ic_reset_press);
        selectedItemImg.add(R.drawable.ic_info_press);

        listview = (ListView) view.findViewById(R.id.list_set);

        mainItemAdapter = new MainItemAdapter(getLayoutInflater(), itemList,itemImg);
        listview.setAdapter(mainItemAdapter);

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

