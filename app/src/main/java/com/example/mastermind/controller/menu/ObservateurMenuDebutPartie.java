package com.example.mastermind.controller.menu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mastermind.ChoixDuMotDePasse;
import com.example.mastermind.ConfigurationActivity;
import com.example.mastermind.MasterMindActivity;
import com.example.mastermind.MenuActivity;

import java.util.Random;

public class ObservateurMenuDebutPartie implements View.OnClickListener {

    private MenuActivity menu;

    private int typePartie;

    public ObservateurMenuDebutPartie(MenuActivity menu, int type){
        this.menu=menu;
        this.typePartie=type;
    }

    @Override
    public void onClick(View view) {
        boolean vide = this.menu.acceptPieceVide();
        if(typePartie == 1){
            Intent mastermind = new Intent(menu, MasterMindActivity.class);
            mastermind.putExtra("vide", vide);

            Random r=new Random();
            int tab[]=new int[4];
            int max=6;
            if(vide){
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
            choixCode.putExtra("vide", vide);
            menu.startActivity(choixCode);
        }
    }
}
