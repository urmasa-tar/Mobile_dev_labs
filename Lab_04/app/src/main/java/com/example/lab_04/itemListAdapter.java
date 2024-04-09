package com.example.lab_04;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class ItemListAdapter extends ArrayAdapter<Person> {

    public ItemListAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
}
