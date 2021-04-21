package com.geek.a5_les_lifecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvTask;
    private RecyclerAdapter adapter;
    private FloatingActionButton btnOpenSecondActivity;
    private String editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initOpenSecondActivityButton();
        initRecycler();

    }

    private void initOpenSecondActivityButton() {
        btnOpenSecondActivity = findViewById(R.id.btn_open_second_activity);
        btnOpenSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddNewItemActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initRecycler() {
        rvTask = findViewById(R.id.rv_item);

        List<String> list = new ArrayList<>();

        adapter = new RecyclerAdapter(list);
        rvTask.setAdapter(adapter);

        editText = getIntent().getStringExtra(AddNewItemActivity.KEY_ADD_BUTTON);

        adapter.addNewItem(editText);

    }


}