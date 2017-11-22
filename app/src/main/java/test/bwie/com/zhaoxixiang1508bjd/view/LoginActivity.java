package test.bwie.com.zhaoxixiang1508bjd.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import test.bwie.com.zhaoxixiang1508bjd.Bean.LoginBean;
import test.bwie.com.zhaoxixiang1508bjd.MainActivity;
import test.bwie.com.zhaoxixiang1508bjd.R;
import test.bwie.com.zhaoxixiang1508bjd.presenter.login.LoginPresenter;
import test.bwie.com.zhaoxixiang1508bjd.view.fragment.FragMyself;
import test.bwie.com.zhaoxixiang1508bjd.view.listener.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView{

    private TextView loginBack;
    private EditText loginUser;
    private EditText loginPass;
    private Button loginLogin;
    private TextView loginReg;
    private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        final LoginPresenter presenter=new LoginPresenter(this);
        loginReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,RegActivity.class);
                startActivity(intent);
            }
        });
        loginLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.get();
            }
        });
        loginBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initView() {
        loginBack = (TextView) findViewById(R.id.login_back);
        loginUser = (EditText) findViewById(R.id.login_user);
        loginPass = (EditText) findViewById(R.id.login_pass);
        loginLogin = (Button) findViewById(R.id.login_login);
        loginReg = (TextView) findViewById(R.id.login_reg);

    }

    @Override
    public void getData(LoginBean bean) {
        String code=bean.getCode();
        if(code.equals("0")){
            preferences=getSharedPreferences("user", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=preferences.edit();
            editor.putString("uid",bean.getData().getUid()+"");
            editor.putString("token",bean.getData().getToken().toString());
            editor.commit();
            Intent intent=new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("myself",1);
            startActivity(intent);
        }
        //Toast.makeText(this,bean.getData().getUid()+"",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public String getUser() {
        return loginUser.getText().toString().trim();
    }

    @Override
    public String getPass() {
        return loginPass.getText().toString().trim();
    }
}
