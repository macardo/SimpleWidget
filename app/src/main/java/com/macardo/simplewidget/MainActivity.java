package com.macardo.simplewidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    private AutoCompleteTextView autoCompleteTextView;//定义autoCompleteTextView对象
    private ArrayAdapter<String> arrayAdapter;//定义适配器
    private MultiAutoCompleteTextView multiAutoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);//对象绑定布局控件
        multiAutoCompleteTextView = findViewById(R.id.multiAutoCompleteTextView);
        String data[] = {"auto","autoComplete","autoCompleteTextView"};//定义data数据源
        arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,data);//适配器绑定数据源
        autoCompleteTextView.setAdapter(arrayAdapter);//控件绑定适配器
        multiAutoCompleteTextView.setAdapter(arrayAdapter);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());//多次匹配时以逗号分隔符隔开

    }
}
