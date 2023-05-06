package com.example.shlokmantraapp.Drawer.SetWallpaper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.shlokmantraapp.Chalisa.Image;
import com.example.shlokmantraapp.Drawer.DarkModeActivity;
import com.example.shlokmantraapp.Drawer.DeityTemples.DeityPlaceActivity;
import com.example.shlokmantraapp.Drawer.RateUsActivity;
import com.example.shlokmantraapp.MenuActivity;
import com.example.shlokmantraapp.R;

public class SetWallpaperActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_wallpaper);
        drawerLayout=findViewById(R.id.sdraw);
        gridView = (GridView) findViewById(R.id.grid);
        gridView.setAdapter(new Image(this));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(), SetWallpaper2Activity.class);
                intent.putExtra("id",position);
                startActivity(intent);
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
    public void ClickSetWallpaper(View view){
        recreate();
    }
    public void ClickGod(View view){ MenuActivity.redirectActivity(this, DeityPlaceActivity.class); }
    public void ClickSetDarkMode(View view){ MenuActivity.redirectActivity(this, DarkModeActivity.class); }
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