package com.covid91.tranzo.ui.base

import android.content.Context
import android.location.LocationManager
import androidx.appcompat.app.AlertDialog
import com.covid91.tranzo.base.Constants


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
        alertDialog.setTitle(Constants.GPSsettings)

        // Setting Dialog Message
        alertDialog.setMessage(Constants.GPSnotenabled)

        // On pressing Settings button
        alertDialog.setPositiveButton(Constants.OK) { dialog, which ->
            dialog.cancel()
        }
        // on pressing cancel button
       // alertDialog.setNegativeButton("Cancel") { dialog, which ->

           // dialog.cancel()
      //  }
        // Showing Alert Message
        alertDialog.show()
    }


    fun canGetLocation(context: Context): Boolean {
        var flag = false
        val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        val isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
        if (isGPSEnabled && isNetworkEnabled) {
            flag = true
        }
        return flag
    }












}