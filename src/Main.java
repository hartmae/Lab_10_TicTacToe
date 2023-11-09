import com.sun.org.apache.xpath.internal.objects.XString;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board [][] = new String[ROW][COL];


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean done = true;
        do {
            if (done) {
                int playerNum = 1;
                int row;
                int col;
                int moves = 0;
                String playerString;
                String player;
                boolean valid;
                boolean gameOver = false;
                boolean win = false;
                boolean isTie = false;
                clearBoard();
                display();
                do {
                    if (!gameOver)
                        if (playerNum == 1) {
                            System.out.println("Player 1's turn!");
                            do {
                                col = SafeInput.getRangedInt(in, " Player 1 pick your Column from 1 to 3", 1, 3);
                                row = SafeInput.getRangedInt(in, "Player 1 pick your Row from 1 to 3", 1, 3);
                            } while (!isValidMove(col, row));
                            playerNum = playerNum + 1;
                            board[row - 1][col - 1] = "X";
                            display();
                            if (moves >= 4) {
                                if (win("X") == true) {
                                    System.out.println("Player 1 Wins!");
                                    break;
                                }
                            }
                            if (moves == 8) {
                                if (win("O") == true) {
                                    System.out.println("Player 2 Wins!");
                                    break;
                                }
                                System.out.println("You have tied.");
                                break;
                            }
                        } else {
                            System.out.println("Player 2's turn!");
                            do {
                                col = SafeInput.getRangedInt(in, " Player 2 pick your Column from 1 to 3", 1, 3);
                                row = SafeInput.getRangedInt(in, "Player 2 pick your Row from 1 to 3", 1, 3);
                            } while (!isValidMove(col,row));
                            playerNum = playerNum - 1;
                            board[row - 1][col - 1] = "O";
                            display();
                            if (moves >= 4) {
                                if (win("O") == true) {
                                    System.out.println("Player 2 Wins!");
                                    break;
                                }
                            }
                            if (moves == 8) {
                                if (win("O") == true) {
                                    System.out.println("Player 2 Wins!");
                                    break;
                                }
                                System.out.println("You have tied.");
                                break;
                            }
                        }
                    moves = moves + 1;



                } while (1 == 1);
            }
        } while (SafeInput.getYNConfirm(in, "Play Again?").equalsIgnoreCase("y"));
    }

    private static void display() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();

        }
    }
    private static void clearBoard() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c] = "[]";
            }


        }
    }

    private static boolean isValidMove(int col, int row) {
            return (board[row - 1][col - 1].equals("[]"));
        }


    private static boolean rowWin(String player) {
        for (int row = 0; row < ROW; row++) {
            if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean colWin(String player) {
        for (int col = 0; col < COL; col++) {
            if (board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean diagonalWin(String player) {
        if ((board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) || (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player))) {
            return true;
        }
        else {
            return false;
        }
    }

    private static boolean win(String player) {
        if (colWin(player) || rowWin(player) || diagonalWin(player)) {
            return true;
        }
        else {
            return false;
        }
    }

    private static boolean isTie() {
        int notX = 0;
        int notO = 0;
        int ties = 0;
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                if (board[r][c].equals(" X ")) {
                    notX++;
                }
                else if (board[r][c].equals(" O ")) {
                    notO++;
                }
                if (notX >= 1 && notO >= 1) {
                    ties++;
                }
            }
        }
        if (ties >= 3) {
            return true;
        }
        else {
            return false;
        }
    }

}
