package com.show.jam.safeschool.ui.Fragmnet;

import com.carlosdelachica.easyrecycleradapters.adapter.EasyRecyclerAdapter;
import com.show.jam.safeschool.model.Notice;
import com.smartydroid.android.starter.kit.app.StarterKeysFragment;

import java.util.ArrayList;

import retrofit2.Call;

/**
 * Created by 99165 on 2016/3/3.
 */
public class NoticeFragment extends StarterKeysFragment<Notice> {



    @Override
    public Call<ArrayList<Notice>> paginate(Notice sinceItem, Notice maxItem, int perPage) {
        return null;
    }

    @Override
    public Object getKeyForData(Notice item) {
        return null;
    }

    @Override
    public void bindViewHolders(EasyRecyclerAdapter adapter) {

    }
}
