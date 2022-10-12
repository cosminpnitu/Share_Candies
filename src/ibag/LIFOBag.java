package ibag;

import java.util.ArrayList;
import java.util.Collection;

import isurprise.ISurprise;

public class LIFOBag implements IBag{
	private ArrayList<ISurprise> lifoContainer = new ArrayList<ISurprise>();


	 // adds a surprise in the bag
	@Override
	public void put(ISurprise newSurprise) {
		lifoContainer.add(newSurprise);
	}
	 
	// adds all the surprises from another IBag
	//   -> the 'bagOfSurprises' will be empty() afterwards??????????????????????????????????????
	@Override
	public void put(IBag bagOfSurprises) {
		while (!bagOfSurprises.isEmpty()) {
			lifoContainer.add(bagOfSurprises.takeOut());
		}
	}
	 
	// removes a surprise from the bag and returns it
	@Override
	public ISurprise takeOut() {
		int index = lifoContainer.size();
		ISurprise surprise = lifoContainer.get(index-1);
		lifoContainer.remove(index-1);
		return surprise;
	}
	
	// Checks if the bag is empty or not
	@Override
	public boolean isEmpty() {
		return lifoContainer.isEmpty();
	}
	 
	// Returns the number of surprises
	@Override
	public int size() {
		return lifoContainer.size();
	}
	@Override
	public String toString() {
		for (int i = 0; i < lifoContainer.size(); i++) {
			System.out.println(i + ": " + lifoContainer.get(i));
		}
		return null;
	}
}