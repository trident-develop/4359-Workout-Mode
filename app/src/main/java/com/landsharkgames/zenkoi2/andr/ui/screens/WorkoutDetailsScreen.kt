package com.landsharkgames.zenkoi2.andr.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.landsharkgames.zenkoi2.andr.data.Workout
import com.landsharkgames.zenkoi2.andr.ui.theme.BeigeBackground
import com.landsharkgames.zenkoi2.andr.ui.theme.BeigeCard
import com.landsharkgames.zenkoi2.andr.ui.theme.BeigeDivider
import com.landsharkgames.zenkoi2.andr.ui.theme.SuccessGreen
import com.landsharkgames.zenkoi2.andr.ui.theme.TextMedium
import com.landsharkgames.zenkoi2.andr.ui.theme.WarmBrown
import com.landsharkgames.zenkoi2.andr.ui.theme.WarmBrownDark
import com.landsharkgames.zenkoi2.andr.viewmodel.TimerState
import com.landsharkgames.zenkoi2.andr.viewmodel.WorkoutViewModel

// Full-screen with back arrow — used from navigation
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkoutDetailsScreen(
    workoutId: Int,
    viewModel: WorkoutViewModel,
    onBack: () -> Unit
) {
    val workout = viewModel.workouts.firstOrNull { it.id == workoutId }
        ?: viewModel.workouts.first()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = workout.title,
                        style = MaterialTheme.typography.titleMedium
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BeigeBackground,
                    titleContentColor = MaterialTheme.colorScheme.onBackground,
                    navigationIconContentColor = WarmBrown
                )
            )
        },
        containerColor = BeigeBackground
    ) { paddingValues ->
        WorkoutDetailsContent(
            workout = workout,
            timerState = viewModel.getOrInitTimerState(workoutId),
            onToggleTimer = { viewModel.toggleTimer(workoutId) },
            onResetTimer = { viewModel.resetTimer(workoutId) },
            modifier = Modifier.padding(paddingValues)
        )
    }
}

// Embeddable content — reused in the Timer tab
@Composable
fun WorkoutDetailsContent(
    workout: Workout,
    timerState: TimerState,
    onToggleTimer: () -> Unit,
    onResetTimer: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(BeigeBackground)
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        // Header card
        Surface(
            shape = RoundedCornerShape(12.dp),
            color = BeigeCard,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = workout.title,
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = workout.targetMuscleGroup,
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    IntensityBadge(intensity = workout.intensity)
                    DurationChip(durationSec = workout.durationSec)
                    Text(
                        text = "${workout.caloriesBurned} kcal",
                        style = MaterialTheme.typography.bodySmall,
                        color = TextMedium
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Timer section
        TimerSection(
            timerState = timerState,
            onToggleTimer = onToggleTimer,
            onResetTimer = onResetTimer
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Exercises
        Text(
            text = "Exercises",
            style = MaterialTheme.typography.titleMedium,
            color = WarmBrownDark
        )
        Spacer(modifier = Modifier.height(10.dp))
        Surface(
            shape = RoundedCornerShape(12.dp),
            color = BeigeCard,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                workout.exercises.forEachIndexed { index, exercise ->
                    Row(
                        modifier = Modifier.padding(vertical = 6.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text(
                            text = "${index + 1}.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = WarmBrown
                        )
                        Text(
                            text = exercise,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                    if (index < workout.exercises.lastIndex) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                                .background(BeigeDivider)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
private fun TimerSection(
    timerState: TimerState,
    onToggleTimer: () -> Unit,
    onResetTimer: () -> Unit
) {
    val minutes = timerState.remainingSec / 60
    val seconds = timerState.remainingSec % 60
    val timeText = "%02d:%02d".format(minutes, seconds)
    val progress = if (timerState.totalSec > 0)
        1f - timerState.remainingSec.toFloat() / timerState.totalSec else 0f

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = if (timerState.isCompleted) "Completed!" else timeText,
            style = MaterialTheme.typography.displayMedium.copy(fontSize = 56.sp),
            color = if (timerState.isCompleted) SuccessGreen else WarmBrownDark,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(12.dp))

        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp),
            color = if (timerState.isCompleted) SuccessGreen else WarmBrown,
            trackColor = BeigeDivider
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = onToggleTimer,
                colors = ButtonDefaults.buttonColors(
                    containerColor = WarmBrown,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .weight(1f)
                    .height(52.dp)
            ) {
                Text(
                    text = when {
                        timerState.isCompleted -> "Start Again"
                        timerState.isRunning -> "Pause"
                        timerState.remainingSec < timerState.totalSec -> "Resume"
                        else -> "Start"
                    },
                    style = MaterialTheme.typography.titleMedium
                )
            }

            OutlinedButton(
                onClick = onResetTimer,
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = WarmBrown
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.size(width = 96.dp, height = 52.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "Reset",
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

private val PreviewWorkout = Workout(
    id = 1,
    title = "Upper Body Strength",
    targetMuscleGroup = "Chest • Shoulders • Triceps",
    durationSec = 15 * 60,
    exercises = listOf(
        "Push-ups — 3×12",
        "Shoulder Press — 3×10",
        "Triceps Dips — 3×12",
        "Plank — 3×30s"
    ),
    caloriesBurned = 180,
    intensity = "Medium",
    benefits = listOf("Builds strength", "Improves posture", "Boosts endurance")
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
private fun WorkoutDetailsContentPreview_Completed() {
    WorkoutDetailsContent(
        workout = PreviewWorkout,
        timerState = TimerState(
            totalSec = 15 * 60,
            remainingSec = 0,
            isRunning = false,
            isCompleted = true
        ),
        onToggleTimer = {},
        onResetTimer = {}
    )
}