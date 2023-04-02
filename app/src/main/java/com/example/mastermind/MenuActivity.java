package com.example.mastermind;

import android.os.Bundle;
import android.widget.CheckBox;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mastermind.controller.menu.ObservateurMenuDebutPartie;
import com.example.mastermind.util.UtilTypePartie;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        this.findViewById(R.id.unJoueur)
                .setOnClickListener(new ObservateurMenuDebutPartie(this, UtilTypePartie.UN_JOEUR, (CheckBox) this.findViewById(R.id.vide)));
        this.findViewById(R.id.deuxJoueur)
                .setOnClickListener(new ObservateurMenuDebutPartie(this, UtilTypePartie.DEUX_JOEUR, (CheckBox) this.findViewById(R.id.vide)));
    }
}
