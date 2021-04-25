package com.moushao.workmanager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.moushao.workmanager.lib.WorkManagerController;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WorkManagerController.initWork(this);
    }
}