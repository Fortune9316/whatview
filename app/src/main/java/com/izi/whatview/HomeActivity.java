package com.izi.whatview;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class HomeActivity extends AppCompatActivity {

    UiController uiController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        uiController = new UiController();
        uiController.HideUiBars(getWindow());
    }
}
