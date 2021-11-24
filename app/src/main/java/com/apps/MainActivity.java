package com.apps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by 태섭 on 2021-11-09
 */

public class MainActivity extends AppCompatActivity {

    private ViewFlipper v_flipper;
    private Spinner spinner;
    private GridLayoutManager layoutManager;
    private RecyclerAdapter adapter;
    private ArrayList<Data> data, filteredData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
        dropDownBox();
        searchText();
        ImageButton imageButton1 = (ImageButton) findViewById(R.id.scrap);
        ImageButton imageButton2 = (ImageButton) findViewById(R.id.scrap2);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CalenderActivity.class);
                startActivity(intent);
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                startActivity(intent);
            }
        });



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

    public void dropDownBox() {
        spinner = (Spinner) findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).toString().equals("이름순")) {
                    sortByTitle();
                    Toast.makeText(getApplicationContext(), "이름순", Toast.LENGTH_SHORT).show();
                } else {
                    sortByPrice();
                    Toast.makeText(getApplicationContext(), "가격순", Toast.LENGTH_SHORT).show();
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                getData();
            }
        });
    }


    private void getData() {
        data = new ArrayList<>();

        data.add(new Data("계란두부조림", 5000, R.drawable.menu1, 1));
        data.add(new Data("된장찌개", 3000, R.drawable.menu2, 2));
        data.add(new Data("라볶이", 2000, R.drawable.menu3, 3));
        data.add(new Data("포테이토 치즈피자", 7000, R.drawable.menu4, 4));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        adapter = new RecyclerAdapter(data);
        recyclerView.setAdapter(adapter);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

    } // 리사이클러뷰 적용


    void sortByPrice() {
        Collections.sort(data, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                if (o1.getPrice() < o2.getPrice()) {
                    return -1;
                } else if (o1.getPrice() > o2.getPrice()) {
                    return 1;
                }
                return 0;
            }
        });
    } // 가격순

    void sortByTitle() {
        Collections.sort(data, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                if (o1.getTitle().compareTo(o2.getTitle()) < 0) {
                    return -1;
                } else if (o1.getTitle().compareTo(o2.getTitle()) > 0) {
                    return 1;
                }
                return 0;
            }
        });
    } // 가격순

    void searchText() {
        EditText editText = findViewById(R.id.editText);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }

    private void filter(String text) {
        filteredData = new ArrayList<>();

        for (Data data : data) {
            if (data.getTitle().toLowerCase().contains(text.toLowerCase())) {
                filteredData.add(data);
            }
        }

        adapter.filterData(filteredData);
    }

}