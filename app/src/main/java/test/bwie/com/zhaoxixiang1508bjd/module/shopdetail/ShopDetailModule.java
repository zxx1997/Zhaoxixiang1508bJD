package test.bwie.com.zhaoxixiang1508bjd.module.shopdetail;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import test.bwie.com.zhaoxixiang1508bjd.Bean.ShopDetailBean;
import test.bwie.com.zhaoxixiang1508bjd.OnFinishListener;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.Api;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.GsonObjectCallback;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.OkHttp3Utils;

/**
 * Created by admin on 2017/11/07/007.
 */

public class ShopDetailModule implements ShopDetailModuleListener{

    private Map<String,String> map=new HashMap<>();
    @Override
    public void getData(final OnFinishListener listener, String pid) {
        map.put("pid",pid);
        OkHttp3Utils.doPost(Api.SHOP_DETAIL, map, new GsonObjectCallback<ShopDetailBean>() {
            @Override
            public void onUi(ShopDetailBean bean) {
                listener.onSuccess(bean);
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }
}
