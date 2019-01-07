package me.mahfud.animalproject.list

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.layout_item_animal.view.*
import me.mahfud.animalproject.Animal

class AnimalHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    @SuppressLint("SetTextI18n")
    fun bind(animal: Animal) {

        itemView.tvAnimal.text = "Name : ${animal.name} \n Genus : ${animal.genus} \n Species : ${animal.species} \n Lifespan : ${animal.lifespan}"

    }

}