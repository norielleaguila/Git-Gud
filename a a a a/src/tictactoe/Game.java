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
	
	public void reset(int player) {
		for(int i = 0; i < boards.length; i++){
			boards[i] = new Board();
		}
		System.out.println("Player " + player + " wins!");
	}

	public void start(){

		boolean done = false;
		
		do{
			System.out.println("\nPlayer " + player);
			System.out.println("Press F to forfeit.");
			System.out.println("How to play:");
			System.out.println("Step 1. Choose board number.");
			System.out.println("Step 2. Choose row number.");
			System.out.println("Step 3. Choose column number.");
			System.out.println("----------------------------");
			System.out.println("Rows "+"Cols: 1, 2, 3");
			System.out.println("1"+"\n2"+"\n3");

			for(int i = 0; i < boards.length; i++){
				System.out.println("Board " + (i + 1));
				boards[i].drawBoard();
				System.out.println();
			}

			boolean flag = false;
			int row, col, bNum, temp;
			Board b;

			do{
				System.out.print("Choose board: ");
				do{
					input = sc.nextLine();
					temp = Integer.parseInt(input) - 1;
				}while(input.equals("") || temp < 0 || temp > 2);
				
				if(input.equals("F") || input.equals("f")){
					flag = true;
					done = true;
				}

				bNum = temp;
				b = boards[bNum];

				System.out.print("Choose row: ");
				do{
					input = sc.nextLine();
					temp = Integer.parseInt(input) - 1;
				}while(input.equals("") || temp < 0 || temp > 2);
				row = temp;

				System.out.print("Choose col: ");
				do{
					input = sc.nextLine();
					temp = Integer.parseInt(input) - 1;
				}while(input.equals("") || temp < 0 || temp > 2);
				col = temp;

				if(b.getBlock(row, col).getMarker().equals("_"))
					flag = true;
				else
					System.out.println("Please enter a valid block.");

			}while(!flag);

			b.setBlock(row, col, player);

			System.out.println("\nBoard " + bNum);
			b.drawBoard();

			if(player == 1){
				if(checkWin(row, col, bNum-1, "x")){
					done = true;
				}
				else{
					player = 2;
					// wait for input before looping
					input = sc.nextLine();
				}
			}
			else{
				if(checkWin(row, col, bNum-1, "o")){
					done = true;
				}
				else{
					player = 1;
					// wait for input before looping
					input = sc.nextLine();
				}
			}

		}while(!done);

		System.out.println("Player " + player + " wins!");
		sc.close();
	}

	public boolean checkWin(int row, int col, int board, String marker){
		//check if 1 row across the board = xxx
		if(boards[0].getBlock(row, col).getMarker().equals(marker)&& boards[1].getBlock(row, col).getMarker().equals(marker) && boards[2].getBlock(row, col).getMarker().equals(marker))
			return true;

		// check if 1 row is straight = xxx 
		if(col == 0){
			if(boards[0].getBlock(row, col+1).getMarker().equals(marker) && boards[0].getBlock(row, col+2).getMarker().equals(marker))
				return true;
			else if(boards[1].getBlock(row, col+1).getMarker().equals(marker) && boards[1].getBlock(row, col+2).getMarker().equals(marker))	
				return true;
			else if(boards[2].getBlock(row, col+1).getMarker().equals(marker) && boards[2].getBlock(row, col+2).getMarker().equals(marker))
				return true;
		}
		else if(col == 1){
			if(boards[0].getBlock(row, col-1).getMarker().equals(marker) && boards[0].getBlock(row, col+1).getMarker().equals(marker))
				return true;
			if(boards[1].getBlock(row, col-1).getMarker().equals(marker) && boards[1].getBlock(row, col+1).getMarker().equals(marker))
				return true;
			if(boards[2].getBlock(row, col-1).getMarker().equals(marker) && boards[2].getBlock(row, col+1).getMarker().equals(marker))
				return true;
		}
		else if(col == 2){
			if(boards[0].getBlock(row, col-1).getMarker().equals(marker) && boards[0].getBlock(row, col-2).getMarker().equals(marker))
				return true;
			if(boards[1].getBlock(row, col-1).getMarker().equals(marker) && boards[1].getBlock(row, col-2).getMarker().equals(marker))
				return true;
			if(boards[2].getBlock(row, col-1).getMarker().equals(marker) && boards[2].getBlock(row, col-2).getMarker().equals(marker))
				return true;
		}

		// check if 1 row is straight = xxx 
		if(row == 0){
			if(boards[0].getBlock(row+1, col).getMarker().equals(marker) && boards[0].getBlock(row+2, col).getMarker().equals(marker))
				return true;
			if(boards[1].getBlock(row+1, col).getMarker().equals(marker) && boards[1].getBlock(row+2, col).getMarker().equals(marker))
				return true;
			if(boards[2].getBlock(row+1, col).getMarker().equals(marker) && boards[2].getBlock(row+2, col).getMarker().equals(marker))
				return true;
		}
		else if(row == 1){
			if(boards[0].getBlock(row-1, col).getMarker().equals(marker) && boards[0].getBlock(row+1, col).getMarker().equals(marker))
				return true;
			if(boards[1].getBlock(row-1, col).getMarker().equals(marker) && boards[1].getBlock(row+1, col).getMarker().equals(marker))
				return true;
			if(boards[2].getBlock(row-1, col).getMarker().equals(marker) && boards[2].getBlock(row+1, col).getMarker().equals(marker))
				return true;
		}
		else if(row == 2){
			if(boards[0].getBlock(row-1, col).getMarker().equals(marker) && boards[0].getBlock(row-2, col).getMarker().equals(marker))
				return true;
			if(boards[1].getBlock(row-1, col).getMarker().equals(marker) && boards[1].getBlock(row-2, col).getMarker().equals(marker))
				return true;
			if(boards[2].getBlock(row-1, col).getMarker().equals(marker) && boards[2].getBlock(row-2, col).getMarker().equals(marker))
				return true;
		}
		
		// check diagonals
		if(boards[0].getBlock(0, 0).getMarker().equals(marker) && boards[0].getBlock(1, 1).getMarker().equals(marker) && boards[0].getBlock(2, 2).getMarker().equals(marker))
			return true;
		if(boards[1].getBlock(0, 0).getMarker().equals(marker) && boards[1].getBlock(1, 1).getMarker().equals(marker) && boards[1].getBlock(2, 2).getMarker().equals(marker))
			return true;
		if(boards[2].getBlock(0, 0).getMarker().equals(marker) && boards[2].getBlock(1, 1).getMarker().equals(marker) && boards[2].getBlock(2, 2).getMarker().equals(marker))
			return true;
		
		if(boards[0].getBlock(0, 2).getMarker().equals(marker) && boards[0].getBlock(1, 1).getMarker().equals(marker) && boards[0].getBlock(2, 0).getMarker().equals(marker))
			return true;
		if(boards[1].getBlock(0, 2).getMarker().equals(marker) && boards[1].getBlock(1, 1).getMarker().equals(marker) && boards[1].getBlock(2, 0).getMarker().equals(marker))
			return true;
		if(boards[2].getBlock(0, 2).getMarker().equals(marker) && boards[2].getBlock(1, 1).getMarker().equals(marker) && boards[2].getBlock(2, 0).getMarker().equals(marker))
			return true;
		
		// check corner to corner = xxx

		// check first if middle block has the marker
		if(boards[1].getBlock(1, 1).getMarker().equals(marker)){
			if(boards[0].getBlock(0, 0).getMarker().equals(marker) &&
					boards[2].getBlock(2, 2).getMarker().equals(marker))
				return true;
			
			if(boards[0].getBlock(2, 0).getMarker().equals(marker) &&
					boards[2].getBlock(0, 2).getMarker().equals(marker))
				return true;
			
			if(boards[0].getBlock(0, 2).getMarker().equals(marker) &&
					boards[2].getBlock(2, 0).getMarker().equals(marker))
				return true;
			
			if(boards[0].getBlock(2, 2).getMarker().equals(marker) &&
					boards[2].getBlock(0, 0).getMarker().equals(marker))
				return true;
		}
		
		
		

		return false;
	}
}
