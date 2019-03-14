package com.yyxnb.arch;

import com.squareup.leakcanary.LeakCanary;
import com.yyxnb.yyxarch.AppUtils;
import com.yyxnb.yyxarch.base.BaseApplication;
import com.yyxnb.yyxarch.http.RxHttpUtils;
import com.yyxnb.yyxarch.utils.log.LogUtils;

public class App extends BaseApplication {

    private final String BASE_URL = "https://api.apiopen.top/";

    @Override
    public void onCreate() {
        super.onCreate();
        initRxHttp();
        AppUtils.INSTANCE.init(this);

        LogUtils.INSTANCE.init()
                .setTag("Test")//设置全局tag
                .setShowThreadInfo(false).setDebug(true); //是否显示日志，默认true，发布时最好关闭

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }

    private void initRxHttp() {
        RxHttpUtils.Companion
                .getInstance()
                .init(this)
                //开启全局配置
                .config()
                //全局的BaseUrl
                .setBaseUrl(BASE_URL)
                .setOkClient(getOkHttpClient());
    }
}
