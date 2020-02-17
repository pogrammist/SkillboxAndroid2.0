package com.example.android127list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

const val EXTRA_TYPE_PRODUCT = "com.example.android127list.EXTRA_TYPE_PRODUCT"

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list_view.setOnItemClickListener { parent, _, position, _ ->
            val intent = Intent(this, ProductsActivity::class.java)
            val typeProduct = parent.getItemAtPosition(position).toString()
            intent.putExtra(EXTRA_TYPE_PRODUCT, typeProduct)
            startActivity(intent)
        }
    }
}
