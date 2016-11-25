package com.example.ipd.androidsqlite;

import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

public class MainActivity extends ListActivity {

    private MessageOperations messageDBOperation;

//    @SuppressWarnings("unchecked")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageDBOperation = new MessageOperations(this);
        messageDBOperation.open();

        List values = messageDBOperation.getAllMessage();

//  Using a listview to show messages
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
    }


    public void addItem(View view) {

        ArrayAdapter adapter = (ArrayAdapter) getListAdapter();

        EditText text = (EditText) findViewById(R.id.editText1);
        Message stud = messageDBOperation.addMessage(text.getText().toString());

        adapter.add(stud);

    }

    public void deleteFirstItem(View view) {

        ArrayAdapter adapter = (ArrayAdapter) getListAdapter();
        Message stud = null;

        if (getListAdapter().getCount() > 0) {
            stud = (Message) getListAdapter().getItem(0);
            messageDBOperation.deleteMessage(stud);
            adapter.remove(stud);
        }

    }

    @Override
    protected void onResume() {
        messageDBOperation.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        messageDBOperation.close();
        super.onPause();
    }

    public void mainClick(View view) {
        Intent intent = new Intent(this, Messages.class);
        startActivity(intent);
    }

}