package com.example.benny.broadcastforoffline;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by benny on 16/12/2.
 */
public class LoginActivity extends BaseActivity {
    private EditText edit_account_text;
    private EditText edit_password_text;
    private Button button;
    private CheckBox remember;

    private SharedPreferences sharedpreference;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        edit_account_text = (EditText) findViewById(R.id.edit_account);
        edit_password_text = (EditText) findViewById(R.id.password_edit);
        button = (Button) findViewById(R.id.button);
        remember = (CheckBox) findViewById(R.id.remember);


        // create shared preference
        sharedpreference = PreferenceManager.getDefaultSharedPreferences(this);

        // check isRemember
        boolean isRemember = sharedpreference.getBoolean("remember_state", false);

        if (isRemember) {
            String account = sharedpreference.getString("account", "");
            String password = sharedpreference.getString("password", "");
            edit_account_text.setText(account);
            edit_password_text.setText(password);
            remember.setChecked(true);
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = edit_account_text.getText().toString();
                String password = edit_password_text.getText().toString();
                if(password.equals("123456") && account.equals("zhibin")) {
                    editor = sharedpreference.edit();

                    if (remember.isChecked()) {
                        editor.putBoolean("remember_state", true);
                        editor.putString("account", account);
                        editor.putString("password", password);
                    } else {
                        editor.clear();
                    }
                    editor.apply();

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
