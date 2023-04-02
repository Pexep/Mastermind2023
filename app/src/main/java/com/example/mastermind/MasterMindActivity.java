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
        System.out.println(data.getIntExtra("nbJoeur", 1));
        System.out.println(data.getIntArrayExtra("code"));
    }
}
