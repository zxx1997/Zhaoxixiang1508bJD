package test.bwie.com.zhaoxixiang1508bjd.presenter.shoplist;

import test.bwie.com.zhaoxixiang1508bjd.Bean.BaseBean;
import test.bwie.com.zhaoxixiang1508bjd.Bean.ShopListBean;
import test.bwie.com.zhaoxixiang1508bjd.OnFinishListener;
import test.bwie.com.zhaoxixiang1508bjd.module.shoplist.ShopListModule;
import test.bwie.com.zhaoxixiang1508bjd.module.shoplist.ShopListModuleListener;
import test.bwie.com.zhaoxixiang1508bjd.presenter.PresenterListener;
import test.bwie.com.zhaoxixiang1508bjd.view.listener.ShopListView;

/**
 * Created by admin on 2017/11/07/007.
 */

public class ShopListPresenter implements PresenterListener,OnFinishListener{

    ShopListView view;
    private final ShopListModuleListener listener;
    public ShopListPresenter(ShopListView view){
        this.view=view;
        listener=new ShopListModule();
    }
    @Override
    public void get() {
        //p跟m关联
        listener.getData(this,view.getPscid());
    }

    @Override
    public void onSuccess(BaseBean baseBean) {
        //p跟v关联
        view.getData((ShopListBean) baseBean);
    }
}
