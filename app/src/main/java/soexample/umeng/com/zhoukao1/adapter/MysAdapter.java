package soexample.umeng.com.zhoukao1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import soexample.umeng.com.zhoukao1.MainActivity;
import soexample.umeng.com.zhoukao1.R;
import soexample.umeng.com.zhoukao1.model.PubuBean;
import soexample.umeng.com.zhoukao1.model.PubusBean;
import soexample.umeng.com.zhoukao1.model.PubusBeanUtils;

public class MysAdapter extends RecyclerView.Adapter<MysAdapter.MyViewHolder> {
    private Context context;
    private List<PubuBean.DataBean.ListBean> list;


    public MysAdapter(Context context, List<PubuBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;


    }

    @NonNull
    @Override
    public MysAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.layout_item2, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MysAdapter.MyViewHolder myViewHolder, final int position) {
        String images = list.get(position).getImages();
        String[] split = images.split("[|]");
        myViewHolder.sdview.setImageURI(split[0]);
        myViewHolder.tv_title.setText(list.get(position).getSubhead());
        myViewHolder.tv_price.setText("￥:" + list.get(position).getPrice() + "");

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //保存数据
                //TODO
                PubusBean pubusBean = new PubusBean();
                pubusBean.setImages(list.get(position).getImages());

                pubusBean.setTitle(list.get(position).getSubhead());
                pubusBean.setPrice(list.get(position).getPrice()+"");
                PubusBeanUtils.getPubusBeanUtils().insert(pubusBean);
                Log.i("杀杀杀",pubusBean+"");
                listener.itemClick();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
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

    private OnClickListener listener;

    //传递接口
    public void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
    }


    public interface OnClickListener {
        void itemClick();
    }

}
