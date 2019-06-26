import com.googlecode.lanterna.terminal.Terminal;

import java.util.ArrayList;

public class Singleplayer {
    private Terminal terminal;


    public Singleplayer(Terminal terminal) {
        this.terminal = terminal;
    }

    public String word(){
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

        int randomPos = (int) (Math.random() * words.size());
        String randomWord = words.get(randomPos);


        return randomWord;
    }


}
