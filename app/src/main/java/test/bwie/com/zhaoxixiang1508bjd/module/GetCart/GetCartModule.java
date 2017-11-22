package test.bwie.com.zhaoxixiang1508bjd.module.GetCart;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import test.bwie.com.zhaoxixiang1508bjd.Bean.GetCartBean;
import test.bwie.com.zhaoxixiang1508bjd.OnFinishListener;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.Api;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.GsonObjectCallback;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.OkHttp3Utils;

/**
 * Created by admin on 2017/11/10/010.
 */

public class GetCartModule implements GetCartModuleListener {
    private Map<String,String> map=new HashMap<>();
    @Override
    public void getData(final OnFinishListener listener, String uid,String token) {
        map.put("uid",uid);
        map.put("token",token);
        OkHttp3Utils.doPost(Api.GET_CART, map, new GsonObjectCallback<GetCartBean>() {
            @Override
            public void onUi(GetCartBean bean) {
                listener.onSuccess(bean);
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }
}
