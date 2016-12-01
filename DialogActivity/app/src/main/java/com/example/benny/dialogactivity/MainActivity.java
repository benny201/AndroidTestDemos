package com.example.benny.dialogactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView msgListView;
    private Button Send;
    private EditText editText;
    public  MessageAdapter adapter;
    private List<Message> msgList = new ArrayList<Message>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msgListView = (ListView) findViewById(R.id.listview);
        Send = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.edittext);
        adapter = new MessageAdapter(MainActivity.this,R.layout.msg_item,msgList);
        msgListView.setAdapter(adapter);
        initial();
        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = editText.getText().toString();
                if(!"".equals(content)) {
                    Message message;
                    if(content.charAt(0)=='1') {
                        message = new Message(content,Message.receive_flag);
                    } else {
                        message = new Message(content,Message.Send_flag);
                    }
                    msgList.add(message);
                    adapter.notifyDataSetChanged();
                    msgListView.setSelection(msgList.size());
                    Send.setText("");
                }
            }
        });

    }
    public void initial() {
        Message msg1 = new Message("hello",Message.receive_flag);
        msgList.add(msg1);
        Message msg2 = new Message("hello,who is that?",Message.Send_flag);
        msgList.add(msg2);
    }
}
