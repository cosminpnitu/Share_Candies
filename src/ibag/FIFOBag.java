package ibag;

import java.util.ArrayList;

import isurprise.ISurprise;

public class FIFOBag implements IBag {
	private ArrayList<ISurprise> fifoContainer = new ArrayList<ISurprise>();
	
	 // adds a surprise in the bag
	@Override
	public void put(ISurprise newSurprise) {
		fifoContainer.add(newSurprise);
	}
	 
	// adds all the surprises from another IBag
	//   -> the 'bagOfSurprises' will be empty() afterwards??????????????????????????????????????
	@Override
	public void put(IBag bagOfSurprises) {
		while (!bagOfSurprises.isEmpty()) {
			fifoContainer.add(bagOfSurprises.takeOut());
		}
	}
	 
	// removes a surprise from the bag and returns it
	@Override
	public ISurprise takeOut() {
		int index = 0;
		ISurprise surprise = fifoContainer.get(index);
		fifoContainer.remove(index);
		return surprise;
	}
	
	// Checks if the bag is empty or not
	@Override
	public boolean isEmpty() {
		return fifoContainer.isEmpty();
	}
	 
	// Returns the number of surprises
	public int size() {
		return fifoContainer.size();
	}
	@Override
	public String toString() {
		for (int i = 0; i < fifoContainer.size(); i++) {
			System.out.println(i + ": " + fifoContainer.get(i));
		}
		return null;
	}
}
