package com.geek.a5_les_lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNewItemActivity extends AppCompatActivity {

    private EditText editText;
    private Button btnAdd;
    public static final String KEY_ADD_BUTTON = "KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_item);
        editText = findViewById(R.id.task_title_et);
        btnAdd = findViewById(R.id.add_new_task_btn);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddNewItemActivity.this, MainActivity.class);
                intent.putExtra(KEY_ADD_BUTTON, editText.getText().toString());
                startActivity(intent);
            }
        });
    }
}