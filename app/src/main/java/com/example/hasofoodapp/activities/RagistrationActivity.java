package com.example.hasofoodapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hasofoodapp.MainActivity;
import com.example.hasofoodapp.R;

public class RagistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ragistration);
    }

    public void login(View view) {
        startActivity(new Intent(RagistrationActivity.this, LoginActivity.class));
    }

    public void mainActivity(View view) {
        startActivity(new Intent(RagistrationActivity.this, MainActivity.class));
    }
}