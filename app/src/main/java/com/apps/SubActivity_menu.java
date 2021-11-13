package com.apps;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity_menu extends AppCompatActivity {

    Button btncom;
    ImageButton backbtn;
    EditText edtcomment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu);

        btncom = (Button) findViewById(R.id.buttoncomment);
        edtcomment = (EditText) findViewById(R.id.edtcomment);

        // 뒤로가기 버튼 클릭시 종료
        backbtn = (ImageButton) findViewById(R.id.backimgbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
