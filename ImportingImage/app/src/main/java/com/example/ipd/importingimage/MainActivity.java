package com.example.ipd.importingimage;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {

//    String[] itemname ={
//            "Safari",
//            "Camera",
//            "Global",
//            "FireFox",
//            "UC Browser",
//            "Android Folder",
//            "VLC Player",
//            "Cold War"
//    };

    String[] itemname ={
            "Ontario",
            "Quebec",
            "Nova Scotia",
            "New Brunswick",
            "Manitoba",
            "British Columbia",
            "Prince Edward Island",
            "Saskatchewan",
            "Alberta",
            "Newfoundland and Labrador"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setListAdapter(new ArrayAdapter<String>(
                this, R.layout.mylist,
                R.id.Itemname,itemname));
    }
}
