package com.example.mastermind.controller.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mastermind.ChoixDuMotDePasse;
import com.example.mastermind.MasterMindActivity;

import java.util.Random;

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
        if(typePartie == 1){
            Intent mastermind = new Intent(menu, MasterMindActivity.class);
            mastermind.putExtra("vide", vide.isChecked());

            Random r=new Random();
            int tab[]=new int[4];
            int max=6;
            if(vide.isChecked()){
                max++;
            }
            tab[0]=r.nextInt(max);
            tab[1]=r.nextInt(max);
            tab[2]=r.nextInt(max);
            tab[3]=r.nextInt(max);
            mastermind.putExtra("code", tab);

            menu.startActivity(mastermind);
        }
        if(typePartie ==2){
            Intent choixCode = new Intent(menu, ChoixDuMotDePasse.class);
            choixCode.putExtra("vide", vide.isChecked());
            menu.startActivity(choixCode);
        }
    }
}
