package com.example.shlokmantraapp.Songs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.shlokmantraapp.Drawer.DarkModeActivity;
import com.example.shlokmantraapp.Drawer.DeityTemples.DeityPlaceActivity;
import com.example.shlokmantraapp.MenuActivity;
import com.example.shlokmantraapp.R;
import com.example.shlokmantraapp.Drawer.RateUsActivity;
import com.example.shlokmantraapp.Drawer.SetWallpaper.SetWallpaperActivity;

import java.util.ArrayList;

public class DevotionalSongActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    private RecyclerView recyclerView;
    private ArrayList<Music> my_main_list;
    private MusicAdapter musicAdapter;
    RecyclerView.LayoutManager layoutManager;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devotional_song);
        drawerLayout=findViewById(R.id.draw);
        recyclerView=(RecyclerView)findViewById(R.id.rec);
        textView=(TextView)findViewById(R.id.tt);
        textView.setSelected(true);
        my_main_list=new ArrayList<>();
        musicAdapter=new MusicAdapter(this,my_main_list.size(),my_main_list);
        layoutManager = new LinearLayoutManager(this); recyclerView.setLayoutManager(layoutManager);
        int count = 0;
        my_main_list.add(new Music("Ganesh Gayatri",R.raw.ganapati_gayatri));
        my_main_list.add(new Music("Hanuman Gayatri",R.raw.hanuman_gayatri));
        my_main_list.add(new Music("Lakshmi Gayatri",R.raw.lakshmi_gayatri));
        my_main_list.add(new Music("Saraswati Gayatri",R.raw.saraswathi_gayathri));
        my_main_list.add(new Music("Shiva Song",R.raw.shambho));
        my_main_list.add(new Music("Shiv Bhajan",R.raw.shiva_shiva_shivaya));
        recyclerView.setAdapter(musicAdapter);

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
    public void ClickSetWallpaper(View view){ MenuActivity.redirectActivity(this, SetWallpaperActivity.class);
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