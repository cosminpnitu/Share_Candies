package give;

import ibag.IBag;
import isurprise.ISurprise;
import java.util.concurrent.TimeUnit;
import factory.BagFactory;

public abstract class AbstractGiveSurprises {
	private static final BagFactory bagF = new BagFactory();
	IBag tolba;
	int waitTime;	
	
	public AbstractGiveSurprises(String typeContainer, int waitTime) {
		this.waitTime = waitTime;
		this.tolba = bagF.makeBag(typeContainer);
	}
	
	//getter Tolba
	public IBag getTolba() {
		return tolba;
	}
	public void put(ISurprise newSurprise) {
		tolba.put(newSurprise);
	}
	public void put(IBag surprises)	{
		tolba.put(surprises);
	}
	public void give() {
		if(!this.tolba.isEmpty()) {
			ISurprise surprise = this.tolba.takeOut();
			surprise.enjoy();
			this.giveWithPassion();
		} else System.out.println("Tolba este goala!");
	}
	public int size() {
		return tolba.size();
	}
	public void giveAll() { 
		for (int i = 0; i < tolba.size();) { //size scade mereu cu 1 cand apelez give()
			give();
			// Sleep for X seconds - code snippet
			try {
				TimeUnit.SECONDS.sleep(this.waitTime); // number of seconds to sleep
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			}
		}
	}
	public boolean isEmpty() {
		return tolba.isEmpty();
	}
	public abstract void giveWithPassion();
}

