package com.izi.whatview;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    UiController uiController;

    TextView titleAppTv;
    TextView logInTv;
    TextView singUpTv;
    Button logInFaceBtn;
    Button logInTwittBtn;
    Button logInGmailBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        uiController = new UiController();
        setContentView(R.layout.activity_main);

        titleAppTv = (TextView)findViewById(R.id.TitleApp);
        logInTv = (TextView)findViewById(R.id.tvLogIn);
        singUpTv = (TextView)findViewById(R.id.tvSignIn);
        logInFaceBtn = (Button) findViewById(R.id.btnFacebook);
        logInTwittBtn = (Button) findViewById(R.id.btnTwitter);
        logInGmailBtn = (Button) findViewById(R.id.btnGmail);

        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/BebasNeue.otf");
        titleAppTv.setTypeface(type);
        singUpTv.setTypeface(type);
        logInTv.setTypeface(type);
        logInFaceBtn.setTypeface(type);
        logInTwittBtn.setTypeface(type);
        logInGmailBtn.setTypeface(type);

    }

    @Override
    protected void onResume() {
        super.onResume();
        uiController.HideUiBars(getWindow());
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        uiController.HideUiBars(getWindow());
    }

    public void SingIn(View view) {
        Intent i = new Intent(getApplicationContext(),SignUpActivity.class);
        startActivity(i);
    }

    public void LogIn(View view) {
        Intent i = new Intent(getApplicationContext(),PickActivity.class);
        startActivity(i);
    }
}
