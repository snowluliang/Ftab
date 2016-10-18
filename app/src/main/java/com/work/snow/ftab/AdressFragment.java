package com.work.snow.ftab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Snow on 2016/10/14.
 *
 */
public class AdressFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater,   ViewGroup container,  Bundle savedInstanceState) {
           View view =  inflater.inflate(R.layout.adress_tab,container,false);
        return view;

    }

}
