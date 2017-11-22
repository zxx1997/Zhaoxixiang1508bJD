package test.bwie.com.zhaoxixiang1508bjd.presenter.fenlei;

import test.bwie.com.zhaoxixiang1508bjd.Bean.BaseBean;
import test.bwie.com.zhaoxixiang1508bjd.Bean.ClassRightBean;
import test.bwie.com.zhaoxixiang1508bjd.OnFinishListener;
import test.bwie.com.zhaoxixiang1508bjd.module.fenlei.ClassRightModule;
import test.bwie.com.zhaoxixiang1508bjd.module.fenlei.ClassRightModuleListener;
import test.bwie.com.zhaoxixiang1508bjd.presenter.PresenterListener;
import test.bwie.com.zhaoxixiang1508bjd.view.listener.ClassView;

/**
 * Created by admin on 2017/11/03/003.
 */

public class ClassRightPresenter implements PresenterListener,OnFinishListener{

    ClassView view;
    private final ClassRightModuleListener listener;
    public ClassRightPresenter(ClassView view){
        this.view=view;
        listener=new ClassRightModule();
    }



    @Override
    public void get() {
        listener.getData(this,view.getCid());
    }

    @Override
    public void onSuccess(BaseBean baseBean) {
        view.getDataRight((ClassRightBean) baseBean);
    }
}
