package com.apps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
/**
 * Created by 예진
 */

public class FindActivity extends AppCompatActivity {

    EditText userid;
    Button resetpw;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findpw);

        userid = (EditText) findViewById(R.id.editText1);
        resetpw = (Button) findViewById(R.id.btn1);
        dbHelper = new DBHelper(this);

        resetpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ui = userid.getText().toString();

                Boolean checkuser = dbHelper.checkuserid(ui);
                if(checkuser==true){
                    Intent intent = new Intent(getApplicationContext(), ResetActivity.class);
                    intent.putExtra("userid", ui);
                    startActivity(intent);
                } else {
                    Toast.makeText(FindActivity.this, "존재하지 않는 아이디입니다. 다시 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}