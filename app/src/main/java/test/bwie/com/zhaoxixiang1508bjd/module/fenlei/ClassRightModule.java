package test.bwie.com.zhaoxixiang1508bjd.module.fenlei;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import test.bwie.com.zhaoxixiang1508bjd.Bean.ClassRightBean;
import test.bwie.com.zhaoxixiang1508bjd.OnFinishListener;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.Api;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.GsonObjectCallback;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.OkHttp3Utils;

/**
 * Created by admin on 2017/11/03/003.
 */

public class ClassRightModule implements ClassRightModuleListener{
    private Map<String,String> map=new HashMap<>();
    @Override
    public void getData(final OnFinishListener listener, String cid) {
        map.put("cid",cid);
        OkHttp3Utils.doPost(Api.CLASS_CHILD, map, new GsonObjectCallback<ClassRightBean>() {
            @Override
            public void onUi(ClassRightBean bean) {
                listener.onSuccess(bean);
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }
}
