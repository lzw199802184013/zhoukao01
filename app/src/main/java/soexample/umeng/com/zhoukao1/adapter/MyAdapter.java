package soexample.umeng.com.zhoukao1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import soexample.umeng.com.zhoukao1.R;
import soexample.umeng.com.zhoukao1.model.PubuBean;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private List<PubuBean.DataBean> data1;


    public MyAdapter(Context context, List<PubuBean.DataBean> data1) {
        this.context = context;
        this.data1 = data1;

    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.layout_item, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder myViewHolder, int position) {
        myViewHolder.tv_name.setText(data1.get(position).getSellerName());
        createRecyclerview(myViewHolder.recyclerview2, data1.get(position).getList());
    }

    private void createRecyclerview(RecyclerView recyclerview2, List<PubuBean.DataBean.ListBean> list) {
        MysAdapter mysAdapter = new MysAdapter(context, list);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerview2.setLayoutManager(staggeredGridLayoutManager);
        recyclerview2.setAdapter(mysAdapter);
        //接口回调
        mysAdapter.setOnClickListener(new MysAdapter.OnClickListener() {
            @Override
            public void itemClick() {
                listener.itemClick();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data1.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        public TextView tv_name;
        @BindView(R.id.recyclerview2)
        public RecyclerView recyclerview2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    private OnClickListener listener;
    //传递接口
    public void setOnClickListener(OnClickListener listener){
        this.listener=listener;
    }


    public interface  OnClickListener{
        void itemClick();
    }
}
