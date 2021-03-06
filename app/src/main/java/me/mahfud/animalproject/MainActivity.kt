package me.mahfud.animalproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.idescout.sql.SqlScoutServer
import kotlinx.android.synthetic.main.activity_main.*
import me.mahfud.animalproject.gallery.GalleryActivity
import me.mahfud.animalproject.list.ListAnimalActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SqlScoutServer.create(this, packageName);

        btnShowAll.setOnClickListener {
            startActivity(Intent(this, ListAnimalActivity::class.java))
        }


        btnAdd.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }
    }
}
