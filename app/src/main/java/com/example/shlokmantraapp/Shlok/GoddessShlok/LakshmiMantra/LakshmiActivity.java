package com.example.shlokmantraapp.Shlok.GoddessShlok.LakshmiMantra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shlokmantraapp.Drawer.DarkModeActivity;
import com.example.shlokmantraapp.R;
import com.example.shlokmantraapp.Shlok.GoddessShlok.GoddessShlokActivity;

import java.util.Locale;

public class LakshmiActivity extends AppCompatActivity {
TextView t1,t2,t3,t4,textView;
String flag="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lakshmi);
        textView=findViewById(R.id.textView2); textView.setSelected(true);
        t1=(TextView)findViewById(R.id.textView5);
        t2=(TextView)findViewById(R.id.textView6);
        t3=(TextView)findViewById(R.id.textView7);
        t4=(TextView)findViewById(R.id.textView8);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim1);
        t1.startAnimation(animation);
        t2.startAnimation(animation);
        t3.startAnimation(animation);
        t4.startAnimation(animation);
       t1.setText(R.string.lt1);
       t2.setText(R.string.lt2);
       t3.setText(R.string.lt3);
       t4.setText(R.string.lt4);
       t1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {  flag="l1";
               Intent intent=new Intent(getApplicationContext(), GoddessShlokActivity.class);
               intent.putExtra("flag",flag);
               startActivity(intent);

           }
       });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {  flag="l2";
                Intent intent=new Intent(getApplicationContext(),GoddessShlokActivity.class);
                intent.putExtra("flag",flag);
                startActivity(intent);

            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {  flag="l3";
                Intent intent=new Intent(getApplicationContext(),GoddessShlokActivity.class);
                intent.putExtra("flag",flag);
                startActivity(intent);

            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {  flag="l4";
                Intent intent=new Intent(getApplicationContext(),GoddessShlokActivity.class);
                intent.putExtra("flag",flag);
                startActivity(intent);

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
            String s="Lakshmi Mantra for : "+t1.getText().toString()+"\n\n"+t2.getText().toString()+"\n\n"+t3.getText().toString()+"\n\n"+
                    t4.getText().toString()+"\n\n";
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
        AlertDialog.Builder mbuild=new AlertDialog.Builder(LakshmiActivity.this);
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