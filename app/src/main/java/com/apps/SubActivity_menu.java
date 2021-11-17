package com.apps;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SubActivity_menu extends AppCompatActivity {

    ImageButton backbtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu);

        // 뒤로가기 버튼 클릭시 종료
        backbtn = (ImageButton) findViewById(R.id.backimgbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void onBtnYoutubeClicked(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/ffuakdFmuh4"));
        startActivity(intent);
    }

    public void onitembtn1Clicked(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.coupang.com/np/search?component=&q=된장&channel=user"));
        startActivity(intent);
    }
    public void onitembtn2Clicked(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.coupang.com/np/search?component=&q=간마늘&channel=user"));
        startActivity(intent);
    }
    public void onitembtn3Clicked(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.coupang.com/np/search?component=&q=양파&channel=user"));
        startActivity(intent);
    }
    public void onitembtn4Clicked(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.coupang.com/np/search?component=&q=대파&channel=user"));
        startActivity(intent);
    }
    public void onitembtn5Clicked(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.coupang.com/np/search?component=&q=청양고추&channel=user"));
        startActivity(intent);
    }
}
