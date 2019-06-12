package cn.runlin.glide_ftp_demo;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

import java.io.InputStream;

import cn.runlin.glide_ftp_demo.GlideFTP.FTPModel;
import cn.runlin.glide_ftp_demo.GlideFTP.FTPModelLoaderFactory;
//https://muyangmin.github.io/glide-docs-cn/doc/configuration.html#applications
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

