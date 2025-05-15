package tictactoe;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.JButton;

public class Tictactoeinterface extends Main{
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JPanel gamepanel = new JPanel();
	JLabel label = new JLabel();
	int tileSize = 70;
	int bWidth;
	int bHeight;
	boolean turn; //true = X false = O 
	boolean gameover;
	ButtonHandler[][] gameboard;
	
	public Tictactoeinterface(){
		gameover = false;
		gameboard = new ButtonHandler[3][3];
		Grid game = new Grid();
		bWidth = tileSize * 10;
		bHeight = tileSize * 10;
		frame.setSize(bWidth , bHeight);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		
		
		label.setFont(new Font("Arial", Font.BOLD, 25));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setText("Tic Tac Toe");
		label.setOpaque(true);
		
		panel.setLayout(new BorderLayout());
		panel.add(label);
		frame.add(panel, BorderLayout.NORTH);
		
		gamepanel.setLayout(new GridLayout(3, 3));
		frame.add(gamepanel);
		
		
		turn = true;
		for(int r = 0; r < 3; r++) {
			for(int c = 0; c < 3; c++) {
				 
				ButtonHandler button = new ButtonHandler(r,c);
				gameboard[r][c] = button;
				
				button.setFocusable(false);
				button.setMargin(new Insets(0,0,0,0));
				button.setFont(new Font("Arial Unicode MS", Font.PLAIN, 45));
				
				button.addActionListener(new ActionListener(){


					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(gameover){
							
						}else{
						if(turn){
							Turn(turn,button.getRow(),button.getCol());
							System.out.println("X has gone to place "+button.getRow()+","+button.getCol());
							game.addXorY(turn,button.getRow(),button.getCol());
							
							if(game.checkwin(turn)==1){
								
								WINNER(turn,0);
								gameover = true;
							}else if(checkdraw()){
								
								WINNER(turn,1);
								gameover = true;
							}
							
							turn = false;
							
						}else{
							Turn(turn,button.getRow(),button.getCol());
							System.out.println("O has gone to place "+button.getRow()+","+button.getCol());
							game.addXorY(turn,button.getRow(),button.getCol());
							
							if(game.checkwin(turn)==2){
								
								WINNER(turn,0);
								gameover = true;
							}else if(checkdraw()){
								
								WINNER(turn,1);
								gameover = true;
							}
							
							turn = true;
						}
						
						
					}
					}
				});
				gamepanel.add(button);
				
			}
		}
		
		
		
		
		frame.setVisible(true);
	}
	
	public void Turn(boolean t,int r,int c){
		if(gameboard[r][c].isEnabled()){
			
			if(t){
				
				gameboard[r][c].setEnabled(false);
				gameboard[r][c].setText("X");
				
			}else{
				
				gameboard[r][c].setEnabled(false);
				gameboard[r][c].setText("O");
			}
			
			
		}
		
	}
	public void WINNER(boolean turn, int draw){
		
		String winner = "";
		Object[] options = { "Yes", "No" };

		if(draw==1){
			winner = "DRAW! Would you like to try again?";
		}
		else{
			if(turn){
				
				winner = "X has won! Would you like to try again?";
			}else{
			
			winner = "O has won! Would you like to try again?";
			}
		}
		
		int i = JOptionPane.showOptionDialog(null, winner, "WINNER!", JOptionPane.YES_NO_OPTION,  JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		
		if(i == JOptionPane.YES_OPTION){
			frame.dispose();
			open();
		}else if(i == JOptionPane.NO_OPTION){
			
			System.exit(0);
		}
		
	}
	public boolean checkdraw(){
		int checkdraw = 0;
		for(int row = 0; row < 3; row++){
			for(int col = 0; col < 3; col++){
				
				if(gameboard[row][col].isEnabled()){
					
					checkdraw++;
				}
				
			}
		}
		if(checkdraw > 0){
			
			
			return false;
		}else{
		return true;
		}
	}
}

