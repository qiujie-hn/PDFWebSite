# PDFWebSite
Android WebView 加载 PDF 文件实现。其原理就是在 app 本地搭建一个 website ,然后利用 WebView 加载这个站点，站点去实现加载显示 PDF 的目的，站点其原理也是采用 js 框架去实现的。
(突然感觉 JS 是万能的 - -)。

>安卓实现 PDF 阅读还有一个开源库实现了，主要采用 ndk 开发实现的，主要开发语言是 C。地址：https://github.com/muennich/mupdf。

# PDFWebSite VS mupdf
### PDFWebSite
- 优点：集成简单，集成简单，集成简单
- 缺点：阅读界面是 web 页面，非原生组件，体验上不如原生View。阅读样式上要定制，需要改 website 源码

### mupdf
- 优点：有原生组件实现，在体验上不错
- 缺点：集成麻烦，需要自行编译 so

# 开发指南
```java
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
```

# 截图
![](/screenshot/F990C9F5-A7B0-42E1-9BA6-46BDD47AF51F.png)![](/screenshot/283E67FE-8E38-4A76-A43B-A76141860C85.png)![](/screenshot/4490BADC-1ED3-4C90-9F72-C3EF6B6160BC.png)

