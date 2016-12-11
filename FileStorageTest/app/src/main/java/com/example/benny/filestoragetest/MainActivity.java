package com.example.benny.filestoragetest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.edit_text);
        String input = load();
        editText.setText(input);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String input = editText.getText().toString();
        save(input);
    }

    public void save(String input) {
        FileOutputStream out  = null;
        BufferedWriter writer = null;
        try {
            out = openFileOutput("new", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(input);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(writer!=null) {
                    writer.close();
                }
             } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String load() {
        FileInputStream in = null;
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            in = openFileInput("new");
            bufferedReader = new BufferedReader(new InputStreamReader(in));
            String hasread = "";
            while((hasread = bufferedReader.readLine())!= null) {
                stringBuilder.append(hasread);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bufferedReader!=null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return stringBuilder.toString();
    }
}
