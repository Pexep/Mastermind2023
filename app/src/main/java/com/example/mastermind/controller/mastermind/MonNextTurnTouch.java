package com.example.mastermind.controller.mastermind;

import android.view.MotionEvent;
import android.view.View;

import com.example.mastermind.MasterMindActivity;

public class MonNextTurnTouch implements View.OnTouchListener {

    private MasterMindActivity master;

    public MonNextTurnTouch(MasterMindActivity m){
        this.master=m;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(motionEvent.getActionMasked() ==  MotionEvent.ACTION_UP)
            this.master.nextTurn();
        return false;
    }
}
