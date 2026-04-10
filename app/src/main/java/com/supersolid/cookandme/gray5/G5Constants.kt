package com.supersolid.cookandme.gray5

// STORAGE
val TINK_KEYSET = "tink_keyset"
val TINK_PREF_FILE = "tink_pref_file"
val MASTER_KEY_URI = "secure_storage_key"
val FILE_NAME = "secure_user_info"
val STUB_STORAGE_VALUE_TRUE = "err5g345g"
val PUSH_STORAGE_VALUE_TRUE = "ffffgg"

// App
val ADB = "adb_enabled"
val TRACKING_ID = "trackingId"

// Push
val PUSH_NOTIFICATION_API_URL = "push_notification_api_url"
val PUSH_NOTIFICATION_API_GADID_KEY = "push_notification_api_gadid_key"
val PUSH_NOTIFICATION_API_FCM_TOKEN_KEY = "push_notification_api_fcm_token_key"

val POSTBACK_API_URL = "postback_api_url"
val POSTBACK_TRACKING_ID_KEY = "postback_tracking_id_key"
val POSTBACK_FCM_TOKEN_KEY = "postback_fcm_token_key"

// URL
val BASE_URL = "attribution_url"
val BASE_URL_STRICT = "base_no_privacy"
val GADID_KEY = "gadid_key"
val REF_KEY = "referrer_key"
val DEVICE_MODEL_KEY = "extra_param_3"
val FIREBASE_INSTALL_ID = "external_id"

val ADB_KEY = "extra_param_2"


// --- Bitmask gate flags ---
val GATE_STUB = 0b001
val GATE_AD = 0b010
val GATE_NET = 0b100

// --- Router keys ---
val ROUTE_STUB = "s"
val ROUTE_NET = "n"

// --- Storage key derivation ---
fun k(seed: String) = seed.fold(0) { acc, c -> acc * 31 + c.code }.toString(16)
// k("lx5") → link storage key
// k("sx5") → stub storage key
// k("px5") → push storage key

