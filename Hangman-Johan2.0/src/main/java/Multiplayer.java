import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.Terminal;

import javax.swing.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Multiplayer {
    public Terminal terminal;



    public Multiplayer(com.googlecode.lanterna.terminal.Terminal terminal) { //Had to use weird terminal shit. THink i could import instead.
        this.terminal = terminal;

    }
    public String getWordMultiplayer() throws IOException, InterruptedException {
        String word = JOptionPane.showInputDialog(null, "Enter word. Do not show your opponent!");
        System.out.println(word);
        return word;

    }


}
