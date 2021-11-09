package com.apps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    ViewFlipper v_flipper;

    public void flipperImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000); //딜레이 시간 1000틱 당 1초
        v_flipper.setAutoStart(true); //자동시작 유무
        v_flipper.setInAnimation(this, android.R.anim.slide_in_left); // 애니메이션
        v_flipper.setOutAnimation(this,android.R.anim.slide_out_right);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int images[] = {
                R.drawable.sample1,
                R.drawable.sample2,
                R.drawable.sample3
        };

        v_flipper = findViewById(R.id.image_slide);
        for(int image : images){
            flipperImages(image);
        } // 변수 images 안에 있는 요소들을 대상으로 반복문 실행

    }

}