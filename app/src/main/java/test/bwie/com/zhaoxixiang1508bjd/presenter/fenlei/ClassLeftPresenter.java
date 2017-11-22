package test.bwie.com.zhaoxixiang1508bjd.presenter.fenlei;

import test.bwie.com.zhaoxixiang1508bjd.Bean.BaseBean;
import test.bwie.com.zhaoxixiang1508bjd.Bean.ClassLeftBean;
import test.bwie.com.zhaoxixiang1508bjd.OnFinishListener;
import test.bwie.com.zhaoxixiang1508bjd.module.fenlei.ClassLeftModule;
import test.bwie.com.zhaoxixiang1508bjd.module.fenlei.ClassLeftModuleListener;
import test.bwie.com.zhaoxixiang1508bjd.presenter.PresenterListener;
import test.bwie.com.zhaoxixiang1508bjd.view.listener.ClassView;

/**
 * Created by admin on 2017/11/03/003.
 */

public class ClassLeftPresenter implements PresenterListener,OnFinishListener{

    ClassView view;
    private final ClassLeftModuleListener listener;
    public ClassLeftPresenter(ClassView view){
        this.view=view;
        listener=new ClassLeftModule();
    }



    @Override
    public void get() {
        listener.getData(this);
    }

    @Override
    public void onSuccess(BaseBean baseBean) {
        view.getDataLeft((ClassLeftBean) baseBean);
    }
}
