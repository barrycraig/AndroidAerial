package com.moaapps.screensaver

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Button
import android.widget.TextView
import lib.folderpicker.FolderPicker
import pub.devrel.easypermissions.EasyPermissions
import java.io.File

import java.net.URLConnection


class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



//        findViewById<Button>(R.id.select_folder)
//            .setOnClickListener {
////                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
////                    val i = Intent(Intent.ACTION_OPEN_DOCUMENT_TREE)
////                    i.addCategory(Intent.CATEGORY_DEFAULT)
////                    startActivityForResult(Intent.createChooser(i, "Choose directory"), 9999)
////                }
//
//                if(EasyPermissions.hasPermissions(this, Manifest.permission.READ_EXTERNAL_STORAGE)){
//                    val intent = Intent(this, FolderPicker::class.java)
//                    startActivityForResult(intent, 9999)
//                }else{
//                    EasyPermissions.requestPermissions(this, "We need to access storage", 123, Manifest.permission.READ_EXTERNAL_STORAGE)
//                }
//            }


        if(EasyPermissions.hasPermissions(this, Manifest.permission.READ_EXTERNAL_STORAGE)){
            val file = File(Environment.getExternalStorageDirectory(),"Screensaver")
            Log.d("TAG", "onCreate: ${file.absolutePath}")
            findViewById<TextView>(R.id.directory).text = "Selected Folder: ${file.absolutePath}"
            if (file.exists() && file.isDirectory){
                val filesList = ArrayList<File>()
                for (file in file.listFiles()){
                    if (file != null && file.absolutePath.endsWith("mov")){
                        filesList.add(file)
                    }
                }
                findViewById<TextView>(R.id.video_count).text = "${filesList.size} files found in the directory"
            }else{
                findViewById<TextView>(R.id.directory).text = "Folder not found"
            }
        }else{
            EasyPermissions.requestPermissions(this, "We need to access storage", 123, Manifest.permission.READ_EXTERNAL_STORAGE)
        }
        


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 9999 && resultCode == RESULT_OK){
            val folderLocation = data?.extras!!.getString("data")
            Log.d("TAG", "onActivityResult: $folderLocation")
            findViewById<TextView>(R.id.directory).text = folderLocation
        }
    }
}