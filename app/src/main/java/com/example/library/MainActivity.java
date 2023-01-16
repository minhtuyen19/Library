package com.example.library;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.library.fragment.CallSlipFragment;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ListView listView;
    View mHeaderView;
    TextView edUser;
    FrameLayout fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment = findViewById(R.id.flContent);//mainlayout

        toolbar = findViewById(R.id.toolbar); //toolbarlayout
        toolbar.setBackgroundColor(Color.rgb(255,182,181));
        toolbar.setTitleTextColor(Color.rgb(18, 37, 67));

        drawerLayout=findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.navigationview);
        listView=findViewById(R.id.lv);

        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_action_menu);
        ab.setDisplayHomeAsUpEnabled(true);
        FragmentManager manager = getSupportFragmentManager();
        NavigationView nv = findViewById(R.id.navigationview);

        mHeaderView = nv.getHeaderView(0);
        edUser=mHeaderView.findViewById(R.id.tvUSer); //nv_header

        Intent i = getIntent();
        String user = i.getStringExtra("user");

        edUser.setText("Welcome " + user + "!");
        if(user.equalsIgnoreCase("Admin")){
            nv.getMenu().findItem(R.id.sub_addUser).setVisible(true);
        }
        nv.setNavigationItemSelectedListener(item->{
            FragmentManager manager1=getSupportFragmentManager();
            switch(item.getItemId()){
                case R.id.nav_PhieuMuon:
                    setTitle("Call Slip Management");
                    CallSlipFragment callSlipFragment1 = new CallSlipFragment();
                    manager1.beginTransaction().replace(R.id.flContent, callSlipFragment1).commit();
                    break;
            }
        });
    }
}