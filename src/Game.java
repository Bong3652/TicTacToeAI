import java.util.Scanner;

public class Game {
    char Player;
    char Computer;
    String[][] board = new String[][] {
            {"_ ", "_ ", "_ "},
            {"_ ", "_ ", "_ "},
            {"_ ", "_ ", "_ "}
    };
    public void displayBoard() {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    public void whoGoesFirst() {
        String choice;
        do {
            System.out.println("Who would you lke to go first?" + "\n" + "1)Yourself" + "\n2)Computer");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextLine();
            if (!(choice.equals("1") || choice.equals("2"))) {
                System.out.println("Type 1 or 2");
            }
            if (choice.equals("1")) {
                this.Player = 'X';
                this.Computer = 'O';
            } else if (choice.equals("2")) {
                this.Player = 'O';
                this.Computer = 'X';
            }
        } while (!(choice.equals("1") || choice.equals("2")));
    }
    public boolean win() {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == board [i][1] && board [i][1] == board[i][2]) {
                return true;
            }
            if (board[0][i] == board [1][i] && board [1][i] == board[2][i]) {
                return true;
            }
        }
        return false;
    }
}
