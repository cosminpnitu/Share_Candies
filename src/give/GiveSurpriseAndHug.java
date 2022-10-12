package give;

import ibag.IBag;

public class GiveSurpriseAndHug extends AbstractGiveSurprises {
	IBag tolba;
	int waitTime;	
	
	public GiveSurpriseAndHug(String typeContainer, int waitTime) {
		super(typeContainer, waitTime);
	}
	public void giveWithPassion() {
		give();
		System.out.println("Warm wishes and a big hug!");
	}
}
