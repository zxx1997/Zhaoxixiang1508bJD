package test.bwie.com.zhaoxixiang1508bjd.presenter.AddAdress;

import test.bwie.com.zhaoxixiang1508bjd.Bean.AddAdressBean;
import test.bwie.com.zhaoxixiang1508bjd.Bean.BaseBean;
import test.bwie.com.zhaoxixiang1508bjd.OnFinishListener;
import test.bwie.com.zhaoxixiang1508bjd.module.AddAdress.AddAderssModuleListener;
import test.bwie.com.zhaoxixiang1508bjd.module.AddAdress.AddAdressModule;
import test.bwie.com.zhaoxixiang1508bjd.presenter.PresenterListener;
import test.bwie.com.zhaoxixiang1508bjd.view.listener.AddAdressView;

/**
 * Created by admin on 2017/11/15/015.
 */

public class AddAdressPrestener implements PresenterListener,OnFinishListener{

    AddAdressView view;
    private final AddAderssModuleListener listener;

    public AddAdressPrestener(AddAdressView view){
        this.view=view;
        listener=new AddAdressModule();
    }
    @Override
    public void get() {
        listener.getData(this,view.getUid(),view.getAdress(),view.getMobile(),view.getName(),view.getToken());
    }

    @Override
    public void onSuccess(BaseBean baseBean) {
        view.getData((AddAdressBean) baseBean);
    }
}
