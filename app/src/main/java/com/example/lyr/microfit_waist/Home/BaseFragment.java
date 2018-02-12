package com.example.lyr.microfit_waist.Home;

import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * Created by lyr on 2018. 2. 12..
 */

public abstract class BaseFragment extends Fragment {

    protected Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;

    }

}