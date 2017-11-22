package test.bwie.com.zhaoxixiang1508bjd.presenter.GetCart;

import test.bwie.com.zhaoxixiang1508bjd.Bean.BaseBean;
import test.bwie.com.zhaoxixiang1508bjd.Bean.GetCartBean;
import test.bwie.com.zhaoxixiang1508bjd.OnFinishListener;
import test.bwie.com.zhaoxixiang1508bjd.module.GetCart.GetCartModule;
import test.bwie.com.zhaoxixiang1508bjd.module.GetCart.GetCartModuleListener;
import test.bwie.com.zhaoxixiang1508bjd.presenter.PresenterListener;
import test.bwie.com.zhaoxixiang1508bjd.view.listener.GetCartView;

/**
 * Created by admin on 2017/11/10/010.
 */

public class GetCartPresenter implements PresenterListener,OnFinishListener{

    GetCartView view;
    private final GetCartModuleListener listener;
    public GetCartPresenter(GetCartView view){
        this.view=view;
        listener=new GetCartModule();
    }
    @Override
    public void get() {
        listener.getData(this,view.getUid(),view.getToken());
    }

    @Override
    public void onSuccess(BaseBean baseBean) {
        view.getData((GetCartBean) baseBean);
    }
}
