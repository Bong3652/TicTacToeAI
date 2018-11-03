import java.util.Scanner;

public class Game {
    private char Player;
    private char Computer;
    private char[][] board = new char[][] {
            {'_', '_', '_'},
            {'_', '_', '_'},
            {'_', '_', '_'},
    };
    public void displayBoard() {
        System.out.println(" -------");
        for (int i = 0; i < this.board.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < this.board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println(" _______");
    }

    public char getPlayer() {
        return Player;
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
    public int possMove() {
        int[][] possMove = new int[3][3];
        int count = 0;
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                if (this.board[i][j] == '_') {
                    possMove[i][j] = 0;
                    count++;
                } else {
                    possMove[i][j] = -1;
                }
            }
        }
        return count;
    }
    public void move(char player, char oppenent) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.printf("%s's move!\n", player);
            displayBoard();
            System.out.println("Enter Row then Column");
            int rc = sc.nextInt();
            if (this.board[rc / 10][rc % 10] == '_') {
                this.board[rc / 10][rc % 10] = player;
                break;
            } else {
                System.out.println("Not a valid move");
            }
        }
    }
    public boolean win() {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == board [i][1] && board [i][1] == board[i][2] && board[i][0] != '_') {
                return true;
            }
            if (board[0][i] == board [1][i] && board [1][i] == board[2][i] && board[0][i] != '_') {
                return true;
            }
            if (board[0][0] == board [1][1] && board [1][1] == board[2][2] && board[0][0] != '_') {
                return true;
            }
            if (board[0][2] == board [1][1] && board [1][1] == board[2][0] && board[0][2] != '_') {
                return true;
            }
        }
        return false;
    }
}
