package test.bwie.com.zhaoxixiang1508bjd.adapter.fenlei;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import test.bwie.com.zhaoxixiang1508bjd.Bean.ClassLeftBean;
import test.bwie.com.zhaoxixiang1508bjd.R;

/**
 * Created by admin on 2017/11/03/003.
 */

public class ClassLeftAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<ClassLeftBean.DataBean> list;
    private OnItemList onItemList;


    public interface OnItemList{
        void onItem(ClassLeftBean.DataBean bean);
    }
    public void setOnItemList(OnItemList onItemList){
        this.onItemList=onItemList;
    }

    public ClassLeftAdapter(Context context,List<ClassLeftBean.DataBean> list){
        this.context=context;
        this.list=list;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.class_left_item,parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder viewHolder= (MyViewHolder) holder;
        ClassLeftBean.DataBean bean=list.get(position);
        viewHolder.tv.setText(bean.getName());
        Uri uri=Uri.parse(bean.getIcon());
        viewHolder.sdv.setImageURI(uri);
        viewHolder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemList!=null){
                    onItemList.onItem(list.get(position));
                }
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
    class MyViewHolder extends RecyclerView.ViewHolder{
        private SimpleDraweeView sdv;
        private TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.class_left_tv);
            sdv=itemView.findViewById(R.id.class_left_iv);
        }
    }
}
