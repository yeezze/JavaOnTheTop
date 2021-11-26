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


public class LoginActivity extends AppCompatActivity {

    EditText userid, password, findpassword;
    Button signup;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userid= (EditText) findViewById(R.id.userid);
        password = (EditText) findViewById(R.id.password);
        findpassword = (EditText) findViewById(R.id.findpassword);
        signup = (Button) findViewById(R.id.btnsignup);
        dbHelper = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ui = userid.getText().toString();
                String pw = password.getText().toString();
                String findpw = findpassword.getText().toString();

                if(ui.equals("")||pw.equals("")||findpw.equals(""))
                    Toast.makeText(LoginActivity.this, "다시 입력해주세요", Toast.LENGTH_SHORT).show();
                else{
                    if(pw.equals(findpw)) {
                        Boolean checkuser = dbHelper.checkuserid(ui);
                        if (checkuser == false) {
                            Boolean insert = dbHelper.insertData(ui, pw);
                            if (insert == true) {
                                Toast.makeText(LoginActivity.this, "성공적으로 등록되었습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(LoginActivity.this, "실패하였습니다.", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(LoginActivity.this, "이미 등록된 유저입니다.", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(LoginActivity.this, "비밀번호를 다시 입력해주세요.", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });

    }
}
