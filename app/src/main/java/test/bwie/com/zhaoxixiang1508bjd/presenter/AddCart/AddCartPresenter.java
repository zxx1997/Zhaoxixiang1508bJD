package test.bwie.com.zhaoxixiang1508bjd.presenter.AddCart;

import test.bwie.com.zhaoxixiang1508bjd.Bean.AddCartBean;
import test.bwie.com.zhaoxixiang1508bjd.Bean.BaseBean;
import test.bwie.com.zhaoxixiang1508bjd.OnFinishListener;
import test.bwie.com.zhaoxixiang1508bjd.module.AddCart.AddCartModule;
import test.bwie.com.zhaoxixiang1508bjd.module.AddCart.AddCartModuleListener;
import test.bwie.com.zhaoxixiang1508bjd.presenter.PresenterListener;
import test.bwie.com.zhaoxixiang1508bjd.view.listener.ShopDetailView;

/**
 * Created by admin on 2017/11/09/009.
 */

public class AddCartPresenter implements PresenterListener, OnFinishListener {

    ShopDetailView view;
    private final AddCartModuleListener listener;

    public AddCartPresenter(ShopDetailView view) {
        this.view = view;
        listener = new AddCartModule();
    }

    @Override
    public void get() {
        listener.getData(this, view.getUid(), view.getPid(), view.getSellerid());
    }

    @Override
    public void onSuccess(BaseBean baseBean) {
        view.getDateCart((AddCartBean) baseBean);
    }
}
