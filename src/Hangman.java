import java.util.Scanner;

public class Hangman {
	
	private static boolean gameEnded = false;
	private static String word;

	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean isCorrect = false;
		int tries = 5;

			while (isCorrect == false) {
				System.out.println("Enter your word:");
				word = scan.nextLine().toLowerCase();
				if (isCorrectWord(word)) {
					isCorrect = true;
				} else {
					System.out.println("Incorrect input (Use only letters)");
				}
			}
		char[] charWord = word.toCharArray();
		char[] guessWord = new char[word.length()];
		clearScreen();
		for (int i = 0; i < word.length(); i ++) {
			guessWord[i] = '_';
			System.out.print("_ ");
		}
		System.out.println();
		
		boolean guessCorrect;
		while (gameEnded == false || tries > 0) {
			guessCorrect = false;
			if (tries <= 0) {
				System.out.println("You Lose!");
				return;
			}

			System.out.println("Enter your letter guess (" + tries + " remaining)" + ":");
			char letterGuess = scan.next().charAt(0);
			for (int j = 0; j < charWord.length; j ++) {
				if (charWord[j] == letterGuess) {
					guessWord[j] = letterGuess;
					guessCorrect = true;
				}
			}
			if (!(guessCorrect)) {
				System.out.println("Incorrect");
				tries--;
			}
			for (int k = 0; k < guessWord.length; k++) {
				System.out.print(guessWord[k] + " ");
			}
			System.out.println();
			
			String finalWord = "";
			for (int m = 0; m < guessWord.length; m++) {
				finalWord += guessWord[m];
			}
			
			if (!(finalWord.contains("_"))) {
				System.out.println("Congratulations, you win!");
				return;
			}
			}
		
	}
	
	public static boolean isCorrectWord(String name) {
		return name.matches("[a-zA-Z]+");
	}
	
	public static void clearScreen() {
		for(int clear = 0; clear < 100; clear++) {
		    System.out.println("\b") ;
		}
	}
}
