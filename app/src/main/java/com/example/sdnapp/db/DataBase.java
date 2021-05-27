package com.example.sdnapp.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {Repo.class,}, version = 1)
public abstract class DataBase extends RoomDatabase {
    private static final String DB_NAME = "database.db";
    private static volatile DataBase instance;

    // region singleton implementation
    public static synchronized DataBase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static DataBase create(final Context context) {
        Builder<DataBase> builder = Room.databaseBuilder(context, DataBase.class, DB_NAME);
        return builder.build();
    }

    // endregion
    // region DAOs
    public abstract RepoDao repoDao();
}
