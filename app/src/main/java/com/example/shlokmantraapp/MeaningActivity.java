package com.example.shlokmantraapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
                textView.setText(R.string.m1);
                break;
            case "s1":
                textView.setText(R.string.m2);break;
            case "s2":
                textView.setText(R.string.m3);break;
            case "s3":
                textView.setText(R.string.m4);break;
            case "s4":
                textView.setText(R.string.m5);break;
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.hindi,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.hi){
            ShowLang();
        }
        return super.onOptionsItemSelected(item);
    }
    private void ShowLang() {
        final String [] list={"Hindi","English"};
        AlertDialog.Builder mbuild=new AlertDialog.Builder(MeaningActivity.this);
        mbuild.setTitle("Choose Language ...");
        mbuild.setSingleChoiceItems(list, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if(i==0)
                {  setLocale("hi");recreate();}
                else if(i==1)
                { setLocale("en");recreate();} }});
        AlertDialog md=mbuild.create();
        md.show();
    }

    private void setLocale(String hi) {
        Locale locale=new Locale(hi);
        Locale.setDefault(locale);
        Configuration configuration=new Configuration();
        configuration.locale=locale;
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor=getSharedPreferences("settings",MODE_PRIVATE).edit();
        editor.putString("lang",hi);
        editor.apply();
    }
    public void loadLocale(){
        SharedPreferences preferences=getSharedPreferences("settings", Activity.MODE_PRIVATE);
        String lang=preferences.getString("lang","");
        setLocale(lang); }
}