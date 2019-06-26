import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Hangman {

    public static void main(String[] args) throws Exception {

        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal terminal;
        terminal = terminalFactory.createTerminal();
        terminal.setCursorVisible(false);

        slowPrinter("Welcome to HANGMAN", terminal, true);
        int input = JOptionPane.showConfirmDialog(null, "Do you want to play in multiplayer mode?");
        // 0=yes, 1=no, 2=cancel
        if (input == 0) {
            Multiplayer multiplayer = new Multiplayer(terminal);
            String word = multiplayer.getWordMultiplayer();
            Runner run = new Runner(word);
            run.runGame(terminal);
        } else if(input == 1) {
            Singleplayer singleplayer = new Singleplayer(terminal);
            String word = singleplayer.word();
            Runner run = new Runner(word);
            run.runGame(terminal);
        } else {
            quit(terminal);

        }
    }
    public static void slowPrinter(String message, Terminal terminal, boolean deleteMessage) throws IOException, InterruptedException {
        for (int i = 0; i < message.length(); i++) {
            terminal.setCursorPosition(24 + i, 12);
            Thread.sleep(75);
            terminal.putCharacter(message.charAt(i));
            Thread.sleep(100);
            terminal.flush();
        }
        if (deleteMessage) {
            for (int i = 0; i < message.length(); i++) {
                terminal.setCursorPosition(24 + i, 12);
                Thread.sleep(50);
                terminal.putCharacter(' ');
                Thread.sleep(50);
                terminal.flush();
            }
        }
    }
    static void quit(Terminal terminal) throws IOException, InterruptedException {
        slowPrinter("BYE BYE", terminal, true);
        terminal.close();
    }
}