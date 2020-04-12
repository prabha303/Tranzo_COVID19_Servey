package com.covid91.tranzo.base.sharedpreference

import android.content.Context
import android.content.SharedPreferences
import com.covid91.tranzo.R

/**
 * This class handles the all the shared preference operation.
 * .i.e., creating shared preference and to set and get value.
 *
 */
object SharedPref {
    private var preference: SharedPreferences? = null
    //Single Single ton objects...
    private var sharedPref: SharedPref? = null
    //Single ton method for this class...

    /**
     * Set the String value in the shared preference with the given key.
     *
     * @param context
     * @param key
     * @param value
     */
    @JvmStatic
    fun setSharedValue(context: Context, key: String?, value: String?) {
        getPreferenceInstance(context)
        val editor = preference!!.edit()
        editor.putString(key, value)
        //\22Apr16. Harish.Calling 'apply' instead 'commit' since it is faster and not a blocking call.
        editor.apply()
        //editor.commit();
    }

    fun setSharedListValues(context: Context, key: String?, values: Set<String?>?) {
        getPreferenceInstance(context)
        val editor = preference!!.edit()
        editor.putStringSet(key, values)
        editor.commit()
    }

    /**
     * Set the Integer value in the shared preference with the given key.
     *
     * @param context
     * @param key
     * @param value
     */
    @JvmStatic
    fun setSharedValue(context: Context, key: String?, value: Int) {
        getPreferenceInstance(context)
        val editor = preference!!.edit()
        editor.putInt(key, value)
        //\22Apr16. Harish.Calling 'apply' instead 'commit' since it is faster and not a blocking call.
        editor.apply()
        //editor.commit();
    }

    /**
     * Set the boolean value in the shared preference with the given key.
     *
     * @param context
     * @param key
     * @param value
     */
    @JvmStatic
    fun setSharedValue(context: Context?, key: String?, value: Boolean?) {
        context.let {

        }
        if (context != null) {
            getPreferenceInstance(context)
        }
        val editor = preference!!.edit()
        editor.putBoolean(key, value!!)
        //\22Apr16. Harish.Calling 'apply' instead 'commit' since it is faster and not a blocking call.
        editor.apply()
        //editor.commit();
    }
    @JvmStatic
    fun setSharedValue(context: Context, key: String?, value: Long?) {
        getPreferenceInstance(context)
        val editor = preference!!.edit()
        editor.putLong(key, value!!)
        //\22Apr16. Harish.Calling 'apply' instead 'commit' since it is faster and not a blocking call.
        editor.apply()
        //editor.commit();
    }

    /**
     * Get Integer value for the given key.
     *
     * @param context
     * @param key
     * @return Int
     */
    @JvmStatic
    fun getIntValue(context: Context, key: String?): Int {
        return getPreferenceInstance(context)!!.getInt(key, 0)
    }



        private fun getPreferenceInstance(context: Context): SharedPreferences? {
            return if (preference != null) {
                preference
            } else {
                preference = context.getSharedPreferences(context.resources.getString(R.string.preference_name), Context.MODE_PRIVATE)
                preference
            }
        }
    @JvmStatic
        fun getLongValue(context: Context?, key: String?): Long {
            return if(context!=null)
                getPreferenceInstance(context)!!.getLong(key, 0L)
            else 0L
        }

        fun getStringListValue(context: Context, key: String?): Set<String>? {
            return getPreferenceInstance(context)!!.getStringSet(key, null)
        }

        /**
         * Get Boolean value for the given key.
         *
         * @param context
         * @param key
         * @return Boolean
         */
        @JvmStatic
        fun getBooleanValue(context: Context?, key: String?): Boolean {
            return if(context!=null)
             getPreferenceInstance(context)!!.getBoolean(key, false)
            else
                false
        }

        /**
         * Get String value for the given key.
         *
         * @param context
         * @param key
         * @return String
         */
        @JvmStatic
        fun getStringValue(context: Context?, key: String?): String? {
            return if(context!=null)
             getPreferenceInstance(context)!!.getString(key, null)
            else
            return null
        }

}