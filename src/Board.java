import java.util.Random;

public class Board {

    private char player;
    private char position[] = new char[10];
    char[][] field = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}
    };
    public char[][] getField() {
        return field;
    }

    public char winner() {
        char winner = ' ';
        if (position[1] == 'X' && position[2] == 'X' && position[3] == 'X') winner = 'X';
        if (position[4] == 'X' && position[5] == 'X' && position[6] == 'X') winner = 'X';
        if (position[7] == 'X' && position[8] == 'X' && position[9] == 'X') winner = 'X';
        if (position[1] == 'X' && position[4] == 'X' && position[7] == 'X') winner = 'X';
        if (position[2] == 'X' && position[5] == 'X' && position[8] == 'X') winner = 'X';
        if (position[3] == 'X' && position[6] == 'X' && position[9] == 'X') winner = 'X';
        if (position[1] == 'X' && position[5] == 'X' && position[9] == 'X') winner = 'X';
        if (position[3] == 'X' && position[5] == 'X' && position[7] == 'X') winner = 'X';
        if (winner == 'X') {
            System.out.println("Player X wins the game.");
            return winner;
        }
        if (position[1] == 'O' && position[2] == 'O' && position[3] == 'O') winner = 'O';
        if (position[4] == 'O' && position[5] == 'O' && position[6] == 'O') winner = 'O';
        if (position[7] == 'O' && position[8] == 'O' && position[9] == 'O') winner = 'O';
        if (position[1] == 'O' && position[4] == 'O' && position[7] == 'O') winner = 'O';
        if (position[2] == 'O' && position[5] == 'O' && position[8] == 'O') winner = 'O';
        if (position[3] == 'O' && position[6] == 'O' && position[9] == 'O') winner = 'O';
        if (position[1] == 'O' && position[5] == 'O' && position[9] == 'O') winner = 'O';
        if (position[3] == 'O' && position[5] == 'O' && position[7] == 'O') winner = 'O';
        if (winner == 'O') {
            System.out.println("Player O wins the game.");
            return winner;
        }
        for (int i = 1; i < 10; i++) {
            if (position[i] == 'X' || position[i] == 'O') {
                if (i == 9) {
                    char stalemate = 'D';
                    System.out.println("Board is stalemate");
                    return stalemate;
                }
                continue;
            } else
                break;
        }
        return winner;
    }

    public boolean checkPosn(int spot) {
        if (position[spot] == 'X' || position[spot] == 'O') {
            return true;
        } else {
            return false;
        }
    }

    public void nextPlayer() {
        if (player == 'X')
            player = 'O';
        else player = 'X';


    }

    public void newField(int enteredNumber) {
        switch (enteredNumber) {
            case 1:
                field[0][0] = player;
                break;
            case 2:
                field[0][1] = player;
                break;
            case 3:
                field[0][2] = player;
                break;
            case 4:
                field[1][0] = player;
                break;
            case 5:
                field[1][1] = player;
                break;
            case 6:
                field[1][2] = player;
                break;
            case 7:
                field[2][0] = player;
                break;
            case 8:
                field[2][1] = player;
                break;
            case 9:
                field[2][2] = player;
                break;


        }
        position[enteredNumber] = player;
    }


    public void compTurn() {
        nextPlayer();
        boolean emptyPositionFound = false;
        while (!emptyPositionFound) {
            int random = new Random().nextInt(9) + 1;
            if (!checkPosn(random)) {
                newField(random);
                emptyPositionFound = true;
            }


        }

    }

}