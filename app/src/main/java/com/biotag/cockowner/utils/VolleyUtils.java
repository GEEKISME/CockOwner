package com.biotag.cockowner.utils;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by duanfangfang on 2016/5/9
 */
public class VolleyUtils {
	private static VolleyUtils sInstance;
	private RequestQueue requestQueue;
	private ImageLoader imageLoader;

	public RequestQueue getRequestQueue() {
		return requestQueue;
	}
	public ImageLoader getImageLoader() {
		return imageLoader;
	}

	private VolleyUtils(Context context){
		requestQueue = Volley.newRequestQueue(context);
		imageLoader = new ImageLoader(requestQueue, new VolleyImageCache());
	}
	public static VolleyUtils getInstance(Context context){
		if(sInstance == null){
			synchronized (VolleyUtils.class) {
				if(sInstance == null){
					sInstance = new VolleyUtils(context);
				}
			}
		}
		return sInstance;
	}

}
