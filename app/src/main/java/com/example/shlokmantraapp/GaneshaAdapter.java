package com.example.shlokmantraapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class GaneshaAdapter extends ArrayAdapter<MainModel> {
    public GaneshaAdapter(@NonNull Context context, ArrayList<MainModel> modals) {
        super(context,0, modals);
    }

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
