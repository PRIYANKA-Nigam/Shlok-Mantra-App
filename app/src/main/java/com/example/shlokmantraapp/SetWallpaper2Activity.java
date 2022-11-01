package com.example.shlokmantraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class SetWallpaper2Activity extends AppCompatActivity {
ImageView imageView;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setwallpaper2);
        imageView=findViewById(R.id.imageView7);
        button=findViewById(R.id.button4);
        getSupportActionBar().hide();
        getSupportActionBar().setTitle("full screen image");
        Intent intent=getIntent();
        int position=intent.getExtras().getInt("id");
        Image image=new Image(this);
        imageView.setImageResource(image.img[position]);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.wallpaper);
                WallpaperManager wallpaperManager=WallpaperManager.getInstance(getApplicationContext());
                try {
                    wallpaperManager.setBitmap(bitmap);
                    Toast.makeText(SetWallpaper2Activity.this,"Wallpaper Set",Toast.LENGTH_SHORT).show();
                }catch (IOException e){
                    Toast.makeText(SetWallpaper2Activity.this,"Wallpaper Set",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}