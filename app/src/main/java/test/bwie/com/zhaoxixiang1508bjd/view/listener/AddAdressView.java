package test.bwie.com.zhaoxixiang1508bjd.view.listener;

import test.bwie.com.zhaoxixiang1508bjd.Bean.AddAdressBean;

/**
 * Created by admin on 2017/11/15/015.
 */

public interface AddAdressView {
    void getData(AddAdressBean bean);
    String getUid();
    String getName();
    String getMobile();
    String getAdress();
    String getToken();
}
