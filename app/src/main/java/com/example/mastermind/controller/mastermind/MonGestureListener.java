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
        this.vue.setColor(5);
        return true;
    }

    @Override
    public boolean onScroll(@NonNull MotionEvent motionEvent, @NonNull MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(@NonNull MotionEvent motionEvent) {
        this.vue.setColor(4);
    }

    @Override
    public boolean onFling(@NonNull MotionEvent motionEvent, @NonNull MotionEvent motionEvent1, float v, float v1) {
        if(v>0 && v1>0){
            if(v>v1){
                //slide a droit plus fort
                this.vue.setColor(2);
            }else{
                //slide en bas plus fort
                this.vue.setColor(1);
            }
        }
        if(v>0 && v1<0){
            if(v+v1 >0){
                //slide a droit plus fort
                this.vue.setColor(2);
            }else{
                //slide en haut plus fort
                this.vue.setColor(1);
            }
        }
        if(v<0 && v1>0){
            if((v+v1) < 0){
                //slide a gauche plus fort
                this.vue.setColor(0);
            }else{
                //slide en bas plus fort
                this.vue.setColor(3);
            }
        }
        if(v<0 && v1<0){
            if(v < v1){
                //slide gauche plus fort
                this.vue.setColor(0);
            }else{
                //slide en haut plus fort
                this.vue.setColor(1);
            }
        }
        return true;
    }
}
