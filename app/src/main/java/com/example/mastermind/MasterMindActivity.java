package com.example.mastermind;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mastermind.controller.mastermind.MonOnTouchListener;
import com.example.mastermind.vue.mastermind.UnePiece;

public class MasterMindActivity extends AppCompatActivity {

    private int[] code;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_mind);
        Intent data=this.getIntent();
        this.code=data.getIntArrayExtra("code");
        LinearLayout l=this.findViewById(R.id.jeu);

        for(int i=0; i<l.getChildCount(); i++){
            LinearLayout fils = (LinearLayout) l.getChildAt(i);
            for(int j=0; j<fils.getChildCount(); j++){
                fils.getChildAt(j).setOnTouchListener(new MonOnTouchListener((UnePiece) fils.getChildAt(j), data.getBooleanExtra("vide", false)));
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
