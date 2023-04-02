package com.example.mastermind.controller.mastermind;

import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MonGestureDetector extends GestureDetector {

    public MonGestureDetector(@NonNull OnGestureListener listener, @Nullable Handler handler) {
        super(listener, handler);
    }
}
