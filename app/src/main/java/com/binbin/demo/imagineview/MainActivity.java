package com.binbin.demo.imagineview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Context context;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        textView = (TextView) findViewById(R.id.txt_1_pic);
        textView.setOnClickListener(this);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (textView.getId()){
            case R.id.txt_1_pic:
                Intent intent = new Intent();
                intent.setClass(context,PictureActivity.class);
                startActivity(intent);
                break;
            default: break;
        }
    }
}
