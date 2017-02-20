import java.util.Random;
import java.util.Scanner;

public class Hangman {
    private String wordAnswer;  //Solution
    private String secretWord ="";  //Current word will include _
    private int numberGuesses = 0;
    private String lettersGuessed = "";

    public void printInstructions(){
//        System.out.println("The man is on the gallows\nthe only way to save him\nis to guess the word in front of you\n" +
//                "and you only have 6 tries!");
    }

    public void play(){
        Scanner scanner = new Scanner(System.in);
        while(numberGuesses < 6 || wordAnswer.equals(secretWord)) {
            System.out.printf("choose a letter: ");
            String userInput = scanner.nextLine();
            guessLetter(userInput);
            this.secretWord = hiddenWord();
            printStanding();
        }
    }

    public void printStanding(){
        System.out.println("Num Guesses: " + numberGuesses);
        System.out.println("Letters Guessed: " + lettersGuessed);
        System.out.println("To Guess: " + secretWord);
    }

    public void setWord(){
        String[] listOfWords = {
                "dog", "cat", "elmo", "easy", "apple",
                "caterpillar", "eskimo", "origami", "sushi"
        };
        wordAnswer = listOfWords[getRandomNumber(listOfWords)];
    }

    public int getRandomNumber(String[] arry){
        Random random = new Random();
        return random.nextInt(arry.length);
    }

    public void guessLetter(String letter) {
        if(lettersGuessed.contains(letter)){
            return;
        } else if (!this.wordAnswer.contains(letter)){
            numberGuesses++;
        } else {
            this.lettersGuessed += letter;
        }

    }

    public String hiddenWord() {

        String secretWord = "";
        for(String letter : this.wordAnswer.split("")){
            if(this.lettersGuessed.contains(letter)){
                secretWord+=letter;
            } else {
                secretWord+="_";
            }
        }
        return secretWord;

    }

}
