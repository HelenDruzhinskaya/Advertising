package ru.myitacademy.samsung.advertising

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
var myIntent = Intent("ru.myitacademy.samsung.advertising.POST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.allbtn).setOnClickListener {
            myIntent.putExtra("hot_news", findViewById<EditText>(R.id.advtxt).text.toString())
            //sendBroadcast(intent)
            sendOrderedBroadcast(myIntent,null)}
    }
fun selectPost(view: View){
    sendOrderedBroadcast(myIntent,Manifest.permission.INTERNET)
}
 fun backPost(view:View){
     sendOrderedBroadcast(myIntent,null,
                          MyReceiver(),null,0,"NewPost",
           Bundle().apply{putString("strEx",findViewById<EditText>(R.id.advtxt).text.toString())})
 }
}