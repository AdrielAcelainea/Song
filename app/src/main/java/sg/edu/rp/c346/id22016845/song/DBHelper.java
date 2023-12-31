package sg.edu.rp.c346.id22016845.song;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;


public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VER=1;
    private static final String DATABASE_NAME="Songs.db";
    private static final String TABLE_TASK="Song";

    private static final String COLUMN_ID="_id";
    private static final String COLUMN_TITLE="title";
    private static final String COLUMN_SINGERS="singers";
    private static final String COLUMN_YEAR="year";
    private static final String COLUMN_STARS="stars";
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSql="CREATE TABLE "+ TABLE_TASK+ "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_TITLE + " TEXT,"
                + COLUMN_SINGERS + " TEXT,"
                + COLUMN_YEAR + " INTEGER,"
                + COLUMN_STARS + " INTEGER )";

        db.execSQL(createTableSql);
        Log.i("info","created tables");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASK);
        onCreate(db);
    }
    public void insertSong(String title, String singers, int year, int stars){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(COLUMN_TITLE,title);
        values.put(COLUMN_SINGERS,singers);
        values.put(COLUMN_YEAR,year);
        values.put(COLUMN_STARS,stars);
        db.insert(TABLE_TASK,null,values);
        db.close();
    }
    public ArrayList<String> getSongContent(){
        ArrayList<String> songs = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[]columns={COLUMN_ID,COLUMN_TITLE,COLUMN_SINGERS,COLUMN_YEAR,COLUMN_STARS};
        Cursor cursor=db.query(TABLE_TASK,columns,null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                int id=cursor.getInt(0);
                String title=cursor.getString(1);
                String singers= cursor.getString(2);
                int year=cursor.getInt(3);
                int stars=cursor.getInt(4);
                Song obj = new Song(id, title, singers, year,stars);
                songs.add(String.valueOf(obj));
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return songs;
    }


}
