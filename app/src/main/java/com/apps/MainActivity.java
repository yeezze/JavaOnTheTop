package com.apps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 태섭 on 2021-11-09
 */

public class MainActivity extends AppCompatActivity {

    ViewFlipper v_flipper;
    private RecyclerAdapter adapter;
    GridLayoutManager layoutManager;

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
        for (int image : images) {
            flipperImages(image);
        } // 변수 images 안에 있는 요소들을 대상으로 반복문 실행 #배너

        init(); // 리사이클러 뷰
        getData(); // 리사이클러 뷰 데이터 가져오기

        /*
        이미지 버튼 클릭시 화면 전환 by 예지
         */
        ImageView logo = (ImageView) findViewById(R.id.logo);
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubActivity_menu.class);
                startActivity(intent);
            }
        });

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


    private void init() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        layoutManager = new GridLayoutManager(getApplicationContext(), 2);

        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    } // 리사이클러 뷰


    private void getData() {

        List<String> listTitle = Arrays.asList("가나다", "나다라", "다라마", "라마바", "마바사", "바사아");
        List<String> listWorth = Arrays.asList("1000", "2000", "1000", "2000", "1000", "3000");
        List<Integer> listResId = Arrays.asList(
                R.drawable.sample1,
                R.drawable.sample2,
                R.drawable.sample3,
                R.drawable.sample4,
                R.drawable.sample5,
                R.drawable.sample6
        );
        for (int i = 0; i < listTitle.size(); i++) {
            // 각 List의 값들을 data 객체에 set 해줍니다.
            Data data = new Data();
            data.setTitle(listTitle.get(i));
            data.setWorth(listWorth.get(i));
            data.setResId(listResId.get(i));

            // 각 값이 들어간 data를 adapter에 추가합니다.
            adapter.addItem(data);
        }

        // adapter의 값이 변경되었다는 것을 알려줍니다.
        adapter.notifyDataSetChanged();
    } // 리사이클러 뷰 데이터 가져오기
}