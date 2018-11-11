package soexample.umeng.com.zhoukao1.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import soexample.umeng.com.zhoukao1.R;
import soexample.umeng.com.zhoukao1.adapter.MyssAdapter;
import soexample.umeng.com.zhoukao1.model.PubusBean;
import soexample.umeng.com.zhoukao1.model.PubusBeanUtils;

public class RightFragment extends Fragment {

    private Unbinder bind;
    @BindView(R.id.recyclerview3)
    public RecyclerView recyclerview3;
    private List<PubusBean> list = new ArrayList<>();
    private MyssAdapter myssAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_right, null, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        myssAdapter = new MyssAdapter(getContext());
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerview3.setLayoutManager(staggeredGridLayoutManager);
        recyclerview3.setAdapter(this.myssAdapter);
        list = PubusBeanUtils.getPubusBeanUtils().query();
        this.myssAdapter.setList(list);
    }


    public void itemClick() {
        //查询数据库
        list = PubusBeanUtils.getPubusBeanUtils().query();
        myssAdapter.setList(list);
        Log.i("嗡嗡嗡无", list + "");
    }

}
