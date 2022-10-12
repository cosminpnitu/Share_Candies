package gathersurprise;

import java.util.ArrayList;
import java.util.Random;

import isurprise.Candies;
import isurprise.FortuneCookie;
import isurprise.ISurprise;
import isurprise.MinionToy;

public final class GatherSurprises {
	private static ISurprise surprise;

	private GatherSurprises() {	
	}
	public static ArrayList<ISurprise> gather(int n) {
		ArrayList<ISurprise> nSurprises = new ArrayList<ISurprise>();
		for (int i = 0; i < n; i++) {
			nSurprises.add(gather());
		}
		return nSurprises;
		
	}
	public static ISurprise gather() {
		Random random = new Random();
		int index = random.nextInt(3);
		switch (index) {
			case 0:
				surprise = FortuneCookie.generate();
				break;
			case 1:
				surprise = Candies.generate();
				break;
			case 2:
				surprise = MinionToy.generate();
				break;
		}
		return surprise;
	}
}
