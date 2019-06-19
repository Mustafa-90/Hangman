/*import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) throws Exception {
        // Task 4
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal terminal = terminalFactory.createTerminal();
        terminal.setCursorVisible(false);
        Scanner in = new Scanner(System.in);
        int hangCounter = 0;


        ArrayList<String> words = new ArrayList<String>();
        words.add("Ambulance");
        words.add("Saxophone");
        words.add("Terminated");
        words.add("Birdseed");
        words.add("Flute");
        words.add("Sunglasses");
        words.add("Factory");
        words.add("Hangman");
        words.add("Super");
        words.add("Pokemon");
        words.add("Computer");
        words.add("Dishwasher");
        words.add("Election");
        words.add("Scanner");
        words.add("Analog");
        words.add("Diner");
        words.add("Hamburger");
        words.add("Elephant");
        words.add("Tiger");
        words.add("Lion");

        int randomPos = (int) (Math.random() * words.size());
        String randomWord = words.get(randomPos);
        System.out.println(randomWord);
        boolean continueReadingInput = true;


        do {
            KeyStroke keyStroke = null;
            keyStroke = null;
            do {
                for (int i = 0; i < randomWord.length() * 2; i += 2) {
                    terminal.setCursorPosition(i + 15, 14);
                    terminal.putCharacter('_');
                    terminal.setCursorPosition(i + 16, 14);
                    terminal.putCharacter(' ');
                }
                terminal.flush();
            } while (keyStroke == null);

            KeyType type = keyStroke.getKeyType();
            Character c = keyStroke.getCharacter();

            if (c == Character.valueOf('q') || c == Character.valueOf('Q')) {
                continueReadingInput = false;
                String q = "QUIT";
                for (int i = 0; i < q.length(); i++) {
                    terminal.setCursorPosition(38 + i, 12);
                    Thread.sleep(100);
                    terminal.putCharacter(q.charAt(i));
                    Thread.sleep(100);
                    terminal.flush();
                }
                Thread.sleep(200);
                terminal.close();
            }
        }
        while (continueReadingInput);
    }
} */


import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.ArrayList;

public class Hangman {


    // Create a terminal.


    public static void main(String[] args) throws Exception {
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal terminal;
        terminal = terminalFactory.createTerminal();
        terminal.setCursorVisible(false);


        ArrayList<String> words = new ArrayList<String>();
        words.add("ambulance");
        words.add("saxophone");
        words.add("terminated");
        words.add("birdseed");
        words.add("flute");
        words.add("sunglasses");
        words.add("factory");
        words.add("hangman");
        words.add("super");
        words.add("pokemon");
        words.add("computer");
        words.add("dishwasher");
        words.add("election");
        words.add("scanner");
        words.add("analog");
        words.add("diner");
        words.add("hamburger");
        words.add("elephant");
        words.add("tiger");
        words.add("lion");

        drawMan draw = new drawMan();

        // Variables for the positioning of the wrong guesses.
        int wrongLetterX = 25;
        int wrongLetterY = 25;
        int errorCounter = 1;
        int rightCounter = 1;

        // Get out a random word from the arraylist.
        int randomPos = (int) (Math.random() * words.size());
        String randomWord = words.get(randomPos);
        System.out.println(randomWord);
        char[] listedWord = randomWord.toCharArray();

        for (int i = 0; i < randomWord.length(); i++) {
            terminal.setCursorPosition(i + 14, 14);
            terminal.putCharacter('_');
        }
        terminal.flush();

        // Quitting the program.
        boolean continueReadingInput = true;

        do {
            KeyStroke keyStroke = null;
            keyStroke = null;
            do {
                Thread.sleep(5); // might throw InterruptedException
                keyStroke = terminal.pollInput();

            } while (keyStroke == null);

            KeyType type = keyStroke.getKeyType();
            Character c = keyStroke.getCharacter();
            terminal.flush();

            boolean isRight = false;

            for (int j = 0; j < listedWord.length; j++) {

                if (c == listedWord[j]) {
                    isRight = true;
                    terminal.setCursorPosition(j + 14, 14);
                    terminal.putCharacter(c);
                    terminal.flush();
                 }
            }

            if (isRight) {
                rightCounter++;

                if (rightCounter == listedWord.length) {
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
            } else {
                terminal.setCursorPosition(wrongLetterX, wrongLetterY);
                terminal.putCharacter(c);
                wrongLetterX++;
                wrongLetterY++;

                draw.drawMan(terminal, errorCounter);
                errorCounter++;
                if (errorCounter == 13) {
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

                terminal.flush();
            }

            if (c == Character.valueOf('q') || c == Character.valueOf('Q')) {
                continueReadingInput = false;
                String q = "QUIT";
                for (int x = 0; x < q.length(); x++) {
                    terminal.setCursorPosition(38 + x, 12);
                    Thread.sleep(100);
                    terminal.putCharacter(q.charAt(x));
                    Thread.sleep(100);
                    terminal.flush();
                }
                Thread.sleep(200);
                terminal.close();
            }

        } while (continueReadingInput);
    }
/*
    private static void drawMan(Terminal terminal, int errorCounter) throws IOException {
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
    }*/
}