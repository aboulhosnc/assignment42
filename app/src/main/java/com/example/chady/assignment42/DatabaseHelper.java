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
    private static final String TABLE_NAME = "antonymTable";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_USER_WORD = "userWord";
    private static final String COLUMN_USER_ANTONYM = "userAntonym";

    SQLiteDatabase db;

    private static final String TABLE_CREATE = "create table antonymTable (id integer primary key not null  , " +
            "userWord text not null , userAntonym text not null);";

    //constructor
    public DatabaseHelper(Context context)
    {
        super(context ,DATABASE_NAME , null, DATABASE_VERSION );
    }

    @Override

    //creates database
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;

    }

    // method to insert user word and antonym to database

    public void insertAntonym(AntonymList a)

    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query ="select * from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        int count = cursor.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_USER_WORD, a.getUserWord());
        values.put(COLUMN_USER_ANTONYM, a.getUserAntonym());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }


    public String searchUserWord(String userWord )
    {
        db = this.getReadableDatabase();
        String query ="select userWord, userAntonym from  " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String userDatabase;
        String antonymDatabase;

        // default result if no pair is there
        String result = userWord + " antonym not Found";

        if(cursor.moveToFirst())
        {
            do{
                userDatabase = cursor.getString(0);
                antonymDatabase = cursor.getString(1);

                if(userDatabase.equals(userWord))
                {

                    result = "The word you input was " + userWord
                            + "\n \n The antonym is " + cursor.getString(1);
                    break;
                }
            }while(cursor.moveToNext());

        }
        return result;
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS " +TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);


    }
}
