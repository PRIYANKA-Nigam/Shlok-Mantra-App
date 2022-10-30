package com.example.shlokmantraapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
            String[] days={"Lord Shiva","Lord Ganesh","Lord Hanumaan","Lord Ram","Lord Krishna","Lord Brahma","Lord Vishnu"};
            for (int i=0;i<days.length;i++){
                dayarrayList.add(days[i]);
            }
        }
        if(parentArrayList.get(position).equals("Goddess Mantra")){
            String[] days={"Goddess Lakshmi","Goddess Saraswati","Goddess Kali","Goddess Durga","Goddess Gayatri"};
            for (int i=0;i<days.length;i++){
                dayarrayList.add(days[i]);
            }
        }
        if (parentArrayList.get(position).equals("Mantras for Health & wealth")){
            String[] days={"Shlok1","Shlok2","Shlok3","Shlok4"};
            for (int i=0;i<days.length;i++){
                dayarrayList.add(days[i]);
            }
        }
        if(parentArrayList.get(position).equals("Mantras for Health recovery")){
            String[] days={"Shlok1","Shlok2"};
            for (int i=0;i<days.length;i++){
                dayarrayList.add(days[i]);
            }
        }
        if (parentArrayList.get(position).equals("Lakshmi & Kuber Mantra")){
            String[] days={"Shlok1","Shlok2"};
            for (int i=0;i<days.length;i++){
                dayarrayList.add(days[i]);
            }
        }
        if (parentArrayList.get(position).equals("Mantra for Knowledge & wisdom")){
            String[] days={"Shlok1","Shlok2"};
            for (int i=0;i<days.length;i++){
                dayarrayList.add(days[i]);
            }
        }
        if (parentArrayList.get(position).equals("Mantra for Study/Exams")){
            String[] days={"Shlok1","Shlok2"};
            for (int i=0;i<days.length;i++){
                dayarrayList.add(days[i]);
            }
        }
        if (parentArrayList.get(position).equals("Mantra for Marriage")){
            String[] days={"Shlok1","Shlok2"};
            for (int i=0;i<days.length;i++){
                dayarrayList.add(days[i]);
            }
        }
        if (parentArrayList.get(position).equals("Sakat Chauth Mantra")){
            String[] days={"Shlok1","Shlok2"};
            for (int i=0;i<days.length;i++){
                dayarrayList.add(days[i]);
            }
        }
        if (parentArrayList.get(position).equals("Karwa Chauth Mantra")){
            String[] days={"Shlok1","Shlok2"};
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