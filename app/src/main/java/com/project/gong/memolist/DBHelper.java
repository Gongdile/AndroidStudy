package com.project.gong.memolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyMemos.db";
    public static final String MEMOS_TABLE_NAME = "memos";
    public static final String MOVIES_COLUMN_ID = "id";
    public static final String MEMOS_COLUMN_TITLE = "title";
    public static final String MEMOS_COLUMN_CONTENT = "content";
    public static final String MEMOS_COLUMN_EXPLAIN = "explains";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table memos " +
                        "(id integer primary key,title text, content text, explains text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS memos");
        onCreate(db);
    }

    public boolean insertMemo(String title, String content, String explains) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("title", title);
        contentValues.put("content", content);
        contentValues.put("explains", explains);


        db.insert("memos", null, contentValues);
        return true;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from memos where id=" + id + "", null);
        return res;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, MEMOS_TABLE_NAME);
        return numRows;
    }

    public boolean updateMemo(Integer id, String title, String content, String explains) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("content", content);
        contentValues.put("explains", explains);
        db.update("memos", contentValues, "id = ? ", new String[]{Integer.toString(id)});
        return true;
    }

    public Integer deleteMemo(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("memos",
                "id = ? ",
                new String[]{Integer.toString(id)});
    }

    public ArrayList getAllMemos() {
        ArrayList array_list = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from memos", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            array_list.add(res.getString(res.getColumnIndex(MEMOS_COLUMN_TITLE)));
            res.moveToNext();
        }
        return array_list;
    }


}
