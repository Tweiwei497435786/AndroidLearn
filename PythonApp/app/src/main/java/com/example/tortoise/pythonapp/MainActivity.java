package com.example.tortoise.pythonapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    public final static String EXTRA_MESSAGE = "com.tortoise.pythonapp.displayItemActivity";
    private String[] data = {"猪","狗","鸡","猫","兔"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//设置contentview，activity
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, data);//适配器
        ListView listView = (ListView)findViewById(R.id.homelistView);

        //设置监听
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    // implements 实现 AdapterView.OnItemClickListner接口的点击item方法
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String showText = "点击了" + position + "，ID为：" + id +",内容：" + data[position];
        Toast.makeText(this,showText, Toast.LENGTH_LONG).show();
        Log.d("showText",showText);
        displayItemActivity();
    }

    // 跳转到一个新的Activity组件
    private void displayItemActivity() {
        Intent intent = new Intent(this, DispalyItemActivity.class);//不同activity中提供运行时绑定
        intent.putExtra(EXTRA_MESSAGE, "111");//绑定内容
        startActivity(intent);//跳转到新的activity
    }

}
