package com.example.benny.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public  static String[] fruits = {"apple","banana","pear","pepper","watermelon","lemon","shit"};
    public List<Fruit> fruit = new ArrayList<Fruit>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initiate();
        FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.fruit,fruit);
        final ListView listView = (ListView) findViewById(R.id.textview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit newfruit = fruit.get(position);
                Toast.makeText(MainActivity.this,newfruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void initiate() {
        Fruit apple = new Fruit("Apple",R.drawable.apple);
        fruit.add(apple);
        Fruit banana = new Fruit("banana",R.drawable.apple);
        fruit.add(banana);
        Fruit pear = new Fruit("Pear",R.drawable.apple);
        fruit.add(pear);
        Fruit watermelon = new Fruit("Watermelon",R.drawable.apple);
        fruit.add(watermelon);
        Fruit lenmon = new Fruit("lemon",R.drawable.apple);
        fruit.add(lenmon);
        Fruit shit = new Fruit("Shit",R.drawable.apple);
        fruit.add(shit);
        Fruit bigshit = new Fruit("Bigshit",R.drawable.apple);
        fruit.add(bigshit);
        Fruit bigshit1 = new Fruit("Bigshit",R.drawable.apple);
        fruit.add(bigshit1);
        Fruit bigshit2 = new Fruit("Bigshit",R.drawable.apple);
        fruit.add(bigshit2);
        Fruit bigshit3 = new Fruit("Bigshit",R.drawable.apple);
        fruit.add(bigshit3);
        Fruit bigshit4 = new Fruit("Bigshit",R.drawable.apple);
        fruit.add(bigshit4);
        Fruit bigshit5 = new Fruit("Bigshit",R.drawable.apple);
        fruit.add(bigshit5);
        Fruit bigshit6 = new Fruit("Bigshit",R.drawable.apple);
        fruit.add(bigshit6);
        Fruit bigshit7 = new Fruit("Bigshit",R.drawable.apple);
        fruit.add(bigshit7);
        Fruit bigshit10 = new Fruit("Bigshit",R.drawable.apple);
        fruit.add(bigshit10);
        Fruit bigshit8 = new Fruit("Bigshit",R.drawable.apple);
        fruit.add(bigshit8);
        Fruit bigshit9 = new Fruit("Bigshit",R.drawable.apple);
        fruit.add(bigshit9);
        Fruit bigshit11 = new Fruit("Bigshit",R.drawable.apple);
        fruit.add(bigshit11);
        Fruit bigshit12 = new Fruit("Bigshit",R.drawable.apple);
        fruit.add(bigshit12);
        Fruit bigshit13 = new Fruit("Bigshit",R.drawable.apple);
        fruit.add(bigshit13);
        Fruit bigshit14 = new Fruit("Bigshit",R.drawable.apple);
        fruit.add(bigshit14);

    }

}
