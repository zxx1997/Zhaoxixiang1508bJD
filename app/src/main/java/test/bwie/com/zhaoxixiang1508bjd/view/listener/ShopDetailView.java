package test.bwie.com.zhaoxixiang1508bjd.view.listener;

import test.bwie.com.zhaoxixiang1508bjd.Bean.AddCartBean;
import test.bwie.com.zhaoxixiang1508bjd.Bean.ShopDetailBean;

/**
 * Created by admin on 2017/11/07/007.
 */

public interface ShopDetailView {
    String getPid();
    String getUid();
    String getSellerid();
    void getDateCart(AddCartBean bean);
    void getData(ShopDetailBean bean);

}
