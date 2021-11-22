package com.apps;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
/**
 * Created by 예진, DBHelper 생성
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "login.db";

    public DBHelper(Context context) {
        super(context,"login.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE USER(userid TEXT PRIMARY KEY, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS USER");

    }
    public Boolean insertData(String userid, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("userid", userid);
        cv.put("password", password);
        long value = db.insert("USER", null,cv);
        if(value==-1) return false;
        else
            return true;
    }
    public Boolean updatepassword(String userid, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("password", password);
        long value = db.update("USER", cv, "userid = ?", new String[] {userid});
        if(value==-1) return false;
        else
            return true;
    }
    public Boolean checkuserid(String userid){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM USER WHERE userid =?", new String[] {userid});
        if(cursor.getCount()>0)
            return true;
        else
            return false;

    }
    public Boolean checkuserpassword(String userid, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM USER WHERE userid =? and password = ?", new String[] {userid,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
