package com.example.mytest;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

// AppCompatActivity
public class MainActivity extends ListActivity {

    private class ListItems {
        private CharSequence title;
        private Class<? extends Activity> activityClass;

        public ListItems(int titleResId, Class<? extends Activity> activityClass) {
            this.activityClass = activityClass;
            this.title = getResources().getString(titleResId);
        }

        @Override
        public String toString() {
            return title.toString();
        }
    }

    private static ListItems[] myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myList = new ListItems[] {
                new ListItems(R.string.title_screen_slide, ScreenSlideActivity.class),
        };

        setListAdapter(new ArrayAdapter<ListItems>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                myList));
    }

    @Override
    protected void onListItemClick(ListView listView, View view, int position, long id) {
        startActivity(new Intent(MainActivity.this, myList[position].activityClass));
    }
}
