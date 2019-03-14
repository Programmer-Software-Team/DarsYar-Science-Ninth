package com.darsyarscienceninth.prt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import java.io.File;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        TextView tv1 = (TextView)findViewById(R.id.textView5);
        TextView tv2 = (TextView)findViewById(R.id.textView4);
        Typeface typ = Typeface.createFromAsset(getAssets(),"yekan.ttf");
        tv1.setTypeface(typ);
        tv2.setTypeface(typ);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                @SuppressLint("SdCardPath") File file = new File("/data/data/com.darsyarscienceninth.prt/databases/user.db");
                if(file.exists()){
                    finish();
                    Intent i = new Intent(Splash.this,menu.class);
                    startActivity(i);
                }else{
                    finish();
                    Intent i = new Intent(Splash.this,MainActivity.class);
                    startActivity(i);
                }
            }
        }, 2000);
    }
}
