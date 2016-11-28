package com.example.ipd.smartnote;

    import android.content.ContentValues;
    import android.content.Context;
    import android.database.Cursor;
    import android.database.SQLException;
    import android.database.sqlite.SQLiteDatabase;
    import android.database.sqlite.SQLiteOpenHelper;
    import android.util.Log;

public class DBActivities {

        public static final String NAME = "name";
        public static final String BODY = "body";
        public static final String DATE = "date";
        public static final String ROWID = "id";
//        public static final String IMAGE = "image";

        private DBHelper dbHelper;
        private SQLiteDatabase db;

    //  Creating table
        private static final String TABLE_CREATE =
                "create table SmartNote (id integer primary key autoincrement, "
                        + "name varchar not null, body varchar not null, date varchar not null);";
//    + "name varchar not null, body varchar not null, date varchar not null, image varchar);";

        private static final String DATABASE_NAME = "data";
        private static final String DATABASE_TABLE = "SmartNote";
        private static final int DATABASE_VERSION = 2;

        private final Context mCtx;

        private static class DBHelper extends SQLiteOpenHelper {

            DBHelper(Context context) {
                super(context, DATABASE_NAME, null, DATABASE_VERSION);
            }

            @Override
            public void onCreate(SQLiteDatabase db) {

                db.execSQL(TABLE_CREATE);
            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                Log.w("DBActivities", "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
                db.execSQL("DROP TABLE IF EXISTS notes");
                onCreate(db);
            }
        }

        public DBActivities(Context ctx) {
            this.mCtx = ctx;
        }

        public DBActivities open() throws SQLException {
            dbHelper = new DBHelper(mCtx);
            db = dbHelper.getWritableDatabase();
            return this;
        }

        public void close() {
            dbHelper.close();
        }

        public long createNote(String title, String body, String date) {
//            public long createNote(String title, String body, String date, String image) {
            ContentValues initialValues = new ContentValues();
            initialValues.put(NAME, title);
            initialValues.put(BODY, body);
            initialValues.put(DATE, date);
//            initialValues.put(IMAGE, image);

            return db.insert(DATABASE_TABLE, null, initialValues);
        }

        public boolean deleteNote(long rowId) {

            return db.delete(DATABASE_TABLE, ROWID + "=" + rowId, null) > 0;
        }

        public Cursor fetchAllNotes() {

            return db.query(DATABASE_TABLE, new String[] {ROWID, NAME,
                    BODY, DATE}, null, null, null, null, null);
//            BODY, DATE, IMAGE}, null, null, null, null, null);
        }

        public Cursor fetchNote(long rowId) throws SQLException {

            Cursor mCursor =
                    db.query(true, DATABASE_TABLE, new String[] {ROWID,
                                    NAME, BODY, DATE}, ROWID + "=" + rowId, null,
//                            NAME, BODY, DATE, IMAGE}, ROWID + "=" + rowId, null,
                            null, null, null, null);
            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;

        }

        public boolean updateNote(long rowId, String title, String body,String date) {
//            public boolean updateNote(long rowId, String title, String body,String date, String image) {
            ContentValues args = new ContentValues();
            args.put(NAME, title);
            args.put(BODY, body);

            args.put(DATE, date);
//            args.put(IMAGE, image);

            return db.update(DATABASE_TABLE, args, ROWID + "=" + rowId, null) > 0;
        }
    }
