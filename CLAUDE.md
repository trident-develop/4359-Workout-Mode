# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build Commands

```bash
./gradlew assembleDebug          # Build debug APK
./gradlew assembleRelease        # Build release APK
./gradlew test                   # Run unit tests
./gradlew connectedAndroidTest   # Run instrumented tests (requires device/emulator)
./gradlew lint                   # Run lint checks
```

## Architecture

Single-module Android app — Jetpack Compose, Material 3, single Activity, portrait-only.

- **Package:** `com.landsharkgames.zenkoi2.andr`
- **Min SDK:** 28 (Android 9), **Target/Compile SDK:** 36
- **Entry point:** `MainActivity` → `WorkoutModeTheme` → `WorkoutNavGraph`
- **Dependency versions:** managed via `gradle/libs.versions.toml` (version catalog)

### Package layout

| Package | Contents |
|---|---|
| `data/` | `Workout` data class, `WorkoutData` (20 hardcoded workouts), `WorkoutRepository` (SharedPrefs) |
| `viewmodel/` | `WorkoutViewModel` (AndroidViewModel) — workout list, timer state, last-selected workout |
| `nav/` | `NavGraph.kt` — routes: `loading`, `main`, `workout_details/{workoutId}` |
| `ui/theme/` | Beige color scheme, custom font from `res/font/font.ttf`, Material 3 typography |
| `ui/screens/` | `LoadingScreen`, `MainScreen` (bottom nav), `WorkoutListScreen`, `WorkoutDetailsScreen`, `BenefitsScreen` |

### Navigation flow

```
LoadingScreen (2s) → MainScreen (bottom nav)
                          ├── Tab 0: WorkoutListScreen → WorkoutDetailsScreen (back-stack)
                          ├── Tab 1: WorkoutDetailsContent (last-selected workout, no back)
                          └── Tab 2: BenefitsScreen → WorkoutDetailsScreen (back-stack)
```

### State & timer

- `WorkoutViewModel` is Activity-scoped (created in `WorkoutNavGraph`, passed down).
- Timer states live in `mutableStateMapOf<Int, TimerState>()` keyed by workout id.
- Each timer is a `viewModelScope` coroutine job; jobs are cancelled/tracked per workout id.
- Last-selected workout id is persisted via `WorkoutRepository` → `SharedPreferences`.

### Shared composables

- `WorkoutDetailsContent` — the core timer + exercises UI, used by both the Timer tab and `WorkoutDetailsScreen`.
- `IntensityBadge`, `DurationChip` — reused across list and benefits screens (defined in `WorkoutListScreen.kt`).

## Key Tech

- Kotlin 2.0.21, AGP 9.0.1
- Jetpack Compose BOM 2024.09.00, Navigation Compose 2.7.7
- Material Design 3, Material Icons Extended
- `lifecycle-viewmodel-compose` 2.6.1 for `viewModel()` in composables
