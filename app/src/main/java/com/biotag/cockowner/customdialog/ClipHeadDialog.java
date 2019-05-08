package com.biotag.cockowner.customdialog;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.biotag.cockowner.R;
import com.biotag.cockowner.common.Constants;
import com.biotag.cockowner.common.GetAttrString;
import com.biotag.cockowner.common.Log;
import com.biotag.cockowner.utils.FileUtils;

import java.io.File;
import java.util.Arrays;

/**
 * Created by Lxh on 2016/10/24.
 * 选择头像用的dialog
 */

public class ClipHeadDialog extends Dialog {

    public static final  int IMAGE_REQUEST_CODE  = 0;
    public static final  int IMAGE_REQUEST_CODE_LEG  = 5;
    public static final  int SKIN_CAMERA_REQUEST_CODE = 1;
    public static final  int LEG_CAMERA_REQUEST_CODE = 2;
//    public static final  int RESULT_REQUEST_CODE = 2;
    public static final  int SELECT_PIC_KITKAT   = 3;
    public static final  int SELECT_PIC_KITKAT_LEG   = 4;
    public static final int CAMERA_CODE         = 60;

    public static final String SKIN_IMG = "face.jpg";
    public static final String LEG_IMG = "leg.jpg";

    private int       headPosition;
    private Context mContext;
    private OnWheelViewItemClick onWheelViewItemClick;
    private int index ;//用来标记是在拍摄 cock 的skin 图像还是在拍摄 cock 的leg图像
    private File outputImage;

    public ClipHeadDialog(final Context context, final int index) {
        super(context, R.style.no_fullscreen_reward_dialog);
        setContentView(R.layout.modify_dialog);
        getWindow().setGravity(Gravity.BOTTOM);
        this.index = index;
        mContext = context;

        Button cancelBtn = findViewById(R.id.cancelBtn);
        cancelBtn.setText(GetAttrString.getBasic_cancel());
        Button okBtn = findViewById(R.id.okBtn);
        okBtn.setText(GetAttrString.getBasic_confirm());

        WheelView mWheelView = findViewById(R.id.wheelView);
        mWheelView.setOffset(1);
        String[] clipheads = new String[]{GetAttrString.getPicture(), GetAttrString.getPictureByLib()};
        mWheelView.setItems(Arrays.asList(clipheads));

        headPosition = 1;
        mWheelView.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
            @Override
            public void onSelected(int selectedIndex, String item) {
                headPosition = selectedIndex;
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //============================================申请权限
                if (
                        ContextCompat.checkSelfPermission(mContext, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                        ContextCompat.checkSelfPermission(mContext, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ||
                        ContextCompat.checkSelfPermission(mContext,Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED) {
                    //申请了两种权限：WRITE_EXTERNAL_STORAGE与 CAMERA 权限
                    ActivityCompat.requestPermissions((Activity) mContext,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE},
                            CAMERA_CODE);
                    return;
                }
                //============================================根据输入的index的不同创建一个照片文件，等待写入数据
                if(index== Constants.SKIN_COCK_IMG){
                    outputImage = new File(Environment.getExternalStorageDirectory()+"/cockowner/", SKIN_IMG);
                }else if(index == Constants.LEG_COCK_IMG){
                    outputImage = new File(Environment.getExternalStorageDirectory()+"/cockowner/", LEG_IMG);

                }
                try {
                    if(outputImage.exists()){
                        outputImage.delete();
                    }
                    outputImage.createNewFile();
                    Log.i(Constants.TAG,"the file has been created");
                }catch (Exception e){
                    e.printStackTrace();
                }
                //==================================================开始正式分两个方式来往face.jpg中写入数据
                if (1 == headPosition) {
                    //照相机拍摄
                    Intent intentFromCapture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//指定打开相机的动作
                    if(Build.VERSION.SDK_INT>=24){
                        intentFromCapture.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                        intentFromCapture.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                    }
                    if(Build.VERSION.SDK_INT>=24){
                        intentFromCapture.putExtra(MediaStore.EXTRA_OUTPUT, FileProvider.getUriForFile(context.getApplicationContext(),"com.biotag.cockowner.fileprovider",outputImage));
                    }else {
                        intentFromCapture.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(outputImage));
                    }
                    Log.i(Constants.TAG,"origin uri is"+ FileUtils.getUriForFile(context,outputImage));
                    if(index==Constants.SKIN_COCK_IMG){
                        onWheelViewItemClick.onItemClick(intentFromCapture, SKIN_CAMERA_REQUEST_CODE);
                    }else if(index==Constants.LEG_COCK_IMG){
                        onWheelViewItemClick.onItemClick(intentFromCapture,LEG_CAMERA_REQUEST_CODE);
                    }

                } else if (2 == headPosition) {
                    Intent intentimg ;
                    //从相册选择
                    if(Build.VERSION.SDK_INT>=24){
                        intentimg = new Intent(Intent.ACTION_GET_CONTENT);
                        intentimg.addCategory(Intent.CATEGORY_OPENABLE);
                        intentimg.setType("image/*");
                    }else {

//                    Intent intent = new Intent(Intent.ACTION_GET_CONTENT); //指定获取图片的动作
                        intentimg = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                    intent.addCategory(Intent.CATEGORY_OPENABLE);
//                    intent.setType("image/*");
                        intentimg.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                    }
                    if(index==Constants.SKIN_COCK_IMG){
                        onWheelViewItemClick.onItemClick(intentimg, android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT ? SELECT_PIC_KITKAT : IMAGE_REQUEST_CODE);
                    }else if(index == Constants.LEG_COCK_IMG){
                        onWheelViewItemClick.onItemClick(intentimg, android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT ? SELECT_PIC_KITKAT_LEG : IMAGE_REQUEST_CODE_LEG);
                    }
//                    onWheelViewItemClick.onItemClick(intent, RecordCockInfoPartOneActivity.CAMERA_PHOTO_CROP_SKIN);
                }
                dismiss();
            }
        });

    }


    public void setOnWheelViewItemClick(OnWheelViewItemClick onWheelViewItemClick) {
        this.onWheelViewItemClick = onWheelViewItemClick;
    }

    public interface OnWheelViewItemClick {
        public void onItemClick(Intent intent, int requestCode);
    }


}
