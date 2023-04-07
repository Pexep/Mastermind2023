package com.example.mastermind.controller.mastermind;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

import com.example.mastermind.vue.mastermind.UnePiece;

public class MonOnTouchListener implements View.OnTouchListener {

    private GestureDetector detector;
    public MonOnTouchListener(UnePiece p, boolean t){
        this.detector=new GestureDetector(new MonGestureListener(p));
        this.detector.setOnDoubleTapListener(new MonOnDoubleTapListener(p));
        if(t==false){
            this.detector.setIsLongpressEnabled(t);
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.detector.onTouchEvent(motionEvent);
        return true;
    }
}
