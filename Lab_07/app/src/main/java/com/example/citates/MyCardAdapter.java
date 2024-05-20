package com.example.citates;

import android.content.ClipData;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyCardAdapter extends RecyclerView.Adapter<MyCardAdapter.MyViewHolder> implements View.OnClickListener {

    ArrayList<Person> people;

    @Override
    public void onClick(View v) {

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imgView;
        TextView tvname;
        TextView tvtitle;
        public View view;
        public ClipData.Item currentItem;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imgView = (ImageView) itemView.findViewById(R.id.imgView);
            this.tvname = (TextView) itemView.findViewById(R.id.tvname);
            this.tvtitle = (TextView) itemView.findViewById(R.id.tvtitle);

        }
    }
}
