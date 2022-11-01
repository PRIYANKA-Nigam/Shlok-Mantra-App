package com.example.shlokmantraapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class RateUsActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_us);
        drawerLayout=findViewById(R.id.rdraw);
    }
    public void ClickMenu(View view){
        MenuActivity.openDrawer(drawerLayout);
    }
    public void ClickLogo(View view){
        MenuActivity.closeDrawer(drawerLayout);
    }
    public void ClickHome(View view){
        MenuActivity.redirectActivity(this,MenuActivity.class);
    }
    public void ClickSetWallpaper(View view){ MenuActivity.redirectActivity(this,SetWallpaperActivity.class); }
    public void ClickRateUs(View view){
        recreate();
    }
    public void ClickLogout(View view){
        MenuActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MenuActivity.closeDrawer(drawerLayout);
    }
}