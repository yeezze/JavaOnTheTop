package com.apps;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
/*
sqlite by 예진
 */

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import com.apps.R;

/*
sqlite by 예진
 */

public class MenuActivity extends AppCompatActivity {
    mySQLiteHelper mySQLiteHelper;
    TextView name1, name2, name3, name4;
    TextView cost1, cost2, cost3, cost4;
    ToggleButton toggleButton1, toggleButton2, toggleButton3, toggleButton4;
    Spinner spinner;
    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name1 = (TextView) findViewById(R.id.name1);
        name2 = (TextView) findViewById(R.id.Name2);
        name3 = (TextView) findViewById(R.id.Name3);
        name4 = (TextView) findViewById(R.id.Name4);

        cost1 = (TextView) findViewById(R.id.cost1);
        cost2 = (TextView) findViewById(R.id.cost2);
        cost3 = (TextView) findViewById(R.id.cost3);
        cost4 = (TextView) findViewById(R.id.cost4);

        toggleButton1 = (ToggleButton) findViewById(R.id.toggleButton1);
        toggleButton2 = (ToggleButton) findViewById(R.id.toggleButton2);
        toggleButton3 = (ToggleButton) findViewById(R.id.toggleButton3);
        toggleButton4 = (ToggleButton) findViewById(R.id.toggleButton4);

        int imageResource1 = R.drawable.sample1;
        Drawable image1 = getResources().getDrawable(imageResource1);
        int imageResource2 = R.drawable.sample2;
        Drawable image2 = getResources().getDrawable(imageResource2);
        int imageResource3 = R.drawable.sample3;
        Drawable image3 = getResources().getDrawable(imageResource3);
        int imageResource4 = R.drawable.sample4;
        Drawable image4 = getResources().getDrawable(imageResource4);

        toggleButton1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                if (toggleButton1.isChecked()) {
                    sqlDB = mySQLiteHelper.getWritableDatabase();
                    sqlDB.execSQL("INSERT INTO menuTable VALUES ( '" + name1.getText().toString() + "' , '" + cost1.getText().toString() + "', '" + image1 + "', '" + "T" + "');");
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(), "냉장고에 저장하였습니다.", 0).show();
                }
            }
        });

        toggleButton2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                if (toggleButton2.isChecked()) {
                    sqlDB = mySQLiteHelper.getWritableDatabase();
                    sqlDB.execSQL("INSERT INTO menuTable VALUES ( '" + name2.getText().toString() + "' , '" + cost2.getText().toString() + "', '" + image2 + "', '" + "T" + "');");
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(), "냉장고에 저장하였습니다.", 0).show();
                }
            }
        });

        toggleButton3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                if (toggleButton3.isChecked()) {
                    sqlDB = mySQLiteHelper.getWritableDatabase();
                    sqlDB.execSQL("INSERT INTO menuTable VALUES ( '" + name3.getText().toString() + "' , '" + cost3.getText().toString() + "', '" + image3 + "', '" + "T" + "');");
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(), "냉장고에 저장하였습니다.", 0).show();
                }
            }
        });
        toggleButton4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                if (toggleButton4.isChecked()) {
                    sqlDB = mySQLiteHelper.getWritableDatabase();
                    sqlDB.execSQL("INSERT INTO menuTable VALUES ( '" + name4.getText().toString() + "' , '" + cost4.getText().toString() + "', '" + image4 + "', '" + "T" + "');");
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(), "냉장고에 저장하였습니다.", 0).show();
                }
            }
        });
    }

    public class mySQLiteHelper extends SQLiteOpenHelper {
        public String TABLE_NAME = "menuTable";
        public String MENU_TITLE = "menuTitle";
        public String MENU_COST = "menuCost";
        public String MENU_IMAGE = "menuImage";
        public String MENU_STATUS = "mStatus";

        private String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + MENU_TITLE + " TEXT," + MENU_IMAGE + " TEXT,"
                + MENU_COST + " TEXT," + MENU_STATUS + " TEXT)";

        public mySQLiteHelper(Context context) {
            super(context, "menuDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
        }


        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS menuTable");
            onCreate(db);
            }
        }
    }
