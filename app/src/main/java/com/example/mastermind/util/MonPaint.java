package com.example.mastermind.util;

import android.graphics.Paint;

public abstract class MonPaint {
    private static Paint rouge;
    private static Paint verte;
    private static Paint bleue;
    private static Paint jaune;
    private static Paint blanche;
    private static Paint noir;

    private static void istanciate(){
        MonPaint.rouge=new Paint();
        MonPaint.rouge.setColor(0xffff0000);

        MonPaint.verte=new Paint();
        MonPaint.verte.setColor(0xff00ff00);

        MonPaint.bleue=new Paint();
        MonPaint.bleue.setColor(0xff0000ff);

        MonPaint.jaune=new Paint();
        MonPaint.jaune.setColor(0xffffff00);

        MonPaint.blanche=new Paint();
        MonPaint.blanche.setColor(0xffffffff);

        MonPaint.noir=new Paint();
        MonPaint.noir.setColor(0xff000000);
    }

    public static Paint getVerte(){
        if(MonPaint.verte== null){
            MonPaint.istanciate();
        }
        return MonPaint.verte;
    }

    public static Paint getJaune(){
        if(MonPaint.jaune== null){
            MonPaint.istanciate();
        }
        return MonPaint.jaune;
    }

    public static Paint getBleue(){
        if(MonPaint.bleue== null){
            MonPaint.istanciate();
        }
        return MonPaint.bleue;
    }

    public static Paint getBlanche(){
        if(MonPaint.blanche== null){
            MonPaint.istanciate();
        }
        return MonPaint.blanche;
    }

    public static Paint getNoir(){
        if(MonPaint.noir== null){
            MonPaint.istanciate();
        }
        return MonPaint.noir;
    }
}
