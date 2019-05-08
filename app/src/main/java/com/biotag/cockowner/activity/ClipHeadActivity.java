package com.biotag.cockowner.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.biotag.cockowner.R;
import com.biotag.cockowner.common.Constants;
import com.biotag.cockowner.common.Log;
import com.biotag.cockowner.customdialog.ClipHeadDialog;
import com.biotag.cockowner.customdialog.RxToast;
import com.biotag.cockowner.customview.ClipImageView;
import com.biotag.cockowner.manager.ThreadManager;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class ClipHeadActivity extends AppCompatActivity {

    private static final int MSG_IMG = 0;
    private Button clip_photo,cancel;
    private ClipImageView src_pic;
    private String filePath;
    private int degree;
    private Bitmap photo;
    private String SDPATH = Environment.getExternalStorageDirectory()+"/cockowner/"+"face.jpg";//裁剪后的图片的位置
    private String SDPATHLEG = Environment.getExternalStorageDirectory()+"/cockowner/"+"leg.jpg";

    static class ClippHeadHandler extends Handler{
        private WeakReference<ClipHeadActivity>clipHeadActivityWeakReference ;
        public ClippHeadHandler(ClipHeadActivity clipHeadActivity){
            clipHeadActivityWeakReference = new WeakReference<ClipHeadActivity>(clipHeadActivity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            ClipHeadActivity clipHeadActivity = clipHeadActivityWeakReference.get();
            if(clipHeadActivity!=null){
                switch (msg.what){
                    case MSG_IMG:
                        if (clipHeadActivity.photo!=null) {
                            clipHeadActivity.src_pic.setImageBitmap(rotateBitmapByDegree(clipHeadActivity.photo,msg.arg1));  // 将filepath 指向的图片加载进src_pic 中
                        }else {
//                            Toast.makeText(clipHeadActivity, "图片压缩失败", Toast.LENGTH_SHORT).show();
                            RxToast.error(clipHeadActivity, "图片压缩失败！", Toast.LENGTH_SHORT, true).show();

                        }
                        break;
                }
            }
        }
    }

    private ClippHeadHandler myViewUpdateHandler = new ClippHeadHandler(this);

//    private Handler myViewUpdateHandler = new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            switch (msg.what){
//                case MSG_IMG:
//                    if (photo!=null) {
//                        src_pic.setImageBitmap(rotateBitmapByDegree(photo,msg.arg1));  // 将filepath 指向的图片加载进src_pic 中
//                    }else {
//                        Toast.makeText(ClipHeadActivity.this, "图片压缩失败", Toast.LENGTH_SHORT).show();
//                    }
//                    break;
//            }
//        }
//    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clip_head);
        clip_photo = (Button)findViewById(R.id.clip_photo);
        cancel = (Button)findViewById(R.id.cancel);
        final Intent intent = getIntent(); //  获取到从newcommonmethod 中方法startzoom() 的intent
        src_pic = (ClipImageView)findViewById(R.id.src_pic);
        if(src_pic !=null){
            if(intent.getStringExtra("uri")!=null){
                filePath = intent.getStringExtra("uri"); //将NewCommonmethod 中的130行：从图库选择的那张图片的uri取出来赋值给filepath
                ThreadManager.getInstance().execute(new Runnable() {
                    @Override
                    public void run() {
                        degree = getBitmapDegree(filePath);
                        //getImage() 方法中已经对filepath指向的图片进行了压缩
                        photo = getImage(filePath); //  参见方法getImage(),将filepath所指向的图片返回为一个bitmap
                        Message msg = Message.obtain(myViewUpdateHandler);
                        msg.what = MSG_IMG;
                        msg.arg1 = degree;
                        msg.sendToTarget(); //图片压缩好后给主线程发消息，看本行代码的47行，将压缩好的图片加载进src_pic中
                    }
                });
            }
        }

        if (cancel != null){
            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }

        if(clip_photo!=null){
            clip_photo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(intent.getStringExtra("type").equals("modify")){
                        //开启子线程执行保存图片与上传图片的操作
                        ThreadManager.getInstance().execute(new Runnable() {
                            @Override
                            public void run() {
                                //这句代码表示ClipImageView控件将正方形区域内的图片截下来了，这句代码其实很关键
                                //clip这个关键的动作
                                Bitmap bitmap = src_pic.clip();
                                String imageType = intent.getStringExtra("imgeType");
                                if(imageType.equals(ClipHeadDialog.SKIN_IMG)){
                                    //SDPATH 与 RecordCockInfoPartOneAc 中的skinfile 是同一个文件
                                    if(saveBitmap(SDPATH,bitmap,110)){
                                        Intent intent1 = new Intent();
                                        intent1.putExtra("imageType",ClipHeadDialog.SKIN_IMG);
                                        intent1.setData(Uri.parse(SDPATH));
                                        setResult(RESULT_OK,intent1);
                                        finish();
                                    }
                                }else if (imageType.equals(ClipHeadDialog.LEG_IMG)){
                                    //SDPATHLEG 与 RecordCockInfoPartOneAc 中的legfile 是同一个文件
                                    if(saveBitmap(SDPATHLEG,bitmap,110)){
                                        Intent intent2 = new Intent();
                                        intent2.putExtra("imageType",ClipHeadDialog.LEG_IMG);
                                        intent2.setData(Uri.parse(SDPATHLEG));
                                        setResult(RESULT_OK,intent2);
                                        finish();
                                    }

                                }
                            }
                        });
                    }
                }
            });
        }
    }

    //保存图片的操作
    private boolean saveBitmap(String sdpath, Bitmap bitmap, int size) {
        File file = new File(sdpath);
        if(file.exists()){
            file.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(file);
            // 生成压缩的图片
            int i = 0;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG,50,baos);
            int quality = 80;
            if(baos.toByteArray().length>0){
                Log.i(Constants.TAG,"baos.tobytearray().length"+ baos.toByteArray().length);
            }
            if (baos.toByteArray().length/1024>100) {
                baos.reset();
                quality-=10;
                bitmap.compress(Bitmap.CompressFormat.JPEG,quality,baos);
            }
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            while (true){
                if((options.outHeight>>i <=size)&&(options.outHeight>>i <=size)){
                    options.inSampleSize = (int)Math.pow(0.5,i);
                    options.inJustDecodeBounds = false;
                    bitmap = BitmapFactory.decodeStream(bais,null,options);
                    break;
                }
                i+=1;
            }
            out.write(baos.toByteArray());
            bitmap.compress(Bitmap.CompressFormat.JPEG,10,out);
            out.flush();
            out.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    //将图片旋转一定的角度后返回一张新的图片
    public static Bitmap rotateBitmapByDegree(Bitmap photo, int degree) {
        Bitmap returnBitmap = null;
        //根据旋转角度，生成旋转矩阵
        Matrix matrix = new Matrix();
        matrix.postRotate(degree);
        try {
            returnBitmap = Bitmap.createBitmap(photo,0,0,photo.getWidth(),photo.getHeight(),matrix,true);
        }catch (OutOfMemoryError error){

        }
        if(returnBitmap==null){
            returnBitmap = photo;
        }
        if(photo!=returnBitmap){
            photo.recycle();
        }
        return returnBitmap;
    }

    //等比例缩放图片
    public static Bitmap getImage(String filePath) {
        BitmapFactory.Options newOpts = new BitmapFactory.Options();
        newOpts.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeFile(filePath,newOpts);
        newOpts.inJustDecodeBounds = false;
        int w = newOpts.outWidth;
        int h = newOpts.outHeight;
        float hh = 500f;
        float ww = 600f;
        //缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
        int be = 1;
        if(w>h && w>ww){//如果宽度大的话根据宽度固定大小缩放
            be  = (int)(w/ww);
        }else if (w<h && h >hh){//如果高度高的话根据高度固定大小缩放
            be = (int)(h/hh);
        }
        if(be<0){
            be = 1;
        }
        newOpts.inSampleSize = be;
        bitmap = BitmapFactory.decodeFile(filePath,newOpts);
        return bitmap;
    }

    public static int getBitmapDegree(String path) {
        int degree = 0;
        try {
            // 从指定路径下读取图片，并获取其EXIF信息
            ExifInterface exifInterface = new ExifInterface(path);
            // 获取图片的旋转信息
            int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION,
                    ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    degree = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    degree = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    degree = 270;
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return degree;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myViewUpdateHandler.removeCallbacksAndMessages(null);
    }
}
