
public class Rovot{

	private Integer x, y; // position coordinates (min (0, 0) max (5, 5))
	private char d; // heading direction (eg. N, E, S, W )

	Rovot(){
		// default x and y coord vals (dummy in this case) 
		this.x = 5; 
		this.y = 5; 
	}

	// Construct with two integer numbers for coordinate
	// and char of direction of the Rovot.
	Rovot(Integer xVal, Integer yVal, char dVal){
		this.x = xVal; // x cordinate
		this.y = yVal; // y coordinate
		this.d = dVal; // direction for the Rovot either one of {'N', 'W', 'S', 'E'}
	}

	/*
		Take a message as a parameter and check each letter in the string
		'M' = move forward ( call moveRovot() )
		otherwise change direction ( call changeDir() )
	*/
	public void sendMessage(String input){
		// TODO: error handling for input.length < 1	
		if( input == null || input.toCharArray().length < 1 ) 
			return;

		// parse each char to uppercase to eliminate confusion of lowercase/uppercase
		input = input.toUpperCase();

		for(char dVal : input.toCharArray() ){
			if(dVal == 'M'){
				moveRovot(this.d);
			}else{
				changeDir(dVal);
			}

			// System.out.print("afterChange::");
			// printRovot(); 			
		}	

	}

	/* Upon messages, change direction of the Rovot		
		'L' = turn left  90 degree
		'R' = turn right 90 degree
	*/
	public void changeDir(char toDir){

		char[] dArray = {'N', 'W', 'S', 'E'};
		int currIndex = -1 ;

		// find indes in the array dArray to get current robot's index
		for(int i = 0 ; i < dArray.length; i++){
			if(this.d == dArray[i]){
				currIndex = i;
				break;
			}
		}

		if (currIndex < 0)
			return; //error handling

		switch (toDir){
			case 'L': currIndex += 1;
				break;
			case 'R' : currIndex -= 1;
				break;
			default: break;
		}

		// edgeCase
		if(currIndex > 3)
			currIndex %= dArray.length ;
		else if(currIndex < 0)
			currIndex += dArray.length ;

		this.d = dArray[currIndex];


	} 

	/*
		When needed to move forward, move the Rovot by one 
		depending on heading direction
	*/
	public void moveRovot(char dVal){
		switch (dVal) {
				case 'N' : this.y++;
					break;
				case 'S' : this.y--;
					break;
				case 'W' : this.x--;
					break;
				case 'E' : this.x++;
					break;
				default: break;
			}
	}

	// Print thhe Rovot's current position ( coordinates && direction )
	public void printRovot(){
		System.out.println("x=" + this.x + ", y=" + y + ", d=" + d);
	}



}