package test.bwie.com.zhaoxixiang1508bjd.view.listener;

import test.bwie.com.zhaoxixiang1508bjd.Bean.UserInfoBean;

/**
 * Created by admin on 2017/11/03/003.
 */

public interface UserInfoView {
    void getData(UserInfoBean bean);
    String getUid();
    String getToken();
}
