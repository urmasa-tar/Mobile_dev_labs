package com.example.lab_04;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


class ItemListAdapter extends ArrayAdapter<Person> {
    private Context mContext;
    int mResource;
    public ItemListAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        // Сюда вставлять текст метода
        String txtItem1 = getItem(position).getTitle();
        String txtItem2 = getItem(position).getRef();
        Bitmap imgItem = getItem(position).getImg();

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView textView1 = (TextView) convertView.findViewById(R.id.titleView);
        TextView textView2 = (TextView) convertView.findViewById(R.id.refView);
        ImageView imgView = (ImageView) convertView.findViewById(R.id.imgView);

        titleView.setText(txtItem1);
        refView.setText(txtItem2);
        imgView.setImageBitmap(imgItem);

        return convertView;
    }

}
