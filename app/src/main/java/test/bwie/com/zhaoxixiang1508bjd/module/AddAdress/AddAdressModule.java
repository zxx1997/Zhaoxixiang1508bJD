package test.bwie.com.zhaoxixiang1508bjd.module.AddAdress;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import test.bwie.com.zhaoxixiang1508bjd.Bean.AddAdressBean;
import test.bwie.com.zhaoxixiang1508bjd.OnFinishListener;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.Api;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.GsonObjectCallback;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.OkHttp3Utils;

/**
 * Created by admin on 2017/11/15/015.
 */

public class AddAdressModule implements AddAderssModuleListener{
    private Map<String,String> map=new HashMap<>();
    @Override
    public void getData(final OnFinishListener listener, String uid, String addr, String mobile, String name, String token) {
        map.put("uid",uid);
        map.put("addr",addr);
        map.put("mobile",mobile);
        map.put("name",name);
        map.put("token",token);
        OkHttp3Utils.doPost(Api.ADD_ADRESS, map, new GsonObjectCallback<AddAdressBean>() {
            @Override
            public void onUi(AddAdressBean bean) {
                listener.onSuccess(bean);
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }
}
