import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class drawMan {

    public drawMan() {
    }

    public static void drawMan(Terminal terminal, int errorCounter) throws IOException {
        switch (errorCounter) {
            case 1:
                terminal.setCursorPosition(45, 12);
                terminal.putCharacter('/');
                terminal.setCursorPosition(46, 11);
                terminal.putCharacter('/');
                terminal.flush();
                break;

            case 2:
                terminal.setCursorPosition(47, 10);
                terminal.putCharacter('_');
                terminal.setCursorPosition(48, 11);
                terminal.putCharacter('\\');
                terminal.setCursorPosition(49, 12);
                terminal.putCharacter('\\');
                terminal.flush();
                break;

            case 3:
                terminal.setCursorPosition(47, 10);
                terminal.putCharacter('|');
                terminal.setCursorPosition(47, 9);
                terminal.putCharacter('|');
                terminal.setCursorPosition(47, 8);
                terminal.putCharacter('|');
                terminal.flush();
                break;

            case 4:
                terminal.setCursorPosition(47, 7);
                terminal.putCharacter('=');
                terminal.setCursorPosition(48, 7);
                terminal.putCharacter('=');
                terminal.setCursorPosition(49, 7);
                terminal.putCharacter('=');
                terminal.setCursorPosition(50, 7);
                terminal.putCharacter('=');
                terminal.setCursorPosition(51, 7);
                terminal.putCharacter('=');
                terminal.flush();
                break;

            case 5:
                terminal.setCursorPosition(48, 8);
                terminal.putCharacter('/');
                terminal.flush();
                break;

            case 6:
                terminal.setCursorPosition(51, 8);
                terminal.putCharacter('|');
                terminal.flush();
                break;
            case 7:
                terminal.setCursorPosition(51, 9);
                terminal.putCharacter('O');
                terminal.flush();
                break;

            case 8:
                terminal.setCursorPosition(51, 10);
                terminal.putCharacter('|');
                terminal.flush();
                break;

            case 9:
                terminal.setCursorPosition(50, 10);
                terminal.putCharacter('/');
                terminal.flush();
                break;

            case 10:
                terminal.setCursorPosition(52, 10);
                terminal.putCharacter('\\');
                terminal.flush();
                break;

            case 11:
                terminal.setCursorPosition(50, 11);
                terminal.putCharacter('/');
                terminal.flush();
                break;

            case 12:
                terminal.setCursorPosition(52, 11);
                terminal.putCharacter('\\');
                terminal.flush();
                break;
        }
    }

    public static void winnerPrint(Terminal terminal) throws IOException {
        terminal.setForegroundColor(TextColor.ANSI.GREEN);
        terminal.setCursorPosition(47, 14);
        terminal.putCharacter('W');
        terminal.setCursorPosition(48, 14);
        terminal.putCharacter('I');
        terminal.setCursorPosition(49, 14);
        terminal.putCharacter('N');
        terminal.setCursorPosition(50, 14);
        terminal.putCharacter('N');
        terminal.setCursorPosition(51, 14);
        terminal.putCharacter('E');
        terminal.setCursorPosition(52, 14);
        terminal.putCharacter('R');
        terminal.setCursorPosition(53, 14);
        terminal.putCharacter('!');
    }

    public static void loserPrint(Terminal terminal) throws IOException {
        terminal.setCursorPosition(47, 14);
        terminal.putCharacter('D');
        terminal.setCursorPosition(48, 14);
        terminal.putCharacter('E');
        terminal.setCursorPosition(49, 14);
        terminal.putCharacter('A');
        terminal.setCursorPosition(50, 14);
        terminal.putCharacter('D');
        terminal.setCursorPosition(51, 14);
        terminal.putCharacter('!');
    }

    public static void guessCounter(Terminal terminal, int numberOfGuesses) throws IOException {
        char[] numberArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        terminal.flush();

        int row = 11; int column = 5;

        switch (numberOfGuesses) {
            case 0:
                terminal.setCursorPosition(10, column);
                terminal.putCharacter(numberArray[1]);
                terminal.setCursorPosition(row, column);
                terminal.putCharacter(numberArray[2]);
                terminal.flush();
                break;
            case 1:
                terminal.setCursorPosition(10, column);
                terminal.putCharacter(numberArray[1]);
                terminal.setCursorPosition(row, column);
                terminal.putCharacter(numberArray[1]);
                terminal.flush();
                break;
            case 2:
                terminal.setCursorPosition(10, column);
                terminal.putCharacter(numberArray[1]);
                terminal.setCursorPosition(row, column);
                terminal.putCharacter(numberArray[0]);
                terminal.flush();
                break;
            case 3:
                terminal.setCursorPosition(10, column);
                terminal.putCharacter(' ');
                terminal.setCursorPosition(row, column);
                terminal.putCharacter(numberArray[9]);
                terminal.flush();
                break;
            case 4:
                terminal.setCursorPosition(row, column);
                terminal.putCharacter(numberArray[8]);
                terminal.flush();
                break;
            case 5:
                terminal.setCursorPosition(row, column);
                terminal.putCharacter(numberArray[7]);
                terminal.flush();
                break;
            case 6:
                terminal.setCursorPosition(row, column);
                terminal.putCharacter(numberArray[6]);
                terminal.flush();
                break;
            case 7:
                terminal.setCursorPosition(row, column);
                terminal.putCharacter(numberArray[5]);
                terminal.flush();
                break;
            case 8:
                terminal.setCursorPosition(row, column);
                terminal.putCharacter(numberArray[4]);
                terminal.flush();
                break;
            case 9:
                terminal.setCursorPosition(row, column);
                terminal.putCharacter(numberArray[3]);
                terminal.flush();
                break;
            case 10:
                terminal.setCursorPosition(row, column);
                terminal.putCharacter(numberArray[2]);
                terminal.flush();
                break;
            case 11:
                terminal.setCursorPosition(row, column);
                terminal.putCharacter(numberArray[1]);
                terminal.flush();
                break;
            case 12:
                terminal.setForegroundColor(TextColor.ANSI.RED);
                terminal.setCursorPosition(row, column);
                terminal.putCharacter(numberArray[0]);
                terminal.flush();
                break;
            default:
                terminal.flush();
                break;
        }
    }
}
