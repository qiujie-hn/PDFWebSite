package com.qiuajy.demo;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = (WebView) findViewById(R.id.web_view);

        WebSettings settings = webView.getSettings();
        // 开启 javascript 功能；原因：站点采用了 javascript
        settings.setJavaScriptEnabled(true);
        // 这句解决本地跨域问题，如果你的 PDF 文件在站点里，是不需要的，但是，我们一般情况是加载站点外部 PDF 文件
        settings.setAllowFileAccessFromFileURLs(true);

        // demo code
        /*
         * "file:///android_asset/pdf-website/index.html?pdf="这里是固定的，当然 `pdf-website`
         * 取决于开发者自己目录名称
         * 参数：pdf = 这里是 PDF 文件路径
         */
        webView.loadUrl("file:///android_asset/pdf-website/index.html?pdf=../pdf/packt-gradle-for-android.pdf");
    }
}
