package com.example.shlokmantraapp.Chalisa;

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

public class FinalChalisaActivity extends AppCompatActivity {
    TextView t1,t2;  TextToSpeech textToSpeech;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_chalisa);
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
            int pos = getIntent().getIntExtra("id", 0);
            if (pos == 0) {
                t1.setText("Shiva Chalisa");
                t2.setText(getString(R.string.o));
            } else if (pos == 1) {
                t1.setText("Ganesha Chalisa");
                t2.setText(getString(R.string.p));
            } else if (pos == 2) {
                t1.setText("Hanumaan Chalisa");
                t2.setText(getString(R.string.q));
            }
         else if (pos == 3) {
            t1.setText("Rama Chalisa");
            t2.setText(getString(R.string.r));
        }else if (pos == 4) {
                t1.setText("Brahma Chalisa");
                t2.setText(getString(R.string.s));
            }else if (pos == 5) {
                t1.setText("Vishnu Chalisa");
                t2.setText(getString(R.string.t));
            }else if (pos == 6) {
                t1.setText("Shani Chalisa");
                t2.setText(getString(R.string.u));
            }else if (pos == 7) {
                t1.setText("Lakshmi Chalisa");
                t2.setText(getString(R.string.v));
            }
            else if (pos == 8) {
                t1.setText("Durga Chalisa");
                t2.setText(getString(R.string.w));
            }
            else if (pos == 9) {
                t1.setText("Saraswati Chalisa");
                t2.setText(getString(R.string.x));
            }
            else if (pos == 10) {
                t1.setText("Kali Chalisa");
                t2.setText(getString(R.string.y));
            }else if (pos == 11) {
                t1.setText("Gayatri Chalisa");
                t2.setText(getString(R.string.z));
            }else if (pos == 12) {
                t1.setText("Santoshi Chalisa");
                t2.setText(getString(R.string.z1));
            }
            else if (pos == 13) {
                t1.setText("Kuber Chalisa");
                t2.setText(getString(R.string.z2));
            }
            else if (pos == 14) {
                t1.setText("Karwa ");
                t2.setText(R.string.karwa);
            }
            else if (pos == 15) {
                t1.setText("Chhath");
                t2.setText(R.string.chhath);
            }
            else if (pos == 16) {
                t1.setText("Marriage");
                t2.setText(R.string.wed);
            }
            else if (pos == 17) {
                t1.setText("Studies/Education");
                t2.setText(R.string.vidya);
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p= t2.getText().toString();
                int speech =textToSpeech.speak(p,TextToSpeech.QUEUE_FLUSH,null);
                Toast.makeText(FinalChalisaActivity.this,"Reading for you ...",Toast.LENGTH_SHORT).show();
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
            String s="Chalisa : "+t1.getText().toString()+"\n\n"+t2.getText().toString();
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, " -- " + s);
            sendIntent.setType("text/plain");
            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);
            Toast.makeText(getApplicationContext(), "Sharing Mantra ...", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    private void ShowLang() {
        final String [] list={"Hindi","English"};
        AlertDialog.Builder mbuild=new AlertDialog.Builder(FinalChalisaActivity.this);
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