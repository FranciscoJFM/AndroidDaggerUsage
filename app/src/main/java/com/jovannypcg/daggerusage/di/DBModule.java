package com.jovannypcg.daggerusage.di;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.jovannypcg.daggerusage.repository.helper.DBHelper;
import com.jovannypcg.daggerusage.repository.schema.IUserSchema;
import com.jovannypcg.daggerusage.repository.schema.UserSchema;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Provides methods to inject the database-related objects.
 * @version 1.0.
 */
@Module
public class DBModule {
    /**
     * The context in which the database is available.
     */
    private Context context;

    /**
     * The application reference to successfully create the UserSchema
     * dependency.
     */
    private Application application;

    /**
     * Constructor.
     *
     * @param app The context in which the database is available.
     * @param context The application reference to successfully create the UserSchema dependency.
     */
    public DBModule(Application app, Context context) {
        this.context = context;
        this.application = app;
    }

    /**
     * Provides a SQLiteDatabaseOpenHelper.
     * @return The SQLiteDatabaseOpenHelper which provides the schemas of this app.
     */
    @Provides
    @Singleton
    public DBHelper provideDbHelper() {
        return new DBHelper(this.context);
    }

    /**
     * Provides the database.
     * @param dbHelper The SQLiteDatabaseOpenHelper.
     * @return The database.
     */
    @Provides
    @Singleton
    public SQLiteDatabase provideSqliteDatabase(DBHelper dbHelper) {
        return dbHelper.getWritableDatabase();
    }

    /**
     * Provides the userschema which handles database operations regarding users.
     * @return The userschema which handles database operations regarding users.
     */
    @Provides
    @Singleton
    public IUserSchema provideUserSchema() {
        return new UserSchema(application);
    }
}
