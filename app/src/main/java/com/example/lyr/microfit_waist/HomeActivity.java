package com.example.lyr.microfit_waist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;

public class HomeActivity extends AppCompatActivity {

    private ListView listview;
    MainItemAdapter madapter = null;

    //아이템 리스트
    private ArrayList<String> item_list;
    //아이템 이미지 리스트
    private ArrayList<Integer> item_img;
    //아이템 선택되었을 때 이미지 리스트
    private ArrayList<Integer> item_img_select;
    //리스트아이템 뷰
    @BindView(R.id.noti_y)
    Button noti_y;
    ImageView item_imgview;
    TextView item_mtxt;
    TextView item_txt;

    String[] str_item;

    //메인화면으로 보낼 데이터
    int home_num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        item_list = new ArrayList<String>();
        item_img = new ArrayList<Integer>();
        item_img_select = new ArrayList<Integer>();
        item_list.add("프로그램,프로그램을 실행 합니다");
        item_list.add("평가기록,평가기록을 보여 줍니다");
        item_list.add("관리자확인,관리자 메뉴를 실행 합니다");
        item_list.add("설정,설정 메뉴를 실행 합니다");
        item_img.add(R.drawable.ic_program);
        item_img.add(R.drawable.ic_record);
        item_img.add(R.drawable.ic_admin);
        item_img.add(R.drawable.ic_set);
        item_img_select.add(R.drawable.ic_program_press);
        item_img_select.add(R.drawable.ic_record_press);
        item_img_select.add(R.drawable.ic_admin_press);
        item_img_select.add(R.drawable.ic_set_press);

        listview = (ListView) findViewById(R.id.list_home);

        madapter = new MainItemAdapter(getLayoutInflater(), item_list,item_img);
        listview.setAdapter(madapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        home_num = 0;
                        break;
                    case 1:
                        home_num = 1;
                        break;
                    case 2:
                        home_num = 2;
                        break;
                    case 3:
                        home_num = 3;
                        break;
                }
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                intent.putExtra("home_num",home_num);
                startActivity(intent);
            }
        });
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
