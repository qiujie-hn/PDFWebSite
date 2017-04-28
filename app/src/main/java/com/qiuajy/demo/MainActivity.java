package com.qiuajy.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = (WebView) findViewById(R.id.web_view);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowFileAccessFromFileURLs(true);

        webView.loadUrl("file:///android_asset/pdf-website/index.html?pdf=../pdf/packt-gradle-for-android.pdf");


        // assets/pdf-website/ 就是阅读 pdf 的站点
        // 如果想加载网络资源 pdf，需要解决跨域问题，这个需要开发者自己去解决了，推荐加载本地 pdf，如果是网络的文件
        // 建议下载到本地显示， pdf = pdf 文件路径地址即可
    }
}
