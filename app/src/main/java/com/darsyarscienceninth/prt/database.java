package com.darsyarscienceninth.prt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {
    private static final String databasename = "user.db";
    private static final int version = 1;
    public database(Context context) {
        super(context, databasename, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String cQuery = "CREATE TABLE " + "user_info" + " ( " + "ID" + " INTEGER PRIMARY KEY, " + "name" + " TEXT);";
        db.execSQL(cQuery);
        Log.i("Mahdi", "Table Created!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insertPerson(Person iprs) {

        SQLiteDatabase idb = this.getWritableDatabase();
        ContentValues icv = new ContentValues();
        icv.put("ID", iprs.pID);
        icv.put("name", iprs.pName);
        idb.insert("user_info", null, icv);
        idb.close();
        Log.i("Mahdi", "insertPerson Method");
    }
    public Person getPerson(String gID) {

        Person gPrs = new Person();
        SQLiteDatabase gdb = this.getReadableDatabase();
        String gQuery = "SELECT * FROM " + "user_info" + " WHERE " + "ID" + "=" + gID;
        Cursor gCur = gdb.rawQuery(gQuery, null);
        if (gCur.moveToFirst()) {
            gPrs.pName = gCur.getString(1);
        }
        Log.i("Mahdi", "getPerson Method");
        return gPrs;

    }

    public void updatePerson(Person uprs) {

        SQLiteDatabase udb = this.getWritableDatabase();
        ContentValues ucv = new ContentValues();
        ucv.put("name", uprs.pName);
        udb.update("user_info", ucv, "ID" + " = ?", new String[] {String.valueOf(uprs.pID)});
        Log.i("Mahdi", "updatePerson Method");

    }

    public int personCount() {

        String gQuery = "SELECT * FROM " + "user_info";
        SQLiteDatabase gdb = this.getReadableDatabase();
        Cursor gCur = gdb.rawQuery(gQuery, null);
        int cResult = gCur.getCount();
        return cResult;

    }
}
