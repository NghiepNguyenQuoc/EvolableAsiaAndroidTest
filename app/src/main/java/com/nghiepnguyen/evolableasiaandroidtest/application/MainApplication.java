package com.nghiepnguyen.evolableasiaandroidtest.application;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;

import com.bumptech.glide.GenericRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.caverock.androidsvg.SVG;
import com.nghiepnguyen.evolableasiaandroidtest.R;
import com.nghiepnguyen.evolableasiaandroidtest.utils.SvgDecoder;
import com.nghiepnguyen.evolableasiaandroidtest.utils.SvgDrawableTranscoder;
import com.nghiepnguyen.evolableasiaandroidtest.utils.SvgSoftwareLayerSetter;

import java.io.InputStream;

/**
 * Created by W10-PRO on 30-Sep-17.
 */

public class MainApplication extends Application {
    public static MainApplication instance;
    public static GenericRequestBuilder<Uri, InputStream, SVG, PictureDrawable> requestBuilder;


    public MainApplication() {
        super();
        instance = this;
    }

    public static MainApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        requestBuilder = Glide.with(this)
                .using(Glide.buildStreamModelLoader(Uri.class, this), InputStream.class)
                .from(Uri.class)
                .as(SVG.class)
                .transcode(new SvgDrawableTranscoder(), PictureDrawable.class)
                .sourceEncoder(new StreamEncoder())
                .cacheDecoder(new FileToStreamDecoder<SVG>(new SvgDecoder()))
                .decoder(new SvgDecoder())
                .placeholder(R.drawable.image_place_holder)
                .error(R.drawable.image_error)
                .animate(android.R.anim.fade_in)
                .listener(new SvgSoftwareLayerSetter<Uri>());
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    public static GenericRequestBuilder<Uri, InputStream, SVG, PictureDrawable> getRequestBuilder() {
        return requestBuilder;
    }
}