import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Hangman {


    public static void main(String[] args) throws Exception {

        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal terminal;
        terminal = terminalFactory.createTerminal();
        terminal.setCursorVisible(false);

        Set<Character> usedLetters = new HashSet<Character>();

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
        int rightCounter = 0;

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

            if (usedLetters.contains(c)) {
                String message = "The letter has already been used";
                for (int i = 0; i < message.length(); i++) {
                    terminal.setCursorPosition(i + 15, 20);
                    terminal.putCharacter(message.charAt(i));
                }
                terminal.flush();

            } else if (isRight) {
                rightCounter++;
                String message = "Correct! Enter a new letter.";
                for (int i = 0; i < message.length(); i++) {
                    terminal.setCursorPosition(i + 15, 20);
                    terminal.putCharacter(message.charAt(i));
                    terminal.flush();
                }

                if (rightCounter == listedWord.length) {
                    draw.winnerPrint(terminal);
                    terminal.flush();
                }
            } else {
                terminal.setCursorPosition(wrongLetterX, wrongLetterY);
                terminal.putCharacter(c);
                wrongLetterX++;
                wrongLetterY++;

                draw.drawMan(terminal, errorCounter);
                errorCounter++;
                terminal.flush();

                if (errorCounter == 13) {
                    draw.loserPrint(terminal);
                    terminal.flush();
                }

            }

            usedLetters.add(c);

            if (keyStroke.getKeyType().equals(KeyType.Enter)) {
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
}