package com.example.elcomplus.vsign.screens.base;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class BaseActivity extends AppCompatActivity {
    protected Handler mHandler;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    void intConfig() {
        mHandler = new Handler();
    }
    protected void setToolbarTitle(Toolbar toolbar, int title, boolean hasBack) {
        setToolbarTitle(toolbar, getString(title), hasBack);

    }

    protected void setToolbarTitle(Toolbar toolbar, String title, boolean hasBack) {
        setSupportActionBar(toolbar);
        setTitle(title);
        if (hasBack) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        intConfig();
    }
}
