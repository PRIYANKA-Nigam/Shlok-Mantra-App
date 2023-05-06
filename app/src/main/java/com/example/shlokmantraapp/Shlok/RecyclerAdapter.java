package com.example.shlokmantraapp.Shlok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shlokmantraapp.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{
    ArrayList<String> parentArrayList;
    Context context;

    public RecyclerAdapter(ArrayList<String> parentArrayList, Context context) {
        this.parentArrayList = parentArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.parent_recycler,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(parentArrayList.get(position));
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        holder.child.setLayoutManager(layoutManager);
        holder.child.setHasFixedSize(true);
        ArrayList<String> dayarrayList = new ArrayList<>();
        if (parentArrayList.get(position).equals("God Mantra")){
            String[] days={"Lord Shiva","Lord Ganesh","Lord Hanumaan","Lord Ram","Lord Krishna","Lord Brahma","Lord Vishnu","Shani Dev"};
            for (int i=0;i<days.length;i++){
                dayarrayList.add(days[i]);
            }
        }if (parentArrayList.get(position).equals("Other Useful Mantra")){
            String[] days={"Other Mantra"};
            for (int i=0;i<days.length;i++){
                dayarrayList.add(days[i]);
            }
        }
        if(parentArrayList.get(position).equals("Goddess Mantra")){
            String[] days={"Goddess Lakshmi","Goddess Saraswati","Goddess Kali","Goddess Durga","Goddess Gayatri","Goddess Santoshi"};
            for (int i=0;i<days.length;i++){
                dayarrayList.add(days[i]);
            }
        }
        if (parentArrayList.get(position).equals("Lakshmi & Kuber Mantra")){
            String[] days={"Kubera Dhana Prapti Mantra","Laxmi Kuber Mantra"};
            for (int i=0;i<days.length;i++){
                dayarrayList.add(days[i]);
            }
        }
        if (parentArrayList.get(position).equals("Mantra for Study/Exams")){
            String[] days={"The Bija Mantra of Goddess Sarawati","Vidya Mantra"};
            for (int i=0;i<days.length;i++){
                dayarrayList.add(days[i]);
            }
        }
        if (parentArrayList.get(position).equals("Mantra for Marriage")){
            String[] days={"Katyayani Mantra","Parvati Mantra for delayed Marriages","Surya Mantra for delayed Marriages",
            "Vivah Hetu Mantra1","Vivah Hetu Mantra2","Shiva Parvati Mantra for happy married life"};
            for (int i=0;i<days.length;i++){
                dayarrayList.add(days[i]);
            }
        }
        if (parentArrayList.get(position).equals("Chhath puja Mantra")){
            String[] days={"Chhath Puja Mantra","Surya Dev Mantra","Suryadev Aradhana Mantra"};
            for (int i=0;i<days.length;i++){
                dayarrayList.add(days[i]);
            }
        }
        if (parentArrayList.get(position).equals("Karwa Chauth Mantra")){
            String[] days={"Maa Parvati Mantra","Lord Shiva Mantra","Lord Kartikeya Mantra","Lord Ganesha Mantra","Shri Chandrama Mantra"};
            for (int i=0;i<days.length;i++){
                dayarrayList.add(days[i]);
            }
        }
//        else {
//            String[] days = {"Sat", "Sun", "Mon", "Tues", "Wednes", "Thurs", "Fri"};
//            for (int i = 0; i < days.length; i++) {
//                dayarrayList.add(days[i]);
//            }
//        }
        ChildRecyclerAdapter childRecyclerAdapter=new ChildRecyclerAdapter(dayarrayList,context);
        holder.child.setAdapter(childRecyclerAdapter);
        childRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return parentArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;RecyclerView child;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tt);
            child=itemView.findViewById(R.id.child);

        }
    }
}
