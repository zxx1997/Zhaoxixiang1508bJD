package test.bwie.com.zhaoxixiang1508bjd.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import test.bwie.com.zhaoxixiang1508bjd.Bean.RegBean;
import test.bwie.com.zhaoxixiang1508bjd.R;
import test.bwie.com.zhaoxixiang1508bjd.presenter.reg.RegPresenter;
import test.bwie.com.zhaoxixiang1508bjd.view.listener.RegView;

public class RegActivity extends AppCompatActivity implements RegView {

    private TextView regBack;
    private EditText regUser;
    private EditText regPass;
    private Button regReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        initView();
        final RegPresenter regPresenter=new RegPresenter(this);
        regReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regPresenter.get();
            }
        });
        regBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void getData(RegBean bean) {
        Toast.makeText(this,bean.getMsg(),Toast.LENGTH_LONG).show();
    }

    @Override
    public String getUser() {
        return regUser.getText().toString().trim();
    }

    @Override
    public String getPass() {
        return regPass.getText().toString().trim();
    }

    private void initView() {
        regBack = (TextView) findViewById(R.id.reg_back);
        regUser = (EditText) findViewById(R.id.reg_user);
        regPass = (EditText) findViewById(R.id.reg_pass);
        regReg = (Button) findViewById(R.id.reg_reg);
    }
}
