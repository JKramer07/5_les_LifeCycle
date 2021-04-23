package com.geek.a5_les_lifecycle;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import static com.geek.a5_les_lifecycle.AddNewItemActivity.KEY_ADD_BUTTON;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;
    private RecyclerView rvTask;
    private RecyclerAdapter adapter;
    private FloatingActionButton btnOpenSecondActivity;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecycler();
        initOpenSecondActivityButton();
    }

    private void initOpenSecondActivityButton() {
        btnOpenSecondActivity = findViewById(R.id.btn_open_second_activity);
        btnOpenSecondActivity.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddNewItemActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
        });
    }

    private void initRecycler() {
        rvTask = findViewById(R.id.rv_item);
        list = new ArrayList<>();
        adapter = new RecyclerAdapter(list);
        rvTask.setAdapter(adapter);
        list.add("Value 1");
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            String string = (String) data.getExtras().get(KEY_ADD_BUTTON);
            adapter.addNewItem(string);
            adapter.notifyDataSetChanged();
        }
    }
}