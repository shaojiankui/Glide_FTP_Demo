# Glide_FTP_Demo
Glide_FTP_Demo,custom Glide AppGlideModule and ModelLoader to load ftp images directly fro android

## 集成方式
### 1.工程build.gradle
```
repositories {
        google()
        jcenter()
        mavenCentral()
    }
```

### 2.Module的build.gradle
```implementation 'com.github.bumptech.glide:glide:4.9.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.9.0'
    implementation 'commons-net:commons-net:3.6' //ftp支持库
```

### 3.新建MyAppGlideModule继承AppGlideModule，注入FTPModelLoaderFactory
自定义AppGlideModule官方文档
https://muyangmin.github.io/glide-docs-cn/doc/configuration.html#applications

```
@GlideModule
public class MyAppGlideModule extends AppGlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
    }

    @Override
    public void registerComponents(Context context, Glide glide, Registry registry) {
        registry.prepend(FTPModel.class, InputStream.class,
                new FTPModelLoaderFactory(context));
    }
    @Override
    public boolean isManifestParsingEnabled() {
        return false;
    }
}
```

## 加载带用户信息的全路径

```
String path = "ftp://DSERP:DSERP@192.168.215.150/tryCarCheck/S711039/vimghz__LFV3A23C1J3011237_20190717.jpg";
                FTPModel ftpModel = new FTPModel(path);

                Glide.with(MainActivity.this).load(ftpModel)
                        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
                        .into(imageView);
```


## 加载FTP绝对路径
```
FTPModel ftpModel = new FTPModel("192.168.215.150", null, "DSERP", "DSERP", "/DMS/S711039/201905/vDriLcsUrlDown_170175cd-8174-46e1-83c6-62e550b4cd45.bmp");

                Glide.with(MainActivity.this).load(ftpModel)
                        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
                        .into(imageView2);
```


