
public class run {
    public void start() {
        Game g = new Game();
        System.out.println("\n               You will never be able to win this game");
        System.out.println("*** Don't even try cheating the system by messing with the original code ***");
        System.out.println("                        !!!!!THAT'S UNETHICAL!!!!!");
        g.whoGoesFirst();
        while (!g.win()) {
            if (g.getPlayer() == 'X') {
                g.move('X');
                g.computerMove('X', 'O');
            } else if (g.getPlayer() == 'O') {
                g.computerMove('O', 'X');
                g.move('O');
            }
            if (g.possMove() == 0) {
                break;
            }
        }
        g.displayBoard();
        System.out.println("Finish");
    }
    public static void main(String[] args) {
        run r = new run();
        r.start();
    }
}
