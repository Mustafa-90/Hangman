import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Hangman {


    public static void main(String[] args) throws Exception {

        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal terminal;
        terminal = terminalFactory.createTerminal();
        terminal.setCursorVisible(false);

        boolean continuePlaying = true;

        Set<Character> usedLetters = new HashSet<Character>();

        List<String> words = getWordsFromFile();

        drawMan draw = new drawMan();

        // Variables for the positioning of the wrong guesses.
        int wrongLetterX = 25;
        int wrongLetterY = 25;
        int errorCounter = 1;
        int rightCounter = 0;

        while (continuePlaying) {
            // Get out a random word from the arraylist.
            int randomPos = (int) (Math.random() * words.size());
            String randomWord = words.get(randomPos);
            randomWord = randomWord.toUpperCase();
            System.out.println(randomWord);

            char[] listedWord = randomWord.toCharArray();

            drawMan.generateBoard(terminal, randomWord);

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
                c = c.toUpperCase(c);
                terminal.flush();

                // Quit game when pressing the ENTER key.
                if (type.equals(KeyType.Enter)) {
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

                boolean isRight = false;
                try {
                    // Check if the entered letter is correct.
                    for (int j = 0; j < listedWord.length; j++) {

                        if (c == listedWord[j] && !usedLetters.contains(c)) {
                            isRight = true;
                            terminal.setCursorPosition(j + 14, 14);
                            terminal.putCharacter(c);
                            terminal.flush();
                            rightCounter++;
                        }
                    }
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }

                // Print out if letter has been used.
                if (usedLetters.contains(c)) {
                    String message = "The letter has already been used";
                    for (int i = 0; i < message.length(); i++) {
                        terminal.setCursorPosition(i + 15, 20);
                        terminal.putCharacter(message.charAt(i));
                    }
                    terminal.flush();
                }
                // If letter is correct, print out correct and put the character instead of " _ "
                else if (isRight) {
                    draw.correctLetter(terminal);
                    terminal.flush();

                    // Double check if the whole word is found.
                    if (rightCounter == listedWord.length) {
                        draw.winnerPrint(terminal);
                        usedLetters.clear();
                        errorCounter = 1;
                        rightCounter = 0;
                        wrongLetterX = 25;
                        wrongLetterY = 25;
                        terminal.flush();

                        Thread.sleep(2000);
                        terminal.clearScreen();
                        continueReadingInput = false;
                    }
                }

                // If wrong letter, print out a message and print out
                // the wrong letter.
                else {
                    terminal.setCursorPosition(wrongLetterX, wrongLetterY);
                    terminal.putCharacter(c);
                    wrongLetterX++;
                    wrongLetterY++;

                    String message = "Wrong! Enter a new letter.";
                    for (int i = 0; i < message.length(); i++) {
                        terminal.setForegroundColor(TextColor.ANSI.RED);
                        terminal.setCursorPosition(i + 15, 20);
                        terminal.putCharacter(message.charAt(i));
                        terminal.setForegroundColor(TextColor.ANSI.WHITE);
                    }

                    for (int j = 26; j < 32; j++) {
                        terminal.setCursorPosition(j + 15, 20);
                        terminal.putCharacter(' ');
                    }

                    // Method to print out the man.
                    draw.drawMan(terminal, errorCounter);
                    errorCounter++;

                    // Print out if the user lost the game.
                    if (errorCounter == 13) {
                        draw.loserPrint(terminal);
                        for (int x = 0; x < randomWord.length(); x++) {
                            terminal.setCursorPosition(x + 14, 14);
                            Thread.sleep(100);
                            terminal.putCharacter(randomWord.charAt(x));
                            Thread.sleep(100);
                            terminal.flush();
                        }
                        Thread.sleep(200);
                        Thread.sleep(2000);

                        usedLetters.clear();
                        errorCounter = 1;
                        rightCounter = 0;
                        wrongLetterX = 25;
                        wrongLetterY = 25;
                        terminal.clearScreen();

                        continueReadingInput = false;
                    }
                    terminal.flush();
                }

                usedLetters.add(c);

            } while (continueReadingInput);
        }
    }
    private static List<String> getWordsFromFile () {
        File file = new File("wordsDB.txt");
        Scanner scan = null;
        List<String> words;
        String wordsFromFile = "";
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
        while (scan.hasNext()) {
            wordsFromFile = wordsFromFile.concat(scan.nextLine() + "\n").trim();
        }
        String[] arrOfWords = wordsFromFile.split(",");

        return words = Arrays.asList(arrOfWords);
    }
}
