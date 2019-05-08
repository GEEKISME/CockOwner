package com.biotag.cockowner.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Environment;
import android.view.Display;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.biotag.cockowner.activity.ClipHeadActivity;
import com.biotag.cockowner.customdialog.BulrBitmapUtil;
import com.biotag.cockowner.customdialog.CircleImageView;
import com.biotag.cockowner.customdialog.ClipHeadDialog;
import com.biotag.cockowner.utils.UIUtils;
import com.biotag.cockowner.utils.UriToFilePath;
import com.biotag.cockowner.utils.VolleyUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.UUID;

import static com.biotag.cockowner.common.Constants.BOUNDARY;

/**
 * Created by Lxh on 2017/8/11.
 */

public class NewCommmonMethod {
    private static volatile NewCommmonMethod utils  = null;
    private NewCommmonMethod(){}

    public static NewCommmonMethod getInstance() {
        if ( utils== null) {
            synchronized (NewCommmonMethod.class) {
                if (utils == null) {
                    utils = new NewCommmonMethod();
                }
            }
        }
        return utils;
    }

    //头像缩放比例
    private static final int HEAD_IMAGE_SCALE = 90;
    /**
     * 向图片资源管理器发起的请求码
     */
    public static final int HEAD_IMAGE_REQUEST_CODE = 100;
    public static final int HEAD_CAMERA_REQUEST_CODE = 101;


    /**
     * 根据歌手头像设置背景高斯模糊
     *
     * @param url    歌手头像url
     * @param view   需要设置背景的控件
     * @param isBlur 是否需要高斯模糊
     */
    public void setHeadBackGround(String url, final View view, final boolean isBlur) {
        RequestQueue requestQueue = VolleyUtils.getInstance(UIUtils.getContext()).getRequestQueue();
        ImageRequest imgRequest = new ImageRequest(url,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bmp) {
                        if (bmp != null) {
                            if (isBlur) {
                                Bitmap outBmp = BulrBitmapUtil.blurBitmap(bmp, UIUtils.getContext());
                                if (outBmp != null) {
                                    view.setBackgroundDrawable(new BitmapDrawable(outBmp));
                                }
                            } else {
                                if (view instanceof CircleImageView) {
                                    CircleImageView civ = (CircleImageView) view;
                                    civ.setImageBitmap(bmp);
                                }
                            }
                        }
                    }
                },
                HEAD_IMAGE_SCALE,
                HEAD_IMAGE_SCALE,
                Bitmap.Config.ARGB_8888,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError arg0) {
                        // Log.d(TAG, "load singer headimage error");
                    }
                });
        requestQueue.add(imgRequest);
    }





    /**
     * 打开切图界面
     *
     * @param activity
     * @param uri
     * @param type
     * @param i    1 代表是skin图片，2 代表是leg图片
     * @param j    1 代表是camera ，2 代表是从图库选择
     */
    public void startPhotoZoom(Activity activity, Uri uri, String type,int i,int j){
        Intent intent = new Intent();
        intent.setClass(activity, ClipHeadActivity.class);
        String uris = UriToFilePath.getPath(activity,uri);
        if(i==1){
            intent.putExtra("imgeType", ClipHeadDialog.SKIN_IMG);
        }else {
            intent.putExtra("imgeType", ClipHeadDialog.LEG_IMG);
        }
        intent.putExtra("type",type);
        intent.putExtra("uri",uris);
        if(j == 2){

            activity.startActivityForResult(intent,HEAD_IMAGE_REQUEST_CODE);
        }else {
            activity.startActivityForResult(intent,HEAD_CAMERA_REQUEST_CODE);
        }

    }

    /**
     * 检测当前模式是否为debug模式
     * @param context
     */
    public void checkDebug(Context context) {
        if (isApkDebugable(context)) {
            Log.isLog = true;
            Toast.makeText(context, "当前模式debug", Toast.LENGTH_SHORT).show();
        } else {
            Log.isLog = false;
        }
    }

    /**
     * 参考yama该函数说明
     */
    public boolean isApkDebugable(Context context) {
        try {
            ApplicationInfo info = context.getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 计算图片的缩放值
     *
     * @param options
     * @param reqWidth
     * @param reqHeight
     * @return
     */
    private int cutBySize(BitmapFactory.Options options, int reqWidth, int reqHeight) {

        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);

            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }

        return inSampleSize;
    }

    /**
     * 根据路径获得图片并压缩返回bitmap
     *
     * @param filePath
     * @return
     */
    public Bitmap cutPictureSize(String filePath) {

        Display mDisplay = ((Activity) UIUtils.getContext()).getWindowManager().getDefaultDisplay();
        int width = mDisplay.getWidth();
        int height = mDisplay.getHeight();

        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);
        options.inSampleSize = cutBySize(options, width, height);
        options.inJustDecodeBounds = false;

        return BitmapFactory.decodeFile(filePath, options);
    }

    /**
     * 存储图片
     *
     * @param bitmap
     * @param savePackage
     * @return
     */
    public String cutPictureQuality(Bitmap bitmap, String savePackage) {

        String fileName = UUID.randomUUID().toString().replace("-","") + ".jpg";
        String fileDirectory = Environment.getExternalStorageDirectory() + File.separator + savePackage;

        // 判断文件夹存在
        File file = new File(fileDirectory);
        if (file != null && !file.exists()) {
            file.mkdirs();
        }

        try {

            // 第一次压缩
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);

            FileOutputStream fos = new FileOutputStream(new File(fileDirectory, fileName));

            int options = 100;
            // 如果大于50kb则再次压缩,每次图片quality减10
            while (baos.toByteArray().length / 1024 > 50 ) {
                // 清空baos
                baos.reset();

                // 这里压缩options%，把压缩后的数据存放到baos中
                bitmap.compress(Bitmap.CompressFormat.JPEG, options, baos);
                Log.i(Constants.TAG,"byte'size is now"+baos.toByteArray().length/1024);
                options -= 5;
            }
            Log.i(Constants.TAG,"byte's size is"+ baos.toByteArray().length/1024);
            fos.write(baos.toByteArray());
            fos.close();
            baos.close();

        } catch (Exception e) {
        }
        return fileDirectory + File.separator + fileName;
    }


    //===========================================================================================
    /**
     *android上传文件到服务器
     * @param params:请求参数
     * @param fileFormName:文件名称
     * @param uploadFile:上传的文件
     * @param newFileName:可不写
     * @param urlStr:后台地址
     * @throws IOException
     */

    public void uploadForm(Activity activity , final Map<String, String> params, String fileFormName,
                           File uploadFile, String newFileName, String urlStr)
            throws IOException {

        Log.i(Constants.TAG,"进来了");
        if (newFileName == null || newFileName.trim().equals("")) {
            newFileName = uploadFile.getName();
        }

        StringBuilder sb = new StringBuilder();
        /**
         * 普通的表单数据
         */
        if (params != null)
            for (String key : params.keySet()) {
                sb.append("--" + Constants.BOUNDARY + "\r\n");
                sb.append("Content-Disposition: form-data; name=\"" + key
                        + "\"" + "\r\n");
                sb.append("\r\n");
                sb.append(params.get(key) + "\r\n");
            }
        /**
         * 上传文件的头
         */
        sb.append("--" + BOUNDARY + "\r\n");
        sb.append("Content-Disposition: form-data; name=\"" + fileFormName
                + "\"; filename=\"" + newFileName + "\"" + "\r\n");
        sb.append("Content-Type: image/jpeg" + "\r\n");// 如果服务器端有文件类型的校验，必须明确指定ContentType
        sb.append("\r\n");

        byte[] headerInfo = sb.toString().getBytes("UTF-8");
        byte[] endInfo = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("UTF-8");
        System.out.println(sb.toString());
        Log.i(Constants.TAG,sb.toString());
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type",
                "multipart/form-data; boundary=" + BOUNDARY);
        conn.setRequestProperty("Content-Length", String
                .valueOf(headerInfo.length + uploadFile.length()
                        + endInfo.length));
        conn.setDoOutput(true);

        OutputStream out = conn.getOutputStream();
        InputStream in = new FileInputStream(uploadFile);
        out.write(headerInfo);

        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) != -1)
            out.write(buf, 0, len);

        out.write(endInfo);
        in.close();
        out.close();
        Log.i(Constants.TAG,conn.getResponseCode()+"");
        Log.i(Constants.TAG,conn.getResponseMessage());
        if (conn.getResponseCode() == 200) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(UIUtils.getContext(), GetAttrString.getUpload_Image_msg_0(), Toast.LENGTH_SHORT).show();
                    //将照片已经上传成功的广播发送出去
                    if(params.get("type").equals("leg")){
                        Intent intent = new Intent();
                        intent.setAction("com.biatag.cockowner");
                        intent.putExtra("legimgupload","success");
                        UIUtils.getContext().sendBroadcast(intent);
                    }

                }
            });
        }else {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(UIUtils.getContext(), GetAttrString.getUpload_Image_msg_3(), Toast.LENGTH_SHORT).show();
                    //
                }
            });
        }
    }
}
