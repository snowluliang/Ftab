package com.work.snow.ftab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private ViewPager mViewPager;

    private List<Fragment> mFragment;

    private LinearLayout llWinxin;
    private LinearLayout llAddress;
    private LinearLayout llFriend;
    private LinearLayout llSetting;

    private ImageButton ibWeixin;
    private ImageButton ibAddress;
    private ImageButton ibFriend;
    private ImageButton ibSetting;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
        selectId(0);
    }



    private void initEvent() {
        llWinxin.setOnClickListener(this);
        llAddress.setOnClickListener(this);
        llFriend.setOnClickListener(this);
        llSetting.setOnClickListener(this);
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.mViewPag);
        mFragment = new ArrayList<Fragment>();
        //LinearLayout  的控件
        llWinxin = (LinearLayout) findViewById(R.id.tab_weixin);
        llAddress = (LinearLayout) findViewById(R.id.tab_adress);
        llFriend = (LinearLayout) findViewById(R.id.tab_friend);
        llSetting = (LinearLayout) findViewById(R.id.tab_setting);
        //ImageButton 的控件
        ibWeixin = (ImageButton) findViewById(R.id.ib_weixin);
        ibAddress = (ImageButton) findViewById(R.id.ib_adress);
        ibFriend = (ImageButton) findViewById(R.id.ib_friend);
        ibSetting = (ImageButton) findViewById(R.id.ib_setting);
        //Fragment 初始化

        Fragment fWeixin = new WinXinFragment();
        Fragment fAddress = new AdressFragment();
        Fragment fFriend = new FriendFragment();
        Fragment fSetting = new SettingFragment();
        mFragment.add(fWeixin);
        mFragment.add(fAddress);
        mFragment.add(fFriend);
        mFragment.add(fSetting);

        FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                return mFragment.get(position);
            }

            @Override
            public int getCount() {
                return mFragment.size();
            }
        };
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
               int currentItem = mViewPager.getCurrentItem();
                restImgs();
                switch (currentItem) {
                    case 0:
                        ibWeixin.setImageResource(R.drawable.tab_weixin_pressed);
                        break;
                    case 1:
                        ibAddress.setImageResource(R.drawable.tab_address_pressed);
                        break;
                    case 2:
                        ibFriend.setImageResource(R.drawable.tab_find_frd_pressed);
                        break;
                    case 3:
                        ibSetting.setImageResource(R.drawable.tab_settings_pressed);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private void selectId(int i) {

        restImgs();
        switch (i) {
            case 0:
                ibWeixin.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case 1:
                ibAddress.setImageResource(R.drawable.tab_address_pressed);
                break;
            case 2:
                ibFriend.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case 3:
                ibSetting.setImageResource(R.drawable.tab_settings_pressed);
                break;

        }
        mViewPager.setCurrentItem(i);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab_weixin:
                selectId(0);
                break;
            case R.id.tab_adress:
                selectId(1);
                break;
            case R.id.tab_friend:
                selectId(2);
                break;
            case R.id.tab_setting:
                selectId(3);
                break;

        }

    }

    private void restImgs() {
        ibWeixin.setImageResource(R.drawable.tab_weixin_normal);
        ibAddress.setImageResource(R.drawable.tab_address_normal);
        ibFriend.setImageResource(R.drawable.tab_find_frd_normal);
        ibSetting.setImageResource(R.drawable.tab_settings_normal);
    }

}


