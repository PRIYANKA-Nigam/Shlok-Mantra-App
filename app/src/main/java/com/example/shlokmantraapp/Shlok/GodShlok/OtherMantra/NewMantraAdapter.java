package com.example.shlokmantraapp.Shlok.GodShlok.OtherMantra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shlokmantraapp.R;

import java.util.ArrayList;

public class NewMantraAdapter extends RecyclerView.Adapter<NewMantraAdapter.ViewHolder>{
    ArrayList<NewMantraModel> mainModels;
    Context context;

    public NewMantraAdapter(ArrayList<NewMantraModel> mainModels, Context context) {
        this.mainModels = mainModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.new_mantra_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(mainModels.get(position).getImage());
        holder.textView.setText(mainModels.get(position).getText());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewMantraActivity.textView.setText(holder.textView.getText().toString());
                NewMantraActivity.pos=position;
                if (position==0){
                    NewMantraActivity.textView2.setText(R.string.ot1);
                }
                if (position==1){
                    NewMantraActivity.textView2.setText(R.string.ot2);
                }
                if (position==2){
                    NewMantraActivity.textView2.setText(context.getString(R.string.saras));
                }
                if (position==3){
                    NewMantraActivity.textView2.setText(R.string.ot3);
                }
                if (position==4){
                    NewMantraActivity.textView2.setText(R.string.ot4);
                }
                if (position==5){
                    NewMantraActivity.textView2.setText(R.string.ot5);
                }
                if (position==6){
                    NewMantraActivity.textView2.setText(R.string.ot6);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mainModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        LinearLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.i);
            textView=itemView.findViewById(R.id.t);
            layout=itemView.findViewById(R.id.lii);
        }
    }
}
