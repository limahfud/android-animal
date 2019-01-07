package me.mahfud.animalproject.gallery

import android.Manifest
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.MediaColumns
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_gallery.*
import me.mahfud.animalproject.R


class GalleryActivity : AppCompatActivity(), GalleryAdapter.OnGalleryClicked {


    companion object {
        private const val MY_PERMISSIONS_REQUEST_READ_STORAGE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        askingPermissionToAccessData()
    }

    private fun askingPermissionToAccessData() {
        if (ContextCompat.checkSelfPermission(this,
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                            Manifest.permission.READ_EXTERNAL_STORAGE)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.



                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }

            ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    MY_PERMISSIONS_REQUEST_READ_STORAGE)
        } else {
            displayImages()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
             MY_PERMISSIONS_REQUEST_READ_STORAGE -> {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    displayImages()
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }


        }
    }

    private fun getAllImagesPath(): List<String> {
        val uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(MediaColumns.DATA, MediaStore.Images.Media.BUCKET_DISPLAY_NAME)

        val cursor = contentResolver.query(uri, projection, null, null, null)

        val columnIndexData = cursor.getColumnIndexOrThrow(MediaColumns.DATA)

        val listOfAllImages = ArrayList<String>()
        while (cursor.moveToNext()) {
            val absolutePathOfImage = cursor.getString(columnIndexData)
            listOfAllImages.add(absolutePathOfImage)
        }

        cursor.close()

        return listOfAllImages
    }

    private fun displayImages() {
        val images = getAllImagesPath()

        val adapter = GalleryAdapter(images, this)
        gvGallery.layoutManager = GridLayoutManager(this, 2)
        gvGallery.adapter = adapter
    }

    override fun onClicked(position: Int) {
        Toast.makeText(this, "Di klik nomor $position", Toast.LENGTH_SHORT).show()
    }


}
