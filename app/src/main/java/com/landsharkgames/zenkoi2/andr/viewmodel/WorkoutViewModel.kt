package com.landsharkgames.zenkoi2.andr.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.landsharkgames.zenkoi2.andr.data.Workout
import com.landsharkgames.zenkoi2.andr.data.WorkoutRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class TimerState(
    val totalSec: Int,
    val remainingSec: Int,
    val isRunning: Boolean,
    val isCompleted: Boolean
)

class WorkoutViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = WorkoutRepository(application)

    val workouts: List<Workout> = repository.workouts

    private val _lastSelectedWorkoutId = MutableStateFlow(repository.getLastSelectedWorkoutId())
    val lastSelectedWorkoutId: StateFlow<Int> = _lastSelectedWorkoutId.asStateFlow()

    // Compose-observable map for timer states, keyed by workout id
    val timerStates = mutableStateMapOf<Int, TimerState>()

    private val timerJobs = mutableMapOf<Int, Job>()

    fun selectWorkout(workoutId: Int) {
        _lastSelectedWorkoutId.value = workoutId
        repository.saveLastSelectedWorkoutId(workoutId)
    }

    fun getOrInitTimerState(workoutId: Int): TimerState {
        return timerStates.getOrPut(workoutId) {
            val workout = workouts.first { it.id == workoutId }
            TimerState(workout.durationSec, workout.durationSec, false, false)
        }
    }

    fun toggleTimer(workoutId: Int) {
        val state = getOrInitTimerState(workoutId)
        when {
            state.isCompleted -> resetTimer(workoutId)
            state.isRunning -> pauseTimer(workoutId)
            else -> startTimer(workoutId)
        }
    }

    fun resetTimer(workoutId: Int) {
        timerJobs[workoutId]?.cancel()
        timerJobs.remove(workoutId)
        val workout = workouts.first { it.id == workoutId }
        timerStates[workoutId] = TimerState(workout.durationSec, workout.durationSec, false, false)
    }

    private fun startTimer(workoutId: Int) {
        val current = getOrInitTimerState(workoutId)
        timerStates[workoutId] = current.copy(isRunning = true)
        timerJobs[workoutId]?.cancel()
        timerJobs[workoutId] = viewModelScope.launch {
            while (true) {
                delay(1000L)
                val s = timerStates[workoutId] ?: break
                if (!s.isRunning) break
                val newRemaining = s.remainingSec - 1
                if (newRemaining <= 0) {
                    timerStates[workoutId] = s.copy(remainingSec = 0, isRunning = false, isCompleted = true)
                    break
                } else {
                    timerStates[workoutId] = s.copy(remainingSec = newRemaining)
                }
            }
        }
    }

    private fun pauseTimer(workoutId: Int) {
        timerJobs[workoutId]?.cancel()
        timerJobs.remove(workoutId)
        timerStates[workoutId] = timerStates[workoutId]?.copy(isRunning = false) ?: return
    }

    override fun onCleared() {
        super.onCleared()
        timerJobs.values.forEach { it.cancel() }
    }
}
