package com.android.practice.practice.dialog

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.android.practice.practice.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_alert_dialog.*
import java.util.*
import kotlin.collections.ArrayList

class CustomAlertDialog : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)

        btSimpleAlert.setOnClickListener {
            showSimpleAlert()
        }
        btListOfItems.setOnClickListener {
            showListAlert()
        }
        btMultipleChoices.setOnClickListener {
            showMultipleChoicesAlert()
        }
        btCustomLayout.setOnClickListener {
            showCustomAlert()
        }
        btContainsEditText.setOnClickListener {
            showEditTextAlert()
        }
        btBottomSheetDialog.setOnClickListener {
//            showBottomSheetDialog()
            val btnSheet = layoutInflater.inflate(R.layout.bottom_sheet, null)

            val dialog = BottomSheetDialog(this)
            dialog.setContentView(btnSheet)

            btnSheet.setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()

        }
    }

    private fun showSimpleAlert() {
        AlertDialog.Builder(this)
            .setTitle("Simple Alert")
            .setMessage("This is a simple alert dialog")
            .setPositiveButton("OK") { dialog, which ->
                Toast.makeText(applicationContext, "OK is pressed", Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("Cancel") { dialog, which ->
                Toast.makeText(applicationContext, "Cancel is pressed", Toast.LENGTH_LONG).show()
            }
            .setNeutralButton("Neutral") { _, _ ->
                Toast.makeText(applicationContext, "Neutral is pressed", Toast.LENGTH_LONG).show()
            }
            .show()
    }

    private fun showListAlert() {
        val items = arrayOf("Bird", "Cat", "Dog", "Fish", "Chicken")
        AlertDialog.Builder(this)
            .setTitle("List of Pets Dialog")
            .setItems(items) { _, which ->
                Toast.makeText(applicationContext, "${items[which]} is pressed", Toast.LENGTH_LONG)
                    .show()
            }
            .setNegativeButton("Cancel") { dialog, which ->
                Toast.makeText(applicationContext, "Cancel is pressed", Toast.LENGTH_LONG).show()
            }
            .show()
    }

    private fun showMultipleChoicesAlert() {
        val selectedList = ArrayList<Int>()
        val items = arrayOf("Bird", "Cat", "Dog", "Fish", "Chicken")
        AlertDialog.Builder(this)
            .setTitle("Multiple Choices Dialog")
            .setMultiChoiceItems(items, null) { dialog, which, isChecked ->
                if (isChecked) {
                    selectedList.add(which)
                } else if (selectedList.contains(which)) {
                    selectedList.remove(which)
                }
            }
            .setPositiveButton("OK") { dialog, which ->
                val selectedItems = ArrayList<String>()
                for (i in selectedList.indices) {
                    selectedItems.add(items[selectedList[i]])
                }
                Toast.makeText(
                    applicationContext,
                    "Selected items: " + Arrays.toString(selectedItems.toArray()),
                    Toast.LENGTH_SHORT
                ).show();
            }
            .show()
    }

    private fun showCustomAlert() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_custom_layout, null)

        val customDialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .show()

        val btnDismiss = dialogView.findViewById<Button>(R.id.btDismissCustomDialog)
        btnDismiss.setOnClickListener {
            customDialog.dismiss()
        }
    }

    private fun showEditTextAlert() {
        val editText = EditText(this)
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        editText.layoutParams = layoutParams

        AlertDialog.Builder(this)
            .setTitle("EditText Alert")
            .setMessage("Please input your name..")
            .setView(editText)
            .setPositiveButton("OK") { dialog, which ->
                Toast.makeText(
                    applicationContext, "Your name is ${editText.text}",
                    Toast.LENGTH_LONG
                ).show()
            }
            .setNegativeButton("Cancel") { dialog, which ->
                Toast.makeText(applicationContext, "Cancel is pressed", Toast.LENGTH_LONG).show()
            }
            .show()
    }

    private fun showBottomSheetDialog() {
        val btnSheet = layoutInflater.inflate(R.layout.bottom_sheet, null)

        val dialog = BottomSheetDialog((applicationContext))
        dialog.setContentView(btnSheet)

        btnSheet.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
}