package com.charlesfeng.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ListView listView01;
    private List<String> show_text = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView01 = (ListView) findViewById(R.id.lv_names);

        show_text.add("Charles");
        show_text.add("Paul");
        show_text.add("Dino");
        show_text.add("Vince");
        show_text.add("Hero");


        final MyAdapter adapter = new MyAdapter(this, show_text);
        listView01.setAdapter(adapter);
        listView01.setTextFilterEnabled(true);

        EditText editText = (EditText) findViewById(R.id.et);

        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

    }
}