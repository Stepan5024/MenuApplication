package com.example.menuapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListPopupWindow
import androidx.annotation.MenuRes
import androidx.appcompat.widget.PopupMenu
import androidx.core.content.ContentProviderCompat.requireContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*val button = findViewById<Button>(R.id.button)
        button.setOnClickListener { v: View ->
            showMenu(v, R.menu.popup_menu)
        }

         */

        val listPopupWindowButton = findViewById<Button>(R.id.button)
        val listPopupWindow = ListPopupWindow(this, null, androidx.transition.R.attr.listPopupWindowStyle)

// Set button as the list popup's anchor
        listPopupWindow.anchorView = listPopupWindowButton

// Set list popup's content
        val items = listOf("Item 1", "Item 2", "Item 3", "Item 4")
        val adapter = ArrayAdapter(this, R.layout.list_popup_window_item, items)
        listPopupWindow.setAdapter(adapter)

// Set list popup's item click listener
        listPopupWindow.setOnItemClickListener { parent: AdapterView<*>?, view: View?, position: Int, id: Long ->
            // Respond to list popup window item click.

            // Dismiss popup.
            listPopupWindow.dismiss()
        }

// Show list popup window on button click.
        listPopupWindowButton.setOnClickListener { v: View? -> listPopupWindow.show() }


    }
    private fun showMenu(v: View, @MenuRes menuRes: Int) {
        val popup = PopupMenu(this, v)
        popup.menuInflater.inflate(menuRes, popup.menu)

        popup.setOnMenuItemClickListener { menuItem: MenuItem ->
            // Respond to menu item click.
           true
        }
        popup.setOnDismissListener {
            // Respond to popup being dismissed.
        }
        // Show the popup menu.
        popup.show()
    }
}