package test.bwie.com.zhaoxixiang1508bjd.presenter.shopdetail;

import test.bwie.com.zhaoxixiang1508bjd.Bean.BaseBean;
import test.bwie.com.zhaoxixiang1508bjd.Bean.ShopDetailBean;
import test.bwie.com.zhaoxixiang1508bjd.OnFinishListener;
import test.bwie.com.zhaoxixiang1508bjd.module.shopdetail.ShopDetailModule;
import test.bwie.com.zhaoxixiang1508bjd.module.shopdetail.ShopDetailModuleListener;
import test.bwie.com.zhaoxixiang1508bjd.presenter.PresenterListener;
import test.bwie.com.zhaoxixiang1508bjd.view.listener.ShopDetailView;

/**
 * Created by admin on 2017/11/07/007.
 */

public class ShopDetailPresenter implements PresenterListener,OnFinishListener{

    ShopDetailView view;
    private final ShopDetailModuleListener listener;

    public ShopDetailPresenter(ShopDetailView view){
        this.view=view;
        listener=new ShopDetailModule();
    }
    @Override
    public void get() {
        listener.getData(this,view.getPid());
    }

    @Override
    public void onSuccess(BaseBean baseBean) {
        view.getData((ShopDetailBean) baseBean);
    }
}
