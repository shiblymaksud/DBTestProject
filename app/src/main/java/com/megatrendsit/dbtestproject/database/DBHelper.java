package com.megatrendsit.dbtestproject.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.megatrendsit.dbtestproject.model.Verses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maksud on 6/9/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "app_db.db";
    public static final String DBLOCATION = "/data/data/com.megatrendsit.dbtestproject/databases/";
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public DBHelper(Context context) {
        super(context, DBNAME, null, 1);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void openDatabase() {
        String dbPath = mContext.getDatabasePath(DBNAME).getPath();
        if(mDatabase != null && mDatabase.isOpen()) {
            return;
        }
        mDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void closeDatabase() {
        if(mDatabase!=null) {
            mDatabase.close();
        }
    }

    public List<Verses> getListVerses() {
        Verses verses = null;
        List<Verses> versesList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM GASHIA", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            verses = new Verses(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
            versesList.add(verses);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return versesList;
    }
}
