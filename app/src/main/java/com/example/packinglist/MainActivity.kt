package com.example.packinglist

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import kotlin.system.exitProcess


class MainActivity : AppCompatActivity() {

    private val item = mutableListOf<String>()
    private val category = mutableListOf<String>()
    private val quantity = mutableListOf<Int>()
    private val comments = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val addButton: Button = findViewById(R.id.addButton)
        val viewButton: Button = findViewById(R.id.viewButton)
        val exitButton: Button = findViewById(R.id.exitButton)

        addButton.setOnClickListener {
            showAddItemDialog()
        }

        viewButton.setOnClickListener {
            if (item.isNotEmpty()) {
                val intent = Intent(this, PackingList::class.java)
                intent.putStringArrayListExtra("item", ArrayList(item))
                intent.putStringArrayListExtra("category", ArrayList(category))
                intent.putIntegerArrayListExtra("quantity", ArrayList(quantity))
                intent.putStringArrayListExtra("comments", ArrayList(comments))
                startActivity(intent)
            } else {
                Snackbar.make(viewButton, "Packing list is empty. Add items first.", Snackbar.LENGTH_SHORT).show()
            }
        }

        exitButton.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }
    }

    private fun showAddItemDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Add New Item")

        val view = layoutInflater.inflate(R.layout.activity_dialog_add_item, null)
        val itemNameEditText: EditText = view.findViewById(R.id.itemNameEditText)
        val categoryEditText: EditText = view.findViewById(R.id.categoryEditText)
        val quantityEditText: EditText = view.findViewById(R.id.quantityEditText)
        val commentsEditText: EditText = view.findViewById(R.id.commentsEditText)

        builder.setView(view)

        builder.setPositiveButton("Add") { dialog, _ ->
            val itemName = itemNameEditText.text.toString().trim()
            val category = categoryEditText.text.toString().trim()
            val quantityStr = quantityEditText.text.toString().trim()
            val comments = commentsEditText.text.toString().trim()

            if (itemName.isEmpty() || category.isEmpty() || quantityStr.isEmpty()) {
                Snackbar.make(findViewById(android.R.id.content), "Item name, category, and quantity cannot be empty.", Snackbar.LENGTH_SHORT).show()
                return@setPositiveButton
            }

            val quantity = quantityStr.toIntOrNull()
            if (quantity == null || quantity <= 0) {
                Snackbar.make(findViewById(android.R.id.content), "Invalid quantity. Please enter a number greater than zero.", Snackbar.LENGTH_SHORT).show()
                return@setPositiveButton
            }

            item.add(itemName)
            this.category.add(category)
            this.quantity.add(quantity)
            this.comments.add(comments)

            Snackbar.make(findViewById(android.R.id.content), "$itemName added to the packing list.", Snackbar.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.cancel()
        }

        builder.show()
    }
}