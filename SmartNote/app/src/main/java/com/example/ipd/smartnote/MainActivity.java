package com.example.ipd.smartnote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void newNote(View view) {
        Intent intent = new Intent(this, EditNote.class);
        startActivity(intent);
    }

    public void listOfNotes(View view) {
        Intent intent = new Intent(this, ListOfNotes.class);
        startActivity(intent);
    }

    public void gallery(View view) {
        Intent intent = new Intent(this, Gallery.class);
        startActivity(intent);
    }
}
