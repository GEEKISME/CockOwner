package com.biotag.cockowner.utils;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.toolbox.ImageLoader.ImageCache;

/**
 * Created by duanfangfang on 2016/5/9
 */
public class VolleyImageCache implements ImageCache {
	private int maxSize = 4*1024*1024;
	private LruCache<String, Bitmap> mLruCache = new LruCache<String, Bitmap>(maxSize ){
		@SuppressLint("NewApi")
		@Override
		protected int sizeOf(String key, Bitmap value) {
			return value.getByteCount();
		};
	};

	@Override
	public Bitmap getBitmap(String url) {
		return mLruCache.get(url);
	}
	
	@Override
	public void putBitmap(String url, Bitmap bitmap) {
		mLruCache.put(url, bitmap);
	}

}
