import java.util.Random;
import java.util.Scanner;

public class Hangman {
    private String wordAnswer;
    private String secretWord ="";
    private int numberGuesses = 0;
    private String lettersGuessed = "";

    public void printInstructions(){
        System.out.println("The man is on the gallows\nthe only way to save him\nis to guess the word in front of you\n" +
                "and you only have 6 tries!");
    }

    public String getLettersGuessed(){
        return lettersGuessed;
    }

    public int getNumberGuesses(){
        return numberGuesses;
    }

    public void setWordAnswer(String wordAnswer){
        this.wordAnswer = wordAnswer;
    }

    public void setLettersGuessed(String s){
        this.lettersGuessed = s;
    }

    public void play(){
        Scanner scanner = new Scanner(System.in);
        wordAnswer = setWord();
        while(numberGuesses < 6 ) {
            System.out.printf("choose a letter: ");
            String userInput = scanner.nextLine().toLowerCase();
            guessLetter(userInput);
            this.secretWord = hiddenWord();
            printStanding();
            if(this.secretWord.equals(wordAnswer)) {
                break;
            }
        }
        if(numberGuesses == 6) {
            System.out.printf( "Sorry, out of guesses, the word was: '%s'", wordAnswer);
        }else {
            System.out.println("great job, you guessed it!");
        }
    }

    public void promptUser(){

    }

    public String getWordAnswer(){
        return this.wordAnswer;
    }

    public void printStanding(){
        System.out.println("Num Guesses: " + numberGuesses);
        System.out.println("Letters Guessed: " + lettersGuessed);
        System.out.println("To Guess: " + secretWord);
    }

    public String setWord(){
        String[] listOfWords = {
                "dog", "cat", "elmo", "water", "alaska",
                "thermal", "inadvertently", "purified",
                "eating", "forward", "drowning", "career"
        };
        return listOfWords[getRandomNumber(listOfWords)];
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
            this.lettersGuessed += letter;
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
