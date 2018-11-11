package soexample.umeng.com.zhoukao1.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import soexample.umeng.com.zhoukao1.MainActivity;
import soexample.umeng.com.zhoukao1.R;
import soexample.umeng.com.zhoukao1.adapter.MyAdapter;
import soexample.umeng.com.zhoukao1.adapter.MysAdapter;
import soexample.umeng.com.zhoukao1.model.PubuBean;
import soexample.umeng.com.zhoukao1.net.HelperUtils;
import soexample.umeng.com.zhoukao1.net.HttpUtils;

public class LeftFragment extends Fragment {

    private Unbinder bind;
    @BindView(R.id.recyclerview)
    public RecyclerView recyclerview;
    private String dataUrl = "http://www.zhaoapi.cn/product/getCarts?uid=71";
    private List<PubuBean.DataBean> data1 = new ArrayList<>();
    private MyAdapter myAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_left, null, false);
        bind = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        doGet();
        doHttp();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(linearLayoutManager);
    }


//    private void doGet() {
//        new HttpUtils().get(dataUrl).result(new HttpUtils.HttpListener() {
//            @Override
//            public void success(String data) {
//                Gson gson = new Gson();
//                PubuBean pubuBean = gson.fromJson(data, PubuBean.class);
//                data1 = pubuBean.getData();
//                myAdapter = new MyAdapter(getActivity(), data1);
//                recyclerview.setAdapter(myAdapter);
//                myAdapter.setOnClickListener(new MyAdapter.OnClickListener() {
//                    @Override
//                    public void itemClick() {
//                        if (getActivity() instanceof MainActivity) {
//                            ((MainActivity) getActivity()).itemClick();
//
//                        }
//                    }
//                });
//            }
//
//            @Override
//            public void fail() {
//
//            }
//        });
//
//    }


    //解绑
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
    }

    private void doHttp() {
        Map<String, String> map = new HashMap<>();
        map.put("uid", "71");
        new HelperUtils().get("/product/getCarts", map).result(new HelperUtils.HttpListeners() {
            @Override
            public void success(String data) {
                Gson gson = new Gson();
                PubuBean pubuBean = gson.fromJson(data, PubuBean.class);
                pubuBean.getMsg();
                pubuBean.getCode();
                Toast.makeText(getActivity(), pubuBean.getMsg() + ""+pubuBean.getCode(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void fail(String error) {

            }
        });
    }
}
