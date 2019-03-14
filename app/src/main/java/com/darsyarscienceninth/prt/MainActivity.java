package com.darsyarscienceninth.prt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    database dbm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t1 = (TextView)findViewById(R.id.textView);
        TextView t2 = (TextView)findViewById(R.id.textView2);
        final EditText edt1 = (EditText)findViewById(R.id.editText);
        Button btn1 = (Button)findViewById(R.id.button);
        Typeface typ1 = Typeface.createFromAsset(getAssets(),"yekan.ttf");
        t1.setTypeface(typ1);
        t2.setTypeface(typ1);
        edt1.setTypeface(typ1);
        btn1.setTypeface(typ1);
        dbm = new database(this);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                @SuppressLint("SdCardPath") File file = new File("/data/data/com.darsyarscienceninth.prt/databases/user.db");
                if(file.exists()){
                    Log.d("s", "exits!!");
                    finish();
                    Intent i = new Intent(MainActivity.this,menu.class);
                    startActivity(i);
                }else{
                    Log.d("a","not exits!!");
                    String mID = "1";
                    String mName = edt1.getText().toString();
                    if (TextUtils.isEmpty(mName)) {
                        Toast.makeText(MainActivity.this, "لطفا نام خود را بنویسید", Toast.LENGTH_LONG).show();
                    }else{
                        Person iperson = new Person();
                        iperson.pID = mID;
                        iperson.pName = mName;
                        dbm.insertPerson(iperson);
                        finish();
                        Intent i = new Intent(MainActivity.this,menu.class);
                        startActivity(i);
                        Log.i("Mahdi", "Data inserted!");
                    }
                }


            }
        });
    }
}
