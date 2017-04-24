/**
 * 
 */
package GUI;

import java.util.*;

/**
 * basic dice for the game, has a side up and randomizer 
 * @author Cole
 *
 */
public class FarkleDice {
	
	public int F = 6;
	private static int faceup;
	
	/**
	 * returns the side up on a dice
	 * @return faceup 
	 */
	public int getFaceup(){
		return faceup;
	}
	
	
	/**
	 * generates a random number for the dice between 1-6
	 */
	public void roll(){
		Random roller=new Random();
		faceup=roller.nextInt(F)+1;
	}
}
