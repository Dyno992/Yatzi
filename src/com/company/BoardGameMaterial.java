package com.company;

import java.util.Scanner;

import static com.company.Die.*;

class BoardGameMaterial {
    private static int turn;

     static void startGame() {
        boolean game = true;
        createDice();
        while (game && turn < 3) {
            System.out.println("Starting turn " + (turn + 1) + " of 3, rolling dice.");
            for (int i = 0; i < dice.length; i++) {
                dice[i].roll();
                System.out.println(i + ": " + "Dice Shows " + dice[i].value);
            }
            game = false;
        }
    }

     static boolean checkIfYahtzee(Die[] dice) {
        boolean yahtzee =  true;
        for (int j = 1; j < 5; j++) {
            if (dice[j].value != dice[j - 1].value) {
                yahtzee = false;
                break;
            }
        }return yahtzee;
    }

    static void nextRound() {
        if (turn != 2) {
            System.out.println("Want to throw again? (y for yes, anything else for no)");
            Scanner sc = new Scanner(System.in);
            if (sc.next().equals("y")) {
                ++turn;
                startGame();
            } else {
                System.out.println("Program Ending...");
                System.exit(0);
            }
        }
    }

    static void gameOver() {
        System.out.println("Game over! Want to play again?");
        Scanner sc = new Scanner(System.in);
        if (sc.next().equals("y")) {
            turn = 0;
        } else {
            System.out.println("Program Ending...");
            System.exit(0);
        }
    }
}