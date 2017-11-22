package test.bwie.com.zhaoxixiang1508bjd.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import test.bwie.com.zhaoxixiang1508bjd.Bean.UserInfoBean;
import test.bwie.com.zhaoxixiang1508bjd.R;
import test.bwie.com.zhaoxixiang1508bjd.presenter.getUserInfo.UserInfoPresenter;
import test.bwie.com.zhaoxixiang1508bjd.view.GetAdressActivity;
import test.bwie.com.zhaoxixiang1508bjd.view.LoginActivity;
import test.bwie.com.zhaoxixiang1508bjd.view.MyAdressActivity;
import test.bwie.com.zhaoxixiang1508bjd.view.listener.UserInfoView;

/**
 * Created by admin on 2017/11/01/001.
 */

public class FragMyself extends Fragment implements UserInfoView {

    private ImageView myselfUserIv;
    private TextView myselfUserLogin;
    private TextView address;
    private String uid;
    private String username;
    private SharedPreferences preferences;
    private String token;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.frag_myself, container, false);
        UserInfoPresenter presenter = new UserInfoPresenter(this);
        myselfUserIv = (ImageView) view.findViewById(R.id.myself_user_iv);
        myselfUserLogin = (TextView) view.findViewById(R.id.myself_user_login);
        address=view.findViewById(R.id.myself_address);

        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), GetAdressActivity.class);
                getActivity().startActivity(intent);
            }
        });

        preferences = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        uid = preferences.getString("uid", null);
        token=preferences.getString("token",null);
        if (uid != null&&token!=null) {
            presenter.get();
            //myselfUserLogin.setText("注册/登录");
        }
        myselfUserLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }


    @Override
    public void getData(UserInfoBean bean) {
        //if(bean!=null){
        username = bean.getData().getUsername();
        myselfUserLogin.setText(username);
        // }

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
