# TicTacToe Game
Author: Anik Kirtania

## Overview

A simple Tic-Tac-Toe game implemented in Java using Swing GUI framework. This classic two-player game features a 3x3 grid with a clean interface, game state tracking, and a live clock display.

## Features

- Graphical user interface with a 3x3 grid
- Two-player gameplay (Player 0 and Player 1)
- Automatic win detection
- Draw condition detection
- Live clock display showing current date and time
- Play again option after game completion
- Visual indicators for player moves:
  - Player 0: Yellow background with "0" text
  - Player 1: Blue background with "1" text
- Validation to prevent placing on occupied positions

## Technical Details

### Requirements

- Java Development Kit (JDK) 8 or higher
- Any operating system supporting Java


Code

### Classes

1. **Mygame.java**
   - Extends JFrame and implements ActionListener
   - Contains the game logic and UI components
   - Manages player turns and win detection

2. **Tictactoe.java**
   - Contains the main method
   - Initializes the game

## How to Run

### Option 1: Using the JAR File

Simply double-click on `tictactoe.jar` or run:

java -jar tictactoe.jar

Code

### Option 2: From Source

1. Compile the source files:
javac -d out com/mycompany/tictactoe/*.java

Code

2. Run the application:
java -cp out com.mycompany.tictactoe.Tictactoe

Code

## Game Rules

- The game starts with Player 0 making the first move
- Players take turns placing their marks (0 or 1) on the 3x3 grid
- The first player to get three of their marks in a row (horizontally, vertically, or diagonally) wins
- If all cells are filled and no player has won, the game ends in a draw

## Implementation Details

### Key Components

- **Game Board**: Implemented as a 3x3 grid of JButtons
- **Win Detection**: Checks for winning patterns using predefined position arrays
- **Status Labels**: Displays game title and current time
- **Threading**: Uses a separate thread to update the clock display

### Game Logic

- Uses an array `chance[]` to track the state of each cell (2 for empty, 0 for Player 0, 1 for Player 1)
- Winning positions are defined in the `winningPos[][]` array
- The `active` variable tracks the current player (0 or 1)
- The `gOver` flag indicates when the game has ended

## Future Enhancements

- Add option to play against computer AI
- Implement difficulty levels
- Add game statistics tracking
- Improve UI with customizable themes
- Add sound effects
- Allow customizing player names and symbols
- Restore commented out icon functionality

---

*Note: This project was developed as part of coursework for the 2nd semester OOP(JAVA) Course.*
