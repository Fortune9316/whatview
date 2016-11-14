package com.izi.whatview;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity {

    UiController uiController;
    TextView tvTitle;
    Button btnCreate;
    EditText username;
    EditText password;
    EditText email;
    public static SignUpActivity instance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        uiController = new UiController();
        setContentView(R.layout.activity_sign_up);
        tvTitle = (TextView)findViewById(R.id.tvMainSignUp);
        btnCreate = (Button)findViewById(R.id.btnCreate);
        username = (EditText)findViewById(R.id.etxNewUsername);
        password = (EditText)findViewById(R.id.etxNewPassword);
        email = (EditText)findViewById(R.id.etxNewEmail);
        tvTitle.setTypeface(uiController.GetCustomTypeface(this));
        btnCreate.setTypeface(uiController.GetCustomTypeface(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        uiController.HideUiBars(getWindow());
    }

    public void CreateAccount(View view) {
        Data data = new Data(this);
        SQLiteDatabase sq = data.getWritableDatabase();
        Cursor cursor = sq.rawQuery("select * from user",null);
        ArrayList<String> arrayList = new ArrayList<>();
        if(cursor!=null){
            if(cursor.moveToFirst()){
                do{
                    String usu = cursor.getString(cursor.getColumnIndex("username"));
                    arrayList.add(usu);
                }while (cursor.moveToNext());
            }
        }

        Editable ed1 = username.getText();
        Editable ed2 = password.getText();
        Editable ed3 = email.getText();
        if(checkInDatabase(arrayList,ed1.toString()))
        {
            Toast.makeText(getApplicationContext(),"User already exists!",Toast.LENGTH_SHORT).show();
        }else
        {
            data.addUser(data,ed1.toString(),ed2.toString());
            sendConfirmation(ed3.toString());
            //this.finish();
        }

    }
    public boolean checkInDatabase(ArrayList list, String data)
    {
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).equals(data))
                return true;
        }
        return  false;
    }

    public void sendConfirmation(String mail)
    {
       String message = "Dear  " + username.getText().toString().trim() + ": \n \n" + "Welcome to Whatview, thank you for register :)";


        SendMail sm = new SendMail(this,mail.trim(),"Whatview new account",message.trim());
        sm.execute();
    }
}
