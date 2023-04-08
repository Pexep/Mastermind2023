package com.example.mastermind;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mastermind.vue.mastermind.UnePiece;

public class FinDePartieActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fin_de_partie);
		
		boolean trouve = getIntent().getBooleanExtra("trouve", false);
		int[] code = getIntent().getIntArrayExtra("code");
		int tours = getIntent().getIntExtra("tour", 0);
		
		if (trouve){
			((TextView)findViewById(R.id.texte_gagnant)).setText("Victoire de l'attaquant");
		} else {
			((TextView)findViewById(R.id.texte_gagnant)).setText("Victoire du défenseur");
		}
		
		((UnePiece)findViewById(R.id.reponse_code1)).setColor(code[0]);
		((UnePiece)findViewById(R.id.reponse_code2)).setColor(code[1]);
		((UnePiece)findViewById(R.id.reponse_code3)).setColor(code[2]);
		((UnePiece)findViewById(R.id.reponse_code4)).setColor(code[3]);
		
		if (trouve) {
			if (tours == 0) {
				((TextView)findViewById(R.id.texte_nombre_coups)).setText("Le défenseur a trouvé le code en 1 tentative");
			} else {
				((TextView)findViewById(R.id.texte_nombre_coups)).setText("Le défenseur a trouvé le code en " + (tours+1) + " tentatives");
			}
		}
	}
	
	@Override
	public void onBackPressed() {
		Intent menu=new Intent(this, MenuActivity.class);
		this.startActivity(menu);
		this.finish();
	}
}
