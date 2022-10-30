package com.example.shlokmantraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
TextView textView;
ImageView imageView; Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView=findViewById(R.id.textView);
        button=findViewById(R.id.button);
        imageView=findViewById(R.id.imageView);
        String s= getIntent().getStringExtra("name");
        textView.setText(s);
        if(s.equalsIgnoreCase("Lord Shiva")){
            imageView.setImageResource(R.drawable.shiva);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= new Intent(MainActivity2.this,ShivaActivity.class);
                    startActivity(intent);
                }
            });
        }
        if (s.equalsIgnoreCase("Lord Ganesh")){
            imageView.setImageResource(R.drawable.ganesha);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= new Intent(MainActivity2.this,GaneshaActivity.class);
                    startActivity(intent);
                }
            });
        }
        if (s.equalsIgnoreCase("Lord Hanumaan")){
            imageView.setImageResource(R.drawable.hanuman);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainActivity2.this,HanumanActivity.class));
                }
            });
        }
        if (s.equalsIgnoreCase("Lord Ram")){
            imageView.setImageResource(R.drawable.rama);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainActivity2.this,RamaActivity.class));
                }
            });
        } if (s.equalsIgnoreCase("Lord Krishna")){
            imageView.setImageResource(R.drawable.krishna);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainActivity2.this,KrishnaActivity.class));
                }
            });
        } if (s.equalsIgnoreCase("Lord Brahma")){
            imageView.setImageResource(R.drawable.brahma);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainActivity2.this,BramhaActivity.class));
                }
            });
        }

                 if (s.equalsIgnoreCase("Lord Vishnu")){
                    imageView.setImageResource(R.drawable.vishnu);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(new Intent(MainActivity2.this,VishnuActivity.class));
                        }
                    });
                }
                 if (s.equalsIgnoreCase("Goddess Lakshmi")){
                    imageView.setImageResource(R.drawable.lakshmi);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(new Intent(MainActivity2.this,LakshmiActivity.class));
                        }
                    });
                }
                 if (s.equalsIgnoreCase("Goddess Saraswati")){
                    imageView.setImageResource(R.drawable.saraswati);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(new Intent(MainActivity2.this,SaraswatiActivity.class));
                        }
                    });
                } if (s.equalsIgnoreCase("Goddess Kali")){
                    imageView.setImageResource(R.drawable.kali);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(new Intent(MainActivity2.this,KaliActivity.class));
                        }
                    });
                } if (s.equalsIgnoreCase("Goddess Durga")){
                    imageView.setImageResource(R.drawable.durga);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(new Intent(MainActivity2.this,DurgaActivity.class));
                        }
                    });
                } if (s.equalsIgnoreCase("Goddess Gayatri")){
                    imageView.setImageResource(R.drawable.gayatri);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(new Intent(MainActivity2.this,GayatriActivity.class));
                        }
                    });
                }





    }
}