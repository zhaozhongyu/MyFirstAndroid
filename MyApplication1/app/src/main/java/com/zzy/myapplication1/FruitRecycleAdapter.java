package com.zzy.myapplication1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by xl on 2018/1/26.
 */

public class FruitRecycleAdapter extends RecyclerView.Adapter<FruitRecycleAdapter.ViewHolder> {

    private List<Fruit> FruitList;
    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView fruitImage;
        TextView fruitText;
        View fruitView;
        public ViewHolder(View view ){
            super(view);
            fruitView = view;
            fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            fruitText = (TextView) view.findViewById(R.id.fruit_name);
        }
    }

    public FruitRecycleAdapter(List<Fruit> fruitList){
        this.FruitList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Fruit fruit = FruitList.get(position);
                Toast.makeText(view.getContext(), "click view"+fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.fruitImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Fruit fruit = FruitList.get(position);
                Toast.makeText(view.getContext(), "click Image"+fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = FruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitText.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return FruitList.size();
    }
}
