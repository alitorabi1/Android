package com.example.ipd.studenttracker;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.List;

public class Messages extends ListActivity {

    private DBOperations dbOperation;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);
        setTitle("Messages");

        dbOperation = new DBOperations(this);
        dbOperation.open();

        List values = dbOperation.getAllMessage();

        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
    }

    public void goBack(View v) {
        Intent intent = new Intent(this, ListItems.class);
        startActivity(intent);
    }

}
