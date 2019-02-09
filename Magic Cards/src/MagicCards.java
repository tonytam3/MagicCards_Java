import java.util.Scanner;
//import java.util.List;
//import java.util.Arrays;
//import java.util.Collections;

public class MagicCards {
	static int[][] cardStack = new int[7][3];
	static int[] masterStack = new int[21];
	static Scanner response = new Scanner(System.in);
	
	public static void progIntro () {
		System.out.println("Think of a number between 1 - 21\n Keep the number to yourself\n");
	}
	public static int selectStack() {
		int selectedStack =5;
		do{
			System.out.println("\nWhich stack has your number?");
			selectedStack = response.nextInt();
		}while(selectedStack >=3);
		return selectedStack;
	}
	public static void masterStackPop () {
		for (int i=0; i < masterStack.length; i++) {
			masterStack[i]=i+1;
//			System.out.print(masterStack[i]+" ");
//			System.out.print(masterStack.length+);
		}
		/*List<Integer> masterStackList =  Arrays.asList(masterStack);
		Collections.shuffle(masterStackList);
		for (int i = 0; i<masterStackList.size();i++) {
			masterStack[i]= masterStackList.get(i);
		}*/
		
	}
	public static void dealMasterStack () {
		int i=0;
		//int y=0;
		while (i<20) {
			for(int y=0; y<7;y++) {
				for (int x = 0; x<3; x++) {
					cardStack[y][x]=masterStack[i];
					i++;
				}
			//y++;
			}
		}
	}
	public static void printCardStack() {
		for (int x=0; x < cardStack[x].length; x++) {
			System.out.print("Stack"+x+": ");
			for (int y=0; y<cardStack.length;y++) {
				System.out.print(cardStack[y][x]+" ");
			}
			System.out.println();
		}
	}
	public static void redealMasterStack(int i) {
		int x =0;
		int MS1 =0;
		while(x<3) {
			if(x == 0) {
				if( x == i) {
					for (int y=6;y>=0;y--) {
						masterStack[MS1]=cardStack[y][x+1];
						MS1++;
					}
					x++;
				}
				else {
					for (int y=6;y>=0;y--) {
						masterStack[MS1]=cardStack[y][x];
						MS1++;
					}
					x++;
				}
			}
			if (x==1) {
				if(x==i) {
					for (int y=6;y>=0;y--) {
						masterStack[MS1]=cardStack[y][x];
						MS1++;
					}
					x++;
				}
				else{
					for (int y=6;y>=0;y--) {
						masterStack[MS1]=cardStack[y][i];
						MS1++;
					}
					x++;
				}
			}
			if (x==2) {
				if(x==i) {
					for (int y=6;y>=0;y--) {
						masterStack[MS1]=cardStack[y][x-1];
						MS1++;
					}
					x++;
				}
				else {
					for (int y=6;y>=0;y--) {
						masterStack[MS1]=cardStack[y][x];
						MS1++;
					}
					x++;
				}
			}
		}
	}
	public static void main (String[] args) {
		MagicCards.progIntro();
		MagicCards.masterStackPop();
		
		int n=0;
		while (n<4) {
			dealMasterStack ();
			printCardStack();
			int userInput = MagicCards.selectStack();
			MagicCards.redealMasterStack(userInput);
			n++;
		}
		MagicCards.printCardStack();
		System.out.print("\nThe Number you are thinking of is: "+cardStack[3][1]);
	}
}
