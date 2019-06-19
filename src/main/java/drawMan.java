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
}
