package com.show.jam.safeschool.ui.activity;

import android.media.tv.TvContentRating;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.show.jam.safeschool.R;
import com.show.jam.safeschool.ui.Fragmnet.AccountFragment;
import com.show.jam.safeschool.ui.Fragmnet.ClassCircleFragmnet;
import com.show.jam.safeschool.ui.Fragmnet.EducationFragment;
import com.show.jam.safeschool.ui.Fragmnet.HomeFragment;
import com.show.jam.safeschool.ui.Fragmnet.MessageFragment;
import com.smartydroid.android.starter.kit.app.StarterActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends StarterActivity {

    public static final String TAB_HOME = "tag_home_identifier";
    public static final String TAB_MESSAGE = "tag_message_identifier";
    public static final String TAB_EDUCATION = "tag_education_identifier";
    public static final String TAB_CLASS_CIRCLE = "tab_class_identifier";
    public static final String TAB_ACCOUNT = "tag_account_identifier";

    @Bind(R.id.mian_tabhost)
    FragmentTabHost mTabhost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTabHost();
    }

    private void setTabHost() {
        mTabhost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        mTabhost.addTab(createTabSpec(TAB_HOME, R.string.tab_home, R.drawable.selector_tab_home), HomeFragment.class, null);
        mTabhost.addTab(createTabSpec(TAB_MESSAGE, R.string.tab_message, R.drawable.selector_tab_messge), MessageFragment.class, null);
        mTabhost.addTab(createTabSpec(TAB_EDUCATION, R.string.tab_education, R.drawable.selector_tab_education), EducationFragment.class, null);
        mTabhost.addTab(createTabSpec(TAB_CLASS_CIRCLE, R.string.tab_class_circle, R.drawable.selector_tab_class_circle), ClassCircleFragmnet.class, null);
        mTabhost.addTab(createTabSpec(TAB_ACCOUNT, R.string.tab_account, R.drawable.selector_tab_account), AccountFragment.class, null);
    }

    private TabHost.TabSpec createTabSpec(String tag, int stringRes, int drawableResId) {
        TabHost.TabSpec spec = mTabhost.newTabSpec(tag);
        spec.setIndicator(createTabIndicator(stringRes, drawableResId));
        spec.setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String tag) {
                return findViewById(android.R.id.tabcontent);
            }
        });
        return spec;
    }


    /**
     * android.R.id.icon1 固定
     * 设置底部布局
     */
    private View createTabIndicator(int res, int drawableResId) {
        LinearLayout tabIndicator = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.tab_indicator, mTabhost.getTabWidget(), false);
        ImageView icon = (ImageView) tabIndicator.findViewById(android.R.id.icon1);
        icon.setImageResource(drawableResId);
        TextView text = (TextView) tabIndicator.findViewById(android.R.id.text1);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tabIndicator.getLayoutParams();
        tabIndicator.setEnabled(true);
        params.weight = 1.0F;
        tabIndicator.setGravity(Gravity.CENTER);
        return tabIndicator;
    }
}
