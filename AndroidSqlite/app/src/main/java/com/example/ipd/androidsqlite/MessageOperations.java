package com.example.ipd.androidsqlite;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class MessageOperations {

//  Databese fields
    private DataBaseWrapper dbHelper;
    @SuppressWarnings("unused")
    private String[] Message_TABLE_COLUMNS = { DataBaseWrapper.Message_ID,  DataBaseWrapper.Message_NAME };
    private SQLiteDatabase database;

//  Calling data from database
    public MessageOperations(Context context) {
        dbHelper = new DataBaseWrapper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

//  Add message
    public Message addMessage(String name) {

        ContentValues values = new ContentValues();

        values.put(DataBaseWrapper.Message_NAME, "An image " + name);

        long studId = database.insert(DataBaseWrapper.MESSAGE, null, values);

//  make and return message
        Cursor cursor = database.query(DataBaseWrapper.MESSAGE,
                Message_TABLE_COLUMNS, DataBaseWrapper.Message_ID + " = "
                        + studId, null, null, null, null);

        cursor.moveToFirst();

        Message newComment = parseMessage(cursor);
        cursor.close();
        return newComment;
    }

//  Remove message
    public void deleteMessage(Message comment) {
        long id = comment.getId();
        System.out.println("Comment deleted with id: " + id);
        database.delete(DataBaseWrapper.MESSAGE, DataBaseWrapper.Message_ID
                + " = " + id, null);
    }

    public List getAllMessage() {
        List messageList = new ArrayList();

        Cursor cursor = database.query(DataBaseWrapper.MESSAGE,
                Message_TABLE_COLUMNS, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Message Message = parseMessage(cursor);
            messageList.add(Message);
            cursor.moveToNext();
        }

        cursor.close();
        return messageList;
    }


    private Message parseMessage(Cursor cursor) {
        Message Message = new Message();
        Message.setId((cursor.getInt(0)));
        Message.setName(cursor.getString(1));
        return Message ;
    }
}