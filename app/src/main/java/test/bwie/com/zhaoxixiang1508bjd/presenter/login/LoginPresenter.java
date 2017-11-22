package test.bwie.com.zhaoxixiang1508bjd.presenter.login;

import test.bwie.com.zhaoxixiang1508bjd.Bean.BaseBean;
import test.bwie.com.zhaoxixiang1508bjd.Bean.LoginBean;
import test.bwie.com.zhaoxixiang1508bjd.OnFinishListener;
import test.bwie.com.zhaoxixiang1508bjd.module.login.LoginModule;
import test.bwie.com.zhaoxixiang1508bjd.module.login.LoginModuleListener;
import test.bwie.com.zhaoxixiang1508bjd.presenter.PresenterListener;
import test.bwie.com.zhaoxixiang1508bjd.view.listener.LoginView;

/**
 * Created by admin on 2017/11/02/002.
 */

public class LoginPresenter implements PresenterListener,OnFinishListener{

    LoginView loginView;
    private final LoginModuleListener login;

    public LoginPresenter(LoginView loginView) {
        this.loginView=loginView;
        login=new LoginModule();
    }


    @Override
    public void get() {
        //p跟m关联
        login.getData(this,loginView.getUser(),loginView.getPass());
    }

    @Override
    public void onSuccess(BaseBean baseBean) {
        //关联view
        loginView.getData((LoginBean) baseBean);
    }
}
