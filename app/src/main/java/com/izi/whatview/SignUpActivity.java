package com.izi.whatview;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SignUpActivity extends AppCompatActivity {

    UiController uiController;
    TextView tvTitle;
    Button btnCreate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        uiController = new UiController();
        setContentView(R.layout.activity_sign_up);
        tvTitle = (TextView)findViewById(R.id.tvMainSignUp);
        btnCreate = (Button)findViewById(R.id.btnCreate);

        tvTitle.setTypeface(uiController.GetCustomTypeface(this));
        btnCreate.setTypeface(uiController.GetCustomTypeface(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        uiController.HideUiBars(getWindow());
    }

    public void CreateAccount(View view) {
        Toast.makeText(getApplicationContext(),"Account created successfully",Toast.LENGTH_SHORT).show();
        this.finish();
    }
}
