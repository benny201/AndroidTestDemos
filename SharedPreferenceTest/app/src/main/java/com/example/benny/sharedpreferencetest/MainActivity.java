package com.example.benny.sharedpreferencetest;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("benny",MODE_PRIVATE).edit();
                editor.putString("FirstName","Benny");
                editor.putBoolean("answer",true);
                editor.putString("LastName","Wu");
                editor.apply();
            }
        });

        load = (Button) findViewById(R.id.button2);
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences loadShared = getSharedPreferences("benny",MODE_PRIVATE);
                String name = loadShared.getString("FirstName", null);
                Log.d("BENNY", "onClick: " + name);
            }
        });


    }
}
