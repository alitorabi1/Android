package com.example.ipd.studenttracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ListItems extends AppCompatActivity {

    ListView list;
    String[] itemname ={
            "TodayActivities",
            "TodayGrade",
            "AverageGrade",
            "Messages"
    };

    Integer[] imgid={
            R.drawable.todayactivities,
            R.drawable.todaygrade,
            R.drawable.averagegrade,
            R.drawable.messages
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);

        CustomListAdapter adapter = new CustomListAdapter(this, itemname, imgid);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem= itemname[+position];
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

                final Intent intent = new Intent();
                final int ACTIVITY_0 = 0;
                final int ACTIVITY_1 = 1;
                final int ACTIVITY_2 = 2;
                final int ACTIVITY_3 = 3;
                switch (position)
                {
                    case ACTIVITY_0:
                        intent.setClass(ListItems.this, TodayActivities.class);
                        break;
                    case ACTIVITY_1:
                        intent.setClass(ListItems.this, TodayGrade.class);
                        break;
                    case ACTIVITY_2:
                        intent.setClass(ListItems.this, TodayGrade.class);
                        break;
                    case ACTIVITY_3:
                        intent.setClass(ListItems.this, Messages.class);
                        break;
                    default:
                        break;
                }
                startActivityForResult(intent, position);
            }
        });
    }
}
