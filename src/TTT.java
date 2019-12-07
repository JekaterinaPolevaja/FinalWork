import java.util.Scanner;

public class TTT {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Welcome to Tic Tac Toe!");
        System.out.println("\n");
        System.out.println("Press Y to start the game! Enter any other symbol if you want the computer to start.");
        String goFirst = sc.nextLine();
        Board board = new Board();
        Printer printer = new Printer();

        printer.printBoard(board.getField());
        board.nextPlayer();
        if (goFirst.equalsIgnoreCase("y")) {
            System.out.println("Please enter the position for X.");
        }else {
            System.out.println("The computer is making its turn.");
            System.out.println("\n");
            board.compTurn();
            printer.printBoard(board.getField());
            board.nextPlayer();
            System.out.println("Please enter the position for X.");
        }
        boolean positionTaken = true;
        boolean gameContinues = true;
        int coordinate;
        while (gameContinues) {
            Scanner in = new Scanner(System.in);
            coordinate = in.nextInt();
            if (coordinate <=0||coordinate>=10)
            {
                System.out.println("Please enter a number from 1 to 9.");
            }
            else
            {
                positionTaken = board.checkPosn(coordinate);
                if (!positionTaken) {
                    board.newField(coordinate);
                    printer.printBoard(board.getField());
                    if (board.winner() == 'X') {
                        gameContinues = false;
                    }
                    else {
                        System.out.println("\n");
                        board.compTurn();
                        printer.printBoard(board.getField());
                        if (board.winner() == ('O')) {
                            gameContinues = false;
                        } else {
                            board.nextPlayer();
                            System.out.println("Please enter position.");
                        }
                    }
                } else {
                    System.out.println("This position is full, please choose another.");
                }
            }
        }

    }
}