package com.example.instagram;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
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
        Intent intent = new Intent(MainActivity.this, Home.class);
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
//                    Intent i = new Intent(MainActivity.this,Home.class);
//                    startActivity(i);

//                    Intent read1 = new Intent();
//                    read1.setAction(Intent.ACTION_VIEW);
//                    read1.setData(ContactsContract.Contacts.CONTENT_URI);
//                    startActivity(read1);

//                    Uri uri = Uri.parse("https://www.facebook.com/");
//                    Intent it = new Intent(Intent.ACTION_VIEW,uri);
//                    startActivity(it);

//                    Uri uri = Uri.parse("tel:0974149916");
//                    Intent it = new Intent(Intent.ACTION_DIAL,uri);
//                    startActivity(it);
//                    Intent intent = new Intent(MainActivity.this, Home.class);
//                    intent.putExtra("userName", username);
//                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}