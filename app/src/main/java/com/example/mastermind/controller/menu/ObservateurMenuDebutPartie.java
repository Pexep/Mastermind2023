package com.example.mastermind.controller.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;
import com.example.mastermind.MasterMindActivity;

public class ObservateurMenuDebutPartie implements View.OnClickListener {

    private AppCompatActivity menu;

    private int typePartie;

    private CheckBox vide;


    public ObservateurMenuDebutPartie(AppCompatActivity menu, int type, CheckBox vide){
        this.menu=menu;
        this.typePartie=type;
        this.vide=vide;
    }

    @Override
    public void onClick(View view) {
        Intent mastermind = new Intent(menu, MasterMindActivity.class);
        mastermind.putExtra("nbJoeur", typePartie);
        mastermind.putExtra("vide", vide.isActivated());
        menu.startActivity(mastermind);
    }
}
