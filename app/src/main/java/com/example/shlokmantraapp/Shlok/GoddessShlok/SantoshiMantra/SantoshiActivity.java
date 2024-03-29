package com.example.shlokmantraapp.Shlok.GoddessShlok.SantoshiMantra;

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
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shlokmantraapp.Drawer.DarkModeActivity;
import com.example.shlokmantraapp.R;
import com.example.shlokmantraapp.Shlok.MainModel;

import java.util.ArrayList;
import java.util.Locale;

public class SantoshiActivity extends AppCompatActivity {
    TextView textView;
    TextToSpeech textToSpeech;
    ArrayList<MainModel> mainModels;
//    GaneshaAdapter adapter;
    SantoshiAdapter adapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_santoshi);
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
        Integer[] num = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.seven};
        String[] shlok = {getString(R.string.sant1),
                getString(R.string.sant2)
                , getString(R.string.sant3), getString(R.string.sant4),
                getString(R.string.sant5), getString(R.string.sant6), getString(R.string.sant7), getString(R.string.sant8)};

        mainModels = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            MainModel mainModel = new MainModel(num[i], shlok[i]);
            this.mainModels.add(mainModel);
        }
        adapter=new SantoshiAdapter(this,mainModels);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MainModel model = (MainModel) listView.getItemAtPosition(i);
                String p=model.getText();
                //  String p= (String) listView.getItemAtPosition(i);  java.lang.ClassCastException:
                int speech =textToSpeech.speak(p,TextToSpeech.QUEUE_FLUSH,null);
                Toast.makeText(SantoshiActivity.this,"Reading for you ...",Toast.LENGTH_SHORT).show();
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
            String s="Santoshi Mantra : "+getString(R.string.sant1)+"\n\n"+getString(R.string.sant2)+"\n\n"+getString(R.string.sant3)+"\n\n"+
                    getString(R.string.sant4)+"\n\n"+getString(R.string.sant5)+"\n\n"+getString(R.string.sant6)+"\n\n"+
                    getString(R.string.sant7)+"\n\n"+getString(R.string.sant8)+"\n\n";
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
        AlertDialog.Builder mbuild=new AlertDialog.Builder(SantoshiActivity.this);
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