package com.jovannypcg.daggerusage.repository.schema;

import android.app.Application;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jovannypcg.daggerusage.model.User;
import com.jovannypcg.daggerusage.repository.helper.DBHelper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Defines the user schema and its methods to save and retrieve data.
 *
 * @version 1.0.
 */
public class UserSchema implements IUserSchema {
    /**
     * The database.
     */
    @Inject
    SQLiteDatabase sqLiteDatabase;

    /**
     * The name of the table.
     */
    public static final String TABLE_NAME = "users";

    /**
     * Column to storage the name of the user.
     */
    public static final String NAME_COLUMN = "_name";

    /**
     * Column to storage the age of the user.
     */
    public static final String AGE_COLUMN = "_age";

    /**
     * Column to storage the email of the user.
     */
    public static final String EMAIL_COLUMN = "_email";

    /**
     * Set of columns that is needed when retrieving
     * information from the database.
     *
     * Take a look at the <i>getAllUsers</i> method.
     */
    private static final String [] COLUMNS = {
            NAME_COLUMN,
            AGE_COLUMN,
            EMAIL_COLUMN
    };

    /**
     * DDL string that creates the user table.
     */
    public static final String CREATE_USER_TABLE =
              "CREATE TABLE " + TABLE_NAME + " ( "
            + DBHelper.ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAME_COLUMN + " TEXT NOT NULL, "
            + AGE_COLUMN + " INTEGER NOT NULL, "
            + EMAIL_COLUMN + " TEXT NOT NULL)";

    /**
     * Constructor.
     * Requires the application references to get the app component
     * and inject the dependencies of this class.
     *
     * @param app The application which contains the di component.
     */
    public UserSchema(Application app) {
        ((com.jovannypcg.daggerusage.Application) app).getComponent().inject(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean insertUser(User user) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(NAME_COLUMN, user.getName());
        contentValues.put(AGE_COLUMN, user.getAge());
        contentValues.put(EMAIL_COLUMN, user.getEmail());

        long id = sqLiteDatabase.insert(UserSchema.TABLE_NAME, null, contentValues);

        return id >= 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> getAllUsers() {
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME, COLUMNS, null, null, null, null, null);
        List<User> users = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                User user = new User();

                user.setName(cursor.getString(0));
                user.setAge(cursor.getInt(1));
                user.setEmail(cursor.getString(2));

                users.add(user);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return users;
    }
}
