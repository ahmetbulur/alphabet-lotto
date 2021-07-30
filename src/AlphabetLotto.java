
import java.io.IOException;
import java.util.Random;

public class AlphabetLotto {

	// generate necessary stacks and variables
	Stack p1_first_four = new Stack(4);
	Stack p1_last_four = new Stack(4);
	Stack p2_first_four = new Stack(4);
	Stack p2_last_four = new Stack(4);
	Stack bag1 = new Stack(26);
	Stack bag2 = new Stack(26);
	Stack tempstack;
	boolean differentLetters;
	char index1, index2, index3, index4;

	void PushToStacks() {

		// Player 1

		// If letters are different from each other, continue operation
		// else regenerate letters
		do {
			differentLetters = true;
			index1 = (char) getRandomNumberInRange(65, 78);
			index2 = (char) getRandomNumberInRange(65, 78);
			index3 = (char) getRandomNumberInRange(65, 78);
			index4 = (char) getRandomNumberInRange(65, 78);

			if (index1 == index2 || index1 == index3 || index1 == index4 || index2 == index3 || index2 == index4
					|| index3 == index4)
				differentLetters = false;
		} while (!differentLetters);

		// push letters to stack
		p1_first_four.push(index1);
		p1_first_four.push(index2);
		p1_first_four.push(index3);
		p1_first_four.push(index4);

		// If letters are different from each other, continue operation
		// else regenerate letters
		do {
			differentLetters = true;
			index1 = (char) getRandomNumberInRange(79, 90);
			index2 = (char) getRandomNumberInRange(79, 90);
			index3 = (char) getRandomNumberInRange(79, 90);
			index4 = (char) getRandomNumberInRange(79, 90);

			if (index1 == index2 || index1 == index3 || index1 == index4 || index2 == index3 || index2 == index4
					|| index3 == index4)
				differentLetters = false;
		} while (!differentLetters);

		// push letters to stack
		p1_last_four.push(index1);
		p1_last_four.push(index2);
		p1_last_four.push(index3);
		p1_last_four.push(index4);

		// Bag 1

		char ch;

		for (ch = 'A'; ch <= 'Z'; ch++) {

			bag1.push(ch);

		}

		// Player 2

		// If letters are different from each other, continue operation
		// else regenerate letters
		do {
			differentLetters = true;
			index1 = (char) getRandomNumberInRange(65, 78);
			index2 = (char) getRandomNumberInRange(65, 78);
			index3 = (char) getRandomNumberInRange(65, 78);
			index4 = (char) getRandomNumberInRange(65, 78);

			if (index1 == index2 || index1 == index3 || index1 == index4 || index2 == index3 || index2 == index4
					|| index3 == index4)
				differentLetters = false;
		} while (!differentLetters);

		// push letters to stack
		p2_first_four.push(index1);
		p2_first_four.push(index2);
		p2_first_four.push(index3);
		p2_first_four.push(index4);

		// If letters are different from each other, continue operation
		// else regenerate letters
		do {

			differentLetters = true;
			index1 = (char) getRandomNumberInRange(79, 90);
			index2 = (char) getRandomNumberInRange(79, 90);
			index3 = (char) getRandomNumberInRange(79, 90);
			index4 = (char) getRandomNumberInRange(79, 90);

			if (index1 == index2 || index1 == index3 || index1 == index4 || index2 == index3 || index2 == index4
					|| index3 == index4)
				differentLetters = false;
		} while (!differentLetters);

		// push letters to stack
		p2_last_four.push(index1);
		p2_last_four.push(index2);
		p2_last_four.push(index3);
		p2_last_four.push(index4);

	}

	void printPlayer1() {

		System.out.print("Player1 : ");

		tempstack = new Stack(4);
		while (!(p1_first_four.isEmpty())) {
			System.out.print(p1_first_four.peek() + " ");
			tempstack.push(p1_first_four.pop());
		}
		while (!(tempstack.isEmpty()))
			p1_first_four.push(tempstack.pop());

		tempstack = new Stack(4);
		while (!(p1_last_four.isEmpty())) {
			System.out.print(p1_last_four.peek() + " ");
			tempstack.push(p1_last_four.pop());
		}
		while (!(tempstack.isEmpty()))
			p1_last_four.push(tempstack.pop());

		// keep Bag1 in same location on console
		for (int i = 1; i < 10 - (p1_first_four.size() + p1_last_four.size()); i++) {
			System.out.print("  ");
		}

	}

	void printPlayer2() {

		System.out.print("\nPlayer2 : ");

		tempstack = new Stack(4);
		while (!(p2_first_four.isEmpty())) {
			System.out.print(p2_first_four.peek() + " ");
			tempstack.push(p2_first_four.pop());
		}
		while (!(tempstack.isEmpty()))
			p2_first_four.push(tempstack.pop());

		tempstack = new Stack(4);
		while (!(p2_last_four.isEmpty())) {
			System.out.print(p2_last_four.peek() + " ");
			tempstack.push(p2_last_four.pop());
		}
		while (!(tempstack.isEmpty()))
			p2_last_four.push(tempstack.pop());

		// keep Bag2 in same location on console
		for (int i = 1; i < 10 - (p2_first_four.size() + p2_last_four.size()); i++) {
			System.out.print("  ");
		}
	}

	void printBag1() {

		System.out.print("\tBag1 : ");

		tempstack = new Stack(26);
		while (!(bag1.isEmpty()))
			tempstack.push(bag1.pop());

		while (!(tempstack.isEmpty())) {
			System.out.print(tempstack.peek() + " ");
			bag1.push(tempstack.pop());

		}

		System.out.println();

	}

	void printBag2() {

		System.out.print("\tBag2 : ");

		tempstack = new Stack(26);
		while (!(bag2.isEmpty()))
			tempstack.push(bag2.pop());

		while (!(tempstack.isEmpty())) {
			System.out.print(tempstack.peek() + " ");
			bag2.push(tempstack.pop());
		}

		System.out.println("\n");

	}

	private static int getRandomNumberInRange(int min, int max) {

		Random r = new Random();
		return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();

	}

	AlphabetLotto() throws IOException, InterruptedException {

		boolean gameOver = false;
		int prizeUsage = 0, p1_prize = 0, p2_prize = 0;

		PushToStacks();

		printPlayer1();

		printBag1();

		printPlayer2();

		printBag2();

		do {

			boolean generateRandom = false;
			char selectedLetter;

			// If Bag1 contains randomly generated letter, continue operation
			// else regenerate letter
			do {
				selectedLetter = (char) getRandomNumberInRange(65, 90);

				tempstack = new Stack(26);
				while (!(bag1.isEmpty())) {
					if (bag1.peek().equals(selectedLetter)) {
						bag2.push(bag1.pop());
						generateRandom = true;
					} else {
						tempstack.push(bag1.pop());
					}
				}
				while (!(tempstack.isEmpty()))
					bag1.push(tempstack.pop());

			} while (!generateRandom);

			System.out.println("Selected Letter : " + selectedLetter);

			System.out.println(
					"-------------------------------------------------------------------------------------------");

			// if randomly generated letter equals an element on stack, pop that element
			tempstack = new Stack(4);
			while (!(p1_first_four.isEmpty())) {
				if (p1_first_four.peek().equals(selectedLetter)) {
					p1_first_four.pop();
				} else {
					tempstack.push(p1_first_four.pop());
				}
			}
			while (!(tempstack.isEmpty()))
				p1_first_four.push(tempstack.pop());

			// if randomly generated letter equals an element on stack, pop that element
			tempstack = new Stack(4);
			while (!(p1_last_four.isEmpty())) {
				if (p1_last_four.peek().equals(selectedLetter)) {
					p1_last_four.pop();
				} else {
					tempstack.push(p1_last_four.pop());
				}
			}
			while (!(tempstack.isEmpty()))
				p1_last_four.push(tempstack.pop());

			// if randomly generated letter equals an element on stack, pop that element
			tempstack = new Stack(4);
			while (!(p2_first_four.isEmpty())) {
				if (p2_first_four.peek().equals(selectedLetter)) {
					p2_first_four.pop();
				} else {
					tempstack.push(p2_first_four.pop());
				}
			}
			while (!(tempstack.isEmpty()))
				p2_first_four.push(tempstack.pop());

			// if randomly generated letter equals an element on stack, pop that element
			tempstack = new Stack(4);
			while (!(p2_last_four.isEmpty())) {
				if (p2_last_four.peek().equals(selectedLetter)) {
					p2_last_four.pop();
				} else {
					tempstack.push(p2_last_four.pop());
				}
			}
			while (!(tempstack.isEmpty()))
				p2_last_four.push(tempstack.pop());

			// if randomly generated letter equals to an element on bag1, pop that element
			// and
			// push it to bag2
			tempstack = new Stack(26);
			while (!(bag1.isEmpty())) {
				if (bag1.peek().equals(selectedLetter)) {
					bag2.push(bag1.pop());
				} else {
					tempstack.push(bag1.pop());
				}
			}
			while (!(tempstack.isEmpty()))
				bag1.push(tempstack.pop());

			printPlayer1();

			printBag1();

			printPlayer2();

			printBag2();

			// Just one player can take "Birinci Cinko" prize
			// If player1 deletes the first or last 4 letters, he/she gets the award $10
			if ((p1_first_four.isEmpty() || p1_last_four.isEmpty()) && prizeUsage == 0) {
				System.out.println("Player 1 gets $10 (Birinci Cinko)\n");
				p1_prize += 10;
				prizeUsage++;
			}

			// Just one player can take "Birinci Cinko" prize
			// If player2 deletes the first or last 4 letters, he/she gets the award $10
			if ((p2_first_four.isEmpty() || p2_last_four.isEmpty()) && prizeUsage == 0) {
				System.out.println("Player 2 gets $10 (Birinci Cinko)\n");
				p2_prize += 10;
				prizeUsage++;
			}

			Thread.sleep(100);

			// When a player deletes all letters from the stack, game is over
			if ((p1_first_four.isEmpty() && p1_last_four.isEmpty())
					|| (p2_first_four.isEmpty() && p2_last_four.isEmpty()))
				gameOver = true;

		} while (!gameOver);

		// If both players delete their last letter at the same time, their game is over
		// without any winner (tie) and they share the money
		if (p1_first_four.isEmpty() && p1_last_four.isEmpty() && p2_first_four.isEmpty() && p2_last_four.isEmpty()) {
			System.out.println("It’s a draw!");
			p1_prize = 20;
			p2_prize = 20;
		} else {

			// When a player deletes all letters from the stack, he/she wins the game lotto
			// and gets $30.
			if (p1_first_four.isEmpty() && p1_last_four.isEmpty()) {
				System.out.println("Player1 is the winner!");
				p1_prize += 30;
			}
			if (p2_first_four.isEmpty() && p2_last_four.isEmpty()) {
				System.out.println("Player2 is the winner");
				p2_prize += 30;
			}

		}
		System.out.println("Player1 gets $" + p1_prize);
		System.out.println("Player2 gets $" + p2_prize);

	}

}
