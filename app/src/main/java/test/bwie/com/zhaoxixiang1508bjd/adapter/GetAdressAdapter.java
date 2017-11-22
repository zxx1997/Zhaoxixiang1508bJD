package test.bwie.com.zhaoxixiang1508bjd.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import test.bwie.com.zhaoxixiang1508bjd.Bean.BaseBean;
import test.bwie.com.zhaoxixiang1508bjd.Bean.GetAdressBean;
import test.bwie.com.zhaoxixiang1508bjd.OnFinishListener;
import test.bwie.com.zhaoxixiang1508bjd.R;
import test.bwie.com.zhaoxixiang1508bjd.module.GetAdress.GetAdressModuleListener;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.Api;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.GsonObjectCallback;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.OkHttp3Utils;

/**
 * Created by admin on 2017/11/16/016.
 */

public class GetAdressAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<GetAdressBean.DataBean> list;
    public GetAdressAdapter(Context context,List<GetAdressBean.DataBean> list){
        this.context=context;
        this.list=list;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.adress_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final GetAdressBean.DataBean bean=list.get(position);
        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.name.setText("姓名："+bean.getName());
        viewHolder.addr.setText("详细地址："+bean.getAddr());
        viewHolder.mobile.setText("电话："+bean.getMobile()+"");
        if(bean.getStatus()==1){
            viewHolder.moren.setText("默认地址");
        }else{
            viewHolder.moren.setText("设为默认地址");
        }
        viewHolder.moren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uid=bean.getUid()+"";
                String addrid=bean.getAddrid()+"";
                int status=bean.getStatus();
                String token=context.getSharedPreferences("user",Context.MODE_PRIVATE).getString("token",null);
                if(status==0){
                    status=1;
                }else{
                    status=0;
                }
                Map<String,String> map=new HashMap<String, String>();
                map.put("uid",uid);
                map.put("addrid",addrid);
                map.put("status",status+"");
                map.put("token",token);

                OkHttp3Utils.doPost(Api.SET_ADRESS, map, new GsonObjectCallback<BaseBean>() {
                    @Override
                    public void onUi(BaseBean baseBean) {
                        Toast.makeText(context,baseBean.getMsg(),Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onFailed(Call call, IOException e) {

                    }
                });
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

        private TextView name,addr,mobile,moren;
        public ViewHolder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.get_adress_name);
            addr=itemView.findViewById(R.id.get_adress_addr);
            mobile=itemView.findViewById(R.id.get_adress_mobile);
            moren=itemView.findViewById(R.id.get_adress_moren);
        }
    }
}
