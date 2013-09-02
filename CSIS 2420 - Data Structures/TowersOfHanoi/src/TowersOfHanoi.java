
public class TowersOfHanoi {

	private static int moves;
	
	public TowersOfHanoi() {
		
	}

	private static void hanoi(int d, char src, char dest, char interm)
	{
		if(d >= 1)
		{
			hanoi(d-1, src, interm, dest);
			moves++;
			System.out.printf("move a disk from %c to %c.\n", src, dest);
			hanoi(d-1, interm, dest, src);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		hanoi(64, 'a', 'c', 'b');
		System.out.println(moves);
	}

}
