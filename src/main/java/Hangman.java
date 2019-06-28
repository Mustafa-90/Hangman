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

        Set<Character> usedLetters = new HashSet<Character>();

        List<String> words = getWordsFromFile();

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

        drawMan.generateBoard(terminal, randomWord);

        // Quitting the program.
        boolean continueReadingInput = true;

        do {
            KeyStroke keyStroke = null;
            keyStroke = null;
            do {
                Thread.sleep(5); // might throw InterruptedException
                keyStroke = terminal.pollInput();
                terminal.flush();
            } while (keyStroke == null);

            KeyType type = keyStroke.getKeyType();
            Character c = keyStroke.getCharacter();
            terminal.flush();

            if (keyStroke.getKeyType().equals(KeyType.Enter)) {
                continueReadingInput = false;
                String q = "QUIT";
                for (int x = 0; x < q.length(); x++) {
                    terminal.setCursorPosition(30 + x, 7);
                    Thread.sleep(100);
                    terminal.putCharacter(q.charAt(x));
                    Thread.sleep(100);
                    terminal.flush();
                }
                Thread.sleep(200);
                terminal.close();
            }

            boolean isRight = false;

            for (int j = 0; j < listedWord.length; j++) {

                if (c == listedWord[j] && !usedLetters.contains(c)) {
                    isRight = true;
                    terminal.setCursorPosition(j + 14, 14);
                    terminal.putCharacter(c);
                    terminal.flush();
                    rightCounter++;
                    System.out.println(rightCounter);
                }
            }

            if (usedLetters.contains(c)) {
                String message = "The letter has already been used.";
                for (int i = 0; i < message.length(); i++) {
                    terminal.setCursorPosition(i + 15, 20);
                    terminal.putCharacter(message.charAt(i));
                    terminal.flush();
                }

            } else if (isRight) {
                String message = "Correct! Enter a new letter.";
                for (int i = 0; i < message.length(); i++) {
                    terminal.setCursorPosition(i + 15, 20);
                    terminal.putCharacter(message.charAt(i));
                    terminal.flush();
                }
                for (int i = 26; i < 32; i++) {
                    terminal.setCursorPosition(i + 17, 20);
                    terminal.putCharacter(' ');
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
//                drawMan.guessCounter(terminal, errorCounter);
                errorCounter++;
                terminal.flush();

                if (errorCounter == 13) {
                    draw.loserPrint(terminal);
                    continueReadingInput=false;
                    terminal.flush();
                }
            }
            usedLetters.add(c);

        } while (continueReadingInput);
    }

    private static List<String> getWordsFromFile() {
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