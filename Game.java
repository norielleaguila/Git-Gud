package tictactoe;

import java.util.Scanner;

public class Game {
	private Scanner sc;
	private String input;
	private int player;
	private Board[] boards;
	
	public Game(){
		sc = new Scanner(System.in);
		player = 1;
		boards = new Board[3];
		
		for(int i = 0; i < boards.length; i++){
			boards[i] = new Board();
		}
		
	}
	
	public void start(){
		
		do{
			System.out.println("Player " + player);
			System.out.println("Press F to forfeit.");
			System.out.println("How to play:");
			System.out.println("Step 1. Choose board number.");
			System.out.println("Step 2. Choose row number.");
			System.out.println("Step 3. Choose column number.");
			System.out.println("----------------------------");
			
			for(int i = 0; i < boards.length; i++){
				System.out.println("Board " + (i + 1));
				boards[i].drawBoard();
				System.out.println();
			}
			
			boolean flag = false;
			int row, col, bNum;
			Board b;
			
			do{
				System.out.print("Choose board: ");
				input = sc.nextLine();
				
				bNum = Integer.parseInt(input);
				b = boards[ bNum -1];
				
				System.out.print("Choose row: ");
				input = sc.nextLine();
				row = Integer.parseInt(input) - 1;
				
				System.out.print("Choose col: ");
				input = sc.nextLine();
				col = Integer.parseInt(input) - 1;
				
				if(b.getBlock(row, col).getMarker().equals("_"))
					flag = true;
				else
					System.out.println("Please enter a valid block.");
				
			}while(!flag);
			
			b.setBlock(row, col, player);
			
			System.out.println("\nBoard " + bNum);
			b.drawBoard();
			
			// wait for input before looping
			input = sc.nextLine();
			
			if(player == 1)
				player = 2;
			else
				player = 1;
						
		}while(input != "F" || input != "f");
		
		sc.close();
	}
}
