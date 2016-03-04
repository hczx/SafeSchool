package com.show.jam.safeschool.ui.Fragmnet;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.show.jam.safeschool.R;
import com.show.jam.safeschool.model.Banner;

import java.lang.ref.WeakReference;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 99165 on 2016/3/3.
 */
public class HomeFragment extends BaseFragmnt {
    @Bind(R.id.frg_homepage_search_button)
    LinearLayout mSearchBtn;
    @Bind(R.id.frg_homepage_toolbal)
    Toolbar nToolbar;
    @Bind(R.id.frg_homepage_top_viewpager)
    ViewPager mBannerViewPager;
    @Bind(R.id.frg_homepage_dot_group)
    LinearLayout mDotGroup;
    @Bind(R.id.frg_homepage_banner_container)
    RelativeLayout mBannerContainer;
    @Bind(R.id.frg_homepage_top_tablayout)
    TabLayout mTabLayout;
    @Bind(R.id.frg_homepage_content_viewpager)
    ViewPager mContentViewPager;


    private List<View> mImgList;//Fresco图片容器集合
    private List<Banner> mImgUrlList;//网络图片地址URL
    private int preDotPosition = 0;//点的上一个位置

    private final static long PLAY_DELA = 3000;//切换图片的延时
    private final static int  WHAT_AUTO_PLAY = 1000;
    private boolean isLoadBanner = false;

    private BannerAutoPlayHandler mHandler;
    private HomeFragmentPagerAdapter mFragmentAdapter;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragmnet_home;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    /**
     * 出去可能引起的内存泄露
     */
    private static class BannerAutoPlayHandler extends Handler {

        private final WeakReference<HomeFragment> mFragment;

        private BannerAutoPlayHandler(WeakReference<HomeFragment> mFragment) {
            this.mFragment = mFragment;
        }

        @Override
        public void handleMessage(Message msg) {
            HomeFragment homeContainerFrgament = mFragment.get();
            if (homeContainerFrgament != null) {
                homeContainerFrgament.mBannerViewPager.setCurrentItem(
                        homeContainerFrgament.mBannerViewPager.getCurrentItem() + 1
                );
                BannerAutoPlayHandler.this.sendEmptyMessageDelayed(WHAT_AUTO_PLAY,PLAY_DELA);
            }
        }
    }
}
