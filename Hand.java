/**
 * 
 */
package GUI;

/**
 * @author Cole
 *
 */
public class Hand {

	public int DIP = 6;
	int hand[] =new int[6];
	
	public Hand(){
		for(int i = 0; i < hand.length; i++){
			FarkleDice dice = new FarkleDice();
			dice.roll();
			hand[i] = dice.getFaceup();
		}
	}
	
	public int[] gethand(){
		return hand;
	}
	
	private int[] sorthand(int[] hand){//sorts hand
		
		   boolean swap;
		   int temp;
		   do
		   {
		      swap = false;
		      for (int i = 0; i < (DIP - 1); i++)
		      {
		         if (hand[i] > hand[i + 1])
		         {
		            temp = hand[i];
		            hand[i] = hand[i + 1];
		            hand[i + 1] = temp;
		            swap = true;
		         }
		      }
		   } while (swap);
		   
		 return hand;
		}
	
}
