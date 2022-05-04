//Sahit Neziri

package sn.prog2.exercises.set1;

import java.util.Random;
import java.util.Scanner;

public class ConnectFour {
    static boolean isWon = false;
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();


    //If won it doesn't draw the last board panel

    public static void main(String[] args) {
        String[][] board = {
                {" . ", " . ", " . ", " . ", " . ", " . ", " . "},
                {" . ", " . ", " . ", " . ", " . ", " . ", " . "},
                {" . ", " . ", " . ", " . ", " . ", " . ", " . "},
                {" . ", " . ", " . ", " . ", " . ", " . ", " . "},
                {" . ", " . ", " . ", " . ", " . ", " . ", " . "},
                {" . ", " . ", " . ", " . ", " . ", " . ", " . "}
        };
        int rounds = 1;

        boolean playMode = checkPlayers();

        while (!isWon || rounds <= 43) {
            System.out.println("Gameround: " + (rounds));
            drawGameBoard(board, playMode, rounds);
            rounds++;
            if (rounds == 42) break;
        }

        if (rounds == 42) System.out.println("!!Game Over!! \nDraw");
    }

    //checks if Player has friends or needs Computer as Opponent
    private static boolean checkPlayers() {
        int players = 3;
        while (players > 2 || players < 1) {
            System.out.println("How many are Playing? (1-2)");
            players = sc.nextInt();
        }

        if (players == 1) {
            System.out.println("Singleplayer-Mode:");
            System.out.println("Your Opponent will be a Bot");
            return false;
        }
        System.out.println("Multiplayer-Mode:");
        return true;
    }

    public static void drawGameBoard(String[][] board, boolean com, int rounds) {
        board = connectFour(board, com, rounds);

        System.out.println();
        System.out.println("01 02 03 04 05 06 07");
        System.out.println("--------------------");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println("--------------------");
        System.out.println();

    }

    public static String[][] connectFour(String[][] board, boolean com, int rounds) {
        //Value out of Bounds, will get changed while playing, is only needed for placeToken()
        int p1Column = 0, p2Column = 0;

        //player turns
        if (rounds % 2 != 0) {
            System.out.println("Player 1 (x) choose a column (1-7)");

            p1Column = sc.nextInt() - 1;
            while (p1Column < 0 || p1Column > 6) {
                System.out.println("Could not support " + (p1Column + 1) + ", please choose the wanted Column!");
                p1Column = sc.nextInt() - 1;
            }
        } else {
            if (!com) {
                //p2 (player2) will be controlled from my very intelligent AI bot, on Singleplayer mode:
                do {
                    p2Column = random.nextInt(7);
                } while (!board[0][p2Column].equals(" . "));
            } else {
                System.out.println("Player 2 (0) choose a column (1-7)");

                p2Column = sc.nextInt() - 1;
                while (p2Column < 0 || p2Column > 6) {
                    System.out.println("Could not support " + (p2Column + 1) + ", please choose the wanted Column!");
                    p2Column = sc.nextInt() - 1;
                }
            }
        }

        //adds new (played) Game board in doubleArray board:
        return placeToken(board, p1Column, p2Column, rounds);
    }

    public static String[][] placeToken(String[][] board, int p1Column, int p2Column, int rounds) {

        int column = 5;

        if (rounds % 2 != 0) board = difToken(board, p1Column, " x ", column);
        else board = difToken(board, p2Column, " o ", column);


        return board;
    }

    public static String[][] difToken(String[][] board, int playerColumn, String player, int column) {


        for (int i = column; i >= 0; i--) {
            if (board[i][playerColumn].equals(" . ")) {
                if (player.equals(" x ")) {
                    board[i][playerColumn] = "\033[0;34m" + " x " + "\033[0m";
                    if (gameOver(checkWin(board, playerColumn, i), "Player 1")) {
                        isWon = true;
                        break;
                    }
                } else {
                    board[i][playerColumn] = "\033[0;31m" + " 0 " + "\033[0m";
                    if (gameOver(checkWin(board, playerColumn, i), "Player 2")) {
                        isWon = true;
                        break;
                    }
                }
                break;
            }
        }

        return board;
    }

    public static boolean checkWin(String[][] board, int column, int row) {
        int maxCol = 6, maxRow = 5, count = 0;
        String player = board[row][column]; //player ID
//Horizontal check
        for (int i = 0; i < maxCol; i++) {
            if (board[row][i].equals(player)) count++;
            else count = 0;

            if (count >= 4) return true;
        }
//Vertical check

        for (int i = 0; i < maxRow; i++) {
            if (board[i][column].equals(player)) count++;
            else count = 0;

            if (count >= 4) return true;
        }

//Diagonally check
        for (int i = column + 1, j = row + 1; i < maxRow && j < maxCol; i++, j++) {
            if (!board[j][i].equals(player)) {
                count = 1;
                break;
            }
            count++;
        }

        for (int i = column - 1, j = row - 1; i >= 0 && j >= 0; i--, j--) {
            if (!board[j][i].equals(player)) {
                count = 1;
                break;
            }
            count++;
        }

        for (int i = column + 1, j = row - 1; i < maxRow && j >= 0; i++, j--) {
            if (!board[j][i].equals(player)) {
                count = 1;
                break;
            }
            count++;
        }

        for (int i = column - 1, j = row + 1; i >= 0 && j < maxCol; i--, j++) { // 4 in a row diagonally
            if (!board[j][i].equals(player)) {
                count = 1;
                break;
            }
            count++;
        }

        if (count >= 4) return true;

        return false;
    }

    public static boolean gameOver(boolean win, String player) {
        if (win) {
            System.out.println(player + " has won this game!");
            System.exit(0);
            return true;
        }
        // False
        return false;
    }
}
