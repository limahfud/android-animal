package me.mahfud.animalproject.list

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_list_animal.*
import me.mahfud.animalproject.Animal
import me.mahfud.animalproject.DBHandler
import me.mahfud.animalproject.R

class ListAnimalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_animal)

        val adapter = AnimalAdapter(getList())
        rvListAnimal.layoutManager = LinearLayoutManager(this)
        rvListAnimal.adapter = adapter
    }

    private fun getList() : List<Animal> {
        val dbHandler = DBHandler(this, null)

        val db = dbHandler.readableDatabase

        val cursor = db.rawQuery("SELECT * FROM ${DBHandler.TABLE_ANIMAL}", null)

        val listAnimal = mutableListOf<Animal>()

        if (cursor.moveToFirst()) {

            val name = cursor.getString(1)
            val species = cursor.getString(2)
            val genus = cursor.getString(3)
            val isOnWater = cursor.getInt(4)
            val lifespan = cursor.getInt(5)

            val animal = Animal(name, species, genus, isOnWater == 1, lifespan)

            listAnimal.add(animal)

            while (cursor.moveToNext()) {
                val name = cursor.getString(1)
                val species = cursor.getString(2)
                val genus = cursor.getString(3)
                val isOnWater = cursor.getInt(4)
                val lifespan = cursor.getInt(5)

                val animal = Animal(name, species, genus, isOnWater == 1, lifespan)

                listAnimal.add(animal)
            }

            cursor.close()
        }

        db.close()

        return listAnimal
    }
}
