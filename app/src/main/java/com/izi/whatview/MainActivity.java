package com.izi.whatview;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    UiController uiController;

    TextView titleAppTv;
    TextView logInTv;
    TextView singUpTv;
    Button logInFaceBtn;
    Button logInTwittBtn;
    Button logInGmailBtn;
    EditText username;
    EditText password;
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
        username = (EditText) findViewById(R.id.etxUsername);
        password = (EditText) findViewById(R.id.etxPassword);

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
        Data data = new Data(this);
        SQLiteDatabase sq = data.getWritableDatabase();
        Cursor cursor = sq.rawQuery("select * from user",null);
        ArrayList<String> arrayListUser = new ArrayList<>();
        ArrayList<String> arrayListPassword = new ArrayList<>();
        if(cursor!=null){
            if(cursor.moveToFirst()){
                do{
                    String usu = cursor.getString(cursor.getColumnIndex("username"));
                    String pass = cursor.getString(cursor.getColumnIndex("password"));
                    arrayListUser.add(usu);
                    arrayListPassword.add(pass);
                }while (cursor.moveToNext());
            }
        }
        if(checkRegister(arrayListUser,arrayListPassword,username.getText().toString().trim(),password.getText().toString().trim()))
        {
            Toast.makeText(this,"Welcome",Toast.LENGTH_SHORT).show();
            startActivity(i);
        }else
        {
            Toast.makeText(this,"Invalid user or password",Toast.LENGTH_SHORT).show();
        }


    }

    public boolean checkRegister(ArrayList listUser, ArrayList listPassword, String user,String password)
    {
        for(int i=0;i<listUser.size();i++)
        {
            if(listUser.get(i).equals(user) && listPassword.get(i).equals(password))
                return true;
        }
        return  false;
    }
}
