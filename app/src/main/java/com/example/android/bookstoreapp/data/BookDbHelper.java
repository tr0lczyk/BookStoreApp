package com.example.android.bookstoreapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.bookstoreapp.data.BookContract.BookEntry;

public final class BookDbHelper extends SQLiteOpenHelper{


    public static final String LOG_TAG = BookDbHelper.class.getSimpleName();
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "shelter.db";

    public BookDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_BOOKS_TABLE = "CREATE TABLE " +
                BookEntry.TABLE_NAME + " (" +
                BookEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                BookEntry.PRODUCT_NAME + " TEXT NOT NULL, " +
                BookEntry.PRODUCT_PRICE + " TEXT NOT NULL, " +
                BookEntry.PRODUCT_QUANTITY + " INTEGER NOT NULL DEFAULT 0, " +
                BookEntry.PRODUCT_SUPPLIER_NAME + " TEXT NOT NULL, " +
                BookEntry.PRODUCT_SUPPLIER_PHONE_NUMBER + " INTEGER NOT NULL);";

        db.execSQL(SQL_CREATE_BOOKS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
