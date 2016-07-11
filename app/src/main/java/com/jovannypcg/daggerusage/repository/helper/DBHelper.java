package com.jovannypcg.daggerusage.repository.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.jovannypcg.daggerusage.repository.schema.UserSchema;

/**
 * Creates and upgrades the database.
 *
 * This class also includes common column identifiers which
 * can be used in many schemas.
 *
 */
public class DBHelper extends SQLiteOpenHelper {
    /**
     * Name of the database.
     */
    private static final String DB_NAME = "database.db";

    /**
     * Version of the database.
     */
    private static final int DB_VERSION = 1;

    /**
     * Common column identifier for '_id'.
     */
    public static final String ID_COLUMN = "_id";

    /**
     * Constructor.
     *
     * @param context The context in which the database is available.
     */
    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(UserSchema.CREATE_USER_TABLE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + UserSchema.TABLE_NAME);

        onCreate(sqLiteDatabase);
    }
}
