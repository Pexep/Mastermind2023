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

    public static Paint getRouge() {
        if(MonPaint.rouge== null){
            MonPaint.istanciate();
        }
        return MonPaint.rouge;
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

    public static Paint getColor(int n){
        switch (n){
            case 0:
                return MonPaint.getRouge();
            case 1:
                return MonPaint.getBleue();

            case 2:
                return MonPaint.getVerte();

            case 3:
                return MonPaint.getJaune();
            case 4:
                return MonPaint.getNoir();

            case 5:
                return MonPaint.getBlanche();

            default:
                return null;
        }
    }
}
