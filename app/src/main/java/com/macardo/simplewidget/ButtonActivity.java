package com.macardo.simplewidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ButtonActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button;
    private ImageButton imageButton;
    private ToggleButton toggleButton;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        button = findViewById(R.id.button);
        imageButton = findViewById(R.id.imageButton);
        toggleButton = findViewById(R.id.toggleButton);
        imageView = findViewById(R.id.imageView2);

/*        //第1种方式：匿名内部类
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something...
            }
        });*/

        //2.继承 View.OnClickListener 并重写 onClick() 方法
        button.setOnClickListener(this);
        imageButton.setOnClickListener(this);

/*        //3.独立类
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击按钮触发的操作
            }
        };
        button.setOnClickListener(onClickListener);*/

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //更改toggleButtonh状态
                toggleButton.setChecked(isChecked);
                //更改ImageView图片
                imageView.setBackgroundResource(isChecked?R.drawable.smile:R.drawable.sad);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                Toast.makeText(ButtonActivity.this,"Button",Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageButton:
                Toast.makeText(ButtonActivity.this,"imageButton",Toast.LENGTH_SHORT).show();
            default:
                break;
        }
    }
}
