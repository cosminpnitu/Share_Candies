package isurprise;

import java.util.Random;
public class Candies implements ISurprise{
	private static final String[] candyTypeList = {"chocolate", "jelly", "fruits", "vanilla"};
	private static int randomNumber1, randomNumber2;
	private static final Random random = new Random();
	private int candyNr;
	private final String candyType;

	private Candies(String candyType, int candyNr) {
		this.candyType = candyType;
		this.candyNr = candyNr;
	}
	
	@Override
	public void enjoy() {
		System.out.println("Felicitari! Tocmai ai primit un cadou de tipul Candies!");
	}
	
	public static Candies generate() {
		randomNumber1 = random.nextInt(candyTypeList.length - 1);
		randomNumber2 = random.nextInt(9); 
		return new Candies(candyTypeList[randomNumber1], 1 + randomNumber2);
	}
	
	@Override
	public String toString() {
		return "Candies: You will get " + this.candyNr + " " + this.candyType + " candies";
	}
}
