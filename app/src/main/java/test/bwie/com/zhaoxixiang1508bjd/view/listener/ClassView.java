package test.bwie.com.zhaoxixiang1508bjd.view.listener;

import test.bwie.com.zhaoxixiang1508bjd.Bean.ClassLeftBean;
import test.bwie.com.zhaoxixiang1508bjd.Bean.ClassRightBean;

/**
 * Created by admin on 2017/11/03/003.
 */

public interface ClassView {
    void getDataLeft(ClassLeftBean bean);
    void getDataRight(ClassRightBean bean);
    String getCid();
}
