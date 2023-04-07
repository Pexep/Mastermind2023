package com.example.mastermind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mastermind.controller.ChoixDuMotDePasse.OnTouchBoutonValider;
import com.example.mastermind.controller.mastermind.MonOnTouchListener;
import com.example.mastermind.vue.mastermind.UnePiece;

import java.util.Random;

public class ChoixDuMotDePasse extends AppCompatActivity {

    private UnePiece un, deux, trois, quatre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_du_mot_de_passe);

        this.un=(UnePiece) this.findViewById(R.id.code1);
        this.deux=(UnePiece) this.findViewById(R.id.code2);
        this.trois=(UnePiece) this.findViewById(R.id.code3);
        this.quatre=(UnePiece) this.findViewById(R.id.code4);

        boolean t=this.getIntent().getBooleanExtra("vide", false);
        this.un.setOnTouchListener(new MonOnTouchListener(this.un, t));
        this.deux.setOnTouchListener(new MonOnTouchListener(this.deux, t));
        this.trois.setOnTouchListener(new MonOnTouchListener(this.trois, t));
        this.quatre.setOnTouchListener(new MonOnTouchListener(this.quatre, t));

        this.findViewById(R.id.bouton_valider_code).setOnTouchListener(new OnTouchBoutonValider(this));

    }

    public void start(){
        Intent mastermind=new Intent(this, MasterMindActivity.class);
        Intent data=this.getIntent();
        mastermind.putExtra("vide", data.getBooleanExtra("vide", false));

        int tab[]=new int[4];
        tab[0]=this.un.getColor();
        tab[1]=this.deux.getColor();
        tab[2]=this.trois.getColor();
        tab[3]=this.quatre.getColor();
        mastermind.putExtra("code", tab);

        this.startActivity(mastermind);
        this.finish();
    }
}