package cn.runlin.glide_ftp_demo.GlideFTP;

import android.content.Context;

import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;

import java.io.InputStream;

public class FTPModelLoaderFactory implements ModelLoaderFactory<FTPModel, InputStream> {
    public FTPModelLoaderFactory(Context context) {

    }

    @Override
    public ModelLoader<FTPModel, InputStream> build(MultiModelLoaderFactory multiFactory) {
        return new FTPModelLoader();
    }

    @Override
    public void teardown() {
        // Do nothing.
    }
}
