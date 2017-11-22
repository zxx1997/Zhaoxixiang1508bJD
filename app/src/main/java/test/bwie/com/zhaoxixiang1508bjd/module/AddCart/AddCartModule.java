package test.bwie.com.zhaoxixiang1508bjd.module.AddCart;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import test.bwie.com.zhaoxixiang1508bjd.Bean.AddCartBean;
import test.bwie.com.zhaoxixiang1508bjd.OnFinishListener;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.Api;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.GsonObjectCallback;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.OkHttp3Utils;

/**
 * Created by admin on 2017/11/09/009.
 */

public class AddCartModule implements AddCartModuleListener{
    private Map<String,String> map=new HashMap<>();
    @Override
    public void getData(final OnFinishListener listener, String uid, String pid, String sellerid) {
        map.put("uid",uid);
        map.put("pid",pid);
        map.put("token",sellerid);
        OkHttp3Utils.doPost(Api.ADD_CART, map, new GsonObjectCallback<AddCartBean>() {
            @Override
            public void onUi(AddCartBean bean) {
                listener.onSuccess(bean);
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }
}
