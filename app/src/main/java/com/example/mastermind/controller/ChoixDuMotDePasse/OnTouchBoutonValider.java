package com.example.mastermind.controller.ChoixDuMotDePasse;

import android.view.MotionEvent;
import android.view.View;

import com.example.mastermind.ChoixDuMotDePasse;

public class OnTouchBoutonValider implements View.OnTouchListener {

    private ChoixDuMotDePasse mdp;

    public OnTouchBoutonValider(ChoixDuMotDePasse mdp0){
        this.mdp=mdp0;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.mdp.start();
        return false;
    }
}
