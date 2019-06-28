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
        terminal.setForegroundColor(TextColor.ANSI.WHITE);

    }

    public static void loserPrint(Terminal terminal) throws IOException {
        terminal.setForegroundColor(TextColor.ANSI.RED);
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
        terminal.setForegroundColor(TextColor.ANSI.WHITE);
    }

    public static void correctLetter(Terminal terminal) throws IOException {
        String message = "Correct! Enter a new letter.";
        for (int i = 0; i < message.length(); i++) {
            terminal.setForegroundColor(TextColor.ANSI.GREEN);
            terminal.setCursorPosition(i + 15, 20);
            terminal.putCharacter(message.charAt(i));
            terminal.setForegroundColor(TextColor.ANSI.WHITE);

            for (int j = 26; j < 32; j++) {
                terminal.setCursorPosition(j + 17, 20);
                terminal.putCharacter(' ');
            }
        }
        terminal.flush();
    }
}
