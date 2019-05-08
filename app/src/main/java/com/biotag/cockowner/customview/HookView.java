package com.biotag.cockowner.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.biotag.cockowner.R;

/**
 * Created by Lxh on 2017/9/18.
 */

public class HookView extends View{
    public HookView(Context context) {
        super(context);
    }

    public HookView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HookView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private  int progress = 0 ;
    private int line1_x = 0;
    private int line1_y = 0;
    private int line2_x = 0;
    private int line2_y = 0;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        progress = progress+2;
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.arc_blue));
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        int center = getWidth()/2;
        int center1 = center - getWidth()/5;
        int radius = getWidth()/2 - 5;
        RectF rectf = new RectF(center - radius - 1,center-radius -1,center+radius+1,center+radius+1);
        canvas.drawArc(rectf,235,-360*progress/100,false,paint);
        /**
         * 只有当progress 大于100 时才会运行下方的代码，也就是说只有把外面的圆画完后，才会话圆里面的对勾
         */
        /**
         * 绘制对勾
         */
        //先等圆弧画完，才话对勾
        if(progress>=100){
            if(line1_x<radius/3){
                line1_x=line1_x+3;
                line1_y=line1_y+3;
            }
            //画第一根线
            canvas.drawLine(center1,center,center1+line1_x,center+line1_y,paint);
            if(line1_x==radius/3){
                line2_x = line1_x;
                line2_y = line1_y;
                line1_x++;
                line1_y++;
            }
            if(line1_x>=radius/3 && line2_x<=radius){
                line2_x=line2_x+2;
                line2_y=line2_y-1;
            }
            //画第二根线
            canvas.drawLine(center1+line1_x-1,center+line1_y,center1+line2_x,center+line2_y,paint);
        }
        //每隔3ms 刷新界面
        postInvalidateDelayed(3);
    }
}
