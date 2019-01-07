package me.mahfud.animalproject.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import me.mahfud.animalproject.Animal
import me.mahfud.animalproject.R

class AnimalAdapter(val animals: List<Animal>) : RecyclerView.Adapter<AnimalHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_animal, parent, false)

        return AnimalHolder(view)
    }

    override fun getItemCount(): Int = animals.size

    override fun onBindViewHolder(animalHolder: AnimalHolder, position: Int) {
        animalHolder.bind(animals[position])
    }
}