package me.mahfud.animalproject

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.idescout.sql.SqlScoutServer

class DBHandler(context: Context,
                factory: SQLiteDatabase.CursorFactory?) : SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    companion object {

        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "productDB.db"

        const val TABLE_ANIMAL = "animals"

        const val COLUMN_ANIMAL_ID            = "animal_id"
        const val COLUMN_ANIMAL_NAME          = "animal_name"
        const val COLUMN_ANIMAL_GENUS         = "animal_genus"
        const val COLUMN_ANIMAL_SPECIES       = "animal_species"
        const val COLUMN_ANIMAL_IS_ON_WATER   = "animal_is_on_water"
        const val COLUMN_ANIMAL_LIFESPAN      = "animal_lifespan"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createAnimalTableQuery = "CREATE TABLE $TABLE_ANIMAL (" +
                "$COLUMN_ANIMAL_ID          INTEGER PRIMARY KEY," +
                "$COLUMN_ANIMAL_NAME        TEXT," +
                "$COLUMN_ANIMAL_SPECIES     TEXT," +
                "$COLUMN_ANIMAL_GENUS       TEXT," +
                "$COLUMN_ANIMAL_IS_ON_WATER INTEGER," +
                "$COLUMN_ANIMAL_LIFESPAN    INTEGER)"

        db?.execSQL(createAnimalTableQuery);
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun addAnimal(animal: Animal) {

    }


}