package com.apps;

import android.annotation.SuppressLint;
import android.icu.util.Output;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by 예진, 캘린더메모 구축
 */

public class CalenderActivity extends AppCompatActivity {
    private String name1 = null;
    private String name2 = null;
    private String name3 = null;
    private String str1 = null;
    private String str2 = null;
    private String str3 = null;
    private Button save_btn, change_btn, delete_btn;
    private TextView Date, Outputb, Outputl, Outputd;
    private EditText Break, Lunch, Dinner;
    private static final String TAG = "CalendarActivity";
    private CalendarView mCalendarView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        mCalendarView = (CalendarView) findViewById(R.id.calendarView);
        Date = (TextView) findViewById(R.id.Date);
        Outputb = (TextView) findViewById(R.id.Outputb);
        Outputl = (TextView) findViewById(R.id.Outputl);
        Outputd = (TextView) findViewById(R.id.Outputd);

        Break = (EditText) findViewById(R.id.Break);
        Lunch = (EditText) findViewById(R.id.Lunch);
        Dinner = (EditText) findViewById(R.id.Dinner);

        save_btn = (Button) findViewById(R.id.save_btn);
        delete_btn = (Button) findViewById(R.id.delete_btn);
        change_btn = (Button) findViewById(R.id.change_btn);


        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Date.setVisibility(View.VISIBLE);
                save_btn.setVisibility(View.VISIBLE);
                Break.setVisibility(View.VISIBLE);
                Lunch.setVisibility(View.VISIBLE);
                Dinner.setVisibility(View.VISIBLE);
                Outputb.setVisibility(View.INVISIBLE);
                Outputl.setVisibility(View.INVISIBLE);
                Outputd.setVisibility(View.INVISIBLE);
                delete_btn.setVisibility(View.INVISIBLE);
                change_btn.setVisibility(View.INVISIBLE);
                Date.setText(String.format("%d" +"년 "+ "%d" +"월 "+ "%d"+ "일 식단 기록",year, month+1, dayOfMonth));
                Break.setText("");
                Lunch.setText("");
                Dinner.setText("");
                checkDay(year, month, dayOfMonth);
            }
        });

        //저장 버튼 눌렀을 때 설정
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                memo_save(name1);
                memo_save(name2);
                memo_save(name3);
                str1 = Break.getText().toString();
                str2 = Lunch.getText().toString();
                str3 = Dinner.getText().toString();

                Outputb.setText(str1);
                Outputl.setText(str2);
                Outputd.setText(str3);

                save_btn.setVisibility(View.INVISIBLE);
                change_btn.setVisibility(View.VISIBLE);
                delete_btn.setVisibility(View.VISIBLE);

                Break.setVisibility(View.INVISIBLE);
                Lunch.setVisibility(View.INVISIBLE);
                Dinner.setVisibility(View.INVISIBLE);
                Outputb.setVisibility(View.VISIBLE);
                Outputl.setVisibility(View.VISIBLE);
                Outputd.setVisibility(View.VISIBLE);


            }
        });
    }

    public void  checkDay(int cYear,int cMonth,int cDay){
        //파일 이름 설정
        name1="Java_on_top_project_breakfast" + cYear + "-" + (cMonth+1) + "" + "-" + cDay + ".txt";
        name2="Java_on_top_project_lunch" + cYear + "-" + (cMonth+1) + "" + "-" + cDay + ".txt";
        name3="Java_on_top_project_dinner" + cYear + "-" + (cMonth+1) + "" + "-" + cDay + ".txt";
        FileInputStream File = null;//FileStream File 변수 선언

        try{
            File = openFileInput(name1);
            File = openFileInput(name2);
            File = openFileInput(name3);

            byte[] fileData = new byte [File.available()];
            File.read(fileData);
            File.close();

            str1 = new String(fileData);
            str2 = new String(fileData);
            str3 = new String(fileData);


            Break.setVisibility(View.INVISIBLE);
            Lunch.setVisibility(View.INVISIBLE);
            Dinner.setVisibility(View.INVISIBLE);

            Outputb.setVisibility(View.VISIBLE);
            Outputl.setVisibility(View.VISIBLE);
            Outputd.setVisibility(View.VISIBLE);

            Outputb.setText(str1);
            Outputl.setText(str2);
            Outputd.setText(str3);

            save_btn.setVisibility(View.INVISIBLE);
            change_btn.setVisibility(View.VISIBLE);
            delete_btn.setVisibility(View.VISIBLE);

            //수정 버튼 눌렀을 때
            change_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Break.setVisibility(View.VISIBLE);
                    Lunch.setVisibility(View.VISIBLE);
                    Dinner.setVisibility(View.VISIBLE);

                    Outputb.setVisibility(View.INVISIBLE);
                    Outputl.setVisibility(View.INVISIBLE);
                    Outputd.setVisibility(View.INVISIBLE);

                    Break.setText(str1);
                    Lunch.setText(str2);
                    Dinner.setText(str3);

                   save_btn.setVisibility(View.VISIBLE);
                    change_btn.setVisibility(View.INVISIBLE);
                    delete_btn.setVisibility(View.INVISIBLE);

                    //작성한 텍스트를 내보내기
                    Outputb.setText(Break.getText());
                    Outputl.setText(Lunch.getText());
                    Outputd.setText(Dinner.getText());
                }

            });
            //삭제 버튼 눌렀을때
           delete_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Outputb.setVisibility(View.INVISIBLE);
                    Outputl.setVisibility(View.INVISIBLE);
                    Outputd.setVisibility(View.INVISIBLE);

                    Break.setText("");
                    Lunch.setText("");
                    Dinner.setText("");

                    Break.setVisibility(View.VISIBLE);
                    Lunch.setVisibility(View.VISIBLE);
                    Dinner.setVisibility(View.VISIBLE);

                    save_btn.setVisibility(View.VISIBLE);
                    change_btn.setVisibility(View.INVISIBLE);
                    delete_btn.setVisibility(View.INVISIBLE);

                    //파일에서 삭제하기
                    memo_remove(name1);
                    memo_remove(name2);
                    memo_remove(name3);
                }
            });

           //

            if(Outputb.getText()==null){
                Outputb.setVisibility(View.INVISIBLE);

                Date.setVisibility(View.VISIBLE);
                save_btn.setVisibility(View.VISIBLE);
                change_btn.setVisibility(View.INVISIBLE);
                delete_btn.setVisibility(View.INVISIBLE);
                Break.setVisibility(View.VISIBLE);

            }

            if(Outputd.getText()==null){
                Outputd.setVisibility(View.INVISIBLE);

                Date.setVisibility(View.VISIBLE);
                save_btn.setVisibility(View.VISIBLE);
                change_btn.setVisibility(View.INVISIBLE);
                delete_btn.setVisibility(View.INVISIBLE);
                Lunch.setVisibility(View.VISIBLE);

            }

            if(Outputl.getText()==null){
                Outputl.setVisibility(View.INVISIBLE);

                Date.setVisibility(View.VISIBLE);
                save_btn.setVisibility(View.VISIBLE);
                change_btn.setVisibility(View.INVISIBLE);
                delete_btn.setVisibility(View.INVISIBLE);
                Dinner.setVisibility(View.VISIBLE);

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @SuppressLint("WrongConstant")
    public void memo_save(String readDay){
        FileOutputStream File_out = null;

        try{
            File_out = openFileOutput(readDay,MODE_NO_LOCALIZED_COLLATORS);
            String content1 = Break.getText().toString();
            String content2 = Lunch.getText().toString();
            String content3 = Dinner.getText().toString();

            File_out.write((content1).getBytes());
            File_out.write((content2).getBytes());
            File_out.write((content3).getBytes());
            File_out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @SuppressLint("WrongConstant")
    public void memo_remove(String readDay){
        FileOutputStream File_out = null;

        try{
            File_out=openFileOutput(readDay,MODE_NO_LOCALIZED_COLLATORS);
            String content1="";
            String content2="";
            String content3="";
            File_out.write((content1).getBytes());
            File_out.write((content2).getBytes());
            File_out.write((content3).getBytes());
            File_out.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


