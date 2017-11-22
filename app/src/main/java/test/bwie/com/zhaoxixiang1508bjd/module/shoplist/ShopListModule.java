package test.bwie.com.zhaoxixiang1508bjd.module.shoplist;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import test.bwie.com.zhaoxixiang1508bjd.Bean.ShopListBean;
import test.bwie.com.zhaoxixiang1508bjd.OnFinishListener;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.Api;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.GsonObjectCallback;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.OkHttp3Utils;

/**
 * Created by admin on 2017/11/07/007.
 */

public class ShopListModule implements ShopListModuleListener{
    private Map<String,String> map=new HashMap<>();
    @Override
    public void getData(final OnFinishListener listener, String pscid) {
        map.put("pscid",pscid);
        OkHttp3Utils.doPost(Api.SHOP_LIST, map, new GsonObjectCallback<ShopListBean>() {
            @Override
            public void onUi(ShopListBean bean) {
                if(listener!=null){
                    listener.onSuccess(bean);
                }
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }
}
