package me.mahfud.animalproject.gallery

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import me.mahfud.animalproject.R

class GalleryAdapter(val paths: List<String>) : RecyclerView.Adapter<GalleryHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_image_single, parent, false)

        return GalleryHolder(view)
    }

    override fun getItemCount(): Int = paths.size

    override fun onBindViewHolder(galleryHolder: GalleryHolder, position: Int) {
        galleryHolder.bind(paths[position])
    }
}