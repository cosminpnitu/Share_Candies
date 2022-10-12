package ibag;

import java.util.ArrayList;
import java.util.Random;
import isurprise.ISurprise;

public class RandomBag implements IBag{
	private ArrayList<ISurprise> randomContainer = new ArrayList<ISurprise>();

	private static int index;
	private static final Random random = new Random();

	 // adds a surprise in the bag
	@Override
	public void put(ISurprise newSurprise) {
		randomContainer.add(newSurprise);
	}
	 
	// adds all the surprises from another IBag
	//   -> the 'bagOfSurprises' will be empty() afterwards??????????????????????????????????????
	@Override
	public void put(IBag bagOfSurprises) {
		while (!bagOfSurprises.isEmpty()) {
			randomContainer.add(bagOfSurprises.takeOut());
		}
	}
	 
	// removes a surprise from the bag and returns it
	@Override
	public ISurprise takeOut() {
		if (randomContainer.size() == 0) {
			System.out.println("RandomBag este goala");
			return null;
		} 
		index = random.nextInt(randomContainer.size());
		ISurprise surprise = randomContainer.get(index);
		randomContainer.remove(index); 
		return surprise;
	}
	 
	// Checks if the bag is empty or not
	@Override
	public boolean isEmpty() {
//		return randomContainer.isEmpty();
		return (randomContainer.size() == 0);
	}
	 
	// Returns the number of surprises
	public int size() {
		return randomContainer.size();
	}
	@Override
	public String toString() {
		for (int i = 0; i < randomContainer.size(); i++) {
			System.out.println(i + ": " + randomContainer.get(i));
		}
		return null;
	}
}
