package com.example.shlokmantraapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

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
        String[] shlok={"Mantra for protection and security","Mantra to please Lord Shiva","Mantra to remove the fear of death",
       "Mantra to get Rudra’s blessing","Mantra to seek forgiveness from Lord Shiva for any sin" };

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
}