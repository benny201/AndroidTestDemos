package com.example.benny.broadcastforoffline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by benny on 16/12/2.
 */
public class LoginActivity extends BaseActivity {
    private EditText edit_account_text;
    private EditText edit_password_text;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        edit_account_text = (EditText) findViewById(R.id.edit_account);
        edit_password_text = (EditText) findViewById(R.id.password_edit);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit_password_text.getText().toString().equals("123456")&&edit_account_text.getText().toString().equals("zhibinwu")) {
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this,"Wrong account&password!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
