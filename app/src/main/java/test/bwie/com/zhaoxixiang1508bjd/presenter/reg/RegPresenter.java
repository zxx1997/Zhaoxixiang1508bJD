package test.bwie.com.zhaoxixiang1508bjd.presenter.reg;

import test.bwie.com.zhaoxixiang1508bjd.Bean.BaseBean;
import test.bwie.com.zhaoxixiang1508bjd.Bean.RegBean;
import test.bwie.com.zhaoxixiang1508bjd.OnFinishListener;
import test.bwie.com.zhaoxixiang1508bjd.module.reg.RegModule;
import test.bwie.com.zhaoxixiang1508bjd.module.reg.RegModuleListener;
import test.bwie.com.zhaoxixiang1508bjd.presenter.PresenterListener;
import test.bwie.com.zhaoxixiang1508bjd.view.listener.RegView;

/**
 * Created by admin on 2017/11/02/002.
 */

public class RegPresenter implements PresenterListener,OnFinishListener{

    RegView regView;
    private final RegModuleListener reg;

    public RegPresenter(RegView regview) {
        this.regView=regview;
        reg=new RegModule();
    }

    @Override
    public void get() {
        //p跟m关联
        reg.getData(this,regView.getUser(),regView.getPass());
    }

    @Override
    public void onSuccess(BaseBean baseBean) {
        //关联view
        regView.getData((RegBean) baseBean);
    }
}
