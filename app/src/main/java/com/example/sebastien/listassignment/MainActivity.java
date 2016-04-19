package com.example.sebastien.listassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


public class MainActivity extends AppCompatActivity {

    private EditText entry;
    private ArrayList<String> myArray;
    private ArrayAdapter<String> myAdapter;
    private ListView list;
    private Button myButton;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entry = (EditText) findViewById(R.id.entry);
        myArray = new ArrayList<String>();
        myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myArray);
        list = (ListView) findViewById(R.id.myList);
        list.setAdapter(myAdapter);
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                myArray.remove(position);
                myAdapter.notifyDataSetChanged();
                return false;
            }
        });
    }


    public void addEntry(View view) {
        String value = String.valueOf(entry.getText());
        myArray.add(value);
        myAdapter.notifyDataSetChanged();
    }

    public void removeText(View view) {
        entry.setText("");
    }




    /*list.setOnLongItemClickListener(new AdapterView.onLongItemClickListener() {
            @Override
                    public void onLongItemClick(AdapterView<String> myAdapter, View row, int index, long RowID) {
                        myArray.remove(index);
                        myAdapter.notifyDataSetChanged();
        }
       }
     );

    */


}
