package com.covid91.tranzo.ui.base

import android.content.Context
import androidx.appcompat.app.AlertDialog


object DialogUtil {


    interface ConfirmCallBack {
        fun confirmed(success: Boolean)
    }

    fun showAlertDialogOnlyOk(context: Context, cancelFlag : Boolean, title : String, message : String,  pasitiveButton : String, confirmCallBack: ConfirmCallBack?)
    {
        val dialogBuilder = AlertDialog.Builder(context)
        dialogBuilder.setMessage(message)
                // if the dialog is cancelable
                .setCancelable(cancelFlag)
                // positive button text and action
                .setPositiveButton(pasitiveButton) { dialog, id ->
                    dialog.cancel()
                    confirmCallBack?.confirmed(true)
                }
        // negative button text and action
                //.setNegativeButton(cancelButton, DialogInterface.OnClickListener { dialog, id -> dialog.cancel() })
        // create dialog box
        val alert = dialogBuilder.create()
        // set title for alert dialog box
        alert.setTitle(title)
        // show alert dialog
        alert.show()
    }


    fun showSettingsAlert(mContext: Context) {
        val alertDialog = android.app.AlertDialog.Builder(mContext)

        // Setting Dialog Title
        alertDialog.setTitle("GPS settings")

        // Setting Dialog Message
        alertDialog.setMessage("GPS is not enabled. Please enable the location")

        // On pressing Settings button
        alertDialog.setPositiveButton("OK") { dialog, which ->
            dialog.cancel()
        }
        // on pressing cancel button
       // alertDialog.setNegativeButton("Cancel") { dialog, which ->

           // dialog.cancel()
      //  }
        // Showing Alert Message
        alertDialog.show()
    }















}