package com.example.android127list

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Gravity
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    private val arrayList = mutableListOf<String>()
    private lateinit var arrayAdapter: ArrayAdapter<String>
    private lateinit var typeProduct: String
    private var choisedItemPosition: Int? = null
    private val PREFERENCES = "PREFERENCES_PRODUCTS"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        typeProduct = intent.getStringExtra(EXTRA_TYPE_PRODUCT)
        text_view.text = typeProduct

        val preferencesRestore = getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)
        for (item in 0 until preferencesRestore.getInt(typeProduct + "length", 0)) {
            preferencesRestore.getString(typeProduct + item.toString(), null)
                ?.let { arrayList.add(it) }
        }

        arrayAdapter = ArrayAdapter<String>(
            this, android.R.layout.simple_list_item_single_choice, arrayList
        )
        list_view_products.adapter = arrayAdapter
        list_view_products.setOnItemClickListener { parent, view, position, id ->
            choisedItemPosition = position
        }
    }

    fun onClickButtonAdd(view: View) {
        if (edit_text_products.text.isNotEmpty()) {
            arrayList.add(edit_text_products.text.toString())
            arrayAdapter.notifyDataSetChanged()
            edit_text_products.text = null
        } else {
            val toast = Toast.makeText(this, "Добавьте покупку!", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
        }
    }

    fun onClickButtonRemove(view: View) {
        if (arrayList.isNotEmpty()) {
            choisedItemPosition?.let { arrayList.removeAt(it) }
            arrayAdapter.notifyDataSetChanged()
        } else {
            val toast = Toast.makeText(this, "Список покупок пуст!", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        onSaveData()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        onSaveData()
    }

    private fun onSaveData() {
        val preferencesSave = getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)
        val editor = preferencesSave.edit()
        for (item in 0 until arrayList.size) {
            editor.putString(typeProduct + item.toString(), arrayList[item])
        }
        editor.putInt(typeProduct + "length", arrayList.size)
        editor.apply()
    }
}
