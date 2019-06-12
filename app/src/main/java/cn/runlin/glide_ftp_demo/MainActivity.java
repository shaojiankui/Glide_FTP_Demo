package cn.runlin.glide_ftp_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import cn.runlin.glide_ftp_demo.GlideFTP.FTPModel;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ImageView imageView2;

    Button buttonfull;
    Button buttonabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);

        buttonfull = findViewById(R.id.buttonfull);
        buttonabs = findViewById(R.id.buttonabs);


        buttonfull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //第一种方式
                String path = "ftp://DSERP:DSERP@192.168.215.150/tryCarCheck/S711039/vimghz__LFV3A23C1J3011237_20190717.jpg";
                FTPModel ftpModel = new FTPModel(path);

                Glide.with(MainActivity.this).load(ftpModel)
                        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
                        .into(imageView);
            }
        });
        buttonabs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //第二种方式
                FTPModel ftpModel = new FTPModel("192.168.215.150", null, "DSERP", "DSERP", "/DMS/S711039/201905/vDriLcsUrlDown_170175cd-8174-46e1-83c6-62e550b4cd45.bmp");

                Glide.with(MainActivity.this).load(ftpModel)
                        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
                        .into(imageView2);
            }
        });
    }
}
