package test.bwie.com.zhaoxixiang1508bjd.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import test.bwie.com.zhaoxixiang1508bjd.Bean.BaseBean;
import test.bwie.com.zhaoxixiang1508bjd.Bean.GetCartBean;
import test.bwie.com.zhaoxixiang1508bjd.R;
import test.bwie.com.zhaoxixiang1508bjd.adapter.GetCartAdapter;
import test.bwie.com.zhaoxixiang1508bjd.eventbus.MessageCountEvent;
import test.bwie.com.zhaoxixiang1508bjd.eventbus.MessageEvent;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.Api;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.GsonObjectCallback;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.OkHttp3Utils;
import test.bwie.com.zhaoxixiang1508bjd.presenter.GetCart.GetCartPresenter;
import test.bwie.com.zhaoxixiang1508bjd.view.GetOrderActivity;
import test.bwie.com.zhaoxixiang1508bjd.view.ShopDetailActivity;
import test.bwie.com.zhaoxixiang1508bjd.view.listener.GetCartView;

/**
 * Created by admin on 2017/11/01/001.
 */

public class FragGouwuche extends Fragment implements GetCartView{

    private String uid;
    private String token;
    private ExpandableListView elv;
    private CheckBox cball;
    private Button pay,delete;
    private GetCartPresenter presenter;
    private GetCartAdapter adapter;
    private TextView sum;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        EventBus.getDefault().register(this);

        View view=LayoutInflater.from(getActivity()).inflate(R.layout.frag_gouwuche,container,false);

        presenter=new GetCartPresenter(this);
        uid=getActivity().getSharedPreferences("user", Context.MODE_PRIVATE).getString("uid",null);
        token=getActivity().getSharedPreferences("user",Context.MODE_PRIVATE).getString("token",null);
        elv=view.findViewById(R.id.get_cart_elv);
        cball=view.findViewById(R.id.get_cart_cb_all);
        pay=view.findViewById(R.id.get_cart_bt_pay);
        delete=view.findViewById(R.id.get_cart_bt_delete);
        sum=view.findViewById(R.id.get_cart_sum);
        presenter.get();

        cball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.allChecked(cball.isChecked());
            }
        });

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String price=sum.getText().toString();
                uid = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE).getString("uid", null);
                token=getActivity().getSharedPreferences("user",Context.MODE_PRIVATE).getString("token",null);

                Map<String,String> map=new HashMap<String, String>();
                map.put("uid",uid);
                map.put("price",price);
                map.put("token",token);
                OkHttp3Utils.doPost(Api.ADD_ORDER, map, new GsonObjectCallback<BaseBean>() {
                    @Override
                    public void onUi(BaseBean baseBean) {
                        Toast.makeText(getActivity(),baseBean.getMsg(),Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(getActivity(),GetOrderActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailed(Call call, IOException e) {

                    }
                });
            }
        });
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe
    public void messageCountEvent(MessageCountEvent msg){
        sum.setText(msg.getCount()+"");

    }
    @Subscribe
    public void messageEvent(MessageEvent msg){
        cball.setChecked(msg.isFlag());
    }
    @Override
    public void getData(GetCartBean bean) {
        List<GetCartBean.DataBean> list=new ArrayList<>();
        list=bean.getData();
        adapter=new GetCartAdapter(getActivity(),list);
        elv.setAdapter(adapter);
        for (int i=0;i<list.size();i++){
            elv.expandGroup(i);
        }

    }

    @Override
    public String getUid() {
        return uid;
    }

    @Override
    public String getToken() {
        return token;
    }
}
