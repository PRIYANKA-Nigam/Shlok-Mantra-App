package com.example.shlokmantraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class ShlokActivity extends AppCompatActivity {
TextView textView; Button b1,b2;
ImageView imageView;
    TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shlok);
        textView=findViewById(R.id.textView3);
        imageView=findViewById(R.id.imageView2);
        b1=findViewById(R.id.button2);
        b2=findViewById(R.id.button3);
        textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status==TextToSpeech.SUCCESS){ int lang=textToSpeech.setLanguage(Locale.ENGLISH); }
            }
        });
        String s=getIntent().getStringExtra("flag");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ShlokActivity.this,SignificanceActivity.class);
                intent.putExtra("flag",s);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ShlokActivity.this,MeaningActivity.class);
                intent.putExtra("flag",s);
                startActivity(intent);
            }
        });
        switch (s){
            case "s0":
                textView.setText("Om Namah Shivaay!");
                break;
            case "s1":
                textView.setText("Om Tatpurushaya Vidmahe Mahadevaya Dhimahi,\n" +
                        "\n" +
                        "Tanno Rudrah Prachodayat !");break;
            case "s2":
                textView.setText("Om tryambakam yajamahe sugandhim puṣṭi-vardhanam ǀ\n" +
                        "\n" +
                        "urvarukam-iva bandhanān mṛtyormukṣīya māmṛitāt ǁ ");break;
            case "s3":
                textView.setText("Om Namo Bhagavate Rudraya");break;
            case "s4":
                textView.setText("Karcharankritam Vaa Kaayjam Karmjam Vaa\n" +
                        "\n" +
                        "Shravannayanjam Vaa Maansam Vaa Paradham\n" +
                        "\n" +
                        "Vihitam Vihitam Vaa Sarv Metat Kshamasva\n" +
                        "\n" +
                        "Jay Jay Karunaabdhe Shree Mahadev Shambho");break;

        }
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p= (String) textView.getText();
                int speech =textToSpeech.speak(p,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }
}