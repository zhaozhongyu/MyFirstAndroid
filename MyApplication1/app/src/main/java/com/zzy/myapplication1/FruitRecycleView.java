package com.zzy.myapplication1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xl on 2018/1/29.
 */

public class FruitRecycleView extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycleview_layout);
        initFruits();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        FruitRecycleAdapter adapter = new FruitRecycleAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }

    private void initFruits(){
        for(int i = 0; i < 5; i++) {
            fruitList.add(new Fruit("Chrysanthemum", R.drawable.chrysanthemum));
            Fruit Desert = new Fruit("Desert", R.drawable.desert);
            fruitList.add(Desert);
            fruitList.add(new Fruit("Hydrangeas", R.drawable.hydrangeas));
            fruitList.add(new Fruit("Jellyfish", R.drawable.jellyfish));
            fruitList.add(new Fruit("Koala", R.drawable.koala));
            fruitList.add(new Fruit("Lighthouse", R.drawable.lighthouse));
            fruitList.add(new Fruit("Penguins", R.drawable.penguins));
            fruitList.add(new Fruit("Tulips", R.drawable.tulips));
        }
    }
}
