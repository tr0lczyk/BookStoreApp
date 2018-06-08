package com.example.android.bookstoreapp.data;

import android.provider.BaseColumns;

public final class BookContract {

    private BookContract(){}

    public static final class BookEntry implements BaseColumns{

        public static final String TABLE_NAME =  "books";

        public static final String _ID = BaseColumns._ID;

        public static final String PRODUCT_NAME = "name";
        public static final String PRODUCT_PRICE = "price";
        public static final String PRODUCT_QUANTITY = "quantity";
        public static final String PRODUCT_SUPPLIER_NAME = "supname";
        public static final String PRODUCT_SUPPLIER_PHONE_NUMBER = "supnumber";


    }
}
