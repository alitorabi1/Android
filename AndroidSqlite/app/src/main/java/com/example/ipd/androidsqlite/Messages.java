package com.example.ipd.androidsqlite;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.List;

public class Messages extends ListActivity {

    private MessageOperations dbOperation;

    @SuppressWarnings("unchecked")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);
        dbOperation = new MessageOperations(this);
        dbOperation.open();

        List values = dbOperation.getAllMessage();

        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
    }
}
