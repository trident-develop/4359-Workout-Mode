package com.supersolid.cookandme.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.supersolid.cookandme.data.Workout
import com.supersolid.cookandme.ui.theme.BeigeCard
import com.supersolid.cookandme.ui.theme.IntensityHigh
import com.supersolid.cookandme.ui.theme.IntensityHighContainer
import com.supersolid.cookandme.ui.theme.IntensityLow
import com.supersolid.cookandme.ui.theme.IntensityLowContainer
import com.supersolid.cookandme.ui.theme.IntensityMedium
import com.supersolid.cookandme.ui.theme.IntensityMediumContainer
import com.supersolid.cookandme.ui.theme.TextMedium
import com.supersolid.cookandme.ui.theme.WarmBrown
import com.supersolid.cookandme.viewmodel.WorkoutViewModel

@Composable
fun WorkoutListScreen(
    viewModel: WorkoutViewModel,
    onWorkoutClick: (Int) -> Unit
) {
    WorkoutListContent(
        workouts = viewModel.workouts,
        onWorkoutClick = onWorkoutClick
    )
}

@Composable
private fun WorkoutListContent(
    workouts: List<Workout>,
    onWorkoutClick: (Int) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(workouts) { workout ->
            WorkoutCard(workout = workout, onClick = { onWorkoutClick(workout.id) })
        }
    }
}

@Composable
fun WorkoutCard(workout: Workout, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = BeigeCard),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = workout.title,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = workout.targetMuscleGroup,
                        style = MaterialTheme.typography.bodySmall,
                        color = TextMedium
                    )
                }
                IntensityBadge(intensity = workout.intensity)
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                DurationChip(durationSec = workout.durationSec)
                Text(
                    text = "·",
                    color = TextMedium,
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "${workout.caloriesBurned} kcal",
                    style = MaterialTheme.typography.bodySmall,
                    color = TextMedium
                )
            }
        }
    }
}

@Composable
fun IntensityBadge(intensity: String) {
    val (bgColor, textColor) = when (intensity) {
        "High" -> IntensityHighContainer to IntensityHigh
        "Medium" -> IntensityMediumContainer to IntensityMedium
        else -> IntensityLowContainer to IntensityLow
    }
    Surface(
        shape = RoundedCornerShape(50),
        color = bgColor
    ) {
        Text(
            text = intensity,
            style = MaterialTheme.typography.labelSmall,
            color = textColor,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
        )
    }
}

@Composable
fun DurationChip(durationSec: Int) {
    val minutes = durationSec / 60
    Text(
        text = "$minutes min",
        style = MaterialTheme.typography.bodySmall,
        color = WarmBrown
    )
}

private val PreviewWorkouts = listOf(
    Workout(
        id = 1,
        title = "Chest Builder",
        targetMuscleGroup = "Chest",
        durationSec = 12 * 60,
        exercises = listOf("Push-ups", "Incline push-ups", "Wide push-ups"),
        caloriesBurned = 140,
        intensity = "Medium",
        benefits = listOf("Strength", "Endurance")
    ),
    Workout(
        id = 2,
        title = "Leg Day",
        targetMuscleGroup = "Quads • Glutes",
        durationSec = 18 * 60,
        exercises = listOf("Squats", "Lunges", "Glute bridge"),
        caloriesBurned = 230,
        intensity = "High",
        benefits = listOf("Power", "Fat burn")
    ),
    Workout(
        id = 3,
        title = "Mobility Flow",
        targetMuscleGroup = "Full body mobility",
        durationSec = 10 * 60,
        exercises = listOf("Neck rolls", "Hip openers", "Hamstring stretch"),
        caloriesBurned = 80,
        intensity = "Low",
        benefits = listOf("Flexibility", "Recovery")
    )
)

@Preview(
    showBackground = true,
    showSystemUi = true
)

@Preview(
    showBackground = true,
    showSystemUi = true,
    widthDp = 360,
    heightDp = 640
)

@Preview(
    name = "mdpi (160)",
    widthDp = 320,
    heightDp = 680,
    fontScale = 1.0f,
    showBackground = true,
    showSystemUi = true
)

@Preview(
    name = "hdpi (240)",
    widthDp = 450,
    heightDp = 800,
    fontScale = 1.0f,
    showBackground = true,
    showSystemUi = true
)

@Composable
private fun WorkoutListPreview() {
    // Если у тебя есть тема приложения — оберни сюда:
    // WorkoutTheme {
    WorkoutListContent(
        workouts = PreviewWorkouts,
        onWorkoutClick = {}
    )
    // }
}