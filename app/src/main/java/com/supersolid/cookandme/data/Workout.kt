package com.supersolid.cookandme.data

data class Workout(
    val id: Int,
    val title: String,
    val targetMuscleGroup: String,
    val durationSec: Int,
    val exercises: List<String>,
    val caloriesBurned: Int,
    val intensity: String,
    val benefits: List<String>
)
