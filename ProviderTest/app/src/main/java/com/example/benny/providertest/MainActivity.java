package com.example.benny.providertest;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button CreateButton;
    private Button RetrieveButton;
    private Button UpdateButton;
    private Button DeleteButton;
    private String newId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create
        CreateButton = (Button) findViewById(R.id.CreateDate);
        CreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("name", "DAD");
                values.put("author", "Benny");
                values.put("pages", 1000);
                Uri uri = Uri.parse("content://com.example.benny.databasetest.provider/book");
                Uri newUri = getContentResolver().insert(uri, values);
                newId = newUri.getPathSegments().get(1);
            }
        });

        //Retrieve
        RetrieveButton = (Button) findViewById(R.id.RetrieveDate);
        RetrieveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("content://com.example.benny.databasetest.provider/book");
                Cursor cursor = getContentResolver().query(uri, null, null, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));

                        Log.d("BENNY!!!!!!!", name + author + pages);
                    }
                }
                cursor.close();
            }
        });

        //Update
        UpdateButton = (Button) findViewById(R.id.UpdateDate);
        UpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("content://com.example.benny.databasetest.provider/book/" + newId);
                ContentValues values = new ContentValues();
                values.put("pages", 111);
                getContentResolver().update(uri, values, null, null);
            }
        });

        //Delete
        DeleteButton = (Button) findViewById(R.id.DeleteDate);
        DeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("content://com.example.benny.databasetest.provider/book/" + newId);
                getContentResolver().delete(uri, null, null);
            }
        });

    }
}
