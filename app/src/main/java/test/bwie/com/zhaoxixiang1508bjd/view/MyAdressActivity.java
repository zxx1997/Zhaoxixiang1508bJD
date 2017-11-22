package test.bwie.com.zhaoxixiang1508bjd.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import test.bwie.com.zhaoxixiang1508bjd.Bean.AddAdressBean;
import test.bwie.com.zhaoxixiang1508bjd.R;
import test.bwie.com.zhaoxixiang1508bjd.presenter.AddAdress.AddAdressPrestener;
import test.bwie.com.zhaoxixiang1508bjd.view.listener.AddAdressView;

public class MyAdressActivity extends AppCompatActivity implements AddAdressView{

    private EditText adressName;
    private EditText adressMobile;
    private EditText adressAdress;
    private Button adressBt;
    private String uid,token,name,mobile,addr;
    private AddAdressPrestener prestener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_adress);

        initView();
        prestener=new AddAdressPrestener(this);
        adressBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=adressName.getText().toString().trim();
                mobile=adressMobile.getText().toString().trim();
                addr=adressAdress.getText().toString().trim();
                prestener.get();
            }
        });
    }

    private void initView() {
        adressName = (EditText) findViewById(R.id.adress_name);
        adressMobile = (EditText) findViewById(R.id.adress_mobile);
        adressAdress = (EditText) findViewById(R.id.adress_adress);
        adressBt = (Button) findViewById(R.id.adress_bt);
        uid=getSharedPreferences("user", Context.MODE_PRIVATE).getString("uid",null);
        token=getSharedPreferences("user",Context.MODE_PRIVATE).getString("token",null);
    }

    @Override
    public void getData(AddAdressBean bean) {
        Toast.makeText(this,bean.getMsg(),Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public String getUid() {
        return uid;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getMobile() {
        return mobile;
    }

    @Override
    public String getAdress() {
        return addr;
    }

    @Override
    public String getToken() {
        return token;
    }
}
