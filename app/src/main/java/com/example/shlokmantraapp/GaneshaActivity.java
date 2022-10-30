package com.example.shlokmantraapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class GaneshaActivity extends AppCompatActivity {
    TextView textView;
    TextToSpeech textToSpeech;
    ArrayList<MainModel> mainModels;
  GaneshaAdapter adapter;
     ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganesha);
        textView=findViewById(R.id.textView2);
        textView.setSelected(true);
        listView=findViewById(R.id.ll);
        textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status==TextToSpeech.SUCCESS){ int lang=textToSpeech.setLanguage(Locale.ENGLISH); }
            }
        });

        mainModels=new ArrayList<>();
        mainModels.add(new MainModel(R.drawable.one,getString(R.string.g1)));
        mainModels.add(new MainModel(R.drawable.two,getString(R.string.g2)));
        mainModels.add(new MainModel(R.drawable.three, getString(R.string.g3)));
        mainModels.add(new MainModel(R.drawable.four,getString(R.string.g4)));
        mainModels.add(new MainModel(R.drawable.five,getString(R.string.g5)));
        mainModels.add(new MainModel(R.drawable.six, getString(R.string.g6)));
//        for(int i=0;i<num.length;i++) {
//            MainModel mainModel = new MainModel(num[i], shlok[i]);
//            this.mainModels.add(mainModel);
//        }
adapter=new GaneshaAdapter(this,mainModels);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            MainModel model = (MainModel) listView.getItemAtPosition(i);
            String p=model.getText();
              //  String p= (String) listView.getItemAtPosition(i);  java.lang.ClassCastException:
                int speech =textToSpeech.speak(p,TextToSpeech.QUEUE_FLUSH,null);
                Toast.makeText(GaneshaActivity.this,"Reading for you ...",Toast.LENGTH_SHORT).show();
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
        AlertDialog.Builder mbuild=new AlertDialog.Builder(GaneshaActivity.this);
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