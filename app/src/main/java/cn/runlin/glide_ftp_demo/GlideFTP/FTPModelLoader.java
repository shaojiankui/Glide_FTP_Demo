package cn.runlin.glide_ftp_demo.GlideFTP;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;

import java.io.InputStream;

//https://muyangmin.github.io/glide-docs-cn/tut/custom-modelloader.html
public class FTPModelLoader implements ModelLoader<FTPModel, InputStream> {

    @Nullable
    @Override
    public LoadData<InputStream> buildLoadData(@NonNull FTPModel model, int width, int height, @NonNull Options options) {
        return new LoadData<>(new ObjectKey(model),  new FTPDataFetcher(model));
    }

    @Override
    public boolean handles(@NonNull FTPModel FTPModel) {
        return true;
    }
}
