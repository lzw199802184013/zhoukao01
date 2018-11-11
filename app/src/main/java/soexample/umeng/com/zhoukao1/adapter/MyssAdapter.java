package soexample.umeng.com.zhoukao1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import soexample.umeng.com.zhoukao1.R;
import soexample.umeng.com.zhoukao1.model.PubuBean;
import soexample.umeng.com.zhoukao1.model.PubusBean;
import soexample.umeng.com.zhoukao1.model.PubusBeanUtils;

public class MyssAdapter extends RecyclerView.Adapter<MyssAdapter.MyViewHolder> {
    private Context context;
    private List<PubusBean> list = new ArrayList<>();


    public MyssAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyssAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.layout_item2, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyssAdapter.MyViewHolder myViewHolder, int position) {
        String images = list.get(position).getImages();
        String[] split = images.split("[|]");
        myViewHolder.sdview.setImageURI(split[0]);
        myViewHolder.tv_title.setText(list.get(position).getTitle());
        myViewHolder.tv_price.setText("￥:" + list.get(position).getPrice() + "");


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<PubusBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.sdview)
        public SimpleDraweeView sdview;
        @BindView(R.id.tv_title)
        public TextView tv_title;
        @BindView(R.id.tv_price)
        public TextView tv_price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
