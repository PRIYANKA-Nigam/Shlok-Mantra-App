package com.example.shlokmantraapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class Image extends BaseAdapter {
    private Context mc;

    public int[] img={R.drawable.shiva,R.drawable.ganesha,R.drawable.hanuman,
            R.drawable.rama,R.drawable.brahma,R.drawable.vishnu,
            R.drawable.shani_dev,R.drawable.lakshmi,R.drawable.durga,
            R.drawable.saraswati,R.drawable.kali,R.drawable.gayatri,
            R.drawable.santoshi,R.drawable.kuber,R.drawable.karwas,
            R.drawable.chhath,R.drawable.wed,R.drawable.vidya};
    public Image(Context mc) {
        this.mc = mc;
    }

    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public Object getItem(int i) {
        return img[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView=new ImageView(mc);
        imageView.setImageResource(img[i]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(340,350));
        return imageView;
    }
}
