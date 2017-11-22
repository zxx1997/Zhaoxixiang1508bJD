package test.bwie.com.zhaoxixiang1508bjd.view.listener;

import test.bwie.com.zhaoxixiang1508bjd.Bean.LoginBean;
import test.bwie.com.zhaoxixiang1508bjd.Bean.RegBean;

/**
 * Created by admin on 2017/11/02/002.
 */

public interface LoginView {
    void getData(LoginBean bean);
    String getUser();
    String getPass();
}
