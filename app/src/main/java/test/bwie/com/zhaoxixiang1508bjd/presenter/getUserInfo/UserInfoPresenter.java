package test.bwie.com.zhaoxixiang1508bjd.presenter.getUserInfo;

import test.bwie.com.zhaoxixiang1508bjd.Bean.BaseBean;
import test.bwie.com.zhaoxixiang1508bjd.Bean.UserInfoBean;
import test.bwie.com.zhaoxixiang1508bjd.OnFinishListener;
import test.bwie.com.zhaoxixiang1508bjd.module.getUserInfo.UserInfoModule;
import test.bwie.com.zhaoxixiang1508bjd.module.getUserInfo.UserInfoModuleListener;
import test.bwie.com.zhaoxixiang1508bjd.presenter.PresenterListener;
import test.bwie.com.zhaoxixiang1508bjd.view.listener.UserInfoView;

/**
 * Created by admin on 2017/11/03/003.
 */

public class UserInfoPresenter implements PresenterListener,OnFinishListener{
    UserInfoView view;
    private final UserInfoModuleListener user;
    public UserInfoPresenter(UserInfoView view){
        this.view=view;
        user=new UserInfoModule();
    }
    @Override
    public void get() {
        //p关联m
        user.getData(this,view.getUid(),view.getToken());
    }

    @Override
    public void onSuccess(BaseBean baseBean) {
        //p关联v
        view.getData((UserInfoBean) baseBean);
    }
}
