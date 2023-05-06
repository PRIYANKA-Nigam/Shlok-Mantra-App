package com.example.shlokmantraapp.Drawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.shlokmantraapp.Drawer.DeityTemples.DeityPlaceActivity;
import com.example.shlokmantraapp.Drawer.RateUsActivity;
import com.example.shlokmantraapp.Drawer.SetWallpaper.SetWallpaperActivity;
import com.example.shlokmantraapp.MenuActivity;
import com.example.shlokmantraapp.R;

public class DarkModeActivity extends AppCompatActivity {
Switch aSwitch;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.Theme_Dark);
        }else {
            setTheme(R.style.Theme_Light);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dark_mode);
        drawerLayout=findViewById(R.id.ddraw);
        aSwitch=findViewById(R.id.switch2);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }

            }
        });
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
    public void ClickSetWallpaper(View view){ MenuActivity.redirectActivity(this, SetWallpaperActivity.class); }
    public void ClickGod(View view){ MenuActivity.redirectActivity(this, DeityPlaceActivity.class); }
    public void ClickSetDarkMode(View view){ recreate(); }
    public void ClickRateUs(View view){
        MenuActivity.redirectActivity(this, RateUsActivity.class);
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