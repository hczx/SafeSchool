package com.show.jam.safeschool.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.show.jam.safeschool.ui.Fragmnet.NoticeFragment;

/**
 * Created by 99165 on 2016/3/3.
 */
public class HomeFragmentPagerAdapter extends FragmentStatePagerAdapter {


    private final String TAB_TITLE[] = {"通知公告", "365在线", "热点聚焦"};
    private Fragment fragment1;
    private Fragment fragment2;
    private Fragment fragment3;

    public HomeFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        fragment1 = new NoticeFragment();
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
