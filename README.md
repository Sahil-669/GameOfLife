# 🎮 Conway's Game of Life for Android

A modern, fully interactive implementation of Conway's Game of Life, built from the ground up with 100% Kotlin and Jetpack Compose. This app allows users to create their own patterns, select from classic presets, and watch the simulation evolve, all within a custom-sized grid.

## 📸 Screenshots

| | |
| :---: | :---: |
| **Start Menu** | **Game Screen** |
| <img width="1080" height="1920" alt="Image" src="https://github.com/user-attachments/assets/fd7cbded-e021-4b27-962f-f4dc2071efab" /> | <img width="1080" height="1920" alt="Image" src="https://github.com/user-attachments/assets/7cc4cabb-a28d-4c8b-b30b-55c93f17e5e1" /> |
| **Grid Size Selector** | **How to Play** |
| [Screenshot of Bottom Sheet] | <img width="1080" height="1920" alt="Image" src="https://github.com/user-attachments/assets/0106b3bf-3660-44b4-a59b-47202b1dc8b8" /> |

## ✨ Features

* **Interactive Grid:** Tap any cell to toggle its state (alive or dead) and create your own starting patterns.
* **Full Simulation Control:** Start, stop, reset, or advance the simulation one generation at a time.
* **Classic Presets:** Instantly load famous patterns onto the grid, including:
    * Glider
    * Pulsar
    * R-pentomino
    * Gosper Glider Gun
* **Custom Grid Size:** Use a sleek modal bottom sheet to set a custom width and height for your simulation before you start.
* **Grid Toggle:** Show or hide the cell grid lines for a cleaner look, all with the tap of a button.
* **Haptic Feedback:** Tactile feedback on all button presses for a more responsive feel.
* **Portrait-Locked:** A stable and locked portrait orientation, ensuring a consistent user experience.

## 🛠️ Tech Stack & Architecture

This project is built with a modern, scalable, and entirely Kotlin-based stack.

* **UI:** 100% [Jetpack Compose](https://developer.android.com/jetpack/compose) for a modern, declarative UI.
* **Architecture:** Clean [MVVM (Model-View-ViewModel)](https://developer.android.com/jetpack/guide) pattern, with separate ViewModels for the `StartScreen` and `GameScreen` to manage their respective states.
* **State Management:** [Kotlin Flows](https://kotlinlang.org/docs/flow.html) (`StateFlow`) are used to observe and react to state changes (like the grid updating) from the UI.
* **Asynchronous:** [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) power the main game loop (`while(true)` with `delay`) in the `ViewModel` without blocking the main thread.
* **Navigation:** [Compose Navigation](https://developer.android.com/jetpack/compose/navigation) is used to manage the app's flow from the start menu to the game and help screens.

## 📂 Code Structure

* **`/data`**: Contains the `Grid` data class (which holds the `Array<BooleanArray>`) and the `Patterns.kt` file defining the preset shapes.
* **`/domain`**: Holds the core logic in `GameOfLifeEngine.kt`, including the `nextGeneration()` and `countNeighbors()` functions.
* **`/ui`**: Contains all Jetpack Compose screens (`StartScreen`, `GameScreen`, `HelpScreen`), composables (`GameGrid`, `ControlButtons`), and the ViewModels (`GameViewModel`, `StartViewModel`).
* **`/navigation`**: Defines the `AppRoutes` sealed class for type-safe navigation.

## 🚀 How to Run

1.  Clone this repository:
    ```bash
    git clone https://github.com/Sahil-669/GameOfLife
    ```
2.  Open the project in the latest stable version of Android Studio.
3.  Let Gradle sync the dependencies.
4.  Build and run on an emulator or a physical device.
