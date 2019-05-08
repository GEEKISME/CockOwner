package com.biotag.cockowner.customview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;

public class RoundedBackgroundSpan extends ReplacementSpan {
    private static int CORNER_RADIUS = 10;
    private int backgroundColor = 0;
    private int textColor = 0;

    public RoundedBackgroundSpan(int backgroundColor, int textColor) {
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
    }

    @Override
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {

        return Math.round(paint.measureText(text, start, end));
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y,
                     int bottom, Paint paint) {
        RectF rectF = new RectF(x-5 , top, x+5 + measureText(paint, text, start, end) , y );

        paint.setColor(backgroundColor);
        canvas.drawRoundRect(rectF, CORNER_RADIUS, CORNER_RADIUS, paint);
        paint.setColor(textColor);
        Paint.FontMetricsInt fontMetrics = paint.getFontMetricsInt();
        int baseline = (int)(rectF.bottom + rectF.top - fontMetrics.bottom - fontMetrics.top) / 2;
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(text.subSequence(start,end).toString(),rectF.centerX(), baseline, paint);
    }

    private float measureText(Paint paint, CharSequence text, int start, int end) {
        return paint.measureText(text, 0, 1);
    }
}