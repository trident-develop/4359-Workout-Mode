package com.supersolid.cookandme.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.supersolid.cookandme.ui.theme.BeigeBackground
import com.supersolid.cookandme.ui.theme.BeigeCard
import com.supersolid.cookandme.ui.theme.BeigeDivider
import com.supersolid.cookandme.ui.theme.TextMedium
import com.supersolid.cookandme.ui.theme.WarmBrown
import com.supersolid.cookandme.viewmodel.WorkoutViewModel

private data class TabItem(
    val label: String,
    val icon: ImageVector
)

private val tabs = listOf(
    TabItem("Workouts", Icons.Default.FitnessCenter),
    TabItem("Timer", Icons.Default.Timer),
    TabItem("Benefits", Icons.Default.BarChart)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel: WorkoutViewModel,
    onNavigateToDetails: (Int) -> Unit
) {
    var selectedTab by rememberSaveable { mutableIntStateOf(0) }

    val lastSelectedWorkoutId by viewModel.lastSelectedWorkoutId.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = tabs[selectedTab].label,
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BeigeBackground,
                    titleContentColor = MaterialTheme.colorScheme.onBackground
                )
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = BeigeCard,
                tonalElevation = 0.dp
            ) {
                tabs.forEachIndexed { index, tab ->
                    NavigationBarItem(
                        selected = selectedTab == index,
                        onClick = { selectedTab = index },
                        icon = {
                            Icon(
                                imageVector = tab.icon,
                                contentDescription = tab.label
                            )
                        },
                        label = {
                            Text(
                                text = tab.label,
                                style = MaterialTheme.typography.labelSmall
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = WarmBrown,
                            selectedTextColor = WarmBrown,
                            unselectedIconColor = TextMedium,
                            unselectedTextColor = TextMedium,
                            indicatorColor = BeigeDivider
                        )
                    )
                }
            }
        },
        containerColor = BeigeBackground
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            when (selectedTab) {
                0 -> WorkoutListScreen(
                    viewModel = viewModel,
                    onWorkoutClick = { workoutId ->
                        viewModel.selectWorkout(workoutId)
                        onNavigateToDetails(workoutId)
                    }
                )
                1 -> {
                    val timerState = viewModel.getOrInitTimerState(lastSelectedWorkoutId)
                    val workout = viewModel.workouts.firstOrNull { it.id == lastSelectedWorkoutId }
                        ?: viewModel.workouts.first()
                    WorkoutDetailsContent(
                        workout = workout,
                        timerState = timerState,
                        onToggleTimer = { viewModel.toggleTimer(lastSelectedWorkoutId) },
                        onResetTimer = { viewModel.resetTimer(lastSelectedWorkoutId) }
                    )
                }
                2 -> BenefitsScreen(
                    viewModel = viewModel,
                    onWorkoutClick = { workoutId ->
                        viewModel.selectWorkout(workoutId)
                        onNavigateToDetails(workoutId)
                    }
                )
            }
        }
    }
}
