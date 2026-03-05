package com.supersolid.cookandme.data

val allWorkouts: List<Workout> = listOf(
    Workout(
        id = 1,
        title = "Chest Press Power",
        targetMuscleGroup = "Chest",
        durationSec = 900,
        exercises = listOf(
            "Push-Ups — 4 × 15 reps",
            "Wide Push-Ups — 3 × 12 reps",
            "Diamond Push-Ups — 3 × 10 reps",
            "Chest Dips — 3 × 12 reps",
            "Pike Push-Ups — 3 × 10 reps"
        ),
        caloriesBurned = 220,
        intensity = "Medium",
        benefits = listOf(
            "Builds pectoral strength",
            "Improves push power",
            "Enhances upper body definition"
        )
    ),
    Workout(
        id = 2,
        title = "Back & Pull Power",
        targetMuscleGroup = "Back",
        durationSec = 1200,
        exercises = listOf(
            "Pull-Ups — 4 × 8 reps",
            "Inverted Rows — 3 × 12 reps",
            "Superman Hold — 3 × 30 sec",
            "Resistance Band Pull-Apart — 4 × 15 reps",
            "Doorframe Row — 3 × 12 reps"
        ),
        caloriesBurned = 280,
        intensity = "High",
        benefits = listOf(
            "Strengthens lats and rhomboids",
            "Improves posture",
            "Reduces upper back tension"
        )
    ),
    Workout(
        id = 3,
        title = "Leg Day Burn",
        targetMuscleGroup = "Legs",
        durationSec = 1200,
        exercises = listOf(
            "Squats — 4 × 20 reps",
            "Lunges — 3 × 12 reps each leg",
            "Jump Squats — 3 × 15 reps",
            "Wall Sit — 3 × 45 sec",
            "Step-Ups — 3 × 12 reps each leg"
        ),
        caloriesBurned = 350,
        intensity = "High",
        benefits = listOf(
            "Builds quad and hamstring strength",
            "Boosts metabolism",
            "Improves athletic performance"
        )
    ),
    Workout(
        id = 4,
        title = "Glute Sculptor",
        targetMuscleGroup = "Glutes",
        durationSec = 900,
        exercises = listOf(
            "Glute Bridges — 4 × 20 reps",
            "Hip Thrusts — 3 × 15 reps",
            "Donkey Kicks — 3 × 15 reps each",
            "Clamshells — 3 × 20 reps each",
            "Sumo Squats — 3 × 15 reps"
        ),
        caloriesBurned = 200,
        intensity = "Medium",
        benefits = listOf(
            "Tones and lifts glutes",
            "Strengthens hip stabilizers",
            "Supports lower back health"
        )
    ),
    Workout(
        id = 5,
        title = "Core Crusher",
        targetMuscleGroup = "Abs",
        durationSec = 600,
        exercises = listOf(
            "Crunches — 4 × 20 reps",
            "Leg Raises — 3 × 15 reps",
            "Plank — 3 × 40 sec",
            "Bicycle Crunches — 3 × 20 reps",
            "Reverse Crunches — 3 × 15 reps"
        ),
        caloriesBurned = 150,
        intensity = "Medium",
        benefits = listOf(
            "Builds core strength",
            "Improves stability and balance",
            "Flattens and tones abs"
        )
    ),
    Workout(
        id = 6,
        title = "Shoulder Shaper",
        targetMuscleGroup = "Shoulders",
        durationSec = 900,
        exercises = listOf(
            "Pike Push-Ups — 4 × 12 reps",
            "Lateral Raises (band) — 3 × 15 reps",
            "Front Raises (band) — 3 × 15 reps",
            "Arnold Press — 3 × 12 reps",
            "Shoulder Circles — 3 × 30 sec"
        ),
        caloriesBurned = 180,
        intensity = "Medium",
        benefits = listOf(
            "Builds rounded shoulders",
            "Improves overhead strength",
            "Enhances upper body appearance"
        )
    ),
    Workout(
        id = 7,
        title = "Bicep Blast",
        targetMuscleGroup = "Biceps",
        durationSec = 600,
        exercises = listOf(
            "Resistance Band Curls — 4 × 15 reps",
            "Hammer Curls — 3 × 12 reps",
            "Concentration Curls — 3 × 10 reps",
            "Chin-Ups — 3 × 8 reps",
            "Isometric Hold — 3 × 20 sec"
        ),
        caloriesBurned = 120,
        intensity = "Low",
        benefits = listOf(
            "Builds bicep size and definition",
            "Improves pulling strength",
            "Strengthens forearms"
        )
    ),
    Workout(
        id = 8,
        title = "Tricep Toner",
        targetMuscleGroup = "Triceps",
        durationSec = 600,
        exercises = listOf(
            "Tricep Dips — 4 × 15 reps",
            "Close-Grip Push-Ups — 3 × 12 reps",
            "Overhead Tricep Extension (band) — 3 × 15 reps",
            "Tricep Kickbacks — 3 × 12 reps",
            "Diamond Push-Ups — 3 × 10 reps"
        ),
        caloriesBurned = 120,
        intensity = "Low",
        benefits = listOf(
            "Tones the back of the arms",
            "Improves push strength",
            "Reduces arm jiggle"
        )
    ),
    Workout(
        id = 9,
        title = "Full Body Burn",
        targetMuscleGroup = "Full Body",
        durationSec = 1200,
        exercises = listOf(
            "Burpees — 4 × 10 reps",
            "Mountain Climbers — 3 × 30 sec",
            "Squat to Press — 3 × 15 reps",
            "Renegade Rows — 3 × 10 reps",
            "Jump Lunges — 3 × 12 reps"
        ),
        caloriesBurned = 400,
        intensity = "High",
        benefits = listOf(
            "Burns maximum calories",
            "Works every major muscle group",
            "Boosts cardiovascular fitness"
        )
    ),
    Workout(
        id = 10,
        title = "Cardio Flow",
        targetMuscleGroup = "Cardio",
        durationSec = 1200,
        exercises = listOf(
            "High Knees — 4 × 45 sec",
            "Jumping Jacks — 3 × 60 sec",
            "Box Jumps — 3 × 15 reps",
            "Speed Skaters — 3 × 30 sec",
            "Fast Feet — 3 × 30 sec"
        ),
        caloriesBurned = 380,
        intensity = "High",
        benefits = listOf(
            "Improves heart health",
            "Burns significant calories",
            "Boosts endurance and stamina"
        )
    ),
    Workout(
        id = 11,
        title = "HIIT Circuit",
        targetMuscleGroup = "HIIT",
        durationSec = 900,
        exercises = listOf(
            "Burpees — 20 sec on / 10 sec off × 4",
            "Jump Squats — 20 sec on / 10 sec off × 4",
            "Push-Up Variations — 20 sec on / 10 sec off × 4",
            "Mountain Climbers — 20 sec on / 10 sec off × 4",
            "Plank to Downdog — 20 sec on / 10 sec off × 4"
        ),
        caloriesBurned = 300,
        intensity = "High",
        benefits = listOf(
            "Maximizes calorie burn in short time",
            "Increases metabolic rate",
            "Improves cardiovascular power"
        )
    ),
    Workout(
        id = 12,
        title = "Mobility Flow",
        targetMuscleGroup = "Mobility",
        durationSec = 600,
        exercises = listOf(
            "World's Greatest Stretch — 5 reps each",
            "Hip 90/90 Stretch — 2 × 60 sec",
            "Thoracic Rotations — 3 × 10 reps",
            "Ankle Circles — 2 × 30 sec",
            "Wrist Mobility Drills — 2 × 30 sec"
        ),
        caloriesBurned = 80,
        intensity = "Low",
        benefits = listOf(
            "Increases joint range of motion",
            "Reduces injury risk",
            "Improves athletic performance"
        )
    ),
    Workout(
        id = 13,
        title = "Deep Stretch",
        targetMuscleGroup = "Stretching",
        durationSec = 600,
        exercises = listOf(
            "Pigeon Pose — 2 × 60 sec each",
            "Forward Fold — 3 × 30 sec",
            "Figure Four Stretch — 2 × 45 sec",
            "Seated Hamstring Stretch — 3 × 30 sec",
            "Child's Pose — 3 × 30 sec"
        ),
        caloriesBurned = 60,
        intensity = "Low",
        benefits = listOf(
            "Reduces muscle tension",
            "Improves flexibility",
            "Promotes relaxation"
        )
    ),
    Workout(
        id = 14,
        title = "Core Stability",
        targetMuscleGroup = "Core Stability",
        durationSec = 900,
        exercises = listOf(
            "Dead Bug — 3 × 10 reps",
            "Bird Dog — 3 × 10 reps each",
            "Pallof Press (band) — 3 × 12 reps",
            "Single-Leg Balance — 3 × 30 sec",
            "Side Plank — 3 × 30 sec each"
        ),
        caloriesBurned = 140,
        intensity = "Medium",
        benefits = listOf(
            "Builds deep core strength",
            "Improves posture and balance",
            "Reduces lower back pain"
        )
    ),
    Workout(
        id = 15,
        title = "Lower Back Relief",
        targetMuscleGroup = "Lower Back",
        durationSec = 600,
        exercises = listOf(
            "Cat-Cow Stretch — 3 × 10 reps",
            "Knee-to-Chest Stretch — 3 × 30 sec",
            "Superman Hold — 3 × 20 sec",
            "Glute Bridges — 3 × 15 reps",
            "Child's Pose — 3 × 30 sec"
        ),
        caloriesBurned = 90,
        intensity = "Low",
        benefits = listOf(
            "Relieves lower back tension",
            "Strengthens spinal erectors",
            "Improves lumbar flexibility"
        )
    ),
    Workout(
        id = 16,
        title = "Posture Fix",
        targetMuscleGroup = "Neck & Posture",
        durationSec = 600,
        exercises = listOf(
            "Neck Side Stretch — 3 × 30 sec each",
            "Chin Tucks — 3 × 15 reps",
            "Wall Angels — 3 × 10 reps",
            "Chest Opener Stretch — 3 × 30 sec",
            "Shoulder Blade Squeezes — 3 × 15 reps"
        ),
        caloriesBurned = 70,
        intensity = "Low",
        benefits = listOf(
            "Corrects forward head posture",
            "Reduces neck and shoulder tension",
            "Improves spinal alignment"
        )
    ),
    Workout(
        id = 17,
        title = "Calf Burn",
        targetMuscleGroup = "Calves",
        durationSec = 600,
        exercises = listOf(
            "Standing Calf Raises — 4 × 20 reps",
            "Single-Leg Calf Raises — 3 × 15 reps each",
            "Seated Calf Raises — 3 × 20 reps",
            "Jump Rope Mimics — 3 × 45 sec",
            "Calf Stretch Hold — 3 × 30 sec"
        ),
        caloriesBurned = 100,
        intensity = "Low",
        benefits = listOf(
            "Builds calf definition",
            "Improves ankle stability",
            "Supports running performance"
        )
    ),
    Workout(
        id = 18,
        title = "Grip & Forearm",
        targetMuscleGroup = "Forearms & Grip",
        durationSec = 600,
        exercises = listOf(
            "Wrist Curls — 4 × 15 reps",
            "Reverse Wrist Curls — 3 × 15 reps",
            "Dead Hangs — 3 × 20 sec",
            "Towel Squeeze — 3 × 30 sec",
            "Finger Extensions — 3 × 20 reps"
        ),
        caloriesBurned = 90,
        intensity = "Low",
        benefits = listOf(
            "Builds grip strength",
            "Strengthens forearm muscles",
            "Supports all pulling exercises"
        )
    ),
    Workout(
        id = 19,
        title = "Balance & Control",
        targetMuscleGroup = "Balance",
        durationSec = 900,
        exercises = listOf(
            "Single-Leg Stand — 3 × 45 sec each",
            "Bosu Ball Squats — 3 × 15 reps",
            "Heel-to-Toe Walk — 3 × 30 sec",
            "Single-Leg Deadlift — 3 × 10 reps each",
            "Star Balance Reach — 3 × 8 reps each"
        ),
        caloriesBurned = 120,
        intensity = "Medium",
        benefits = listOf(
            "Improves proprioception",
            "Reduces fall and injury risk",
            "Builds stabilizer muscles"
        )
    ),
    Workout(
        id = 20,
        title = "Endurance Builder",
        targetMuscleGroup = "Endurance",
        durationSec = 1200,
        exercises = listOf(
            "Jogging in Place — 5 × 60 sec",
            "Alternating Step Touches — 4 × 45 sec",
            "Low-Impact Jacks — 4 × 60 sec",
            "March & Punch — 3 × 60 sec",
            "Cool-Down Walk — 3 × 60 sec"
        ),
        caloriesBurned = 360,
        intensity = "High",
        benefits = listOf(
            "Builds cardiovascular endurance",
            "Improves aerobic capacity",
            "Increases energy levels"
        )
    )
)
