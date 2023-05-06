package com.example.shlokmantraapp.Drawer.DeityTemples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import com.example.shlokmantraapp.Drawer.DarkModeActivity;
import com.example.shlokmantraapp.Drawer.RateUsActivity;
import com.example.shlokmantraapp.MenuActivity;
import com.example.shlokmantraapp.R;
import com.example.shlokmantraapp.Drawer.SetWallpaper.SetWallpaperActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DeityPlaceActivity extends AppCompatActivity {
    ExpandableListView expandableListView;
    List<String> listGroup;
    DrawerLayout drawerLayout;
    HashMap<String,List<String>> listitem;
    MainAdapterPlace adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deity_place);
        drawerLayout=findViewById(R.id.gdraw);
        expandableListView=(ExpandableListView) findViewById(R.id.ex);
        listGroup=new ArrayList<>();
        listitem=new HashMap<>();
        adapter=new MainAdapterPlace(this,listGroup,listitem);
        expandableListView.setAdapter(adapter); initListData();
    }

    private void initListData() {
        listGroup.add(getString(R.string.aa)); listGroup.add(getString(R.string.bb));
        listGroup.add(getString(R.string.cc)); listGroup.add(getString(R.string.dd));
        listGroup.add(getString(R.string.ee)); listGroup.add(getString(R.string.ff));
        listGroup.add(getString(R.string.gg)); listGroup.add(getString(R.string.hh));
        listGroup.add(getString(R.string.ii)); listGroup.add(getString(R.string.jj));
        listGroup.add(getString(R.string.kk)); listGroup.add(getString(R.string.ll));
        listGroup.add(getString(R.string.mm)); listGroup.add(getString(R.string.nn));
        String[] array;
        List<String> list1 =new ArrayList<>();
        array=getResources().getStringArray(R.array.aa);
        for(String item : array){
            list1.add(item); }
        List<String> list2 =new ArrayList<>();
        array=getResources().getStringArray(R.array.bb);
        for(String item : array){
            list2.add(item);
        }
        List<String> list3 =new ArrayList<>();
        array=getResources().getStringArray(R.array.cc);
        for(String item : array){
            list3.add(item);
        }
        List<String> list4 =new ArrayList<>();
        array=getResources().getStringArray(R.array.dd);
        for(String item : array){
            list4.add(item);
        }
        List<String> list5 =new ArrayList<>();
        array=getResources().getStringArray(R.array.ee);
        for(String item : array){
            list5.add(item);
        }
        List<String> list6 =new ArrayList<>();
        array=getResources().getStringArray(R.array.ff);
        for(String item : array){
            list6.add(item);
        }
        List<String> list7 =new ArrayList<>();
        array=getResources().getStringArray(R.array.gg);
        for(String item : array){
            list7.add(item);
        }
        List<String> list8 =new ArrayList<>();
        array=getResources().getStringArray(R.array.hh);
        for(String item : array){
            list8.add(item);
        }
        List<String> list9 =new ArrayList<>();
        array=getResources().getStringArray(R.array.ii);
        for(String item : array){
            list9.add(item);
        }
        List<String> list10 =new ArrayList<>();
        array=getResources().getStringArray(R.array.jj);
        for(String item : array){
            list10.add(item);
        }
        List<String> list11 =new ArrayList<>();
        array=getResources().getStringArray(R.array.kk);
        for(String item : array){
            list11.add(item);
        }
        List<String> list12 =new ArrayList<>();
        array=getResources().getStringArray(R.array.ll);
        for(String item : array){
            list12.add(item);
        }
        List<String> list13 =new ArrayList<>();
        array=getResources().getStringArray(R.array.mm);
        for(String item : array){
            list13.add(item);
        }
        List<String> list14 =new ArrayList<>();
        array=getResources().getStringArray(R.array.nn);
        for(String item : array){
            list14.add(item);
        }
        listitem.put(listGroup.get(0),list1); listitem.put(listGroup.get(1),list2);
        listitem.put(listGroup.get(2),list3); listitem.put(listGroup.get(3),list4);
        listitem.put(listGroup.get(4),list5); listitem.put(listGroup.get(5),list6);
        listitem.put(listGroup.get(6),list7); listitem.put(listGroup.get(7),list8);
        listitem.put(listGroup.get(8),list9); listitem.put(listGroup.get(9),list10);
        listitem.put(listGroup.get(10),list11); listitem.put(listGroup.get(11),list12);
        listitem.put(listGroup.get(12),list13); listitem.put(listGroup.get(13),list14);
        adapter.notifyDataSetChanged();
    }
    public void ClickMenu(View view){
        MenuActivity.openDrawer(drawerLayout);
    }
    public void ClickLogo(View view){
        MenuActivity.closeDrawer(drawerLayout);
    }
    public void ClickHome(View view){
        MenuActivity.redirectActivity(this,MenuActivity.class);
    }
    public void ClickSetWallpaper(View view){ MenuActivity.redirectActivity(this, SetWallpaperActivity.class); }
    public void ClickGod(View view){ recreate(); }
    public void ClickSetDarkMode(View view){ MenuActivity.redirectActivity(this, DarkModeActivity.class); }
    public void ClickRateUs(View view){
        MenuActivity.redirectActivity(this, RateUsActivity.class);
    }
    public void ClickLogout(View view){
        MenuActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MenuActivity.closeDrawer(drawerLayout);
    }
}