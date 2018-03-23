package com.example.chady.assignment42;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Chady on 3/23/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "antonyms.db";
    private static final String TABLE_NAME = "antonyms";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_USER_WORD = "userWord";
    private static final String COLUMN_USER_ANTONYM = "userAntonym";

    SQLiteDatabase db;

    private static final String TABLE_CREATE = "create table antonyms (id integer primary key not null auto_increment , " +
            "userWord text not null , userAntonym text not null";

    public DatabaseHelper(Context context)
    {
        super(context ,DATABASE_NAME , null, DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String query = "DROP TABLE IF EXISTS " +TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);


    }
}
