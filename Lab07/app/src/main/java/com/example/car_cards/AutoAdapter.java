package com.example.car_cards;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.tv.TvContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AutoAdapter extends RecyclerView.Adapter<AutoAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private final ArrayList<TvContract.Channels.Logo> mylst;

    public AutoAdapter(Context context, ArrayList<TvContract.Channels.Logo> mylst) {
        this.inflater = LayoutInflater.from(context);
        this.mylst = mylst;
    }

    @NonNull
    @Override
    public AutoAdapter.ViewHolder onCreateViewHolder(@NonNull
                                                     ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TvContract.Channels.Logo logo = mylst.get(position);
        holder.imgView.setImageResource(logo.getImg());
        holder.txtView.setText(logo.getName());
    }

    @Override
    public int getItemCount() {
        return mylst.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgView;
        TextView txtView;
        CardView cardView;

        @SuppressLint("CutPasteId")
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView = itemView.findViewById(R.id.txtView);
            txtView = itemView.findViewById(R.id.txtView);
            cardView = itemView.findViewById(R.id.cv);
        }
    }
}
