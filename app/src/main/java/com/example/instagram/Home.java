package com.example.instagram;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView textView = findViewById(R.id.Test);
    if(getIntent() != null){
        String data = getIntent().getStringExtra("userName");
        textView.setText(data);
    }
        Bundle extra = getIntent().getExtras();
        String username = extra.getString("UserName","");
        String password = extra.getString("Password","");
        List<Integer> test = extra.getIntegerArrayList("ListAge");
        Uri uri = getIntent().getData();
        Log.d("TAG",username);
        Log.d("TAG1",password);
        Log.d("ListAge",test.get(2).toString());
        Log.d("data",uri.toString());
    }
}