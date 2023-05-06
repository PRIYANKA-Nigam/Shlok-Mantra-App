package com.example.shlokmantraapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PictureInPictureParams;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.shlokmantraapp.Arti.ArtiActivity;
import com.example.shlokmantraapp.Chalisa.ChalisaActivity;
import com.example.shlokmantraapp.Drawer.DarkModeActivity;
import com.example.shlokmantraapp.Drawer.DeityTemples.DeityPlaceActivity;
import com.example.shlokmantraapp.Drawer.RateUsActivity;
import com.example.shlokmantraapp.Drawer.SetWallpaper.SetWallpaperActivity;
import com.example.shlokmantraapp.Shlok.MainActivity;
import com.example.shlokmantraapp.Songs.DevotionalSongActivity;

public class MenuActivity extends AppCompatActivity {
LinearLayout layout,layout2,layout3,layout4;
DrawerLayout drawerLayout;

    public static void logout(final SetWallpaperActivity mainActivity3) {
        dialog(mainActivity3);
    }
    public static void logout(final DevotionalSongActivity mainActivity3) {
        dialog(mainActivity3);
    }
    public static void logout(final DeityPlaceActivity mainActivity3) {
        dialog(mainActivity3);
    }
    private static void dialog(Activity activity) {
        AlertDialog.Builder builder=new AlertDialog.Builder(activity);
        builder.setTitle("Logout");
        builder.setMessage("Are You Sure You Want to Logout ?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)  @Override
            public void onClick(DialogInterface dialog, int which) {
               activity.finishAffinity(); System.exit(0); }});
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); }});
        builder.show();
    }

    public static void logout(final DarkModeActivity mainActivity3) {
       dialog(mainActivity3);
    }

    public static void logout(final RateUsActivity mainActivity3) {
       dialog(mainActivity3);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        layout2=findViewById(R.id.lin1);layout3=findViewById(R.id.lin3);layout4=findViewById(R.id.lin4);
        layout=findViewById(R.id.li2);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ArtiActivity.class));
            }
        });
        layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), DevotionalSongActivity.class));
            }
        });
        layout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ChalisaActivity.class));
            }
        });
        drawerLayout=findViewById(R.id.draw);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onUserLeaveHint() {
        PictureInPictureParams pictureInPictureParams= new PictureInPictureParams.Builder().build();
        enterPictureInPictureMode(pictureInPictureParams);
    }

    public void ClickMenu(View view){
        openDrawer(drawerLayout);
    }
    public static void openDrawer(DrawerLayout drawerLayout) { drawerLayout.openDrawer(GravityCompat.START); }
    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }
    public static void closeDrawer(DrawerLayout drawerLayout) { if (drawerLayout.isDrawerOpen(GravityCompat.START)){
        drawerLayout.closeDrawer(GravityCompat.START); } }
    public void ClickHome(View view){
        recreate();
    }
    public void ClickSetWallpaper(View view){
        redirectActivity(this,SetWallpaperActivity.class);
    }
    public void ClickGod(View view){
        redirectActivity(this,DeityPlaceActivity.class);
    }
    public void ClickSetDarkMode(View view){ redirectActivity(this,DarkModeActivity.class); }
    public void ClickRateUs(View view){
        redirectActivity(this,RateUsActivity.class);
    }
    public void ClickLogout(View view){
        logout(this);
    }
    public static void logout(final MenuActivity mainActivity) {
    dialog(mainActivity);
    }
    public static void redirectActivity(Activity activity, Class aclass) { Intent intent=new Intent(activity,aclass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); activity.startActivity(intent); } @Override
    protected void onPause() { super.onPause(); closeDrawer(drawerLayout); }
}