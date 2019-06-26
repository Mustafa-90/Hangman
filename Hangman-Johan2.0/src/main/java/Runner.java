import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Runner {
    private String word;

    public Runner(String word) {
        this.word = word;
    }

    public void runGame(Terminal terminal) throws IOException, InterruptedException {

        Set<Character> usedLetters = new HashSet<Character>();
        drawMan draw = new drawMan();

        // Variables for the positioning of the wrong guesses.
        int wrongLetterX = 25;
        int wrongLetterY = 25;
        int errorCounter = 1;
        int rightCounter = 0;
        String randomWord = this.word;
        char[] listedWord = this.word.toCharArray();
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
            char c = keyStroke.getCharacter();
            terminal.flush();

            boolean isRight = false;

            for (int j = 0; j < listedWord.length; j++) {
                try {
                    if (c == listedWord[j]) {
                        isRight = true;
                        terminal.setCursorPosition(j + 14, 14);
                        terminal.putCharacter(c);
                        terminal.flush();
                    }
                } catch (Exception e){
                }
            }
            if (usedLetters.contains(c)) {
                String message = "The letter has already been used";
                for (int i = 0; i < message.length(); i++) {
                    terminal.setCursorPosition(i + 15, 20);
                    terminal.putCharacter(message.charAt(i));
                }
            } else if (isRight) {
                rightCounter++;
                String message = "Correct! Enter a new letter.";
                for (int i = 0; i < message.length(); i++) {
                    terminal.setCursorPosition(i + 15, 20);
                    terminal.putCharacter(message.charAt(i));
                }

                if (rightCounter == this.word.length()) {
                    Thread.sleep(2500);
                    terminal.clearScreen();
                    String gz = "Congratulations, you've guessed correct: " + this.word;
                    Hangman.slowPrinter(gz, terminal, false);
                    Thread.sleep(2500);
                    Hangman.quit(terminal);
                    break;
                }
            } else {
                try {
                    terminal.setCursorPosition(wrongLetterX, wrongLetterY);
                    terminal.putCharacter(c);
                    wrongLetterX++;
                    wrongLetterY++;

                    draw.drawMan(terminal, errorCounter);
                    errorCounter++;
                }catch (Exception e){}
                if (errorCounter == 13) {
                    Thread.sleep(3000);
                    terminal.clearScreen();
                    Hangman.slowPrinter("Sorry, you died. The correct word is: " + this.word, terminal, false);
                    Thread.sleep(3000);
                    Hangman.quit(terminal);
                }
                terminal.flush();
            }
            usedLetters.add(c);

            if (keyStroke.getKeyType().equals(KeyType.Escape)) {
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
