# Multiplayer Card Game

This project involves designing a multiplayer card game that supports up to four players and different types of cards, including number cards and action cards. The game follows a set of rules that dictate how the players can play their cards and how the game is won. The aim of the game is to be the first player to run out of cards.

# Game Rules

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

# Winning the Game

The game ends when one player runs out of cards. That player is declared the winner.

# Implementation Details

The game can be implemented using a variety of programming languages, data structures, and algorithms. A popular approach is to use object-oriented programming (OOP) and a deck class to represent the cards. Each player can have a hand class that holds their cards, and the game logic can be implemented using a game class. The game class can keep track of the state of the game, including the players, the deck, and the discard pile.
<br/><br />
Additionally, a user interface can be created to display the game and allow players to interact with it. The user interface can be implemented using a variety of technologies, such as HTML, CSS, JavaScript, or a graphical user interface (GUI) library in a programming language such as Python or Java.
<br /><br />
In conclusion, designing a multiplayer card game that supports multiple players and different types of cards is a fun and challenging project that involves implementing game logic and user interface design. By following the rules and implementation details outlined above, you can create an exciting game that will provide hours of entertainment for players of all skill levels.

# How to Execute the Application

This readme explains how to execute the application to run a multiplayer card game. The game is developed using Java programming language and can be run using any Integrated Development Environment (IDE) such as Spring Tool Suite (STS), IntelliJ, Eclipse, etc. The application can be downloaded in a zip format from the provided link, and then it can be extracted to a directory of your choice. Once the extraction is complete, follow the steps below to run the application:

1. Open your chosen IDE.
2. Import the extracted file as a new project in your IDE.
3. Locate the Main class in the main package.
4. Run the Main class to start the application.
   
Note that no extra dependencies are required to run the application.

# Kinds of Responses

After executing the application, you can expect one of two responses:

1. Total Number of Rounds Played and Winner: If the game is played to completion without the draw pile becoming empty, the application will display the total number of rounds played and the winner. The response will look something like this: "No of rounds played: 22. Player 1 is the winner...!!!"
2. No Winner Due to Empty Draw Pile: If the draw pile becomes empty during the game, the game ends in a draw, and no winner is declared. The response will look something like this: "Draw pile became empty. Match stopped. No one is the winner...!!!"

In conclusion, by following the steps above, you can successfully execute the application and play the multiplayer card game. The application provides two kinds of responses depending on the outcome of the game, and it can be a fun way to spend your leisure time.
