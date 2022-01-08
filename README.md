# Othello

## Domain 

Othello is a turn-based abstract strategy board game for 2 players, played on an 8×8 uncheckered board. This project is a desktop application for playing Othello in player vs
player mode, created in Java using Java Swing, AWT and other graphical elements. This version can detect and invalidate illegal moves and declares winner or tie automatically.

## Idea

There are sixty-four identical game pieces called disks (often spelled "discs"), which are light on one side and dark on the other. Players take turns placing disks on the board with their assigned color facing up. During a play, any disks of the opponent's color that are in a straight line and bounded by the disk just placed and another disk of the current player's color are turned over to the current player's color. The objective of the game is to have the majority of disks turned to display one's color when the last playable empty square is filled.

## Description of the codebase
 
<img src="Screenshot%20(649).png" width="250" height="250"> <img src="Screenshot%20(650).png" width="250" height="250"> <img src="Screenshot%20(654).png" width="250" height="250">
       
The code is well arranged into sub-directories which are -
1. The first page is the ```Normal Version``` which comes up once you run the code.
2. The second and thrid page is the ```Game Time``` version, which is how it will appear once you start playing. 

# How to Run

1. Make sure VS Code is installed in your system.
2. Fork this repository.
3. Clone the forked repository:
~~~
git clone https://github.com/<your github username>/Othello
~~~
4. Add a remote to the upstream repository:
~~~
# typing the command below should show you only 1 remote named origin with the URL of your forked repository
git remote -v
# adding a remote for the upstream repository
git remote add upstream https://github.com/bodhi996/Othello.github
~~~
5. Run the application.
6. Create a new issue if you face any difficulties (after browsing through StackOverflow on your own) and someone will help you 😁
