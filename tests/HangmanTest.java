import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HangmanTest {

    @Test
    public void getRandomNum(){
        Hangman h = new Hangman();
        String[] listOfWords = {
                "dog", "cat", "elmo", "easy", "apple",
                "caterpillar", "eskimo", "origami", "sushi"
        };

        int i = 0;
        while (i < 100) {
            assertTrue(h.getRandomNumber(listOfWords) < listOfWords.length);
            i++;
        }
    }

    @Test
    public void setARandomWord(){
        Hangman h = new Hangman();
        String word = h.setWord();
        String[] listOfWords = {
                "dog", "cat", "elmo", "water", "alaska",
                "thermal", "inadvertently", "purified",
                "eating", "forward", "drowning", "career"
        };

        assertTrue(Arrays.asList(listOfWords).contains(word));
    }

    @Test
    public void hiddenWord(){
        Hangman h = new Hangman();
        h.setWordAnswer("hello");
        h.setLettersGuessed("ho");

        assertTrue(h.hiddenWord().equals("h___o"));
    }

    @Test
    public void checkNumberOfGuesses(){
        Hangman h = new Hangman();
        h.setWordAnswer("hello");
        h.guessLetter("x");
        h.guessLetter("t");
        h.guessLetter("e"); //in the wordAnswer so doesn't increment numberOfGuesses.
        assertTrue(h.getNumberGuesses() == 2);
    }

    @Test
    public void getLettersGuesses(){
        Hangman h = new Hangman();
        h.setWordAnswer("hello");
        h.guessLetter("x");
        h.guessLetter("t");
        h.guessLetter("e"); //in the wordAnswer so doesn't increment numberOfGuesses.
        assertTrue(h.getLettersGuessed().equals("xte"));
    }

    @Test
    public void playGuessesExceeded(){
        Hangman h = new Hangman();
        h.setWordAnswer("hello");
        h.guessLetter("x");
        h.guessLetter("t");
        h.guessLetter("m");
        h.guessLetter("j");
        h.guessLetter("a");
        h.guessLetter("r");
        assertTrue(h.getNumberGuesses() > 5);
    }

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void x() {
        Hangman h = new Hangman();
        h.setWordAnswer("hello");
        h.guessLetter("x");
        h.guessLetter("t");
        h.guessLetter("m");
        h.guessLetter("j");
        h.guessLetter("a");
        h.guessLetter("r");
        h.play();
        assertEquals(String.format("Sorry, out of guesses, the word was: '%s'",h.getWordAnswer()) , systemOutRule.getLog());
    }

}
