package com.example.android.bookstoreapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.android.bookstoreapp.data.BookContract.BookEntry;
import com.example.android.bookstoreapp.data.BookDbHelper;

public class MainActivity extends AppCompatActivity {

    private BookDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void InsertData(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(BookEntry.PRODUCT_NAME, "Moby Dick");
        values.put(BookEntry.PRODUCT_PRICE, "$ 12");
        values.put(BookEntry.PRODUCT_QUANTITY, 5);
        values.put(BookEntry.PRODUCT_SUPPLIER_NAME, "Book Media");
        values.put(BookEntry.PRODUCT_SUPPLIER_PHONE_NUMBER, 123456789);

        long newRowId = db.insert(BookEntry.TABLE_NAME,null,values);
        Log.v("MainActivity", "New Row Id "+ newRowId);
    }

    private Cursor queryData(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                BookEntry._ID,
                BookEntry.PRODUCT_NAME,
                BookEntry.PRODUCT_PRICE,
                BookEntry.PRODUCT_QUANTITY,
                BookEntry.PRODUCT_SUPPLIER_NAME,
                BookEntry.PRODUCT_SUPPLIER_PHONE_NUMBER
        };

        Cursor cursor = db.query(BookEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);

        TextView displayView = findViewById(R.id.displayView);

        try{
            displayView.setText("The books table contains " + cursor.getCount() + " books.\n\n");
            displayView.append(BookEntry._ID + " - " +
                    BookEntry.PRODUCT_NAME + " - " +
                    BookEntry.PRODUCT_PRICE + " - " +
                    BookEntry.PRODUCT_QUANTITY + " - " +
                    BookEntry.PRODUCT_SUPPLIER_NAME + " - " +
                    BookEntry.PRODUCT_SUPPLIER_PHONE_NUMBER + "\n");

            int idColumnIndex = cursor.getColumnIndex(BookEntry._ID);
            int nameColumnIndex = cursor.getColumnIndex(BookEntry.PRODUCT_NAME);
            int priceColumnIndex = cursor.getColumnIndex(BookEntry.PRODUCT_PRICE);
            int quantityColumnIndex = cursor.getColumnIndex(BookEntry.PRODUCT_QUANTITY);
            int supnameColumnIndex = cursor.getColumnIndex(BookEntry.PRODUCT_SUPPLIER_NAME);
            int supnumberColumnIndex = cursor.getColumnIndex(BookEntry.PRODUCT_SUPPLIER_PHONE_NUMBER);

            while(cursor.moveToNext()){
                int currentID = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(nameColumnIndex);
                String currentPrice = cursor.getString(priceColumnIndex);
                int currentQuantity = cursor.getInt(quantityColumnIndex);
                String currentSupName = cursor.getString(supnameColumnIndex);
                int currentSupNumber = cursor.getInt(supnumberColumnIndex);

                displayView.append(("\n" + currentID + " - " +
                        currentName + " - " +
                        currentPrice + " - " +
                        currentQuantity + " - " +
                        currentSupName + " - " +
                        currentSupNumber));
            }
        } finally {
            cursor.close();
        }
        return cursor;
    }
}
