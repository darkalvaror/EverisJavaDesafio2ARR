package fpdualeveris;

import java.util.Scanner;

import operators.Pinball;

public class FPDual {

	/**
	 * @author Álvaro Rivas Rincón
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/** Creation of an scanner */
		Scanner sc = new Scanner(System.in);
		System.out.println("Set the name of the player");
		String playerName = sc.next();

		/** Execution */
		variablesChallenge(playerName);

	}
	/** Method to play pinball */
	private static void variablesChallenge(String name) {
		/** Add player */
		Pinball jugador1 = new Pinball(name);

		/** Show how strong you shoot the ball */
		System.out.println(jugador1.launchBall());
		
		/** Show all the game */
		jugador1.game();
		
		/** List with the score of the players, in case that there are more than 2 players */
		jugador1.list();
	}

}
