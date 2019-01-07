package me.mahfud.animalproject

import android.content.ContentValues
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        btnSave.setOnClickListener {
            val animal = Animal(
                    name = etAnimalName.text.toString(),
                    genus = etAnimalGenus.text.toString(),
                    species = etAnimalSpecies.text.toString(),
                    lifespan = etAnimalLifespan.text.toString().toInt(),
                    isOnWater = switchOnWater.isChecked
            )

            saveAnimal(animal)
        }
    }

    private fun saveAnimal(animal: Animal) {

        val dbHandler = DBHandler(this, null)

        val db = dbHandler.writableDatabase
        val newAnimalValue = ContentValues()

        newAnimalValue.put(DBHandler.COLUMN_ANIMAL_NAME, animal.name)
        newAnimalValue.put(DBHandler.COLUMN_ANIMAL_GENUS, animal.genus)
        newAnimalValue.put(DBHandler.COLUMN_ANIMAL_SPECIES, animal.species)
        newAnimalValue.put(DBHandler.COLUMN_ANIMAL_IS_ON_WATER, if (animal.isOnWater) 1 else 0)
        newAnimalValue.put(DBHandler.COLUMN_ANIMAL_LIFESPAN, animal.lifespan)

        db.insert(DBHandler.TABLE_ANIMAL,null,  newAnimalValue)
        db.close()
    }
}
