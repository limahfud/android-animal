package me.mahfud.animalproject.gallery

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_gallery.*
import kotlinx.android.synthetic.main.activity_gallery.view.*
import kotlinx.android.synthetic.main.layout_item_image_single.view.*

class GalleryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind (path: String) {
        Glide.with(itemView.context).load(path).into(itemView.ivGridGallery)
    }

}