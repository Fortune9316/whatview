package com.izi.whatview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.view.Window;
import java.lang.reflect.Field;

/**
 * Created by carlos on 30/10/2016.
 */
// class for UI rules in activitys

public class UiController {

    Typeface type;

    public UiController(){

    }

    public void HideUiBars(Window window){
        View decorView = window.getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);
    }

    public Typeface GetCustomTypeface(Context context){
        type = Typeface.createFromAsset(context.getAssets(),"fonts/BebasNeue.otf");
        return  type;
    }

}
