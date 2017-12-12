import java.util.Scanner;
public class TicTacToe {
   
    private static char board[][];
    private static char currentPlayerMark = 'X';
    private static boolean isFinished = false;
    private static int count = 0;
    public static void main(String[] args) {
        TicTacToe tic = new TicTacToe();
        Scanner scan = new Scanner(System.in);
        initializeBoard();
        while (isFinished == false) {
            if (count >= 9) {
                System.out.println("Tie, no one wins");
                return;
            }
            System.out.println("Player one, enter which row you want to place your mark from 1 to 3");
            int row1 = scan.nextInt() - 1;
            System.out.println("Player one, enter which column you want to place your mark from 1 to 3");
            int col1 = scan.nextInt() - 1;
            placeMark(row1, col1);
            initializeBoard();
            isFinished = boardIsFull();
            isFinished = hasWon();
            count++;
            changePlayer();
            System.out.println();
            if (isFinished == true) {
                System.out.println("Player one has won");
                return;
            }
           
            if (count >= 9) {
                System.out.println("Tie, no one wins");
                return;
            }
            System.out.println("Player two, enter which row you want to place your mark from 1 to 3");
            int row2 = scan.nextInt() - 1;
            System.out.println("Player two, enter which column you want to place your mark from 1 to 3");
            int col2 = scan.nextInt() - 1;
            placeMark(row2, col2);
            initializeBoard();
            isFinished = boardIsFull();
            isFinished = hasWon();
            count++;
            changePlayer();
            System.out.println();
        }
        if (isFinished == true) {
            System.out.println("Player two has won");
            return;
        }
    }
   
    public TicTacToe() {
        board = new char [3][3];
        initializeBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '_';
            }
        }
    }
   
    public static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
//      for (int i = 0; i < 3; i++) {
//          System.out.print("  | ");
//          for (int j = 0; j < 3; j++) {
//              System.out.print(board[i][j] + " | ");
//          }
//          System.out.println();
//          System.out.println("--------------");  
    }
   
    public static boolean boardIsFull() {
        boolean isFull = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '_') {
                    isFull = false;
                }
            }
        }
        return isFull;
    }
   
    public static boolean hasWon() {
        if (rowWin() || colWin() || diagWin()) {
            return true;
        }
        return false;
    }
   
    public static boolean rowWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2])) {
                return true;
            }
        }
        return false;
    }
    public static boolean colWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        }
        return false;
    }
   
    public static boolean diagWin() {
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                if ((checkRowCol(board[0][0], board[1][1], board[2][2]) == true) ||
                        (checkRowCol(board[0][2], board[1][1], board[2][0]) == true))
                        {
                    return true;
                }
            }
        }
        return false;
    }
   
    private static boolean checkRowCol(char c1, char c2, char c3) {
        if (c1 == 'X' && c2 == 'X' && c3 =='X') {
            return true;
        }
        if (c1 == 'O' && c2 == 'O' && c3 =='O') {
            return true;
        }
        return false;
    }
   
    public static void changePlayer() {
        if (currentPlayerMark == 'X') {
            currentPlayerMark = 'O';
        } else if (currentPlayerMark == 'O') {
            currentPlayerMark = 'X';
        }
    }
   
    public static boolean placeMark(int row, int col) {
 
                if (board[row][col] == '_') {
                    board[row][col] = currentPlayerMark;
                }
        return true;
    }
   
 
}