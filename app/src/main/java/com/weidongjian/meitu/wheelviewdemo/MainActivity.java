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

    private Toast toast;

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
        loopView.setNotLoop();
        //设置选中文字颜色
        loopView.setCenterTextColor(Color.RED);

        loopView.setDividerColor(Color.GREEN);

        loopView.setTextSize(24);

        loopView.setOuterTextColor(Color.BLUE);

        //滚动监听
        loopView.setListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                if (toast == null) {
                    toast = Toast.makeText(MainActivity.this, "item " + index, Toast.LENGTH_SHORT);
                }
                toast.setText("item " + index);
                toast.show();
            }
        });
        //设置原始数据
        loopView.setItems(list);

        //设置初始位置
        loopView.setInitPosition(0);

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
