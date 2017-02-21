import java.io.IOException;
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
        wordAnswer = setWord();
        boolean endOfGame = true;
        while(endOfGame) {
            getUserInput();
            this.secretWord = hiddenWord();
            printStanding();
            printMan();
            endOfGame = checkIfGameOver();
        }
    }

    public boolean checkIfGameOver(){
        if(this.secretWord.equals(wordAnswer)){
            System.out.println("Great job, you guessed it!");
            return false;
        }else if (numberGuesses == 6){
            System.out.printf("Sorry, out of guesses, the word was: '%s'", wordAnswer);
            return false;
        }else{
            return true;
        }
    }

    public void getUserInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("choose a letter: ");
        String userInput = scanner.nextLine().toLowerCase();
        guessLetter(userInput);
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

    public void printMan(){
        switch(getNumberGuesses()){
            case 0:
                System.out.printf("-----------\n" +
                        " |        |\n" +
                        "          |\n" +
                        "          |\n" +
                        "          |\n" +
                        "          |\n" +
                        "          |\n" +
                        "------------------------\n");
                break;
            case 1:
                System.out.printf("-----------\n" +
                        " |        |\n" +
                        " ()       |\n" +
                        "          |\n" +
                        "          |\n" +
                        "          |\n" +
                        "          |\n" +
                        "------------------------\n");
                break;
            case 2:
                System.out.printf("-----------\n" +
                        " |        |\n" +
                        " ()       |\n" +
                        " ||       |\n" +
                        " ||       |\n" +
                        "          |\n" +
                        "          |\n" +
                        "------------------------\n");
                break;
            case 3:
                System.out.printf("-----------\n" +
                        "  |        |\n" +
                        "  ()       |\n" +
                        " \\||       |\n" +
                        "  ||       |\n" +
                        "           |\n" +
                        "           |\n" +
                        "------------------------\n");
                break;
            case 4:
                System.out.printf("-----------\n" +
                        "  |        |\n" +
                        "  ()       |\n" +
                        " \\||/     |\n" +
                        "  ||       |\n" +
                        "           |\n" +
                        "           |\n" +
                        "------------------------\n");
                break;
            case 5:
                System.out.printf("-----------\n" +
                        "  |       |\n" +
                        "  ()      |\n" +
                        " \\||/     |\n" +
                        "  ||      |\n" +
                        " /        |\n" +
                        "          |\n" +
                        "------------------------\n");
                break;
            case 6:
                System.out.printf("-----------\n" +
                        " |        |\n" +
                        " ()       |\n" +
                        "\\||/      |\n" +
                        " ||       |\n" +
                        "/  \\      |\n" +
                        "          |\n" +
                        "------------------------\n");
        }
    }

}
