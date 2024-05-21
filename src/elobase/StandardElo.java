package elobase;

import java.util.Random;

import elobase.Player;

public class StandardElo {
	
	static final int k = 32;
	static final int c = 400;
	static final int R_a0 = 1000;
	
	 /**
	  * Calculates expected score using players and opponents ratings
	  * @param r_a Player rating
	  * @param r_b Opponent rating
	  * @return Expected score
	  */
	static double calcE_a(double R_a, double R_b) {
		return Q_x(R_a) / (Q_x(R_a) + Q_x(R_b));
	}
	
	static double Q_x(double R_x) {
		return Math.pow(10, R_x/c);
	}

	//S_a actual outcome
	//E_a expected outcome
	static double calcRprime_a(double R_a, double S_a, double E_a) {
		return R_a + ( k * (S_a - E_a) );
	}
	
	static double calcS_a(double P_a, double P_b) {
		return P_a/(P_a + P_b);
	}
	
	static double allInOneCalculation(double R_a, double R_b, double P_a, double P_b) {
		return calcRprime_a(R_a, calcS_a(P_a, P_b), calcE_a(R_a, R_b));
	}
	
	static void playGame(Player a, Player b, int P_a, int P_b) {
		a.setRating(allInOneCalculation(a.getRating(), b.getRating(), P_a, P_b));
		b.setRating(allInOneCalculation(b.getRating(), a.getRating(), P_b, P_a));
	}

	
	static void playGame_randomWinner(Player a, Player b) {
		Random r = new Random();
		if (r.nextInt(10) > 4) {
			playGame(a, b, 1, 0);
			System.out.println(a.getName() + " won the Random game");
		}
		else {
			playGame(b, a, 1, 0);
			System.out.println(b.getName() + " won the Random game");
		}
	}
	
//static void playGradient
	
	public static void main(String[] args) {
		Player max = new Player("Max Verstappen");
		Player sergio = new Player("Sergio Perez");
		
		playGame(max, sergio, 20 - 1, 20 - 2); //Bahrain: Verstappen won, Perez placed second
		playGame(max, sergio, 20 - 2, 20 - 1); //Saudi
		playGame(max, sergio, 20 - 1, 20 - 5); //Austrailia
		playGame(max, sergio, 20 - 2, 20 - 1); //Baku
		playGame(max, sergio, 20 - 1, 20 - 2); //Miami
		playGame(max, sergio, 20 - 1, 20 - 16); //Monaco
		playGame(max, sergio, 20 - 1, 20 - 4); //Spain
		playGame(max, sergio, 20 - 1, 20 - 6); //Canadia
		playGame(max, sergio, 20 - 1, 20 - 3); //Red Bull Ring
		playGame(max, sergio, 20 - 1, 20 - 6); //Perez
		playGame(max, sergio, 20 - 1, 20 - 3); //Hungary
		playGame(max, sergio, 20 - 1, 20 - 2); //Spa
		playGame(max, sergio, 20 - 1, 20 - 4); //Holland
		playGame(max, sergio, 20 - 1, 20 - 2); //Monza
		playGame(max, sergio, 20 - 5, 20 - 8); //Singapore
		playGame(max, sergio, 20 - 1, 20 - 19); //Japan
		playGame(max, sergio, 20 - 1, 20 - 10); //Qatar
		playGame(max, sergio, 20 - 1, 20 - 4); //COTA
		playGame(max, sergio, 20 - 1, 20 - 20); //Mexico
		playGame(max, sergio, 20-20, 20 - 1); //Fiction
		//playGame_randomWinner(jim, john);
		
		System.out.println(max);
		System.out.println(sergio);
		
		
	}
	
}
