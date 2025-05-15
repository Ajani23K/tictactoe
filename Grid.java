package tictactoe;

public class Grid {
	private int length;
	private int width;
	int[][] tictactoe;
	private int X;
	private int O;
	public Grid(){
		
		length = 3;
		width = 3;
		tictactoe = new int[3][3];
		X = 1;
		O = 2;
		
	}
	public void genterateGrid(){
		
		for(int row = 0;row <3; row++){
			for(int column = 0;column < 3; column++){
				
				tictactoe[row][column] = 0;
				
				
			}	
		}	
	}
	public void addXorY(boolean turn,int r, int c){
		//X = 1
		//O = 2
		if(turn){
			tictactoe[r][c] = X;
		}else{
			tictactoe[r][c] = O;
		}
	}
	public int checkwin(boolean turn){
		int WINNER = 0;
		int i = 0;
			if(turn){
				
				i = 1;
			}else{
				
				i = 2;
			}
			if(tictactoe[0][0]  == i && tictactoe[0][1] == i && tictactoe[0][2] == i){
				//top row victory
				WINNER = i;
				
			}else if(tictactoe[1][0]  == i && tictactoe[1][1]  == i && tictactoe[1][2] == i ){
				//middle row victory
				WINNER = i;
			}else if(tictactoe[2][0]  == i && tictactoe[2][1]  == i && tictactoe[2][2] == i ){
				//bottom row victory
				WINNER = i;
				
			}else if(tictactoe[0][0]  == i && tictactoe[1][0]  == i && tictactoe[2][0] == i ){
				//left column victory
				WINNER = i;
				
			}
			else if(tictactoe[0][1]  == i && tictactoe[1][1]  == i && tictactoe[2][1] == i ){
				//middle column victory
				WINNER = i;
				
			}else if(tictactoe[0][2]  == i && tictactoe[1][2]  == i && tictactoe[2][2] == i ){
				//right column victory
				WINNER = i;
				
			}
			else if(tictactoe[0][0]  == i && tictactoe[1][1]  == i && tictactoe[2][2] == i ){
				//left diagonal  victory
				WINNER = i;
				
			}else if(tictactoe[0][2]  == i && tictactoe[1][1]  == i && tictactoe[2][0] == i ){
				//right column victory
				WINNER = i;
				
			}
			
		if(WINNER == 1){
			
		
			System.out.println("X has won!");
			return 1;
		}else if(WINNER == 2){
			
			System.out.println("X has won!");	
			return 2;
		}else{
			
			System.out.println("No one has won yet");
			return 0;
		}
}
}
