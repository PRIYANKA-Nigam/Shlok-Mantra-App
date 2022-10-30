package com.example.shlokmantraapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class ShivaActivity extends AppCompatActivity {
RecyclerView recyclerView;
    ArrayList<MainModel> mainModels;
    MainAdapter mainAdapter;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shiva);
        recyclerView=(RecyclerView)findViewById(R.id.rec);
        textView=findViewById(R.id.textView2);
        textView.setSelected(true);
        Integer[] num={R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five};
        String[] shlok={getString(R.string.sh1),getString(R.string.sh2),getString(R.string.sh3),
                getString(R.string.sh4),getString(R.string.sh5) };

        mainModels=new ArrayList<>();
        for(int i=0;i<num.length;i++){
            MainModel mainModel=new MainModel(num[i],shlok[i]);
            this.mainModels.add(mainModel);
        }
     //   RecyclerView.LayoutManager layoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL); to get items in rowwise in 2 colums
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(ShivaActivity.this);
        recyclerView.setLayoutManager(layoutManager);
      //  recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL)); //to set divider among items
        mainAdapter=new MainAdapter(ShivaActivity.this,mainModels);
        recyclerView.setAdapter(mainAdapter);
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
        AlertDialog.Builder mbuild=new AlertDialog.Builder(ShivaActivity.this);
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