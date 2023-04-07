package com.example.mastermind.controller.mastermind;

import android.view.GestureDetector;
import android.view.MotionEvent;

import androidx.annotation.NonNull;

import com.example.mastermind.vue.mastermind.UnePiece;

public class MonGestureListener implements GestureDetector.OnGestureListener {

    private UnePiece vue;

    public MonGestureListener(UnePiece p) {
        this.vue=p;
    }


    @Override
    public boolean onDown(@NonNull MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(@NonNull MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(@NonNull MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(@NonNull MotionEvent motionEvent, @NonNull MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(@NonNull MotionEvent motionEvent) {
        this.vue.setColor(6);
    }

    @Override
    public boolean onFling(@NonNull MotionEvent motionEvent, @NonNull MotionEvent motionEvent1, float v, float v1) {
        if (Math.abs(v) > Math.abs(v1)) {
            if (v > 0) {
                // slide à droite
                this.vue.setColor(2);
            } else {
                // slide à gauche
                this.vue.setColor(0);
            }
        } else {
            if (v1 > 0) {
                // slide en bas
                this.vue.setColor(1);
            } else {
                // slide en haut
                this.vue.setColor(3);
            }
        }
        return true;
    }
}
