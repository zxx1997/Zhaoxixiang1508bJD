package test.bwie.com.zhaoxixiang1508bjd.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import test.bwie.com.zhaoxixiang1508bjd.Bean.GetOrderBean;
import test.bwie.com.zhaoxixiang1508bjd.R;
import test.bwie.com.zhaoxixiang1508bjd.pay.PayDemoActivity;

/**
 * Created by admin on 2017/11/16/016.
 */

public class GetOrderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<GetOrderBean.DataBean> list;

    public GetOrderAdapter(Context context,List<GetOrderBean.DataBean> list){
        this.context=context;
        this.list=list;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.get_order_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        GetOrderBean.DataBean bean=list.get(position);
        viewHolder.time.setText(bean.getCreatetime()+"");
        viewHolder.price.setText(bean.getPrice()+"");
        if(bean.getStatus()==0){
            viewHolder.status.setText("待支付");
        }else if(bean.getStatus()==1){
            viewHolder.status.setText("已支付");
        }else if(bean.getStatus()==2){
            viewHolder.status.setText("已取消");
        }

        viewHolder.status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context, PayDemoActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(list!=null){
            return list.size();
        }
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView time,price,status;
        public ViewHolder(View itemView) {
            super(itemView);
            time=itemView.findViewById(R.id.get_order_time);
            price=itemView.findViewById(R.id.get_order_price);
            status=itemView.findViewById(R.id.get_order_status);
        }
    }
}
