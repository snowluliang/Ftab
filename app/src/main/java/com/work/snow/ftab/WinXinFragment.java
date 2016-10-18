package com.work.snow.ftab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class WinXinFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater,   ViewGroup container,   Bundle savedInstanceState) {
         // View view =  inflater.inflate(R.layout.weixin_tab,null);
        return inflater.inflate(R.layout.weixin_tab,container,false);


    }
}
