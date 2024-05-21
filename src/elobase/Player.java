package elobase;

public class Player {
	
	private double elo;
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name1) {
		name = name1;
	}

	
	public double getRating() {
		return elo;
	}

	public void setRating(double elo1) {
		elo = elo1;
	}

	public Player(String name1){
		name = name1;
		elo = StandardElo.R_a0;
	}
	
	public String toString() {
		return name + ", Rating: " + elo; 
	}

}
