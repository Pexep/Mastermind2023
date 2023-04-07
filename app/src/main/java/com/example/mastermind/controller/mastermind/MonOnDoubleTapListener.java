package com.example.mastermind.controller.mastermind;

import android.view.GestureDetector;
import android.view.MotionEvent;

import androidx.annotation.NonNull;

import com.example.mastermind.vue.mastermind.UnePiece;

public class MonOnDoubleTapListener implements GestureDetector.OnDoubleTapListener {
    private UnePiece v;

    public MonOnDoubleTapListener(UnePiece p){
        this.v=p;
    }
    @Override
    public boolean onSingleTapConfirmed(@NonNull MotionEvent motionEvent) {
        this.v.setColor(5);
        return true;
    }

    @Override
    public boolean onDoubleTap(@NonNull MotionEvent motionEvent) {
        this.v.setColor(4);
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(@NonNull MotionEvent motionEvent) {
        return false;
    }
}
