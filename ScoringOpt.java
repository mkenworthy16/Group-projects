/**
 * 
 */
package GUI;

/**
 * @author Cole
 *
 */
public class ScoringOpt {

	public boolean[] ones = new boolean[2];
	public boolean[] threes=new boolean[6];
	public static boolean[] hscores = new boolean[6]; //other types of scoring
	//I decided to create a separate array that will contain all the scores, since java does not offer tuples in a simple way
	//The key for the array is this: points[0-1] corresponds to the ones scores, points[2-7] corresponds to the threes scores
	//points[8-10] corresponds to the misc scores
	public int[] points = {100,50,1000,200,300,400,500,600,500,1000,250};
	
	boolean farkle = true;
	static boolean hotdice = false;
	
	/**
	 * 
	 * @param hand
	 */
	public void sc3s(int[] hand){
		int f=0;
		for(int i = 0; i < hand.length-1; i++)
			if (hand[i]==hand[i+1]){
					f=f+1;
					if (f==3){
						threes[hand[i]-1]=true;
						f=0;
					}
			}
	}
	
	/**
	 * 
	 * @param hand
	 */
	public void sc1s(int[] hand){
		for(int i = 0; i < hand.length; i++){
			if (hand[i]==1)
				ones[0]=true;
			if(hand[i]==5)
				ones[1]=true;
		}
	}
	
	/**
	 * 
	 * @param hand
	 */
	public static void fullhouse(int[] hand){
		int u=0;//2ofakind
		int v=0;//3ofakind
		for(int i=0;i<hand.length-2;i++){
			if (hand[i]==hand[i+1]){
				u++;
			}
			if(hand[i]==hand[i+2]){
				u--;
				v++;
			}
		}
		if(v+u>1){
			System.out.println(u+v);
			hscores[2]=true;
			}
		}
	
	/**
	 * 
	 * @param hand
	 */
	public static void straight(int[] hand){
		int x=0;
		int y=x;
		int a;
		for(int i=0;i<hand.length-1;i++){
			if (hand[i]==hand[i+1]-1)
				x++;
			
			else if ((hand[i]!=hand[i+1]) && (x>y)){
				y=x;
				x=0;
			}
		}
		if(x>y)
			a = x;
		else
			a = y;
		if (a > 5)
			hscores[0] = true;
	}
	
	/**
	 * 
	 * @param hand
	 */
	public static void threepairs (int[] hand){
		int t = 0;
		for(int i = 0; i<6; i+=2 ){
			if (hand[i] == hand[i+1])
				t=t+1;
		}
		if(t==3)
			hscores[1]= true;
	}
	
	/**
	 * 
	 * @param hand
	 */
	public static void f345akind(int[] hand){
		int a=0;
		for(int i=1;i<7;i++)
			if(frequency(hand,i)>a)
				a=frequency(hand,i);
		System.out.println(a);
		if(a>5)
			hscores[6]=true;
		else if(a>4)
			hscores[5]=true;
		else if(a>3)
			hscores[4]=true;
	}
	
	/**
	 * 
	 */
	public void scoringoptions(){
		for(int i = 0; i < 6; i++){
			if (threes[i] == true)
				System.out.println("score 3" + i + 's');
			 	
		}
		for(int x = 0; x < 2; x++){
			if (ones[x] == true)
				System.out.println("score 1" + x);
		}
	}
	
	
	/**
	 * 
	 */
	public void choosescore(){
		for(int i = 0; i<6; i++){
			if (threes[i]==true){
				farkle = false;
				System.out.println("test");
		}
		//if user farkled, then score is set to 0 and nothing happens
		//this function will run the functions sc1 and sc3 again, but with the new hand, after the user has selected a scoring option
		//that the way the user can select more than 1 scoring option per hand. if there are 0 scoring options, the user may 
		//choose to roll a new hand and begin the process again
		}}
	
	/**
	 * 
	 * @return
	 */
	public boolean farkled(){
		for(int i = 0; i<6; i++){
			if (threes[i]== true) 
			    farkle = false;
		for(i = 0;i<2;i++){
			if (ones[i]== true) 
			    farkle = false;
			}
		for(i = 0;i<6;i++){
			if (hscores[i]== true) 
			    farkle = false;
			}
		}
		return farkle;
	}
	
	
	/**
	 * 
	 * @param arr
	 * @param a
	 * @return
	 */
	public static int frequency(int[] arr, int a){
		int f=0;
		for(int g=0;g<arr.length;g++){
			if(arr[g]==a)
				f++;
		}
		//System.out.println(f);
		return f;
	}
	
	
	/**
	 * 
	 * @param hand
	 * @param scoredhand
	 * @return
	 */
	public static int[] findnewhand(int[] hand, int[] scoredhand){
		int[] newhand = new int[hand.length - scoredhand.length];
		if (scoredhand.length == 6){
			newhand = hand;
			hotdice=true;
			return newhand;
		}
		int x=0;
		for(int i=1;i<7;i++){
			int f=frequency(hand,i)-frequency(scoredhand,i);
			if(f>0){
			for(int a = 0;a<f;a++){
				newhand[x]= i;
				x++;
			}
			}
				}
		return newhand;
	}
		
		
		
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args){//the main function
		Hand h = new Hand();
		int[] hand = h.gethand();
	
	}
}
