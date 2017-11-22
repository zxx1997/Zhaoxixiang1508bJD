package test.bwie.com.zhaoxixiang1508bjd.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import test.bwie.com.zhaoxixiang1508bjd.Bean.GetAdressBean;
import test.bwie.com.zhaoxixiang1508bjd.R;
import test.bwie.com.zhaoxixiang1508bjd.adapter.GetAdressAdapter;
import test.bwie.com.zhaoxixiang1508bjd.presenter.GetAdress.GetAdressPrestener;
import test.bwie.com.zhaoxixiang1508bjd.view.listener.GetAdressView;

public class GetAdressActivity extends AppCompatActivity implements GetAdressView{

    private Button getAdressAddBt;
    private RecyclerView getAdressRlv;
    private GetAdressPrestener prestener;
    private String uid,token;
    private List<GetAdressBean.DataBean> list;
    private GetAdressAdapter adressAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_adress);

        initView();
        prestener=new GetAdressPrestener(this);
        prestener.get();
        getAdressAddBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(GetAdressActivity.this,MyAdressActivity.class);
                startActivity(intent);
            }
        });


    }

    private void initView() {
        getAdressAddBt = (Button) findViewById(R.id.get_adress_add_bt);
        getAdressRlv = (RecyclerView) findViewById(R.id.get_adress_rlv);
        getAdressRlv.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();

        uid=getSharedPreferences("user", Context.MODE_PRIVATE).getString("uid",null);
        token=getSharedPreferences("user",Context.MODE_PRIVATE).getString("token",null);
    }

    @Override
    public void getData(GetAdressBean bean) {
        list=bean.getData();
        adressAdapter=new GetAdressAdapter(this,list);
        getAdressRlv.setAdapter(adressAdapter);
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
