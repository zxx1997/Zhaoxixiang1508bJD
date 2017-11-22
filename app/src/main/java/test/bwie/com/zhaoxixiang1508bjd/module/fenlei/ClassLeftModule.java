package test.bwie.com.zhaoxixiang1508bjd.module.fenlei;

import java.io.IOException;

import okhttp3.Call;
import test.bwie.com.zhaoxixiang1508bjd.Bean.ClassLeftBean;
import test.bwie.com.zhaoxixiang1508bjd.OnFinishListener;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.Api;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.GsonObjectCallback;
import test.bwie.com.zhaoxixiang1508bjd.okhttp.utils.OkHttp3Utils;

/**
 * Created by admin on 2017/11/03/003.
 */

public class ClassLeftModule implements ClassLeftModuleListener{
    @Override
    public void getData(final OnFinishListener listener) {
        OkHttp3Utils.doGet(Api.CLASS, new GsonObjectCallback<ClassLeftBean>() {
            @Override
            public void onUi(ClassLeftBean classLeftBean) {
                listener.onSuccess(classLeftBean);
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }
}
