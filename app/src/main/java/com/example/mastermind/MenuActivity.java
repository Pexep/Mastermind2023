package com.example.mastermind;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mastermind.controller.menu.ObservateurMenuDebutPartie;
import com.example.mastermind.util.UtilTypePartie;

public class MenuActivity extends AppCompatActivity {
    
    private SharedPreferences prefs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        this.prefs = PreferenceManager.getDefaultSharedPreferences(this);
        
        setContentView(R.layout.activity_menu);
        this.findViewById(R.id.unJoueur)
                .setOnClickListener(new ObservateurMenuDebutPartie(this, UtilTypePartie.UN_JOEUR));
        this.findViewById(R.id.deuxJoueur)
                .setOnClickListener(new ObservateurMenuDebutPartie(this, UtilTypePartie.DEUX_JOEUR));
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_configuration, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        
        if (id == R.id.action_configuration) {
            this.startActivity(new Intent(this, ConfigurationActivity.class));
            return true;
        }
        
        return super.onOptionsItemSelected(item);
    }
    
    public boolean acceptPieceVide() {
        return this.prefs.getBoolean(ConfigurationActivity.PREF_PIECE_VIDE, false);
    }
    
}
