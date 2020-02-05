package com.example.paintk92;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.paintk92.views.FunnyBirdView;
import com.example.paintk92.views.MyDraw;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(new FunnyBirdView(this));
        this.getSupportActionBar().hide();
    }
}
