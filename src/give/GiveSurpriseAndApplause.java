package give;

import ibag.IBag;

public class GiveSurpriseAndApplause extends AbstractGiveSurprises {
	IBag tolba;
	int waitTime;	
	
	public GiveSurpriseAndApplause(String typeContainer, int waitTime) {
		super(typeContainer, waitTime);
	}
	public void giveWithPassion() {
		System.out.println("Loud applause to you… For it is in giving that we receive.");
	}
}
