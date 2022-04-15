package com.rulhouse.tileservicepractice

import android.R
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.service.quicksettings.TileService
import androidx.annotation.RequiresApi


@RequiresApi(Build.VERSION_CODES.N)
class MyQSTileService : TileService() {
    override fun onClick() {
        super.onClick()

        val dialog: AlertDialog = AlertDialog.Builder(this)
            .setIcon(R.drawable.sym_def_app_icon)
            .setTitle("Mr.Title")
            .setMessage("Mr.Content")
            .setNegativeButton(
                "Mr.Cancel",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    dialogInterface.dismiss()
                }
            )
            .setNeutralButton(
                "Third button",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    val dialogIntent = Intent(this, SecondActivity::class.java)
                    dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(dialogIntent)
                }
            )
            .setPositiveButton(
                "Mr.Done",
                DialogInterface.OnClickListener { dialog, which ->
                    val dialogIntent = Intent(this, MainActivity::class.java)
                    dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(dialogIntent)

                    dialog.dismiss()
                }
            ).create()

        showDialog(dialog)
    }
}