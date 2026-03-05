package com.supersolid.cookandme.data

import android.content.Context
import androidx.core.content.edit

private const val PREFS_NAME = "workout_prefs"
private const val KEY_LAST_WORKOUT_ID = "last_workout_id"

class WorkoutRepository(context: Context) {

    private val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    val workouts: List<Workout> = allWorkouts

    fun getLastSelectedWorkoutId(): Int {
        return prefs.getInt(KEY_LAST_WORKOUT_ID, workouts.first().id)
    }

    fun saveLastSelectedWorkoutId(id: Int) {
        prefs.edit { putInt(KEY_LAST_WORKOUT_ID, id) }
    }
}
