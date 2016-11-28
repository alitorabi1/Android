package com.example.lenovo.tinanotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DbActivities {

    public static final String NAME = "name";
    public static final String DATE = "date";
    public static final String BODY = "body";
    public static final String NOTEID = "_id";

    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;

    private static final String DATABASE_NAME = "data";
    private static final String DATABASE_TABLE = "tinanote";
    private static final int DATABASE_VERSION = 2;

    private static final String DATABASE_CREATE =
        "CREATE TABLE IF NOT EXISTS tinanote (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
        + "name VARCHAR NOT NULL, body VARCHAR NOT NULL, date VARCHAR NOT NULL);";

    private final Context mCtx;

    private static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w("DbActivities", "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS tinanotes");
            onCreate(db);
        }
    }

    public DbActivities(Context ctx) {
        this.mCtx = ctx;
    }

    public DbActivities open() throws SQLException {
        mDbHelper = new DatabaseHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        mDbHelper.onCreate(mDb);
        return this;
    }

    public void close() {
        mDbHelper.close();
    }


    public long makeNote(String name, String body, String date) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(NAME, name);
        initialValues.put(BODY, body);
        initialValues.put(DATE, date);

        return mDb.insert(DATABASE_TABLE, null, initialValues);
    }

    public boolean deleteNote(long noteId) {

        return mDb.delete(DATABASE_TABLE, NOTEID + "=" + noteId, null) > 0;
    }

    public Cursor selectAllNotes() {

        return mDb.query(DATABASE_TABLE, new String[] {NOTEID, NAME,
                BODY, DATE}, null, null, null, null, null);
    }

    public Cursor selectNoteById(long noteId) throws SQLException {

        Cursor mCursor =

            mDb.query(true, DATABASE_TABLE, new String[] {NOTEID,
                            NAME, BODY, DATE}, NOTEID + "=" + noteId, null,
                    null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;

    }

    public Cursor getSearchTags(String tag) throws SQLException
    {
        Cursor mCursor = mDb.rawQuery("SELECT * FROM " + DATABASE_TABLE + " WHERE  LOWER(name) LIKE ?", new String[] {"%"+ tag.toLowerCase() + "%" });

        return mCursor;
    }

    public boolean updateNote(long noteId, String name, String body, String date) {
        ContentValues args = new ContentValues();
        args.put(NAME, name);
        args.put(BODY, body);
        args.put(DATE, date);
        
        return mDb.update(DATABASE_TABLE, args, NOTEID + "=" + noteId, null) > 0;
    }

}
