package com.example.shlokmantraapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
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
        mainModels.add(new MainModel(R.drawable.one,"Om Gam Ganapathaye namo namaha\n" +
                "Shree Siddhi Vinayaka namo namaha\n" +
                "Ashta Vinayaka namo namaha\n" +
                "Ganapathi bappa morya"));
        mainModels.add(new MainModel(R.drawable.two,"Gananam tva Ganapatim (Gum) havamahe\n" +
                "kavim kaveenaam upama-shravastamam\n" +
                "Jyeshta raajam Brahmanaam Brahmanaspata\n" +
                "Aa nah shrunvann-uthibhi seeda-saadanam"));
        mainModels.add(new MainModel(R.drawable.three, "Om ekadantaya vidmahe vakratundaya dheemahi\n" +
                "Tanno danti prachodayat\n"));
        mainModels.add(new MainModel(R.drawable.four,"Gauri nandana gajanana\n" +
                "Girija nandana niranjana\n" +
                "Parvati nandana shubhaanana\n" +
                "Paahi prabho maam paahi prasanna\n"));
        mainModels.add(new MainModel(R.drawable.five,"Gaurinandana Gajanana\n" +
                "Girijanandana Niranjana\n" +
                "Paarvati Nandana Shubhaanana\n" +
                "Paahiprabhomaam Pahi Prasanna"));
        mainModels.add(new MainModel(R.drawable.six, "Om Shreem Gam Saubhagya Ganpataye।\n" +
                "Varvarda Sarvajanma Mein Vashamanya Namah"));
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
}