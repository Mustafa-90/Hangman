import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.ArrayList;
import java.util.Random;

//public class MainTest {
//
//    public static void main(String[] args) throws Exception {
//        Random rand = new Random();
//        int xPosition = 0; //rand.nextInt(10);
//        int yPosition = 0; //rand.nextInt(10);
//        int oldYPos = 0;
//        int oldXPos = 0;
//        int monsterPosX = rand.nextInt(80);
//        int monsterPosY = rand.nextInt(20);
//
//        ArrayList<SnakePosition> sp = new ArrayList<SnakePosition>();
//
//
//
//
//        boolean continueReadingInput = true;
//        ArrayList<Character> snakeLength = new ArrayList<Character>();
//        for (int i = 0; i < 5; i++) {
//            snakeLength.add('X');
//        }
//
//        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
//        Terminal terminal = terminalFactory.createTerminal();
//        terminal.setCursorVisible(false);
//
//        do {
//            KeyStroke keyStroke = null;
//
//            terminal.setCursorPosition(monsterPosX, monsterPosY);
//            terminal.putCharacter('O');
//
//            terminal.flush();
//            keyStroke = null;
//            do {
//                Thread.sleep(5); // might throw InterruptedException
//                keyStroke = terminal.pollInput();
//                for (int i = 0; i < snakeLength.size(); i++) {
//                    terminal.setCursorPosition(xPosition, yPosition + i);
//                    terminal.putCharacter(snakeLength.get(i));
//                }
//                terminal.flush();
//            } while (keyStroke == null);
//
//            KeyType type = keyStroke.getKeyType();
//            Character c = keyStroke.getCharacter();
//
//            terminal.flush();
//
//            if (type == KeyType.ArrowUp) {
//                    yPosition--;
//                    terminal.setCursorPosition(xPosition, yPosition);
//                    terminal.putCharacter('X');
//                    terminal.flush();
//                } else if (type == KeyType.ArrowDown) {
//                    yPosition++;
//                    terminal.setCursorPosition(xPosition, yPosition);
//                    terminal.putCharacter('X');
//                    terminal.flush();
//                } else if (type == KeyType.ArrowLeft) {
//                    xPosition--;
//                    terminal.setCursorPosition(xPosition, yPosition);
//                    terminal.putCharacter('X');
//                    terminal.flush();
//                } else if (type == KeyType.ArrowRight) {
//                    xPosition++;
//                    terminal.setCursorPosition(xPosition, yPosition);
//                    terminal.putCharacter('X');
//                    terminal.flush();
//                } else if (c == Character.valueOf('q') || c == Character.valueOf('Q')) {
//                    continueReadingInput = false;
//                    String q = "QUIT";
//                    for (int i = 0; i < q.length(); i++) {
//                        terminal.setCursorPosition(38 + i, 12);
//                        Thread.sleep(100);
//                        terminal.putCharacter(q.charAt(i));
//                        Thread.sleep(100);
//                        terminal.flush();
//                    }
//                    Thread.sleep(200);
//                    terminal.close();
//            }
//        } while (continueReadingInput);
//    }
//}
