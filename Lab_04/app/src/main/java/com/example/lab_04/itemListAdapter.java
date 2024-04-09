package com.example.lab_04;

import android.annotation.SuppressLint;
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

import java.text.BreakIterator;
import java.util.List;
import java.util.Objects;


class ItemListAdapter extends ArrayAdapter<Person> {
    private Context mContext;
    int mResource;
    public ItemListAdapter(@NonNull Context context, int resource, List<Person> peopleList) {
        super(context, resource);
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        // Сюда вставлять текст метода
        String txtItem1 = Objects.requireNonNull(getItem(position)).getTitle();
        String txtItem2 = Objects.requireNonNull(getItem(position)).getRef();
        Bitmap imgItem = Objects.requireNonNull(getItem(position)).getImg();

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView textView1 = (TextView) convertView.findViewById(R.id.titleView);
        TextView textView2 = (TextView) convertView.findViewById(R.id.refView);
        ImageView imgView = (ImageView) convertView.findViewById(R.id.imgView);

        /*
        titleView.setText(txtItem1);
        refView.setText(txtItem2);*/
        imgView.setImageBitmap(imgItem);

        return convertView;
    }

}
