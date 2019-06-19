import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class Main {
    public static void main(String[] args) throws Exception {
        int xCord = 10;
        int yCord = 10;

        // Task 4
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal terminal = terminalFactory.createTerminal();

        terminal.setCursorVisible(false);

        KeyStroke keyStroke = null;

        while (true) {
            do {
                Thread.sleep(5); // might throw InterruptedException
                keyStroke = terminal.pollInput();
                terminal.setCursorPosition(xCord, yCord);
                terminal.putCharacter('X');
                terminal.flush();

            } while (keyStroke == null);

            if (keyStroke.getKeyType().equals(KeyType.ArrowDown)) {
                terminal.setCursorPosition(xCord, yCord);
                terminal.putCharacter(' ');
                yCord++;
                terminal.setCursorPosition(xCord, yCord);
                terminal.putCharacter('X');
                terminal.flush();
            } else if (keyStroke.getKeyType().equals(KeyType.ArrowUp)) {
                terminal.setCursorPosition(xCord, yCord);
                terminal.putCharacter(' ');
                yCord--;
                terminal.setCursorPosition(xCord, yCord);
                terminal.putCharacter('X');
                terminal.flush();
            } else if (keyStroke.getKeyType().equals(KeyType.ArrowLeft)) {
                terminal.setCursorPosition(xCord, yCord);
                terminal.putCharacter(' ');
                xCord--;
                terminal.setCursorPosition(xCord, yCord);
                terminal.putCharacter('X');
                terminal.flush();
            } else if (keyStroke.getKeyType().equals(KeyType.ArrowRight)) {
                terminal.setCursorPosition(xCord, yCord);
                terminal.putCharacter(' ');
                xCord++;
                terminal.setCursorPosition(xCord, yCord);
                terminal.putCharacter('X');
                terminal.flush();
            }
        }
    }
}




