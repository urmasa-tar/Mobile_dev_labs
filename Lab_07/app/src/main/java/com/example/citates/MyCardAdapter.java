package com.example.citates;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.citates.Person;

import java.text.BreakIterator;
import java.util.List;

public class MyCardAdapter extends ArrayAdapter<Person> {
    private Context mContext;
    int mResource;

    public MyCardAdapter(@NonNull Context context, int resource, @NonNull List<Person> objects) {
        super(context, resource, objects);
        this.mContext=context;
        mResource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String txtItem1 = getItem(position).getTitle();
        String txtItem2 = getItem(position).getRef();
        ImageView imgItem = getItem(position).getImg();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView=inflater.inflate(mResource,parent,false);
        TextView titleView = (TextView) convertView.findViewById(R.id.tvtitle);
        TextView refView = (TextView) convertView.findViewById(R.id.tvname);
        ImageView imgView = (ImageView) convertView.findViewById(R.id.imgView);
        titleView.setText(txtItem1);
        refView.setText(txtItem2);
        imgView.setImageBitmap(imgItem.getDrawingCache());
        return convertView;
    }
}