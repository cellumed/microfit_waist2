package com.example.lyr.microfit_waist.Home;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.util.SparseArray;

/**
 * Created by lyr on 2018. 2. 12..
 */

public class MainPagerAdapter extends FragmentPagerAdapter {

    private final SparseArray<BaseFragment> mFragments;


    public MainPagerAdapter(FragmentManager fm) {
        super(fm);

        mFragments = new SparseArray<>();

        mFragments.put(0, new ProgramFragment());
        mFragments.put(1, new RecordFragment());
        mFragments.put(2, new AdminFragment());
        mFragments.put(3, new SetFragment());
    }

    @Override
    public BaseFragment getItem(int position) {
        Log.d("TAG","태그 num : "+position);
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}