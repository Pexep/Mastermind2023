package com.example.mastermind.vue.mastermind;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.mastermind.util.MonPaint;

public class UnePiece extends View {

    private int color;

    public UnePiece(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.color=6;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = this.getRaduis();


        canvas.drawCircle(centerX, centerY, radius, MonPaint.getColor(this.color));
    }

    protected int getRaduis() {
        return 30;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int colorr) {
        this.color = colorr%7;
        this.invalidate();
    }
}
