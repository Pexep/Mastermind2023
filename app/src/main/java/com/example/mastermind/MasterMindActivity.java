package com.example.mastermind;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mastermind.controller.mastermind.MonNextTurnTouch;
import com.example.mastermind.controller.mastermind.MonOnTouchListener;
import com.example.mastermind.vue.mastermind.UnePiece;

public class MasterMindActivity extends AppCompatActivity {

    private int[] code;

    private int tour;

    private LinearLayout jeu;

    private LinearLayout correction;

    private boolean vide;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_mind);
        Intent data=this.getIntent();
        this.code=data.getIntArrayExtra("code");
        this.vide=data.getBooleanExtra("vide", false);
        this.jeu=this.findViewById(R.id.jeu);
        this.correction=this.findViewById(R.id.correction);
        this.tour=0;
        this.findViewById(R.id.tour).setOnTouchListener(new MonNextTurnTouch(this));

        //on récupere le LinearLayout des pieces du tour
        LinearLayout pieces =(LinearLayout) this.jeu.getChildAt(this.tour);
        //on ajoute le listener
        for(int i=0; i<pieces.getChildCount(); i++){
            UnePiece p=(UnePiece) pieces.getChildAt(i);
            p.setOnTouchListener(new MonOnTouchListener(p, this.vide));
        }
    }

    @Override
    public void onBackPressed() {
        Intent menu=new Intent(this, MenuActivity.class);
        this.startActivity(menu);
        this.finish();
    }

    public void nextTurn(){
        if(this.tour<9){
            //on affiche la correction
            boolean gagne = this.afficherCorrection((LinearLayout) this.jeu.getChildAt(this.tour));
            //on supprime les listener
            LinearLayout anciennesPieces =(LinearLayout) this.jeu.getChildAt(this.tour);

            for(int i=0; i<anciennesPieces.getChildCount(); i++){anciennesPieces.getChildAt(i).setOnTouchListener(null);}
            
            if (gagne){
                this.finDePartie(true);
            } else {
                //on incremente le tour
                this.tour++;
                //on récupere le LinearLayout des pieces du tour
                LinearLayout pieces =(LinearLayout) this.jeu.getChildAt(this.tour);
                //on ajoute le listener
                for(int i=0; i<pieces.getChildCount(); i++) {
                    UnePiece p = (UnePiece) pieces.getChildAt(i);
                    p.setOnTouchListener(new MonOnTouchListener(p, this.vide));
                }
            }

        }else{
            //on affiche la correction
            boolean gagne = this.afficherCorrection((LinearLayout) this.jeu.getChildAt(this.tour));
            //on supprime les listener
            if(this.tour>0){
                LinearLayout anciennesPieces =(LinearLayout) this.jeu.getChildAt(this.tour-1);

                for(int i=0; i<anciennesPieces.getChildCount(); i++){anciennesPieces.getChildAt(i).setOnTouchListener(null);}
            }
            this.finDePartie(gagne);
        }
    }

    public boolean afficherCorrection(LinearLayout pieces){
        int[] colorpiece=new int[4];
        for(int i=0; i<4; i++){
            colorpiece[i]=((UnePiece)pieces.getChildAt(i)).getColor();
        }
        LinearLayout correctionsPieces=(LinearLayout) this.correction.getChildAt(this.tour);
        //si on a gagner
        boolean gagner=true;

        for(int i=0; i<4; i++){
            if(colorpiece[i] == this.code[i]){
                //bien placer bon endroit
                ((UnePiece)correctionsPieces.getChildAt(i)).setColor(4);
            }else{
                gagner=false;
                boolean nombre=false;
                for(int j=0; j<4; j++){
                    if(colorpiece[i] == code[j] && colorpiece[j]!=code[j]){
                        nombre=true;
                    }
                }
                if(nombre){
                    //mal placer
                    ((UnePiece)correctionsPieces.getChildAt(i)).setColor(5);
                }
            }
        }
        return gagner;
    }

    public void finDePartie(boolean trouve){
        Log.d("finDePartie", "                                 finDePartie: "+trouve);
        Intent fin=new Intent(this, FinDePartieActivity.class);
        fin.putExtra("trouve", trouve);
        fin.putExtra("tour", this.tour);
        fin.putExtra("code", this.code);
        this.startActivity(fin);
        this.finish();
    }
}
