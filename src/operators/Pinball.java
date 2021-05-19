package operators;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 
 * @author Álvaro Rivas Rincón
 *
 */
public class Pinball implements Comparable<Pinball>{
	private static int randomNumber;
	private static int launchNumber;
	private static int dice;
	private boolean tryAgain = true;
	private String name;
	private static int score;
	private static LinkedList<String> list = new LinkedList<String>();
	
	/** Get the  name from the main class */
	public Pinball(String name) {
		this.name = ((name == null) ? (name = "Jugador1") : (name));
	}

	/**
	 * Method to launch the ball, could be 3 types: weak, normal or strong, everyone
	 * has more points
	 */
	public String launchBall() {
		launchNumber = (int) (Math.random() * (90 - 1) + 1);
		if (launchNumber > 1 && launchNumber < 30) {
			System.out.println("Weak shoot, you will receive: ");
			score = 30;
		}
		if (launchNumber >= 30 && launchNumber < 60) {
			System.out.println("Normal shoot, you will receive: ");
			score = 60;
		}
		if (launchNumber >= 60 && launchNumber < 90) {
			System.out.println("Strong shoot, you will receive: ");
			score = 90;
		}

		/** Call the method to see your actual score */
		return getScore();
	}

	/** Method to play the game */
	public void game() {

		/**
		 * Depends of the shoot, you will have more probability or less to get more
		 * points and dont let the ball fall
		 */
		randomNumber = (int) (Math.random() * (100 - 1) + 1);

		/** Week shoot */
		if (launchNumber > 1 && launchNumber < 30) {
			while (tryAgain == true) {
				if (randomNumber < 30) {
					System.out.println("Your ball is bouncing");
					score += randomNumber;
					/** Call the method for bonus */
					bonus();
					randomNumber = (int) (Math.random() * (100 - 1) + 1);
				} else {
					System.out.println("Oh no!! your ball is going down, what do you want?");
					/** Call the method to try to play again */
					tryAgain();
				}
			}
		}

		/** Normal shoot */
		if (launchNumber >= 30 && launchNumber < 60) {
			while (tryAgain == true) {
				if (randomNumber < 20) {
					System.out.println("Your ball is bouncing");
					score += randomNumber;
					/** Call the method for bonus */
					bonus();
					randomNumber = (int) (Math.random() * (100 - 1) + 1);
				} else {
					System.out.println("Oh no!! your ball is going down, what do you want?");
					/** Call the method to try to play again */
					tryAgain();
				}
			}
		}

		/** Strong shoot */
		if (launchNumber >= 60 && launchNumber < 90) {
			while (tryAgain == true) {
				if (randomNumber < 10) {
					System.out.println("Your ball is bouncing");
					score += randomNumber;
					/** Call the method for bonus */
					bonus();
					randomNumber = (int) (Math.random() * (100 - 1) + 1);
				} else {
					System.out.println("Oh no!! your ball is going down, what do you want?");
					/** Call the method to try to play again */
					tryAgain();
				}
			}
		}

	}

	/**
	 * Method where you can keep playing again or you can finish the game and get
	 * all your points
	 */
	public void tryAgain() {
		/** Ask what the player want */
		Scanner sc = new Scanner(System.in);
		System.out.println("If you want to try again, press 0");
		System.out.println("If you want to finish the game press 1");
		byte resultado = sc.nextByte();
		/** If the player want to play again */
		if (resultado == 0) {
			randomNumber = (int) (Math.random() * (100 - 1) + 1);
			launchNumber = (int) (Math.random() * (100 - 1) + 1);
			/** If the player want to stop play */
		} else if (resultado == 1) {
			System.out.println("You finish the game, getting score...");
			/** Call the method to show the final score */
			totalScore();
			tryAgain = false;
		} else {
			/** Do this when the player dont put 1 or 0 */
			while (resultado != 0 || resultado != 1) {
				System.out.println("Just write 0 or 1, please");
				System.out.println("If you want to try again, press 0");
				System.out.println("If you want to finish the game press 1");
				resultado = sc.nextByte();
				if (resultado == 0) {
					randomNumber = (int) (Math.random() * (100 - 1) + 1);
					launchNumber = (int) (Math.random() * (100 - 1) + 1);
					break;
				} else if (resultado == 1) {
					System.out.println("You finish the game, getting score...");
					/** Call the method to show the final score */
					totalScore();
					tryAgain = false;
					break;
				}
			}
		}
	}

	/** Method to do some bonus for the score */
	public void bonus() {
		dice = (int) (Math.random() * (7 - 1) + 1);
		if (dice == 2) {
			System.out.println("Score x2!!!");
			score = score * 2;
		} else if (dice == 3) {
			System.out.println("You received a strong shoot");
			launchNumber = 89;
		} else if (dice == 4) {
			System.out.println("You lose 500 points");
			score -= 500;
			if (score < 0) {
				score = 0;
			}
		} else if (dice == 5) {
			System.out.println("Score x3");
			score = score * 3;
		}
	}
	
	/** Establish the format of the list, and show it */
	public void list() {
		list.add("Jugador: " + getName() + ": " + getScore());
		System.out.println(list);
	}
	
	/** Show the total score at the end */
	public void totalScore() {
		System.out.println(getName() + " , your total score is: " + getScore());
	}

	/** Get the name of the player */
	public String getName() {
		return name;
	}

	/** Set the name of the player */
	public void setName(String name) {
		this.name = name;
	}

	/** Get the score */
	public static String getScore() {
		return score + " points";
	}
	
	/** Get the list */
	public LinkedList<String> getLista() {
		return list;
	}
	
	/** Set the list */
	public void setLista(LinkedList<String> lista) {
		this.list = lista;
	}
	
	@Override
	public int compareTo(Pinball o) {
		// TODO Auto-generated method stub
		return this.score - o.score;
	}
}
