# Multiplayer Card Game

## Overview

This project involves designing a multiplayer card game that supports up to four players and different types of cards, including number cards and action cards. The game follows a set of rules that dictate how the players can play their cards and how the game is won. The aim of the game is to be the first player to run out of cards.

## Game Rules

1. Each player starts with a hand of 5 cards.
2. The game starts with a deck of 52 cards (a standard deck of playing cards).
3. Players take turns playing cards from their hand, following a set of rules that define what cards can be played when.
4. A player can only play a card if it matches either the suit or the rank of the top card on the discard pile.
5. If a player cannot play a card, they must draw a card from the draw pile. If the draw pile is empty, the game ends in a draw and no player is declared a winner.
6. Aces, Kings, Queens, and Jacks are action cards.
7. When an Ace is played, the next player is skipped and does not get a turn.
8. When a King is played, the sequence of who plays next is reversed.
9. When a Queen is played, the next player draws two cards and misses a turn.
10. When a Jack is played, the next player draws four cards and misses a turn.

11. Actions are not stackable. For example, if a Queen is played by Player 1, and the next player draws two cards and misses a turn, they cannot play a Queen from their hand on that turn, even if one is available.

## Assumptions for Rank Values of Ace, Jack, Queen, and King

In this implementation of the game, the following assumptions have been made:

- Ace has a rank of 1
- Jack has a rank of 11
- Queen has a rank of 12
- King has a rank of 13

## Winning the Game

The game ends when one player runs out of cards. That player is declared the winner.

## Implementation Details

The game can be implemented using a variety of programming languages, data structures, and algorithms. A popular approach is to use object-oriented programming (OOP) and a deck class to represent the cards. Each player can have a hand class that holds their cards, and the game logic can be implemented using a game class. The game class can keep track of the state of the game, including the players, the deck, and the discard pile.
<br/><br />
Additionally, a user interface can be created to display the game and allow players to interact with it. The user interface can be implemented using a variety of technologies, such as HTML, CSS, JavaScript, or a graphical user interface (GUI) library in a programming language such as Python or Java.
<br /><br />
In conclusion, designing a multiplayer card game that supports multiple players and different types of cards is a fun and challenging project that involves implementing game logic and user interface design. By following the rules and implementation details outlined above, you can create an exciting game that will provide hours of entertainment for players of all skill levels.

## How to Execute the Application

1. To run the application, extract the downloaded zip file to a directory of your choice or clone this repository on your local system.
2. The application does not require any extra dependencies to run.
3. Import the extracted file as a new project in your preferred IDE.
4. Locate the Main class in the main package.
5. Run the Main class to start the application.
6. The game can be played with a minimum of 2 players and a maximum of 4 players.
7. Input the desired number of players during the game's start.
8. The application runs on any environment that supports Java 1.8 or above.