package com.example.shlokmantraapp.Chalisa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.shlokmantraapp.R;

public class ChalisaActivity extends AppCompatActivity {
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chalisa);
        gridView = (GridView) findViewById(R.id.grid);
        gridView.setAdapter(new Image(this));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(), FinalChalisaActivity.class);
                intent.putExtra("id",position);
                startActivity(intent);
            }
        });
    }
}