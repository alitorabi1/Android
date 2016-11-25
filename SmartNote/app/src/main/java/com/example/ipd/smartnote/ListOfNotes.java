package com.example.ipd.smartnote;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.AdapterView.AdapterContextMenuInfo;

    public class ListOfNotes extends ListActivity {

        private static final int ACTIVITY_CREATE=0;
        private static final int ACTIVITY_EDIT=1;

        private static final int DELETE_ID = Menu.FIRST;
        private int mNoteNumber = 1;

        private DBActivities dbActivities;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.list_notes);
            dbActivities = new DBActivities (this);
            dbActivities.open();
            fillData();
            registerForContextMenu(getListView());
            Button addnote = (Button)findViewById(R.id.addnotebutton);
            addnote.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    createNote();
                }
            });

        }

        private void createNote() {
            Intent i = new Intent(this, EditNote.class);
            startActivityForResult(i, ACTIVITY_CREATE);
        }

        @Override
        protected void onListItemClick(ListView l, View v, int position, long id) {
            super.onListItemClick(l, v, position, id);
            Intent i = new Intent(this, EditNote.class);
            i.putExtra(DBActivities.ROWID, id);
            startActivityForResult(i, ACTIVITY_EDIT);
        }

        private void fillData() {
            // Get all of the notes from the database and create the item list
            Cursor notesCursor = dbActivities.fetchAllNotes();
            startManagingCursor(notesCursor);


            String[] from = new String[] { DBActivities.NAME , DBActivities.DATE};
            int[] to = new int[] { R.id.text1 ,R.id.date_row};

            // Now create an array adapter and set it to display using our row
            SimpleCursorAdapter notes =
                    new SimpleCursorAdapter(this, R.layout.row_note, notesCursor, from, to);
            setListAdapter(notes);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v,
                                        ContextMenu.ContextMenuInfo menuInfo) {
            super.onCreateContextMenu(menu, v, menuInfo);
            menu.add(0, DELETE_ID, 0, R.string.delete_note);
        }

        @Override
        public boolean onContextItemSelected(MenuItem item) {
            switch(item.getItemId()) {
                case DELETE_ID:
                    AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
                    dbActivities.deleteNote(info.id);
                    fillData();
                    return true;
            }
            return super.onContextItemSelected(item);
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
            super.onActivityResult(requestCode, resultCode, intent);
            fillData();
        }

    }
