package com.example.instagram;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private String username, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button button = (Button)  findViewById(R.id.Login);
        EditText mEditUsername = findViewById(R.id.Username);
        EditText mPassword = findViewById(R.id.password);
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("admin", "123456"));
        accounts.add(new Account("user1", "123456"));
        accounts.add(new Account("user2", "123456"));
        accounts.add(new Account("user3", "123456"));
        accounts.add(new Account("user4", "123456"));
        accounts.add(new Account("user5", "123456"));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = mEditUsername.getText().toString();
                password = mPassword.getText().toString();
                boolean loginSuccess = false;

                for (Account acc : accounts) {
                    if (username.equals(acc.getUserName()) && password.equals(acc.getPassWord())) {
                        loginSuccess = true;
                        break;
                    }
                }

                if (loginSuccess) {
                    Toast.makeText(MainActivity.this, "Login successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}