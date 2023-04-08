package com.example.mastermind;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mastermind.controller.mastermind.MonNextTurnTouch;
import com.example.mastermind.controller.mastermind.MonOnTouchListener;
import com.example.mastermind.vue.mastermind.UnePiece;

import java.util.ArrayList;

public class MasterMindActivity extends AppCompatActivity {

    private int[] code;

    private int tour;

    private LinearLayout jeu;

    private LinearLayout correction;

    private boolean vide;
    
    private ArrayList<ArrayList<Integer>> combinaisons;
    
    private ArrayList<ArrayList<Integer>> corrections;
    
    // 0 pour personne, 1 pour attaquant, 2 pour défenseur
    private int gagnant;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_mind);
        Intent data=this.getIntent();
        this.code=data.getIntArrayExtra("code");
        this.vide=data.getBooleanExtra("vide", false);
        this.jeu=this.findViewById(R.id.jeu);
        this.correction=this.findViewById(R.id.correction);
        
        boolean firstInit = true;
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("master_mind")) {
                firstInit = false;
            }
        }
        if (firstInit){
            Bundle b = new Bundle();
            
            b.putInt("tour", 0);
            
            b.putInt("gagnant", 0);
            
            this.combinaisons = new ArrayList<>();
            combinaisons.add(new ArrayList<>(0));
            for (int i=0; i<4; i++)
                combinaisons.get(0).add(6);
            b.putSerializable("combinaisons", combinaisons);
            
            this.corrections = new ArrayList<>();
            corrections.add(new ArrayList<>(0));
            for (int i=0; i<4; i++)
                corrections.get(0).add(6);
            b.putSerializable("corrections", corrections);
            
            this.init(b);
        }
        
        this.findViewById(R.id.tour).setOnTouchListener(new MonNextTurnTouch(this));
    }

    @Override
    public void onBackPressed() {
        Intent menu=new Intent(this, MenuActivity.class);
        this.startActivity(menu);
        this.finish();
    }

    public void nextTurn(){
        boolean nextable = true;
        if (!vide){
            LinearLayout anciennesPieces =(LinearLayout) this.jeu.getChildAt(this.tour);
            for(int i=0; i<anciennesPieces.getChildCount(); i++){
                if(((UnePiece)anciennesPieces.getChildAt(i)).getColor()==6){
                    nextable = false;
                    break;
                }
            }
        }
        
        if (nextable) {
            if (this.tour < 9) {
                //on affiche la correction
                this.afficherCorrection((LinearLayout) this.jeu.getChildAt(this.tour));
                
                //on supprime les listener et sauvegarde la combinaison
                LinearLayout anciennesPieces = (LinearLayout) this.jeu.getChildAt(this.tour);
                ArrayList<Integer> combinaison = new ArrayList<>();
                for (int i = 0; i < anciennesPieces.getChildCount(); i++) {
                    anciennesPieces.getChildAt(i).setOnTouchListener(null);
                    combinaison.add(((UnePiece) anciennesPieces.getChildAt(i)).getColor());
                }
                this.combinaisons.add(combinaison);
        
                if (this.gagnant == 1) {
                    this.finDePartie(true);
                } else {
                    //on incremente le tour
                    this.tour++;
                    //on récupere le LinearLayout des pieces du tour
                    LinearLayout pieces = (LinearLayout) this.jeu.getChildAt(this.tour);
                    //on ajoute le listener
                    for (int i = 0; i < pieces.getChildCount(); i++) {
                        UnePiece p = (UnePiece) pieces.getChildAt(i);
                        p.setOnTouchListener(new MonOnTouchListener(p, this.vide));
                    }
                }
        
            } else {
                //on affiche la correction
                this.afficherCorrection((LinearLayout) this.jeu.getChildAt(this.tour));
                
                //on supprime les listener et sauvegarde la combinaison
                LinearLayout anciennesPieces = (LinearLayout) this.jeu.getChildAt(this.tour);
                ArrayList<Integer> combinaison = new ArrayList<>();
                for (int i = 0; i < anciennesPieces.getChildCount(); i++) {
                    anciennesPieces.getChildAt(i).setOnTouchListener(null);
                    combinaison.add(((UnePiece) anciennesPieces.getChildAt(i)).getColor());
                }
                this.combinaisons.add(combinaison);
                
                if (this.gagnant == 1) {
                    this.finDePartie(true);
                } else {
                    this.gagnant = 2;
                    this.finDePartie(false);
                }
            }
        }
    }

    public void afficherCorrection(LinearLayout pieces){
        int[] colorpiece=new int[4];
        for(int i=0; i<4; i++){
            colorpiece[i]=((UnePiece)pieces.getChildAt(i)).getColor();
        }
        LinearLayout correctionsPieces=(LinearLayout) this.correction.getChildAt(this.tour);
        ArrayList<Integer> correction = new ArrayList<>();
        //si on a gagner
        boolean gagner=true;

        for(int i=0; i<4; i++){
            if(colorpiece[i] == this.code[i]){
                //bien placer bon endroit
                ((UnePiece)correctionsPieces.getChildAt(i)).setColor(4);
                correction.add(4);
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
                    correction.add(5);
                }else {
                    //mauvais
                    correction.add(6);
                }
            }
        }
        this.corrections.add(correction);
        if (gagner){
            this.gagnant=1;
        }
    }

    public void finDePartie(boolean trouve){
        if (trouve){
            if (this.tour == 0) {
                ((TextView) findViewById(R.id.texte_gagnant)).setText("Victoire de l'attaquant en 1 tentative");
            }else
                ((TextView) findViewById(R.id.texte_gagnant)).setText("Victoire de l'attaquant en " + (this.tour + 1) + " tentatives");
        } else {
            ((TextView)findViewById(R.id.texte_gagnant)).setText("Victoire du défenseur");
        }
    
        ((UnePiece)findViewById(R.id.reponse_code1)).setColor(this.code[0]);
        ((UnePiece)findViewById(R.id.reponse_code2)).setColor(this.code[1]);
        ((UnePiece)findViewById(R.id.reponse_code3)).setColor(this.code[2]);
        ((UnePiece)findViewById(R.id.reponse_code4)).setColor(this.code[3]);
        
        findViewById(R.id.cache_reponse).setVisibility(View.INVISIBLE);
    
        findViewById(R.id.tour).setVisibility(View.INVISIBLE);
        findViewById(R.id.tour).setOnTouchListener(null);
        
        findViewById(R.id.mastermind).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent intent = new Intent(MasterMindActivity.this, MenuActivity.class);
                MasterMindActivity.this.startActivity(intent);
                MasterMindActivity.this.finish();
                return true;
            }
        });
    }
    
    public void init(Bundle state){
        this.tour= state.getInt("tour");
        this.gagnant= state.getInt("gagnant");
        ArrayList<ArrayList<Integer>> combinaisons = (ArrayList<ArrayList<Integer>>) state.getSerializable("combinaisons");
        ArrayList<ArrayList<Integer>> corrections = (ArrayList<ArrayList<Integer>>) state.getSerializable("corrections");
        
        for (int i=0; i<=this.tour; i++){
            ArrayList<Integer> combinaison = combinaisons.get(i);
            ArrayList<Integer> correction = corrections.get(i);
            LinearLayout pieces = (LinearLayout) this.jeu.getChildAt(i);
            LinearLayout correctionsPieces = (LinearLayout) this.correction.getChildAt(i);
            for (int j=0; j<4; j++){
                UnePiece p = (UnePiece) pieces.getChildAt(j);
                p.setColor(combinaison.get(j));
                UnePiece c = (UnePiece) correctionsPieces.getChildAt(j);
                c.setColor(correction.get(j));
                if (i==this.tour){
                    p.setOnTouchListener(new MonOnTouchListener(p, this.vide));
                }
            }
        }
        combinaisons.remove(this.tour);
        corrections.remove(this.tour);
        this.combinaisons = combinaisons;
        this.corrections = corrections;
        
        if (this.gagnant==1){
            this.finDePartie(true);
        }else if (this.gagnant==2)
            this.finDePartie(false);
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (outState == null)
            outState = new Bundle();
        Bundle b = new Bundle();
        b.putInt("tour", this.tour);
        b.putInt("gagnant", this.gagnant);
        
        ArrayList<Integer> combinaison = new ArrayList<>();
        LinearLayout anciennesPieces =(LinearLayout) this.jeu.getChildAt(this.tour);
        for (int i=0; i<4; i++)
            combinaison.add(((UnePiece)anciennesPieces.getChildAt(i)).getColor());
        this.combinaisons.add(combinaison);
        b.putSerializable("combinaisons", this.combinaisons);
    
        ArrayList<Integer> correction = new ArrayList<>();
        for (int i=0; i<4; i++)
            correction.add(6);
        this.corrections.add(correction);
        b.putSerializable("corrections", this.corrections);
        outState.putBundle("master_mind", b);
    }
    
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        this.init(savedInstanceState.getBundle("master_mind"));
    }
}
