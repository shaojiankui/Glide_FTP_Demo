# Glide_FTP_Demo
Glide_FTP_Demo,custom Glide AppGlideModule and ModelLoader to load ftp images directly fro android

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