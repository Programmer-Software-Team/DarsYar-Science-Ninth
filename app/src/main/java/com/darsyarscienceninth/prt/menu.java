package com.darsyarscienceninth.prt;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;

import com.asha.nightowllib.NightOwl;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class menu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    String [] titles = {"درس اول","درس دوم","درس سوم","درس چهارم","درس پنجم","درس ششم","درس هفتم","درس هشتم","درس نهم","درس دهم","درس یازدهم","درس دوازدهم","درس سیزدهم","درس چهاردهم","درس پانزدهم"};
    String [] titles2 = {"خلاصه درس اول","خلاصه درس دوم","خلاصه درس سوم","خلاصه درس چهارم","خلاصه درس پنجم","خلاصه درس ششم","خلاصه درس هفتم","خلاصه درس هشتم","خلاصه درس نهم","خلاصه درس دهم","خلاصه درس یازدهم","خلاصه درس دوازدهم","خلاصه درس سیزدهم","خلاصه درس چهاردهم","خلاصه درس پانردهم"};
    String [] titles3 = {"","","","","","","","","",""};
    database dbm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        dbm = new database(this);
        ListView lv1 = (ListView)findViewById(R.id.listview1);
        ListView lv2 = (ListView)findViewById(R.id.listview2);
        ListView lv3 = (ListView)findViewById(R.id.listview3);
        ImageView img1 = (ImageView)findViewById(R.id.imageView2);
        ImageView img2 = (ImageView)findViewById(R.id.imageView4);
        TextView tv1 = (TextView)findViewById(R.id.textView3);
        lv1.setVisibility(View.VISIBLE);
        lv1.setEnabled(true);
        lv2.setVisibility(View.INVISIBLE);
        lv2.setEnabled(false);
        lv3.setVisibility(View.INVISIBLE);
        lv3.setEnabled(false);
        img1.setVisibility(View.INVISIBLE);
        img1.setEnabled(false);
        img2.setVisibility(View.INVISIBLE);
        img2.setEnabled(false);
        tv1.setVisibility(View.INVISIBLE);
        tv1.setEnabled(false);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        MyAdapter adapter = new MyAdapter(getApplication(),titles);
        lv1.setAdapter(adapter);
        MyAdapter adapter2 = new MyAdapter(getApplication(),titles2);
        lv2.setAdapter(adapter2);
    }

    class MyAdapter extends ArrayAdapter {
        String [] titleArray;
        public MyAdapter(Context context, String [] titles1) {
            super(context, R.layout.listview,R.id.idtitle,titles1);
            this.titleArray = titles1;
        }

        @Override
        @NonNull
        public View getView(int Position, View ConvertView, ViewGroup parent){
            LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            @SuppressLint("ViewHolder") View row = inflater.inflate(R.layout.listview,parent,false);
            TextView Mytitle = (TextView)row.findViewById(R.id.idtitle);
            Typeface typ = Typeface.createFromAsset(getAssets(),"yekan.ttf");
            Mytitle.setTypeface(typ);
            Mytitle.setText(titleArray[Position]);
            return row;
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        ListView lv1 = (ListView)findViewById(R.id.listview1);
        ListView lv2 = (ListView)findViewById(R.id.listview2);
        ListView lv3 = (ListView)findViewById(R.id.listview3);
        ImageView img1 = (ImageView)findViewById(R.id.imageView2);
        ImageView img2 = (ImageView)findViewById(R.id.imageView4);
        TextView tv1 = (TextView)findViewById(R.id.textView3);
        int id = item.getItemId();
        Typeface typ = Typeface.createFromAsset(getAssets(),"yekan.ttf");
        tv1.setTypeface(typ);
        if (id == R.id.nav_home) {
            lv1.setVisibility(View.VISIBLE);
            lv1.setEnabled(true);
            lv2.setVisibility(View.INVISIBLE);
            lv2.setEnabled(false);
            lv3.setVisibility(View.INVISIBLE);
            lv3.setEnabled(false);
            img1.setVisibility(View.INVISIBLE);
            img1.setEnabled(false);
            img2.setVisibility(View.INVISIBLE);
            img2.setEnabled(false);
            tv1.setVisibility(View.INVISIBLE);
            tv1.setEnabled(false);

        } else if (id == R.id.nav_person) {
            lv1.setVisibility(View.INVISIBLE);
            lv1.setEnabled(false);
            lv2.setVisibility(View.INVISIBLE);
            lv2.setEnabled(false);
            lv3.setVisibility(View.INVISIBLE);
            lv3.setEnabled(false);
            img1.setVisibility(View.VISIBLE);
            img1.setEnabled(true);
            img2.setVisibility(View.INVISIBLE);
            img2.setEnabled(false);
            tv1.setVisibility(View.VISIBLE);
            tv1.setEnabled(true);
            Log.i("Mahdi", "View Button Clicked!");
            String vID = "1";
            Person vPer = dbm.getPerson(vID);
            tv1.setText("سلام " + vPer.pName);
            Log.i("Mahdi", "Data Viewed!");

        } else if (id == R.id.nav_books) {
            lv1.setVisibility(View.INVISIBLE);
            lv1.setEnabled(false);
            lv2.setVisibility(View.VISIBLE);
            lv2.setEnabled(true);
            lv3.setVisibility(View.INVISIBLE);
            lv3.setEnabled(false);
            img1.setVisibility(View.INVISIBLE);
            img1.setEnabled(false);
            img2.setVisibility(View.INVISIBLE);
            img2.setEnabled(false);
            tv1.setVisibility(View.INVISIBLE);
            tv1.setEnabled(false);

        } else if (id == R.id.nav_about) {
            lv1.setVisibility(View.INVISIBLE);
            lv1.setEnabled(false);
            lv2.setVisibility(View.INVISIBLE);
            lv2.setEnabled(false);
            lv3.setVisibility(View.INVISIBLE);
            lv3.setEnabled(false);
            img1.setVisibility(View.INVISIBLE);
            img1.setEnabled(false);
            img2.setVisibility(View.VISIBLE);
            img2.setEnabled(true);
            tv1.setVisibility(View.VISIBLE);
            tv1.setEnabled(true);
            tv1.setText("کاری از آرمین احمدی از تیم نرم افزاری پروگرامر");

        }else if (id == R.id.nav_khordad) {
            lv1.setVisibility(View.INVISIBLE);
            lv1.setEnabled(false);
            lv2.setVisibility(View.INVISIBLE);
            lv2.setEnabled(false);
            lv3.setVisibility(View.VISIBLE);
            lv3.setEnabled(true);
            img1.setVisibility(View.INVISIBLE);
            img1.setEnabled(false);
            img2.setVisibility(View.INVISIBLE);
            img2.setEnabled(false);
            tv1.setVisibility(View.INVISIBLE);
            tv1.setEnabled(false);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
