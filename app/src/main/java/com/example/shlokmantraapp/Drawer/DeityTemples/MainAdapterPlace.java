package com.example.shlokmantraapp.Drawer.DeityTemples;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.shlokmantraapp.R;

import java.util.HashMap;
import java.util.List;

public class MainAdapterPlace extends BaseExpandableListAdapter {
    Context context;
    List<String> listGroup;
    HashMap<String,List<String>> listitem;
    public MainAdapterPlace(Context context, List<String> listGroup, HashMap<String, List<String>> listitem) {
        this.context = context;
        this.listGroup = listGroup;
        this.listitem = listitem; }
    @Override
    public int getGroupCount() {
        return listGroup.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listitem.get(this.listGroup.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listGroup.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.listitem.get(this.listGroup.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean b, View view, ViewGroup viewGroup) {
        String group=(String)getGroup(groupPosition); if(view==null){
            LayoutInflater layoutInflater=(LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=layoutInflater.inflate(R.layout.list_group,null); }
        TextView textView=view.findViewById(R.id.tt);
        textView.setText(group);
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean b, View view, ViewGroup viewGroup) {
        String child=(String)getChild(groupPosition,childPosition);
        if(view==null){ LayoutInflater layoutInflater=(LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=layoutInflater.inflate(R.layout.list_item,null); }
        TextView textView=view.findViewById(R.id.li);
        textView.setText(child);
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
