package com.example.project2;


import android.view.View;
import android.widget.EditText;

public class OuterListener implements View.OnClickListener {
    EditText editText;

    public OuterListener(EditText text){
        editText = text;
    }
    @Override
    public void onClick(View view){
        editText.setText("点击了采用外部类作为监听器");
    }
}
