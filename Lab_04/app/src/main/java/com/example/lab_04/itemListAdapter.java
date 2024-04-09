package com.example.lab_04;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;



class ItemListAdapter extends ArrayAdapter<Person> {
    private Context mContext;
    int mResource;
    public ItemListAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
}
