package com.biotag.cockowner.customdialog;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/**
 * Created by duanfangfang on 2016/5/10.
 */
public class BulrBitmapUtil {
    private static final int RADIUS = 13;//模糊程度；

    public static Bitmap blurBitmap(Bitmap bitmap, Context context){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR1) {
            Bitmap outBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            RenderScript rs = RenderScript.create(context);
            ScriptIntrinsicBlur blurScript = null;
            blurScript = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
            Allocation allIn = Allocation.createFromBitmap(rs, bitmap);
            Allocation allOut = Allocation.createFromBitmap(rs, outBitmap);
            blurScript.setRadius(RADIUS);
            blurScript.setInput(allIn);
            blurScript.forEach(allOut);
            allOut.copyTo(outBitmap);
            bitmap.recycle();
            rs.destroy();
            return outBitmap;
        }
        return null;
    }
}
