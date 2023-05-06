package com.example.shlokmantraapp.Arti;

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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shlokmantraapp.Drawer.DarkModeActivity;
import com.example.shlokmantraapp.R;

import java.util.Locale;

public class FinalActivity extends AppCompatActivity {
TextView t1,t2;  TextToSpeech textToSpeech;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        t1=findViewById(R.id.textView16);
        t2=findViewById(R.id.textView17);
        imageView=findViewById(R.id.imageView8);
        textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status==TextToSpeech.SUCCESS){ int lang=textToSpeech.setLanguage(Locale.ENGLISH); }
            }
        });

       try {
           String s = getIntent().getStringExtra("name");
           t1.setText(s);
           switch (s) {
               case "Maa Lakshmi Arti":
                   t2.setText(getString(R.string.a));
                   break;
               case "Maa Durga Arti":
                   t2.setText(getString(R.string.b));
                   break;
               case "Lord Ganesha Arti":
                   t2.setText(getString(R.string.c));
                   break;
               case "Lord Shiva Arti":
                   t2.setText(getString(R.string.d));
                   break;
               case "Maa Kali Arti":
                   t2.setText(getString(R.string.e));
                   break;
               case "Maa Saraswati Arti":
                   t2.setText(getString(R.string.f));
                   break;
               case "Lord Hanumaan Arti":
                   t2.setText(getString(R.string.g));
                   break;
               case "Lord Rama Arti":
                   t2.setText(getString(R.string.h));
                   break;
               case "Maa Santoshi Arti":
                   t2.setText(getString(R.string.i));
                   break;
               case "Maa Gayatri Arti":
                   t2.setText(getString(R.string.j));
                   break;
               case "Lord Krishna Arti":
                   t2.setText(getString(R.string.k));
                   break;
               case "Lord Vishnu Arti":
                   t2.setText(getString(R.string.l));
                   break;
               case "Lord Brahma Arti":
                   t2.setText(getString(R.string.m));
                   break;
               case "Shani Dev Arti":
                   t2.setText(getString(R.string.n));
                   break;
           }
       } catch (NullPointerException e){
           e.printStackTrace();
       }
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p= t2.getText().toString();
                int speech =textToSpeech.speak(p,TextToSpeech.QUEUE_FLUSH,null);
                Toast.makeText(FinalActivity.this,"Reading for you ...",Toast.LENGTH_SHORT).show();
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
        }  else if (item.getItemId()==R.id.dark){
            startActivity(new Intent(getApplicationContext(), DarkModeActivity.class));
        }
        else if (item.getItemId()==R.id.share){
            String s="Arti : "+t1.getText().toString()+"\n\n"+t2.getText().toString();
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, " -- " + s);
            sendIntent.setType("text/plain");
            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);
            Toast.makeText(getApplicationContext(), "Sharing Arti ...", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    private void ShowLang() {
        final String [] list={"Hindi","English"};
        AlertDialog.Builder mbuild=new AlertDialog.Builder(FinalActivity.this);
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