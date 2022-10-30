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
import android.widget.Toast;

import java.util.Locale;

public class OtherMantraActivity extends AppCompatActivity {
TextView t1,t2; TextToSpeech textToSpeech;
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_mantra);
        t1=findViewById(R.id.textView11); t1.setSelected(true);
        t2=findViewById(R.id.textView12);
        imageView=findViewById(R.id.imageView5);
        textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status==TextToSpeech.SUCCESS){ int lang=textToSpeech.setLanguage(Locale.ENGLISH); }
            }
        });
        String s=getIntent().getStringExtra("flag");
        switch (s){
            case "kd":
                t2.setText(R.string.kd);break;
            case "lk":
                t2.setText(R.string.lk);break;
            case "bm":
                t2.setText(R.string.bm);break;
            case "vm":
                t2.setText(R.string.vm);break;
            case "km":
                t2.setText(R.string.km);break;
            case "pm":
                t2.setText(R.string.pm);break;
            case "sm":
                t2.setText(R.string.sm);break;
                case "vhm":
                t2.setText(R.string.vhm);break;
                case "vhhm":
                t2.setText(R.string.vhhm);break;
                case "spm":
                t2.setText(R.string.spm);break;
            case "cpm":
                t2.setText(R.string.cpm);break;
            case "sdm":
                t2.setText(R.string.sdm);break;
            case "sam":
                t2.setText(R.string.sam);break;
            case "mpm":
                t2.setText(R.string.mpm);break;
            case "lsm":
                t2.setText(R.string.lsm);break;
            case "lkm":
                t2.setText(R.string.lkm);break;
            case "lgm":
                t2.setText(R.string.lgm);break;
            case "scm":
                t2.setText(R.string.scm);break;

        }
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p=t2.getText().toString();
                int speech =textToSpeech.speak(p,TextToSpeech.QUEUE_FLUSH,null);
                Toast.makeText(getApplicationContext(),"Reading for you ...",Toast.LENGTH_SHORT).show();
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
        AlertDialog.Builder mbuild=new AlertDialog.Builder(OtherMantraActivity.this);
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