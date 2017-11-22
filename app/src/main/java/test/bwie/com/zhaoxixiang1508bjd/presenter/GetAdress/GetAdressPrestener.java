package test.bwie.com.zhaoxixiang1508bjd.presenter.GetAdress;

import test.bwie.com.zhaoxixiang1508bjd.Bean.BaseBean;
import test.bwie.com.zhaoxixiang1508bjd.Bean.GetAdressBean;
import test.bwie.com.zhaoxixiang1508bjd.OnFinishListener;
import test.bwie.com.zhaoxixiang1508bjd.module.GetAdress.GetAdressModule;
import test.bwie.com.zhaoxixiang1508bjd.module.GetAdress.GetAdressModuleListener;
import test.bwie.com.zhaoxixiang1508bjd.presenter.PresenterListener;
import test.bwie.com.zhaoxixiang1508bjd.view.listener.GetAdressView;

/**
 * Created by admin on 2017/11/16/016.
 */

public class GetAdressPrestener implements PresenterListener,OnFinishListener{

    GetAdressView view;
    private final GetAdressModuleListener listener;

    public GetAdressPrestener( GetAdressView view){
        this.view=view;
        listener=new GetAdressModule();
    }
    @Override
    public void get() {
        listener.getData(this,view.getUid(),view.getToken());
    }

    @Override
    public void onSuccess(BaseBean baseBean) {
        view.getData((GetAdressBean) baseBean);
    }
}
