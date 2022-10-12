package isurprise;

import java.util.Random;

public class FortuneCookie implements ISurprise{
	private static final String[] saying = {
			"1. The fortune you seek is in another cookie.",
			"2. A closed mouth gathers no feet.",
			"3. A conclusion is simply the place where you got tired of thinking.",
			"4. A cynic is only a frustrated optimist.",
			"5. A foolish man listens to his heart. A wise man listens to cookies.",
			"6. You will die alone and poorly dressed.",
			"7. A fanatic is one who can't change his mind, and won't change the subject.",
			"8. If you look back, you’ll soon be going that way.",
			"9. You will live long enough to open many fortune cookies.",
			"10. An alien of some sort will be appearing to you shortly.",
			"11. Do not mistake temptation for opportunity.",
			"12. Flattery will go far tonight.",
			"13. He who laughs at himself never runs out of things to laugh at.",
			"14. He who laughs last is laughing at you.",
			"15. He who throws dirt is losing ground.",
			"16. Some men dream of fortunes, others dream of cookies.",
			"17. The greatest danger could be your stupidity.",
			"18. We don’t know the future, but here’s a cookie.",
			"19. The world may be your oyster, but it doesn't mean you'll get its pearl.",
			"20. You will be hungry again in one hour."};
	private static int randomNumber;
	private static final Random random = new Random();
	private final String fortuneMessage;

	private FortuneCookie(String fortuneMessage) {
		this.fortuneMessage = fortuneMessage;
	}
	
	@Override	
	public void enjoy() {
		System.out.println("Felicitari! Tocmai ai deschis o surpriza Fortune Cookie!");
	}
	
	public static FortuneCookie generate() {
		randomNumber = random.nextInt(saying.length - 1);
		return new FortuneCookie(saying[randomNumber]);
	}

	@Override
	public String toString() {
		return "FortuneCookie: " + this.fortuneMessage;
	}
}
