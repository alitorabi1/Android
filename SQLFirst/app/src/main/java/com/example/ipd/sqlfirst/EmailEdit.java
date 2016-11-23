package com.example.ipd.sqlfirst;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EmailEdit extends AppCompatActivity {

    SQLiteDatabase db;
    EditText etEmail;
    String email = "";
    String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_edit);

        name = getIntent().getExtras().getString("Name");

        etEmail = (EditText) findViewById(R.id.editText2);

        db = openOrCreateDatabase("Users.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Users (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,name varchar, email varchar)");
        String selectQuery = "SELECT email FROM Users WHERE name=?";
        Cursor c = db.rawQuery(selectQuery, new String[] { name });
        if (c.moveToFirst()) {
            etEmail.setText(c.getString(c.getColumnIndex("email")));
        }
        c.close();
    }

    public void saveClick(View view) {

        email = etEmail.getText().toString();

        String query = "INSERT INTO Users (name,email) VALUES('"+name+"', '"+email+"');";
        db.execSQL(query);
    }

}
