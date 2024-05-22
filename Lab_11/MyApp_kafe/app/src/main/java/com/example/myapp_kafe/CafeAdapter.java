package com.example.myapp_kafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CafeAdapter extends RecyclerView.Adapter<CafeAdapter.ViewHolder> {

    private LayoutInflater inflater = null;
    private final ArrayList<Meal> food;// список для обработки

    public CafeAdapter(Context context, ArrayList<Meal> food) {
        this.inflater = LayoutInflater.from(context);;
        this.food = food;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Meal meal = food.get(position);
        holder.imgView.setImageResource(meal.getImg());
        holder.mealView.setText(meal.getName());
        holder.textView.setText("Цена");
        holder.priceView.setText(String.valueOf(meal.getPrice()));
        holder.quanView.setText(String.valueOf(meal.getQuan()));
    }

    @Override
    public int getItemCount() {
        return food.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgView;
        TextView mealView, priceView, quanView, textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView=itemView.findViewById(R.id.imgView);
            mealView=itemView.findViewById(R.id.mealView);
            textView=itemView.findViewById(R.id.textView);
            priceView=itemView.findViewById(R.id.priceView);
            quanView=itemView.findViewById(R.id.quanView);
        }
    }

}
