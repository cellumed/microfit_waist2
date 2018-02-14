package com.example.lyr.microfitwaist.home;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.util.SparseArray;

/**
 * Created by lyr on 2018. 2. 12..
 */

public class MainPagerAdapter extends FragmentPagerAdapter {

    private final SparseArray<BaseFragment> fragmentArray;


    public MainPagerAdapter(FragmentManager fm) {
        super(fm);

        fragmentArray = new SparseArray<>();

        fragmentArray.put(0, new ConnectFragment());
        fragmentArray.put(1, new ProgramFragment());
        fragmentArray.put(2, new SetFragment());
    }

    @Override
    public BaseFragment getItem(int position) {
        Log.d("TAG","태그 num : "+position);
        return fragmentArray.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArray.size();
    }
}