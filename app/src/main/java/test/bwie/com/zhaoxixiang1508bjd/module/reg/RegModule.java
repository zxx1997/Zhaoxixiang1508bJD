package test.bwie.com.zhaoxixiang1508bjd.module.reg;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import test.bwie.com.zhaoxixiang1508bjd.Bean.RegBean;
import test.bwie.com.zhaoxixiang1508bjd.OnFinishListener;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.Api;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.GsonObjectCallback;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.OkHttp3Utils;

/**
 * Created by admin on 2017/11/02/002.
 */

public class RegModule implements RegModuleListener{

    private Map<String,String> map=new HashMap<>();
    @Override
    public void getData(final OnFinishListener listener, String user, String pass) {
        map.put("mobile",user);
        map.put("password",pass);
        OkHttp3Utils.doPost(Api.Reg, map, new GsonObjectCallback<RegBean>() {
            @Override
            public void onUi(RegBean bean) {
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
