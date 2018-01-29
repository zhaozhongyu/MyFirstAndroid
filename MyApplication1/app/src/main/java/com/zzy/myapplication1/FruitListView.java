package com.zzy.myapplication1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xl on 2018/1/27.
 */

public class FruitListView extends AppCompatActivity {
   /* private String[] data = {"apple", "Banana", "Orange", "Pear", "Watermelon", "Grape", "Pineapple",
            "Strawberry","Cherry", "Mango", "apple", "Banana", "Orange", "Pear", "Watermelon", "Grape",
            "Pineapple", "Strawberry","Cherry", "Mango"};*/
   private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.listview_layout);
       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(FruitListView.this, android.R.layout.simple_list_item_1, data);
        initFruits();
        FruitAdapter adapter = new FruitAdapter(FruitListView.this, R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Fruit fruit = fruitList.get(i);
                Toast.makeText(FruitListView.this, fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
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
