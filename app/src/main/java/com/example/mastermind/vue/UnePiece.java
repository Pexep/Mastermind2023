package com.example.mastermind.vue;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.mastermind.util.MonPaint;

public class UnePiece extends View {


    public UnePiece(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(0, 0, 50, 50, 0, (float) (Math.PI*2), false, MonPaint.getNoir());
    }
}
