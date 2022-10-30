package com.example.shlokmantraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class HanumanActivity extends AppCompatActivity {
ListView listView; TextView textView;
    TextToSpeech textToSpeech;
ArrayList<String> arrayList;
ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hanuman);
        textView=findViewById(R.id.textView2);
        textView.setSelected(true);
        textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status==TextToSpeech.SUCCESS){ int lang=textToSpeech.setLanguage(Locale.ENGLISH); }
            }
        });
        listView=findViewById(R.id.ll);
        arrayList=new ArrayList<>();
        arrayList.add(getString(R.string.h1));
        arrayList.add("Om Namo Bhagvate Aanjaneyaay Mahaabalaay Swaahaa");
        arrayList.add("Aum Aeem Bhreem Hanumate Shree Ram Dootaaya Namaha");
        arrayList.add("!! Om Shree Vajradehaya Ramabhaktaya Vayuputhraya Namosthuthe !!");
        arrayList.add("“ !! Om Anjaneyaya Vidmahe Vayuputraya Dhimahi, Tanno Hanumat Prachodayat !!”");
        adapter=new ArrayAdapter<>(this,R.layout.names,arrayList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 String p= (String) listView.getItemAtPosition(i);
                int speech =textToSpeech.speak(p,TextToSpeech.QUEUE_FLUSH,null);
                Toast.makeText(HanumanActivity.this,"Reading for you ...",Toast.LENGTH_SHORT).show();
            }
        });
    }
}