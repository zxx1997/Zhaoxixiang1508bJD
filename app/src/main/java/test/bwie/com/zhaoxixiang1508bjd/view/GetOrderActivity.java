package test.bwie.com.zhaoxixiang1508bjd.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import test.bwie.com.zhaoxixiang1508bjd.Bean.GetOrderBean;
import test.bwie.com.zhaoxixiang1508bjd.R;
import test.bwie.com.zhaoxixiang1508bjd.adapter.GetOrderAdapter;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.Api;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.GsonObjectCallback;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.OkHttp3Utils;

public class GetOrderActivity extends AppCompatActivity {

    private String uid, token;
    private RecyclerView getOrderRlv;
    private Map<String,String> map=new HashMap<>();
    private List<GetOrderBean.DataBean> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_order);

        initView();

        uid=getSharedPreferences("user", Context.MODE_PRIVATE).getString("uid",null);
        token=getSharedPreferences("user",Context.MODE_PRIVATE).getString("token",null);

        map.put("uid",uid);
        map.put("token",token);
        OkHttp3Utils.doPost(Api.GET_ORDER, map, new GsonObjectCallback<GetOrderBean>() {
            @Override
            public void onUi(GetOrderBean getOrderBean) {
                list=getOrderBean.getData();
                GetOrderAdapter adapter=new GetOrderAdapter(GetOrderActivity.this,list);
                getOrderRlv.setAdapter(adapter);
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }

    private void initView() {
        getOrderRlv = (RecyclerView) findViewById(R.id.get_order_rlv);
        getOrderRlv.setLayoutManager(new LinearLayoutManager(this));
    }
}
