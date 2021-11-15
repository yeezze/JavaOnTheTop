package com.apps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 태섭 on 2021-11-09
 */

public class MainActivity extends AppCompatActivity {

    private ViewFlipper v_flipper;
    private Spinner spinner;
    private ImageButton imgBtn1;
    int result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dropDownBox();
        subActivityBtn();

        int images[] = {
                R.drawable.sample1,
                R.drawable.sample2,
                R.drawable.sample3
        };

        v_flipper = findViewById(R.id.image_slide);
        for (int image : images) {
            flipperImages(image);
        } // 변수 images 안에 있는 요소들을 대상으로 반복문 실행 #배너

    }

    public void flipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000); //딜레이 시간 1000틱 당 1초
        v_flipper.setAutoStart(true); //자동시작 유무
        v_flipper.setInAnimation(this, android.R.anim.slide_in_left); // 애니메이션
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    } // 롤링배너
    
    public void dropDownBox(){
        spinner = (Spinner)findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position).toString().equals("이름순")){
                    Toast.makeText(getApplicationContext(),"이름순",Toast.LENGTH_SHORT).show();
                }else if(parent.getItemAtPosition(position).toString().equals("가격순")){
                    Toast.makeText(getApplicationContext(),"가격순",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"등록순",Toast.LENGTH_SHORT).show();
                };
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void subActivityBtn(){
                /*
        이미지 버튼 클릭시 화면 전환 by 예지
         */
        ImageView logo = (ImageView) findViewById(R.id.imageBtnMain1);
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubActivity_menu.class);
                startActivity(intent);
            }
        });

    }



}