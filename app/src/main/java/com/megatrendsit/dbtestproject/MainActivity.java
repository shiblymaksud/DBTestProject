package com.megatrendsit.dbtestproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.megatrendsit.dbtestproject.adapter.ListVerseAdapter;
import com.megatrendsit.dbtestproject.database.DBHelper;
import com.megatrendsit.dbtestproject.model.Verses;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvVerse;
    private ListVerseAdapter adapter;
    private List<Verses> mVerseList;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.buttonShow);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                lvVerse = (ListView)findViewById(R.id.listview_verses);
                dbHelper = new DBHelper(MainActivity.this);

                //Check exists database
                File database = getApplicationContext().getDatabasePath(DBHelper.DBNAME);
                if(false == database.exists()) {
                    dbHelper.getReadableDatabase();
                    //Copy db
                    if(copyDatabase(MainActivity.this)) {
                        Log.e("DB_Test", "Copy database succes");
                        // Toast.makeText(this, "Copy database succes", Toast.LENGTH_SHORT).show();
                    } else {
                        Log.e("DB_Test", "Copy data error");
                        // Toast.makeText(this, "Copy data error", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                //Get product list in db when db exists
                mVerseList = dbHelper.getListVerses();
                //Init adapter
                adapter = new ListVerseAdapter(MainActivity.this, mVerseList);
                //Set adapter for listview
                lvVerse.setAdapter(adapter);
            }
        });


    }


    private boolean copyDatabase(Context context) {
        try {
            InputStream inputStream = context.getAssets().open(DBHelper.DBNAME);
            String outFileName = DBHelper.DBLOCATION + DBHelper.DBNAME;
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[]buff = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buff)) > 0) {
                outputStream.write(buff, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            Log.w("MainActivity","DB copied");
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
