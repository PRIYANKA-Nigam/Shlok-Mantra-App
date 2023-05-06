package com.example.shlokmantraapp.Shlok.GoddessShlok.SantoshiMantra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shlokmantraapp.R;
import com.example.shlokmantraapp.Shlok.MainModel;

import java.util.ArrayList;

public class SantoshiAdapter extends ArrayAdapter<MainModel> {
    Context context; ArrayList<MainModel> mainModels;
    public SantoshiAdapter(Context context, ArrayList<MainModel> mainModels) {
        super(context,0, mainModels); }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MainModel model=getItem(position);
        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_item,parent,false);
        }
        ImageView imageView=convertView.findViewById(R.id.img);imageView.setImageResource(getItem(position).getImage());
        TextView textView=convertView.findViewById(R.id.tt);textView.setText(getItem(position).getText());
        return convertView;
    }
}
