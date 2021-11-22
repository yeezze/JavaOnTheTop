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

public class ResetActivity extends AppCompatActivity {

    TextView userid;
    EditText pw, reset_pw;
    Button complete;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        userid = (TextView) findViewById(R.id.userid_reset);
        pw = (EditText) findViewById(R.id.password_reset);
        reset_pw = (EditText) findViewById(R.id.password_reset2);
        complete = (Button) findViewById(R.id.btnComplete);
        dbHelper = new DBHelper(this);
        Intent intent = getIntent();
        userid.setText(intent.getStringExtra("userid"));

        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ui = userid.getText().toString();
                String password = pw.getText().toString();
                String reset_password = reset_pw.getText().toString();

                if (password.equals(reset_password)) {
                    Boolean checkupdatepassword = dbHelper.updatepassword(ui, password);
                    if (checkupdatepassword == true) {
                        Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                        startActivity(intent);
                        Toast.makeText(ResetActivity.this, "비밀번호가 변경되었습니다.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ResetActivity.this, "다시 입력해주세요.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ResetActivity.this, "다시 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
