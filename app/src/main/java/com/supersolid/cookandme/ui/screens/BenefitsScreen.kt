package com.supersolid.cookandme.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.supersolid.cookandme.data.Workout
import com.supersolid.cookandme.ui.theme.BeigeCard
import com.supersolid.cookandme.ui.theme.TextMedium
import com.supersolid.cookandme.ui.theme.WarmBrown
import com.supersolid.cookandme.ui.theme.WarmBrownLight
import com.supersolid.cookandme.viewmodel.WorkoutViewModel

@Composable
fun BenefitsScreen(
    viewModel: WorkoutViewModel,
    onWorkoutClick: (Int) -> Unit
) {
    BenefitsScreenContent(
        workouts = viewModel.workouts,
        onWorkoutClick = onWorkoutClick
    )
}

@Composable
private fun BenefitsScreenContent(
    workouts: List<Workout>,
    onWorkoutClick: (Int) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(workouts) { workout ->
            BenefitCard(workout = workout)
        }
    }
}

@Composable
private fun BenefitCard(workout: Workout) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
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
                    Text(
                        text = workout.targetMuscleGroup,
                        style = MaterialTheme.typography.bodySmall,
                        color = TextMedium
                    )
                }
                IntensityBadge(intensity = workout.intensity)
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Stats row
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                StatChip(label = "${workout.durationSec / 60} min")
                StatChip(label = "${workout.caloriesBurned} kcal")
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Benefits bullets
            workout.benefits.forEach { benefit ->
                Row(
                    modifier = Modifier.padding(vertical = 3.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = WarmBrownLight,
                        modifier = Modifier.size(12.dp)
                    )
                    Text(
                        text = benefit,
                        style = MaterialTheme.typography.bodySmall,
                        color = TextMedium
                    )
                }
            }
        }
    }
}

@Composable
private fun StatChip(label: String) {
    Text(
        text = label,
        style = MaterialTheme.typography.labelMedium,
        color = WarmBrown
    )
}

private val PreviewWorkouts = listOf(
    Workout(
        id = 1,
        title = "Upper Body Strength",
        targetMuscleGroup = "Chest • Shoulders • Triceps",
        durationSec = 15 * 60,
        exercises = listOf("Push-ups", "Shoulder Press", "Triceps Dips"),
        caloriesBurned = 180,
        intensity = "Medium",
        benefits = listOf("Builds upper-body strength", "Improves posture", "Boosts endurance")
    ),
    Workout(
        id = 2,
        title = "Legs & Glutes",
        targetMuscleGroup = "Quads • Glutes • Hamstrings",
        durationSec = 20 * 60,
        exercises = listOf("Squats", "Lunges", "Glute Bridge"),
        caloriesBurned = 240,
        intensity = "High",
        benefits = listOf("Increases lower-body power", "Tones glutes", "Burns more calories")
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
private fun ScreenPreview() {
    val navController = rememberNavController()
    BenefitsScreenContent(
        workouts = PreviewWorkouts,
        onWorkoutClick = {}
    )
}