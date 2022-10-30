package com.example.shlokmantraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class SignificanceActivity extends AppCompatActivity {
    TextView textView;
    ImageView imageView;
    TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_significance);
        textView=findViewById(R.id.textView4);
        imageView=findViewById(R.id.imageView3);
        String s=getIntent().getStringExtra("flag");
        textView.setText(s);
        switch (s){
            case "s0":
                textView.setText("Also called the ‘Panchakshari Shiva Strota’, this is the most common and mool (basic) \n" +
                        "mantra of Lord Shiva, who is the supreme god here. This mantra is used for protection and security. Being the \n" +
                        "simplest one, this mantra is can be chanted anytime and anywhere, while performing Rudrabhishek or any other \n" +
                        "ritual related to Lord Shiva.");break;
            case "s1":
                textView.setText("As per Hindu mythology, the Shiva Gayatri Mantra is believed \n" +
                        "to be very powerful. This sacred mantra can be chanted daily in the morning time. This \n" +
                        "mantra pleases Lord Shiva and is believed to have the power to fulfil all your wishes \n" +
                        "and give you peace of mind.");break;
            case "s2":
                textView.setText("This is a very powerful mantra and sacred mantra. \n" +
                        "Being a very sacred mantra, it cannot be chanted anytime. ‘Mrityunjaya’ means \n" +
                        "“victory over the death”. This has a very specific significance. This mantra \n" +
                        "is used for a person, who wants to remove the fear of untimely death and \n" +
                        "overcome other forms of physical suffering. In such cases, it is very powerful \n" +
                        "and useful.");break;
            case "s3":
                textView.setText("Rudra is one of the ancient forms of Lord Shiva. The word “Rudra’ comes \n" +
                        "from the Sanskrit language and means ‘the wild one’. Lord Shiva in his \n" +
                        "Rudra form was the god of the storm and had a fiery face.\n" +
                        "The Rudra Gayatri mantra is very useful and powerful to fulfill your desires. \n" +
                        "Mantra is the best way to please Lord Shiva and get his blessings. By \n" +
                        "chanting this mantra, you get Rudra’s blessing.");break;
            case "s4":
                textView.setText("This shloka is a bedtime prayer to God that seeks forgiveness from \n" +
                        "Lord Shiva for any sin that you may have done along the course of work and life, knowingly or \n" +
                        "unknowingly. By your grace, we have completed one more day of our life. So, in order to thank \n" +
                        "Lord Shiva, who is the lord of mercy and compassion, and ask for his mercy.");break;
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