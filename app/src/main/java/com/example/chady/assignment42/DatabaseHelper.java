package com.example.chady.assignment42;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    public void insertAntonym(AntonymList c)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_USER_WORD, c.getUserWord());
        values.put(COLUMN_USER_ANTONYM, c.getUserAntonym());

        db.insert(TABLE_NAME, null, values);
    }


    public String searchUserWord(String userWord )
    {
        db = this.getReadableDatabase();
        String query ="select userWord from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String userDatabase;

        if(cursor.moveToFirst())
        {
            do{
                userDatabase = cursor.getString(0);
                if(userDatabase.equals(userWord))
                {

                }
            }
            while{}
        }
    }

    public String findAntonym(String userWord )
    {
        db = this.getReadableDatabase();
        String query = "select userWord, userAntonym from "+ TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String userDatabase, antonymDatabase;
        antonymDatabase = "not found";

        if(cursor.moveToFirst())
        {
            do{
                userDatabase = cursor.getString(0);

                // if the userWord entered matches userWord in the database
                // move
                if(userDatabase.equals(userWord))
                {
                    antonymDatabase = cursor.getString(1);
                }
            }while (cursor.moveToNext());
        }
        return antonymDatabase;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS " +TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);


    }
}
