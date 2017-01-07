package com.example.benny.litepaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button CreateDataBase;
    private Button CreateData;
    private Button Update;
    private Button Delete;
    private Button Retrieve;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Create Database
        CreateDataBase = (Button) findViewById(R.id.CreateDataBase);
        CreateDataBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connector.getDatabase();
            }
        });

        // Create Data
        CreateData = (Button) findViewById(R.id.CreateData);
        CreateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setAuthor("Benny");
                book.setName("BennyLoveU");
                book.setPages(888);
                book.setPrice(76.7);
                book.save();
            }
        });

        // Update
        Update = (Button) findViewById(R.id.Update);
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setPrice(9.9);
                book.updateAll("name = ?", "BennyLoveU");
            }
        });

        //Delete
        Delete = (Button) findViewById(R.id.Delete);
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataSupport.deleteAll(Book.class, "price < ?", "100");
            }
        });

        //Retrieve
        Retrieve = (Button) findViewById(R.id.Retrieve);
        Retrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Book> bookList = new ArrayList<Book>();
                bookList = DataSupport.findAll(Book.class);
                for (Book book : bookList) {
                    Log.d("bennyfuck", book.getName());
                }
            }
        });


    }
}
