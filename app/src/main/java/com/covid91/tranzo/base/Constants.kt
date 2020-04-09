package com.covid91.tranzo.base


object Constants {

    const val DROP_CONTACT = "DROP_CONTACT"
    const val DROP_LATLONG = "DROP_LATLONG"
    const val DROP_LANDMARK = "DROP_LANDMARK"
    const val DROP_ACKID = "DROP_ACKID"
    const val DROP_ADDRESS = "DROP_ADDRESS"
    const val ONTRIP = "ONTRIP"
    const val OFFLINE = "OFFLINE"
    const val AVAILABLE = "AVAILABLE"
    const val DRIVER_STATUS = "DRIVER_STATUS"
    const val TRIP_STATUS = "TRIP_STATUS"
    const val FROM_LOGIN = "FROM_LOGIN"
    const val GEO_RECEIVER = "GEO_RECEIVER"
    const val GEO_ENTER = "GEO_ENTER"
    const val GEO_EXIT = "GEO_EXIT"
    const val GEO_DWELL = "GEO_DWELL"
    const val MESSAGE = "message"
    const val GEOFENCE = "Lynk_Geofence"
    const val MANUAL = "Manual"
    const val AUTO = "Auto"
    const val FLAG_Y = "Y"
    const val FLAG_N = "N"
    const val FALSE = false
    const val TRUE = true
    const val AUTOSTART_BG_MSG = "Your trip is about to start now!"
    const val AUTOSTART_MSG = "Your trip will auto start in "
    const val AUTOSTART_MSG_SECONDS = " seconds."

    const val TRIPNOTIFICATION = "/tripnotification/"
    const val DRIVERNOTIFICATION = "/drivernotification/"
    const val TRACKINGCHANNEL = "TrackingChannel/"
    const val TRACKINGACKCHENNAL = "TrackingAckChannel"
    const val LYNK = "LYNK"
    const val LYNK_FOREGROUND_MSG = "App is running..."
    const val forgroundservice_notification_id = 999
    const val ForgroundService = "fromForgroundService"
    const val Available = "Available"
    const val Offline = "Offline"
    const val LOGIN = "Login"
    const val BUTTONTEXT = "buttonText"
    const val NAVIGATETO = "navigateTo"
    const val TIMERINSEC = "timeInSec"
    const val OFFLINE_ASSIGNMENT_URL = "OFFLINE_ASSIGNMENT_URL"
    const val Request_Submitted = "Request Submitted"
    const val NOGPS = "NO_GPS"



    const val ACK_RESPONSE = "ack_response"
    const val DATA_WS = "data"
    const val TOKEN = "token"
    const val ACK = "ack"
    const val ACKID = "ACKID"
    const val ACCEPTED = "Accepted"
    const val STARTED = "Started"
    const val ARRIVED = "Arrived"
    const val END = "Ended"


    // Intent extras
    const val IMAGE_URI_LIST = "IMAGE_URI_LIST"
    const val IMAGE_PATH_LIST = "IMAGE_PATH_LIST"
    const val ORDER_ID = "order_id"
    const val DRIVER_ID = "driver_id"
    const val TRIP_ID = "trip_id"
    const val JOURNEY_ID = "journey_id"
    const val DROP_ORDER = "drop_order"
    const val DATA = "screenData"
    const val EXTRA_CUSTOMER_ID = "customer_id"
    const val EXTRA_CUSTOMER_MOBILE = "customer_mobile"
    const val EXTRA_TRIP_ID = "trip_id"
    const val EXTRA_RATING = "trip_rating"
    const val EXTRA_JOURNEY_ID = "EXTRA_JOURNEY_ID"
    const val EXTRA_IS_DEEPLINK = "EXTRA_IS_DEEPLINK"
    const val EXTRA_DRIVER_ID = "EXTRA_DRIVER_ID"
    const val EXTRA_MOBILE_NUMBER = "EXTRA_MOBILE_NUMBER"
    const val EXTRA_WEB_URL = "URL"
    const val EXTRA_HIDE_ACTION_BAR = "HIDE_ACTION_BAR"
    const val WAYPOINT_DATA = "WAYPOINT_DATA"


    // Intent Actions
    const val SIGN_OFF_IMAGE_UPLOAD_COMPLETED = "SIGN_OFF_IMAGE_UPLOAD_COMPLETED"

    //Fragment Ids
    const val FINANCE_FRAGMENT = 100
    const val TRIPS_HOME_FRAGMENT = 101
    const val ALL_TRIPS_FRAGMENT = 102
    const val TRIP_DETAILS_FRAGMENT = 103
    const val REFER_NOW_FRAGMENT = 104
    const val REFER_CONTACTS_FRAGMENT = 105
    const val MONTHLY_BREAKUP = 106
    const val DAILY_BREAKUP = 107
    const val MONTHLY_SUMMARY = 108
    const val DAILY_SUMMARY = 109
    const val SERVICE_METRICS_FRAGMENT = 201
    const val DRIVERRAISETICKETWEBVIEW = 202
    const val GEOFENCE_FRAGMENT = 205
    const val SUPPOERTTICKETFRAGMENT = 203
    const val WEBVIEWPAGE = 204
    const val SUPPORTTYPES = "supportTypes"
    const val GEOADRESS = "geoAddress"

    //remoteconfig keys
    const val LYNK_CUSTOM_ERROR_CONFIG_KEY = "lynk_custom_errors"
    const val LYNK_CONFIG_KEY = "lynk_config"

    var STARTJOURNEYFLAG = 2
    var EndJOURNEYFLAG = 3
    const val FETCHINGLOCATION = "FetchingLocation"


    const val ORDER = "Order"
    const val ACTN = "Actn"
    const val JOURNEYID = "JourneyID"
    const val ORDERID = "orderId"
    const val LAT = "Lat"
    const val LNG = "Lng"
    const val RECEIVEDTIME = "ReceivedTime"
    const val UPDATEDTIME = "UpdatedTime"
    const val TRACKID = "TrackId"
    const val LOCALREFERENCEID = "LocalReferenceId"
    const val ACCURACY = "accuracy"
    const val DRIVERLOCATIONTIMESTAMP = "DriverLocationTimeStamp"
    const val ALT = "alt"
    const val ALTACCURACY = "altaccuracy"
    const val HEADING = "heading"
    const val SPEED = "speed"
    const val IMEI = "IMEI"
    const val UUID = "UUID"
    const val NEXTWAYPOINT = "NextPoint"
    const val NEXTWAYPOINTORDER = "NextWayPointOrder"
    const val TRIPSTATUS_REF = "TripStatus"
    const val ISSINGEDINFOTHERE = "IsSignedInfoThere"
    const val DRIVERPHONE = "DriverPhone"
    const val TRUCKNAME = "TruckName"
    const val TRUCKNUMBER = "TruckNumber"
    const val TRUCKTYPE = "TruckType"
    const val DRIVERNAME = "DriverName"
    const val Ack = "Ack"
    const val voicenote_recordtime = "voicenote_recordtime"
    const val recordLimitationInHrs = "RecordLimitationInHrs"

    /**
     * Constant values for handling 500 error messages
     */
    const val LANGUAGE_MODULE =  "Language"
    const val LOGIN_MODULE =  "Login"
    const val DRIVER_OFFLINE_MODULE =  "Offline"
    const val ONLINE_MODULE =  "Online"
    const val DRIVER_PROFILE_MODULE =  "DriverProfile"
    const val DRIVER_TRIPS_MODULE =  "DriverTrips"
    const val DRIVER_ACCOUNT_MODULE =  "DriverAccount"
    const val DRIVE_OFFTRIP_SUPPORT_MODULE =  "DriverOffTripSupport"
    const val DRIVE_ONTRIP_SUPPORT_MODULE =  "DriverOnTripSupport"
    const val TRIP_ACCEPTANCE_MODULE =  "TripAcceptance"
    const val ENDTRIP_MODULE =  "EndTrip"
    const val DRIVER_GUIDE_MODULE =  "DriverGuide"
    const val DRIVER_DOCUMENT_MODULE =  "DriverDocument"
    const val JOURNEY_TRACKER_MODULE =  "JourneyTracker"

    //Shared pref keys
    const val LYNK_LOG_UPLOADED_TIME = "lynk_log_uploaded_time"
    const val LYNK_LOG_LEVEL_FORCED = "lynk_log_level_forced"
    const val LYNK_NOTIFICATION_DOT = "lynk_notification_dot"
    const val LYNK_NOTIFICATION_DOT_RECEIVED_TIME = "lynk_notification_dot_time"
    const val LYNK_LOG_LEVEL_DEFAULT = "lynk_log_level_default"
    const val NO_GPS_MIN_UPDATE= "no_gps_min_update"
    const val LOGIN_DEEPLINK_EXPIARY= "login_deeplink_expiary_min"

    const val dwell_time_seconds = 120
    const val gps_min_distance_meter = 60
    const val gps_accuracy_meter = 30
    const val gps_min_time_seconds = 5
    const val havershine_distance_meter = 1000000
    const val geo_fence_radius_meter = 200F

    //Broadcast receiver action
    const val CHECK_NETWORK_STATUS = "CHECK_NETWORK_STATUS"

    const val AccuracyInMeterNotInTrip = "AccuracyInMeterNotInTrip"
    const val AccuracyInMeter = "AccuracyInMeter"

    const val OFFLINE_TRIP_CHANNEL = "GandalfClient/offlinetrips/trip"
    const val IS_AUTO_ACCEPT_ENABLED = "AutoAcceptEnabled"
    const val IS_AUTO_ACCEPT_ENABLED_FOR_OFFLINE_TRIP = "AutoAcceptEnabledForOfflineTrip"
    const val NEW_OFFLINE_TRIP_BROADCAST = "NEW_OFFLINE_TRIP_BROADCAST"
    const val OFFLINE_TRIP_ID = "OFFLINE_TRIP_ID"
    const val SHOWING_OFFLINE_TRIP_NOTIFICATION = "SHOWING_OFFLINE_TRIP_NOTIFICATION"
    const val OFFLINE_TRIP_NOTIFICATION_TIMER_BROADCAST = "OFFLINE_TRIP_NOTIFICATION_TIMER"
    const val OFFLINE_TRIP_NOTIFICATION_ENABLED = "OFFLINE_TRIP_NOTIFICATION_ENABLED"
    const val TIMER_TO_ACCEPT_OFFLINE_TRIP = "TIMER_TO_ACCEPT_OFFLINE_TRIP"
    const val OFFLINE_TRIP_NOTIFICATION_INTERVAL = "OFFLINE_TRIP_NOTIFICATION_INTERVAL"
    const val OFFLINE_TRIP_START_TIME = "OFFLINE_TRIP_START_TIME"
    const val OFFLINE_TRIP_END_TIME = "OFFLINE_TRIP_END_TIME"
    const val SHOWING_OFFLINE_TRIP_NOTIFICATION_ID = "SHOWING_OFFLINE_TRIP_NOTIFICATION_ID"
    const val close_offline_trip_activity = "close_offline_trip_activity"
    const val GO_ONLINE_BROADCAST = "GO_ONLINE_BROADCAST"
    const val LAST_TRIP_SHOWN_TIME = "LAST_TRIP_SHOWN_TIME"
    const val IS_TIMER_SCHEDULED = "IS_TIMER_SCHEDULED"
    const val ANM_DATA = "ANM_DATA"
    const val ANM_EXPIRY_TIME = "ANM_EXPIRY_TIME"


    const val MOCKLOCATION = "Mocklocation"
    const val MOCKLOCATION_OFFER = "in mock location ignoring offer notification - "
    const val MOCKLOCATION_ABORT = "in mock location ignoring abort notification - "
    const val MOCKLOCATION_DSC = "in mock location ignoring notification driver status change"
    const val MOCKLOCATION_ANM = "in mock location ignoring acceptedNotMoving notification"
    const val MOCKLOCATION_GEOFENCE = "in mock location ignoring geoFenceReached notification"
    const val NOTIFICATION_NOT_FOUND = "NOTIFICATION_NOT_FOUND"
    const val HANDLE_ACK_DUPLICATION = "HANDLE_ACK_DUPLICATION"

}
