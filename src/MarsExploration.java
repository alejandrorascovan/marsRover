import main.Rover;

public class MarsExploration {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rover.setLimits(5,5);
		Rover rover1 = new Rover(1,2,"N","Rover1");
		Rover rover2 = new Rover(3,3,"E");
		rover1.feed("LMLMLMLMM");
		rover2.feed("MMRMMRMRRM");		
	}
}
