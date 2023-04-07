package com.example.mastermind.vue.mastermind;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

public class PieceCorrection extends UnePiece{

    public PieceCorrection(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected int getRaduis() {
        return 20;
    }
}
