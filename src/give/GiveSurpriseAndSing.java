package give;

import ibag.IBag;

public class GiveSurpriseAndSing extends AbstractGiveSurprises {
	IBag tolba;
	int waitTime;	
	
	public GiveSurpriseAndSing(String typeContainer, int waitTime) {
		super(typeContainer, waitTime);
	}
	public void giveWithPassion() {
		give();
		System.out.println("Singing a nice song, full of joy and genuine excitement…");
	}
}
