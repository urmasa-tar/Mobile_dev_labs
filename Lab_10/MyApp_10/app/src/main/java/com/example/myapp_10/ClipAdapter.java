package com.example.myapp_10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ClipAdapter extends RecyclerView.Adapter<ClipAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private final ArrayList<Picture> mylst;
    private ItemClickListener mClickListener;

    // Это  интерфейс. Родительская activity будет вызывать этот метод
    // в ответ на событие щелчка.
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public ClipAdapter(Context context, ArrayList<Picture> mylst) {
        this.inflater = LayoutInflater.from(context);
        this.mylst = mylst;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picture bl = mylst.get(position);
        holder.imgView.setImageResource(bl.getImg());
        holder.nameView.setText(bl.getStr());

    }

    @Override
    public int getItemCount() {
        return mylst.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgView;
        TextView nameView;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView = itemView.findViewById(R.id.imgView);
            nameView = itemView.findViewById(R.id.nameView);
            itemView.setOnClickListener(this);
            cardView = itemView.findViewById(R.id.cv);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
}
