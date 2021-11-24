package com.apps;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class LogoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
        start(3); // 레이아웃 변경 시간 설정
    }

    private void start(int sec) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1000 * sec); // 딜레이 시간 설정
    }
}