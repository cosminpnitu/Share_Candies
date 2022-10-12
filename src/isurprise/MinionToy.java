package isurprise;

public class MinionToy implements ISurprise{
	private static final String[] minionNameList = {"Dave", "Carl", "Kevin", "Stuart", "Jerry", "Tim"};
	private static int index = 0;	
	private final String minionToy;

	private MinionToy(String minionToy) {
		this.minionToy = minionToy;
	}
	
	@Override
	public void enjoy() {
		System.out.println("Felicitari! Tocmai ai deschis o surpriza Minion!");
	}
	
	public static MinionToy generate() {
		if (index == minionNameList.length) {
			index = 1;
		} else index++;
		return new MinionToy(minionNameList[index-1]);
	}
	
	@Override
	public String toString() {
		return "MinionToy: " + this.minionToy;
	}
}
