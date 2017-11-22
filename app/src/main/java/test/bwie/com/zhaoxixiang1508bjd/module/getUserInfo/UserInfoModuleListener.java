package test.bwie.com.zhaoxixiang1508bjd.module.getUserInfo;

import test.bwie.com.zhaoxixiang1508bjd.OnFinishListener;

/**
 * Created by admin on 2017/11/03/003.
 */

public interface UserInfoModuleListener {
    void getData(OnFinishListener listener, String uid,String token);
}
