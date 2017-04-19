package com.example.cento.wineyardapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import DB.Contract;
import DB.SQLhelper;

import static android.R.attr.id;
import static android.R.attr.value;

public class EmplacementList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emplacement_list);

        setTitle(getResources().getString(R.string.locations));
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.activity_emplacement_list, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.delete:
                Toast.makeText(this, "Delete pressed", Toast.LENGTH_SHORT).show();
                return true ;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}
