package com.weidongjian.meitu.wheelviewdemo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.weigan.loopview.LoopView;
import com.weigan.loopview.OnItemSelectedListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LoopView loopView = (LoopView) findViewById(R.id.loopView);

        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            list.add("item " + i);
        }
        //设置是否循环播放
        loopView.setLoop(false);
        //设置选中文字颜色
        loopView.setCenterTextColor(Color.RED);
        //设置未选中文字颜色
        loopView.setOuterTextColor(Color.BLACK);
        //设置分割线颜色
        loopView.setDividerColor(Color.GREEN);
        //设置文字大小
        loopView.setTextSize(24);
        //设置原始数据
        loopView.setItems(list);
        //设置初始位置
        loopView.setInitPosition(0);
//        //设置滚动条目可见数量
//        loopView.setItemsVisibleCount(4);
        //滚动监听
        loopView.setListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                Toast.makeText(MainActivity.this, "item " + index, Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loopView.setCurrentPosition(0);
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScrollViewActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });
    }

}
