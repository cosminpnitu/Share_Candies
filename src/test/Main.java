package test;

import java.util.ArrayList;

import factory.BagFactory;
import gathersurprise.GatherSurprises;
import give.AbstractGiveSurprises;
import give.GiveSurpriseAndApplause;
import give.GiveSurpriseAndHug;
import ibag.IBag;
import ibag.LIFOBag;
import ibag.RandomBag;
import isurprise.Candies;
import isurprise.FortuneCookie;
import isurprise.ISurprise;
import isurprise.MinionToy;

public class Main {

	public static void main(String[] args) {
//		ISurprise surprise1 = FortuneCookie.generate();
//		ISurprise surprise2 = Candies.generate();
//		ISurprise surprise3 = MinionToy.generate();
//		ISurprise surprise4 = MinionToy.generate();
//		ISurprise surprise5 = MinionToy.generate();
//
//
//		IBag randomBag = new RandomBag();
//		IBag lifoBag = new LIFOBag();
//		ArrayList<ISurprise> nSurprises = GatherSurprises.gather(10);
//		nSurprises.toString();
//		for (int i = 0; i < nSurprises.size(); i++) {
//			System.out.println(i + ": " + nSurprises.get(i));
//		}
//		BagFactory bagF = new BagFactory();
//		IBag lifoBag = bagF.makeBag("LIFO");
//		lifoBag.put(surprise2);
//		lifoBag.put(surprise3);
//		lifoBag.put(surprise4);
//		lifoBag.put(surprise5);
//		lifoBag.toString();
////		System.out.println();
////		lifoBag.takeOut();
////		lifoBag.toString();
//		System.out.println();
//		
//		IBag fifoBag = bagF.makeBag("FIFO");
//		fifoBag.put(surprise4);
//		fifoBag.put(surprise3);
//		fifoBag.put(surprise1);
////		fifoBag.toString();
////		fifoBag.takeOut();
////		System.out.println();
//////
//		fifoBag.toString();
//		System.out.println();
//		lifoBag.put(fifoBag);
//		lifoBag.toString();
//		System.out.println();
//		fifoBag.toString();
//		System.out.println();

		ISurprise surprise1 = FortuneCookie.generate();
		ISurprise surprise7 = GatherSurprises.gather();
		ISurprise surprise2 = Candies.generate();
		ISurprise surprise3 = MinionToy.generate();
		ISurprise surprise4 = MinionToy.generate();
		ISurprise surprise5 = MinionToy.generate();
		
//		IBag randomBag = new RandomBag();
		
		AbstractGiveSurprises test = new GiveSurpriseAndApplause("RANDOM", 1);
		AbstractGiveSurprises test2 = new GiveSurpriseAndHug("RANDOM", 1);
		test.giveWithPassion();
		test.put(GatherSurprises.gather());
		test.put(surprise1);
		test.put(surprise2);
		test.put(surprise3);
		test.put(surprise3);
		System.out.println("Tolba 1: ");
		test.getTolba().toString();
//		System.out.println(test.size());
//		test.giveAll();
//		System.out.println(test.size());
		test2.put(GatherSurprises.gather());
		test2.put(surprise3);
		test2.put(surprise2);
		test2.put(surprise1);
		System.out.println("Tolba 2: ");
		test2.getTolba().toString();
		test.put(test2.getTolba());
		System.out.println("Tolba 1 After: ");
		test.getTolba().toString();
		System.out.println("Tolba 2 After: ");
		test2.getTolba().toString();
		test2.getTolba().takeOut();
		
		while (test.size() != 0) {
			test.give();
			System.out.println(test.size());
		}
//		lifoBag.put(surprise1);
//		System.out.println(surprise1);
//		lifoBag.put(surprise3);
//		System.out.println(surprise3);
//		System.out.println("Size lifo: " + lifoBag.size());
//		lifoBag.toString();
//		ISurprise surprise4 = lifoBag.takeOut();
//		System.out.println("Take out: " + surprise4);
//		lifoBag.put(surprise2);
//		lifoBag.put(surprise3);
//		randomBag.put(surprise1);

//		System.out.println("Size random: " + randomBag.size());
//		System.out.println("Size lifo: " + lifoBag.size());

//		randomBag.put(lifoBag);
//		System.out.println("Size total: " + randomBag.size());

//		randomBag.put(surprise1);
//		ISurprise surprise4 = randomBag.takeOut();
//		System.out.println(surprise4);

//		System.out.println(randomBag.isEmpty());
//		System.out.println(randomBag.size());
	}

}
