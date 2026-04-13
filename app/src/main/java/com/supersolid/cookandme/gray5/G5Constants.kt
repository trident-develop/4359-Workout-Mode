package com.supersolid.cookandme.gray5


// STORAGE
val TINK_KEYSET = "gcgylkjqt1zr"
val TINK_PREF_FILE = "aim9rqn99tfz"
val MASTER_KEY_URI = "tuqmtkrkvsdo"
val FILE_NAME = "l4xlga71ot5l"
val LINK_STORAGE_KEY = "n0kvnp"
val STUB_STORAGE_KEY = "ho36sf"
val STUB_STORAGE_VALUE_TRUE = "55fkarse"
val PUSH_STORAGE_KEY = "nfk4ohe9sf"
val PUSH_STORAGE_VALUE_TRUE = "ngzj9a"
val ONE_TIME_FLAG = "onuy0u"
//val ADB_KEY = "b67xr1m"

// App
val ADB = "adb_enabled"
val TRACKING_ID = "trackingId"

// Push
val PUSH_NOTIFICATION_API_URL = "workoutmode.site/skn12tn8gh/"
val PUSH_NOTIFICATION_API_GADID_KEY = "7wx8i9n12s"
val PUSH_NOTIFICATION_API_FCM_TOKEN_KEY = "nqpox688vy"

val POSTBACK_API_URL = "workoutmode.site/hpm2pbcqoh/"
val POSTBACK_TRACKING_ID_KEY = "n72vmhik4u"
val POSTBACK_FCM_TOKEN_KEY = "s7mm1z3zm1"

// URL
val BASE_URL = "workoutmode.site/privacypolicy/"
val BASE_URL_STRICT = "workoutmode.site"
val GADID_KEY = "aptxjzl54sg7kp1tqt"
val REF_KEY = "wh0ty3m6ffr35a"
val DEVICE_MODEL_KEY = "nnkvaau04g61jfnevi"
val FIRST_TIME_INSTALL_KEY = "p41yz7v9gcdsabbmfon"
val PACKAGE_SOURCE_KEY = "otmglm5co4p"
val FIREBASE_INSTALL_ID = "tg6ssf6yi904"

val NETWORK_SECURITY_KEY = "7bybs0efriv7j6xtx"
val SENSORS_KEY = "xb605u0lqs0zn6"
val DEVICE_ID_KEY = "i9oj9njpxe"
val CPU_KEY = "gorpavlk16z"
val BUILD_KEY = "otmglm5co4p"
val CHRG_UP_BRIGHT_KEY = "lpzv44a6beds07ylt"
val INSTALL_A11Y_KEY = "tufq58y111oljsv6w"

val ADB_KEY = "lt2x3vq0705h3z7fxni"


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

