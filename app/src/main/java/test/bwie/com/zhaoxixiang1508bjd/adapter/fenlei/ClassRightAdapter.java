package test.bwie.com.zhaoxixiang1508bjd.adapter.fenlei;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import test.bwie.com.zhaoxixiang1508bjd.Bean.ClassRightBean;
import test.bwie.com.zhaoxixiang1508bjd.R;
import test.bwie.com.zhaoxixiang1508bjd.view.ShopListActivity;

/**
 * Created by admin on 2017/11/03/003.
 */

public class ClassRightAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<ClassRightBean.DataBean> list;
    private ClassRightChildAdapter adapter;
    public ClassRightAdapter(Context context,List<ClassRightBean.DataBean> list){
        this.context=context;
        this.list=list;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.class_right_item,parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder viewHolder= (MyViewHolder) holder;
        ClassRightBean.DataBean bean=list.get(position);
        viewHolder.tv.setText(bean.getName());
        viewHolder.rlv.setLayoutManager(new GridLayoutManager(context,3));
        adapter=new ClassRightChildAdapter(context,bean.getList());
        viewHolder.rlv.setAdapter(adapter);
        adapter.setOnItemList(new ClassRightChildAdapter.OnItemList() {
            @Override
            public void onItem(ClassRightBean.DataBean.ListBean bean) {
                Intent intent=new Intent(context, ShopListActivity.class);
                String pscid=bean.getPscid()+"";

                intent.putExtra("pscid",pscid);
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
    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv;
        private RecyclerView rlv;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.class_right_tv);
            rlv=itemView.findViewById(R.id.class_right_child_rlv);
        }
    }
}
