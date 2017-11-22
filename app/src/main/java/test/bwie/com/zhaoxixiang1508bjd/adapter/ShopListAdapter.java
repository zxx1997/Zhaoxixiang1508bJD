package test.bwie.com.zhaoxixiang1508bjd.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import test.bwie.com.zhaoxixiang1508bjd.Bean.ShopListBean;
import test.bwie.com.zhaoxixiang1508bjd.R;

/**
 * Created by admin on 2017/11/07/007.
 */

public class ShopListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<ShopListBean.DataBean> list;
    private OnItemClick onItemClick;

    public interface OnItemClick {
        void onItem(ShopListBean.DataBean bean);
    }

    public void setOnItem(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public ShopListAdapter(Context context, List<ShopListBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shop_list_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        MyViewHolder viewHolder = (MyViewHolder) holder;
        final ShopListBean.DataBean bean = list.get(position);
        String u=bean.getImages();
        String [] img=null;
        img=u.split("\\|");
        Uri uri=Uri.parse(img[0]);
        viewHolder.sdv.setImageURI(uri);
        viewHolder.title.setText(bean.getTitle());
        viewHolder.price.setText(bean.getPrice()+"");
        viewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClick!=null){
                    onItemClick.onItem(list.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout ll;
        private SimpleDraweeView sdv;
        private TextView title, price;

        public MyViewHolder(View itemView) {
            super(itemView);
            ll = itemView.findViewById(R.id.shop_list_item_ll);
            sdv = itemView.findViewById(R.id.shop_list_item_sdv);
            title = itemView.findViewById(R.id.shop_list_item_title);
            price = itemView.findViewById(R.id.shop_list_item_price);
        }
    }
}
