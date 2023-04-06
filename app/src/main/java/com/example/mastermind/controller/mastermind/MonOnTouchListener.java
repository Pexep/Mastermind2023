package com.example.mastermind.controller.mastermind;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.example.mastermind.R;
import com.example.mastermind.vue.mastermind.UnePiece;

public class MonOnTouchListener implements View.OnTouchListener {

    private GestureDetector detector;
    private MonGestureListener listener;
    public MonOnTouchListener(UnePiece p){
        this.listener=new MonGestureListener(p);
        this.detector=new GestureDetector(this.listener);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.detector.onTouchEvent(motionEvent);
        return true;
    }
}
