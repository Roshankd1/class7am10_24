package com.roshank.class7am10_24;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by roshank on 09/11/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    static String name = "class7am10_24";
    static int version = 1;

String sqlCreatTableUser = "CREATE TABLE if not exists`createaccount` (\n" +
        "\" +\n" +
        "            \"\\t`Title`\\tINTEGER PRIMARY KEY AUTOINCREMENT,\\n\" +\n" +
        "            \"\\t`Firstname`\\tTEXT,\\n\" +\n" +
        "            \"\\t`Lastname`\\tTEXT,\\n\" +\n" +
        "            \"\\t`Email`\\tTEXT,\\n\" +\n" +
        "            \"\\t`HomePhone`\\tNUMERIC,\\n\" +\n" +
        "            \"\\t`MobilePhone`\\tNUMERIC,\\n\" +\n" +
        "            \"\\t`Image`\\tBLOB,\\n\" +\n" +
        "            \"\\t`Password`\\tTEXT,\\n\" +\n" +
        "            \"\\t`PasswordConfirmation`\\tTEXT\\n\" +\n" +
        "            \")";

    public DatabaseHelper(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
getWritableDatabase().execSQL(sqlCreatTableUser);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
