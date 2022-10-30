package com.example.shlokmantraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class RamaActivity extends AppCompatActivity {
    TextView t1,t2,t3,t4;
    TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rama);
        t4=findViewById(R.id.textView2);
        t4.setSelected(true);
        textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status==TextToSpeech.SUCCESS){ int lang=textToSpeech.setLanguage(Locale.ENGLISH); }
            }
        });
        t1=findViewById(R.id.textView5);
        t2=findViewById(R.id.textView6);
        t3=findViewById(R.id.textView7);
        t1.setText("Om Shri Ramaya Namah॥");
        t2.setText("Om Dasharathaye Vidmahe Sitavallabhaya Dhimahi,\n" +
                "Tanno Rama Prachodayat॥");
        t3.setText("Om Apadamapahartaram Dataram Sarvasampadam।\n" +
                "Lokabhiramam Shriramam Bhuyo-Bhuyo Namamyaham॥");
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p=t1.getText().toString();
                int speech =textToSpeech.speak(p,TextToSpeech.QUEUE_FLUSH,null);
                Toast.makeText(RamaActivity.this,"Reading for you ...",Toast.LENGTH_SHORT).show();

            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p=t2.getText().toString();
                int speech =textToSpeech.speak(p,TextToSpeech.QUEUE_FLUSH,null);
                Toast.makeText(RamaActivity.this,"Reading for you ...",Toast.LENGTH_SHORT).show();

            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p=t3.getText().toString();
                int speech =textToSpeech.speak(p,TextToSpeech.QUEUE_FLUSH,null);
                Toast.makeText(RamaActivity.this,"Reading for you ...",Toast.LENGTH_SHORT).show();

            }
        });
    }
}