package com.example.instagram;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private String username, password;
    private EditText mEditUsername, mPassword;

    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent data = result.getData();
                        if (data != null && data.getExtras() != null) {
                            String usernameReturn = data.getExtras().getString("username");
                            Log.d("username", usernameReturn);
                        }
                    }
                }
            }
    );

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

        Button button = findViewById(R.id.Login);
        mEditUsername = findViewById(R.id.Username);
        mPassword = findViewById(R.id.password);
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
                    Toast.makeText(LoginActivity.this, "Login successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, Home.class);
                    intent.putExtra("userName", username);
                    someActivityResultLauncher.launch(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        clearInputFields();
    }

    private void clearInputFields() {
        mEditUsername.setText("");
        mPassword.setText("");
    }
}
