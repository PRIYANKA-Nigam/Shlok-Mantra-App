package com.example.shlokmantraapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class SaraswatiActivity extends AppCompatActivity {
TextView t1,t2,t3,t4,t5,t6; TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saraswati);
        t1=findViewById(R.id.textView2);
        t2=findViewById(R.id.textView5);
        t3=findViewById(R.id.textView6);
        t4=findViewById(R.id.textView7);
        t5=findViewById(R.id.textView8);
        t6=findViewById(R.id.textView9);
        t1.setSelected(true);
        textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status==TextToSpeech.SUCCESS){ int lang=textToSpeech.setLanguage(Locale.ENGLISH); }
            }
        });
        t2.setText(R.string.sat1);
        t3.setText(R.string.sat2);
        t4.setText(R.string.sat3);
        t5.setText(R.string.sat4);
        t6.setText(R.string.sat5);
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(R.string.sl1);
            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(R.string.sl2);
            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(R.string.sl3);
            }
        });
        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(R.string.sl4);
            }
        });
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(R.string.sl5);
            }
        });
    }

    private void openDialog(int sl1) {
        AlertDialog.Builder a=new AlertDialog.Builder(SaraswatiActivity.this);
        a.setMessage(sl1).setCancelable(true).setPositiveButton("Hindi",
                new DialogInterface.OnClickListener() {
                    @Override public void onClick(DialogInterface dialogInterface, int i) {
                        setLocale("hi");recreate();
                    }
                }).setNeutralButton("Audio", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String p=getString(sl1);
                int speech =textToSpeech.speak(p,TextToSpeech.QUEUE_FLUSH,null);
                Toast.makeText(getApplicationContext(),"Reading for you ...",Toast.LENGTH_SHORT).show();
            }
        }) .setNegativeButton("English", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) { setLocale("en");recreate();  }});
        AlertDialog alert= a.create();alert.setTitle("Saraswati Mantra");alert.show();
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
        AlertDialog.Builder mbuild=new AlertDialog.Builder(SaraswatiActivity.this); //by getApplicationContext() , it will not work
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
//    private void startAnimation() {
//        Animation animation1 = AnimationUtils.loadAnimation(this,R.anim.anim3);
//        t3.startAnimation(animation1);
//        t6.startAnimation(animation1);
//        Animation animation2 = AnimationUtils.loadAnimation(this,R.anim.anim4);
//        t2.startAnimation(animation2);
//        t4.startAnimation(animation2);
//        t5.startAnimation(animation2);
//
//
//    }
}