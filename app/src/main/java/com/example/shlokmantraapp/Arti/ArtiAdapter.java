package com.example.shlokmantraapp.Arti;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shlokmantraapp.R;

import java.util.ArrayList;

public class ArtiAdapter extends RecyclerView.Adapter<ArtiAdapter.ViewHolder>{
    ArrayList<ArtiModel> artiModels;
    Context context;

    public ArtiAdapter(ArrayList<ArtiModel> artiModels, Context context) {
        this.artiModels = artiModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.arti_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         holder.imageView.setImageResource(artiModels.get(position).getImage());
         holder.textView.setText(artiModels.get(position).getText());
         holder.cardView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String s=holder.textView.getText().toString();
                   Intent intent=new Intent(context,FinalActivity.class);
                   intent.putExtra("name",s);
                 context.startActivity(intent);
             }
         });
    }

    @Override
    public int getItemCount() {
        return artiModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
      ImageView imageView; TextView textView;
      CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img);
            textView=itemView.findViewById(R.id.tt);
            cardView=itemView.findViewById(R.id.cd);
        }
    }
}
