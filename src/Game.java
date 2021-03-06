import java.util.InputMismatchException;
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
    public void move(char player) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Player's move!");
            displayBoard();
            System.out.println("Enter Row then Column");
            try {
                int rc = sc.nextInt();
                if (this.board[rc / 10][rc % 10] == '_') {
                    this.board[rc / 10][rc % 10] = player;
                    break;
                } else {
                    System.out.println("Not a valid move");
                }
            } catch (ArrayIndexOutOfBoundsException |InputMismatchException e) {
                if (sc.nextLine().equalsIgnoreCase("Exit")) {
                    System.out.println("We gave the computer the turn since your wimping out! haha");
                    return;
                }
                System.out.println("Your outta bound!");
            }
        }
    }
    /*public boolean computerWinMove() {
        int c = 0; //Computer
        int s = 0; //empty space
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '_') {
                    s++;
                } else {
                    c++;
                }
                if (c == 2 && s == 1) {
                    return true;
                }
            }
            s = 0;
            c = 0;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] == '_') {
                    s++;
                }
                if (c == 2 && s == 1) {
                    return true;
                }
            }
            s = 0;
            c = 0;
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == '_') {
                s++;
            }
            if (c == 2 && s == 1) {
                return true;
            }
        }
        s = 0;
        c = 0;
        if (board[0][2] == Computer) {
            c++;
        } else if (board[0][2] == '_') {
            s++;
        }
        if (board[2][0] == Computer) {
            c++;
        } else if (board[2][0] == '_') {
            s++;
        }
        if (board[1][1] == Computer) {
            c++;
        } else if (board[1][1] == '_') {
            s++;
        }
        if (c == 2 && s == 1) {
            return true;
        }
        return false;
    }*/
    public void computerMove(char Player, char Computer) {
        int p = 0; //Player
        int c = 0; //Computer
        int s = 0; //empty space
        int x = 0;
        int y = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == Player) {
                    p++;
                } else if (board[i][j] == '_') {
                    s++;
                    x = i;
                    y = j;
                } else {
                    c++;
                }
                if (c == 2 && s == 1) {
                    board[x][y] = Computer;
                    return;
                }
                if (p == 2 && s == 1) {
                    board[x][y] = Computer;
                    return;
                }
            }
            s = 0;
            p = 0;
            c = 0;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] == Player) {
                    p++;
                } else if (board[j][i] == '_') {
                    s++;
                    x = j;
                    y = i;
                } else {
                    c++;
                }
                if (c == 2 && s == 1) {
                    board[x][y] = Computer;
                    return;
                }
                if (p == 2 && s == 1) {
                    board[x][y] = Computer;
                    return;
                }
            }
            s = 0;
            p = 0;
            c = 0;
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == Player) {
                p++;
            } else if (board[i][i] == '_') {
                s++;
                x = i;
                y = i;
            } else {
                c++;
            }
            if (c == 2 && s == 1) {
                board[x][y] = Computer;
                return;
            }
            if (p == 2 && s == 1) {
                board[x][y] = Computer;
                return;
            }
        }
        s = 0;
        p = 0;
        c = 0;
        if (board[0][2] == Player) {
            p++;
        } else if (board[0][2] == '_') {
            s++;
            x = 0;
            y = 2;
        } else {
            c++;
        }
        if (board[2][0] == Player) {
            p++;
        } else if (board[2][0] == '_') {
            s++;
            x = 2;
            y = 0;
        } else {
            c++;
        }
        if (board[1][1] == Player) {
            p++;
        } else if (board[1][1] == '_') {
            s++;
            x = 1;
            y = 1;
        } else {
            c++;
        }
        if (c == 2 && s == 1) {
            board[x][y] = Computer;
            return;
        }
        if (p == 2 && s == 1) {
            board[x][y] = Computer;
            return;
        }
        if (board[1][1] == '_') {
            board[1][1] = Computer;
            return;
        } else if (board[0][0] == '_' && board[2][2] == Player) {
            board[0][0] = Computer;
            return;
        } else if (board[0][2] == '_' && board[2][0] == Player) {
            board[0][2] = Computer;
            return;
        } else if (board[2][0] == '_' && board[0][2] == Player) {
            board[2][0] = Computer;
            return;
        } else if (board[2][2] == '_' && board[0][0] == Player) {
            board[2][2] = Computer;
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '_') {
                    board[i][j] = Computer;
                    return;
                }
            }
        }
    }
    public boolean win() {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == board [i][1] && board [i][1] == board[i][2] && board[i][0] != '_') {
                System.out.println("Computer(" + board[i][0] + ") wins");
                return true;
            }
            if (board[0][i] == board [1][i] && board [1][i] == board[2][i] && board[0][i] != '_') {
                System.out.println("Computer(" + board[0][i] + ") wins");
                return true;
            }
            if (board[0][0] == board [1][1] && board [1][1] == board[2][2] && board[0][0] != '_') {
                System.out.println("Computer(" + board[0][0] + ") wins");
                return true;
            }
            if (board[0][2] == board [1][1] && board [1][1] == board[2][0] && board[0][2] != '_') {
                System.out.println("Computer(" + board[0][2] + ") wins");
                return true;
            }
        }
        return false;
    }
}
