package com.example.shlokmantraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class MeaningActivity extends AppCompatActivity {
TextView textView;
ImageView imageView;
TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meaning);
        textView=findViewById(R.id.textView4);
        imageView=findViewById(R.id.imageView3);
        String s=getIntent().getStringExtra("flag");
        switch (s){
            case "s0":
                textView.setText("Hey! Lord Shiva, I bow to you. I bow to the peaceful one who is the embodiment of the entire universe.");
                break;
            case "s1":
                textView.setText("I pray to the mightiest of the Gods, the ideal Purusha, Mahadev." +
                        " I pray to God to bless me with the intellect and illuminate my path with the light of knowledge.");break;
            case "s2":
                textView.setText("O three-eyed Lord, One who can see everything that what others cannot see. Hey, god of gods, \n" +
                        "I invite you to come and bless me with good vasanas. And when my final time comes to depart this world (The time of death), \n" +
                        "I would want to leave my body without any hesitations of leaving worldly attachments.\n");break;
            case "s3":
                textView.setText("I bow to the holy one, to the Rudra i.e. Lord Shiva.");break;
            case "s4":
                textView.setText("Oh lord of mercy, Please forgive all my sins performed consciously or unconsciously. \n" +
                        "I request you to pardon the sinful actions committed by my hands and feet, or produced by my words spoken \n" +
                        "or deeds done. Please pardon the sinful acts committed by my senses like ears and eyes or sinful thoughts \n" +
                        "that entered my mind. Please forgive me for all sins committed while performing my duties as well as the \n" +
                        "action not explicitly prescribed. Please forgive me for all my sins. Victory to you, Mahadev, Shambho, \n" +
                        "you are the ocean of compassion");break;
        }
        textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status==TextToSpeech.SUCCESS){ int lang=textToSpeech.setLanguage(Locale.ENGLISH); }
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p= (String) textView.getText();
                int speech =textToSpeech.speak(p,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }
}