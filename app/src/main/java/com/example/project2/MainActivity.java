package com.example.project2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText show;
    Button button1,button2,button3,button4,button5,button6,button7,button8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show=findViewById(R.id.textView);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        button5=findViewById(R.id.button5);
        button6=findViewById(R.id.button6);
        button7=findViewById(R.id.button7);
        button8=findViewById(R.id.button8);
        class InnerListener implements View.OnClickListener {
            @Override
            public void onClick(View view) {
                show.setText("点击了采用内部类作为监听器");
            }
        }
        button1.setOnClickListener((View.OnClickListener) this);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show.setText("点击了采用匿名内部类作为监听器");
            }
        });

        button4.setOnClickListener(new InnerListener());
        button5.setOnClickListener(new OuterListener(show));
        button6.setOnClickListener(new butterListener());

       button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,configurationtest.class);
                startActivity(intent);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ProgressDialogTest.class);
                startActivity(intent);
            }
        });
    }

    class butterListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            show.setText("点击了采用ButterKnife作为监听器");
        }
    }
    //activity本身作为类
    @Override
    public void onClick(View v){
        show.setText("点击了采用Activity作为监听器");
    }
    //直接绑定到标签
    public void clickHandler(View view) {
        show.setText("点击了采用标签作为监听器");
    }
}

