package com.apps;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class SubActivity_menu extends AppCompatActivity {

    ImageButton backbtn, imageButton;
    Button btnYoutube;
    ImageButton itemBtn1, itemBtn2, itemBtn3, itemBtn4, itemBtn5, itemBtn6;
    TextView textItem1, textItem2, textItem3, textItem4, textItem5, textItem6;
    private Intent intent;
    private int viewNum, resId;
    private String title, price;
    private ImageView imageView;
    private TextView title2, price2, subTitle, textRecipe;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu);
        intent = getIntent();
        viewNum = intent.getIntExtra("viewNum",-1);
        price = intent.getStringExtra("price");
        resId = intent.getIntExtra("resId",-1);
        title = intent.getStringExtra("title");

        imageView = (ImageView) findViewById(R.id.subImg);
        title2 = (TextView) findViewById(R.id.title2);
        price2 = (TextView) findViewById(R.id.price2);
        subTitle = (TextView) findViewById(R.id.subTitle);
        textRecipe = (TextView) findViewById(R.id.textRecipe);

        btnYoutube = (Button) findViewById(R.id.btnYoutube);
        itemBtn1 = (ImageButton) findViewById(R.id.itembtn1);
        itemBtn2 = (ImageButton) findViewById(R.id.itembtn2);
        itemBtn3 = (ImageButton) findViewById(R.id.itembtn3);
        itemBtn4 = (ImageButton) findViewById(R.id.itembtn4);
        itemBtn5 = (ImageButton) findViewById(R.id.itembtn5);
        itemBtn6 = (ImageButton) findViewById(R.id.itembtn6);

        textItem1 = (TextView) findViewById(R.id.textItem1);
        textItem2 = (TextView) findViewById(R.id.textItem2);
        textItem3 = (TextView) findViewById(R.id.textItem3);
        textItem4 = (TextView) findViewById(R.id.textItem4);
        textItem5 = (TextView) findViewById(R.id.textItem5);
        textItem6 = (TextView) findViewById(R.id.textItem6);



        subView(viewNum);

        // 뒤로가기 버튼 클릭시 종료
        backbtn = (ImageButton) findViewById(R.id.backimgbtn);
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CalenderActivity.class);
                startActivity(intent);
            }
        });
    }

    public void subView(int viewNum){

        switch (viewNum){
            case 1:
                imageView.setImageResource(resId);
                title2.setText(title);
                price2.setText(price);
                subTitle.setText(" 밥 한 그릇 뚝딱, 밥반찬으로 딱");
                textRecipe.setText("1. 두부 한 모를 먹기 좋은 크기로 썰어준 후 키친타월로 물기를 제거해 준다.\n");
                textRecipe.append("\n2. 후라이팬에 식용유 한 스푼 정도 두르고 중불로 맞추어 두부를 구워준다.\n");
                textRecipe.append("\n3. 두부를 팬 가장자리에 놓은 후 양파를 먹을 만큼 썰어서 중앙에 굽는다.\n");
                textRecipe.append("\n4. 대파와 청양고추를 썰어 뿌려준다.\n");
                textRecipe.append("\n5. 만들어 놓은 양념장을 뿌린다.\n");
                textRecipe.append("\n6. 팽이버섯 밑동을 자르고 올린 후 뚜껑을 덮어 숨을 죽인 후 양념이 스며들도록 한다.\n");
                textRecipe.append("\n7. 계란을 먹을 만큼 넣고 뚜껑을 덮어 계란이 익을 때까지 익힌다.\n");
                btnYoutube.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        BtnClicked("https://youtu.be/ffuakdFmuh4");
                    }
                });
                itemBtnSetting(itemBtn1, textItem1, R.drawable.tofu, "두부", "https://coupa.ng/caISMv");
                itemBtnSetting(itemBtn2, textItem2, R.drawable.mushroom, "팽이버섯","https://coupa.ng/caISKO");
                itemBtnSetting(itemBtn3, textItem3, R.drawable.egg,"달걀" ,"https://coupa.ng/caISJY");
                itemBtnSetting(itemBtn4, textItem4, R.drawable.onion,"양파" ,"https://coupa.ng/caISH3");
                itemBtnSetting(itemBtn5, textItem5, R.drawable.greenonion,"대파" ,"https://m.coupang.com/nm/search?q=%EB%8C%80%ED%8C%8C");
                itemBtnSetting(itemBtn6, textItem6, R.drawable.chilipepper,"청양고추" ,"https://coupa.ng/caIRVV");
                break;
            case 2:
                imageView.setImageResource(resId);
                title2.setText(title);
                price2.setText(price);
                subTitle.setText(" 손쉽게 즐기는 뜨끈한 집밥의 대명사!");
                textRecipe.setText("1. (애호박), 양파, (두부)는 먹기 좋은 크기로 잘라 준비한다. (깍둑썰기)\n");
                textRecipe.append("\n2. 느타리버섯은 찢어서 준비한다. (생략가능)\n");
                textRecipe.append("\n3. 청양고추, (홍고추), 대파는 1cm 정도 두께로 썰어 준비한다.\n");
                textRecipe.append("\n4. 멸치는 머리, 내장을 제거하고 3등분 정도로 찢어 준비한다.\n");
                textRecipe.append("\n5. 냄비에 손질한 멸치, 물, 양파를 넣어 끓인다.\n");
                textRecipe.append("\n6. 육수가 끓으면 (느타리버섯), (애호박), 간마늘, 된장을 넣는다.\n");
                textRecipe.append("\n7. 된장 육수가 끓어오르면 대파, 청양고추, (홍고추)를 넣어 끓인다.\n");
                textRecipe.append("\n8. 찌개가 끓으면 (두부)를 넣고 1분 정도 끓여 완성한다.\n");
                btnYoutube.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        BtnClicked("https://youtu.be/ffuakdFmuh4");
                    }
                });
                itemBtnSetting(itemBtn1, textItem1, R.drawable.doenjang, "된장", "https://coupa.ng/caIRU6");
                itemBtnSetting(itemBtn2, textItem2, R.drawable.garlic, "간마늘","https://coupa.ng/caIRUh");
                itemBtnSetting(itemBtn3, textItem3, R.drawable.onion,"양파" ,"https://coupa.ng/caIRTd");
                itemBtnSetting(itemBtn4, textItem4, R.drawable.greenonion,"대파" ,"https://coupa.ng/caIRRy");
                itemBtnSetting(itemBtn5, textItem5, R.drawable.chilipepper,"청양고추" ,"https://coupa.ng/caIRVV");
                itemBtnSetting(itemBtn6, textItem6, R.drawable.anchovy,"멸치" ,"https://coupa.ng/caIRYw");
                break;
            case 3:
                imageView.setImageResource(resId);
                title2.setText(title);
                price2.setText(price);
                subTitle.setText(" 매일 먹는 라면, 색다르게 먹는 방법 없을까?");
                textRecipe.setText("1. 대파는 송송 썰어 준비한다. \n");
                textRecipe.append("\n2. 냄비에 물, 분말수프(1/2~2/3), 건더기수프, 설탕, 고추장을 넣고 풀어주며 끓인다. (분말수프의 양은 기호에 맞게 조절한다.)\n");
                textRecipe.append("\n3. 육수가 끓으면 면을 넣고 끓인다.\n");
                textRecipe.append("\n4. 면이 완전히 풀어지면 대파를 넣고 1분정도 더 끓인다. \n");
                textRecipe.append("\n5. 물이 졸아들고 면이 익으면 불을 끄고 그릇에 담아 완성한다.\n");
                btnYoutube.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        BtnClicked("https://youtu.be/6e-IbuuD6ZU");
                    }
                });
                itemBtnSetting(itemBtn1, textItem1, R.drawable.ramen, "라면", "https://coupa.ng/caISPd");
                itemBtnSetting(itemBtn2, textItem2, R.drawable.greenonion, "대파","https://coupa.ng/caIRRy");
                itemBtnSetting(itemBtn3, textItem3, R.drawable.sugar,"황설탕" ,"https://coupa.ng/caISVr");
                itemBtnSetting(itemBtn4, textItem4, R.drawable.gochujang,"고추장" ,"https://coupa.ng/caIST0");
                break;
            case 4:
                imageView.setImageResource(resId);
                title2.setText(title);
                price2.setText(price);
                subTitle.setText(" 본 조르노! 집에서 즐기는 이탈리아");
                textRecipe.setText("1. 감자는 얇게 채 썰고 베이컨은 먹기 좋은 크기로 썰어준다.\n");
                textRecipe.append("\n2. 달군 프라이팬에 오일을 두르고 생새우, 후추를 넣고 약불에 볶는다\n");
                textRecipe.append("\n3. 새우를 건지고 베이컨을 넣어 볶아준다.\n");
                textRecipe.append("\n4. 베이컨이 노릇하게 익으면 감자를 넣어서 골고루 편다.\n");
                textRecipe.append("\n5. 한쪽 면이 다 익으면 반대로 뒤집는다.\n");
                textRecipe.append("\n6. 취향에 맞춰서 소금 후추로 간을 하고 모짜렐라 치즈와 새우 등으로 토핑을 올려준다.\n");
                btnYoutube.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        BtnClicked("https://youtu.be/mQdLsawUBgA");
                    }
                });
                itemBtnSetting(itemBtn1, textItem1, R.drawable.potato, "감자", "https://coupa.ng/caIS2k");
                itemBtnSetting(itemBtn2, textItem2, R.drawable.bacon, "베이컨","https://coupa.ng/caITcg");
                itemBtnSetting(itemBtn3, textItem3, R.drawable.shrimp,"새우" ,"https://coupa.ng/caITbv");
                itemBtnSetting(itemBtn4, textItem5, R.drawable.cheese,"모짜렐라치즈" ,"https://coupa.ng/caITam");
                break;
        }
    }
    public void BtnClicked(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    public void itemBtnSetting(ImageButton item, TextView text, int resId, String name, String url){
        item.setVisibility(View.VISIBLE);
        item.setImageResource(resId);
        text.setVisibility(View.VISIBLE);
        text.setText(name);
        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BtnClicked(url);
            }
        });
    }

}
