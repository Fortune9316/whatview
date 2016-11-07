package com.izi.whatview;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by carlos on 07/11/2016.
 */

public class Data extends SQLiteOpenHelper {

    public Data(Context context) {
        super(context, "whatviewDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(username text, password text)");
    }

    public void addUser(Data db, String nom, String pass){
        SQLiteDatabase sq = db.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("username",nom);
        cv.put("password",pass);

        sq.insert("user",null,cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
