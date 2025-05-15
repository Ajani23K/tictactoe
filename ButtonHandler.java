package tictactoe;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ButtonHandler extends JButton{
	int row;
	int col;
	
	public ButtonHandler(int r, int c){
		
		row = r;
		col = c;
		
	}
	public int getRow(){
		
		
		return row;
	}
	public int getCol(){
		
		
		return col;
	}
}
