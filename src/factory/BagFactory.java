package factory;

import ibag.FIFOBag;
import ibag.IBag;
import ibag.LIFOBag;
import ibag.RandomBag;

public class BagFactory implements IBagFactory{
	public IBag makeBag(String type) {
		switch (type) {
			case "RANDOM":
				return new RandomBag();
			case "LIFO":
				return new LIFOBag();
			case "FIFO":
				return new FIFOBag();
		}
		return null;
	}

}
