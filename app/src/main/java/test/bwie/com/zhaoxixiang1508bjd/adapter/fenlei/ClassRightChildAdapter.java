package test.bwie.com.zhaoxixiang1508bjd.adapter.fenlei;

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

import test.bwie.com.zhaoxixiang1508bjd.Bean.ClassRightBean;
import test.bwie.com.zhaoxixiang1508bjd.R;

/**
 * Created by admin on 2017/11/03/003.
 */

public class ClassRightChildAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<ClassRightBean.DataBean.ListBean> listBeen;

    private OnItemList onItemList;


    public interface OnItemList{
        void onItem(ClassRightBean.DataBean.ListBean bean);
    }
    public void setOnItemList(OnItemList onItemList){
        this.onItemList=onItemList;
    }
    public ClassRightChildAdapter(Context context,List<ClassRightBean.DataBean.ListBean> listBeen){
        this.context=context;
        this.listBeen=listBeen;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.class_right_child_item,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder holder1= (MyViewHolder) holder;
        ClassRightBean.DataBean.ListBean bean=listBeen.get(position);
        Uri uri=Uri.parse(bean.getIcon());
        holder1.sdv.setImageURI(uri);
        holder1.tv.setText(bean.getName());
        holder1.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemList!=null){
                    onItemList.onItem(listBeen.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if(listBeen!=null){
            return listBeen.size();
        }
        return 0;
    }
    class MyViewHolder extends RecyclerView.ViewHolder{

        private SimpleDraweeView sdv;
        private TextView tv;
        private LinearLayout ll;
        public MyViewHolder(View itemView) {
            super(itemView);
            sdv=itemView.findViewById(R.id.class_right_child_iv);
            tv=itemView.findViewById(R.id.class_right_child_tv);
            ll=itemView.findViewById(R.id.class_right_child_ll);
        }
    }
}
