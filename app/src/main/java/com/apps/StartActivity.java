package com.apps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
/**
 * Created by 예진
 */
public class StartActivity extends AppCompatActivity {

    EditText userid, password;
    Button Loginbtn, Makebtn;
    TextView forgotpw;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        userid = (EditText) findViewById(R.id.userid2);
        password = (EditText) findViewById(R.id.password2);
        Loginbtn = (Button) findViewById(R.id.signin2);
        Makebtn = (Button) findViewById(R.id.signin3);
        dbHelper = new DBHelper(this);
        forgotpw = (TextView) findViewById(R.id.forgot);

        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ui = userid.getText().toString();
                String pw = password.getText().toString();

                if(ui.equals("")||pw.equals(""))
                    Toast.makeText(StartActivity.this, "다시 입력해주세요.", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpw  = dbHelper.checkuserpassword(ui,pw);
                    if(checkuserpw==true){
                        Toast.makeText(StartActivity.this, "성공적으로 로그인하였습니다.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(StartActivity.this, "다시 입력해주세요.", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        Makebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        forgotpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FindActivity.class);
                startActivity(intent);
            }
        });
    }
}
