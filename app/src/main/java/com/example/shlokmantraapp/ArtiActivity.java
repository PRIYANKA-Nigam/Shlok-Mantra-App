package com.example.shlokmantraapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ArtiActivity extends AppCompatActivity {
RecyclerView recyclerView;
ArtiAdapter artiAdapter;
ArrayList<ArtiModel> artiModels;
RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arti);
        recyclerView=findViewById(R.id.rec);
        artiModels=new ArrayList<>();
        artiModels.add(new ArtiModel(R.drawable.lakshmi,"Maa Lakshmi Arti"));
        artiModels.add(new ArtiModel(R.drawable.durga,"Maa Durga Arti"));
        artiModels.add(new ArtiModel(R.drawable.ganesha,"Lord Ganesha Arti"));
        artiModels.add(new ArtiModel(R.drawable.shiva,"Lord Shiva Arti"));
        artiModels.add(new ArtiModel(R.drawable.kali,"Maa Kali Arti"));
        artiModels.add(new ArtiModel(R.drawable.saraswati,"Maa Saraswati Arti"));
        artiModels.add(new ArtiModel(R.drawable.hanuman,"Lord Hanumaan Arti"));
        artiModels.add(new ArtiModel(R.drawable.rama,"Lord Rama Arti"));
        artiModels.add(new ArtiModel(R.drawable.santoshi,"Maa Santoshi Arti"));
        artiModels.add(new ArtiModel(R.drawable.gayatri,"Maa Gayatri Arti"));
        artiModels.add(new ArtiModel(R.drawable.krishna,"Lord Krishna Arti"));
        artiModels.add(new ArtiModel(R.drawable.vishnu,"Lord Vishnu Arti"));
        artiModels.add(new ArtiModel(R.drawable.brahma,"Lord Brahma Arti"));
        artiModels.add(new ArtiModel(R.drawable.shani_dev,"Shani Dev Arti"));
        artiAdapter=new ArtiAdapter(artiModels,this);
        layoutManager=new LinearLayoutManager(ArtiActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(artiAdapter);
        recyclerView.setHasFixedSize(true);


    }
}