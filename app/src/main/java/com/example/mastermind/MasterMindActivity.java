package com.example.mastermind;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MasterMindActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_mind);
        Intent data=this.getIntent();
        System.out.println(data.getBooleanExtra("vide", false));
        int tab[]=data.getIntArrayExtra("code");
        for(int i : tab){
            System.out.println(i);
        }
    }

    @Override
    public void onBackPressed() {
        Intent menu=new Intent(this, MenuActivity.class);
        this.startActivity(menu);
        this.finish();
    }
}
