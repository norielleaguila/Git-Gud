
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
		boards[1].initializeFlipBlocks();
	}
	
	public void reset(int player) {
		for(int i = 0; i < boards.length; i++){
			boards[i] = new Board();
		}
		System.out.println("Player " + player + " wins!");
		boards[1].initializeFlipBlocks();
	}

	public void start(){

		boolean done = false, firstTrn = true;
		int Player1Flips = 0, Player2Flips = 0;
		do{
			System.out.println("\nPlayer " + player);
			switch(player){
				case 1: System.out.println("Flips! left: " + Player1Flips); break;
				case 2: System.out.println("Flips! left: " + Player1Flips); break;
			}
			System.out.println("Press F to forfeit.");
//			System.out.println("How to play:");
//			System.out.println("Step 1. Choose board number.");
//			System.out.println("Step 2. Choose row number.");
//			System.out.println("Step 3. Choose column number.");
			System.out.println("----------------------------");
			System.out.println("Rows "+"Cols: 1, 2, 3");
			System.out.println("1"+"\n2"+"\n3");

			
			
			boolean flag = false;
			int row, col, bNum, temp = -1, choice=-1;
			Board b;

			
//			if(firstTrn){ //FlipBlocks assignment
//				
//				System.out.print("Put your Flip! Blocks!");
//				
//				System.out.println("Player 1, assign a flip block");
//				for(int i = 0; i < boards.length; i++){
//					System.out.println("Board " + (i + 1));
//					boards[i].drawBoard();
//					System.out.println();
//				}
//				do{
//					System.out.print("Choose board: ");
//					input = sc.nextLine();
//
//					if(input.equals("F") || input.equals("f")){
//						if(player == 1)
//							player = 2;
//						else
//							player = 1;
//						
//						System.out.println("Player " + player + " wins!");
//						System.exit(0);
//					}
//					else if(!input.equals(""))
//						temp = Integer.parseInt(input) - 1;
//					
//				}while((input.equals("") || temp < 0 || temp > 2) && !flag);
//				
//				bNum = temp;
//				b = boards[bNum];
//				do{
//
//					System.out.print("Choose row: ");
//					do{
//						input = sc.nextLine();
//						temp = Integer.parseInt(input) - 1;
//					}while(input.equals("") || temp < 0 || temp > 2);
//					row = temp;
//	
//					System.out.print("Choose col: ");
//					do{
//						input = sc.nextLine();
//						temp = Integer.parseInt(input) - 1;
//					}while(input.equals("") || temp < 0 || temp > 2);
//					col = temp;
//					if(col == 1 && row == 1)
//						System.out.println("Center block cannot be a Flip! Block");
//					else
//						break;
//				
//				}while(true);
//				
//				b.getBlock(row, col).setFlipBlock(true);
//				System.out.println("Row " + (row+1) +" and Col "+ (col+1) +" in Board "+(bNum+1)+" is now a Flip! Block!");
//				Player1Flips ++;
//				
//				System.out.println("Player 2, assign a flip block");
//				for(int i = 0; i < boards.length; i++){
//					System.out.println("Board " + (i + 1));
//					boards[i].drawBoard();
//					System.out.println();
//				}
//				do{
//					System.out.print("Choose board: ");
//					input = sc.nextLine();
//
//					if(input.equals("F") || input.equals("f")){
//						if(player == 1)
//							player = 2;
//						else
//							player = 1;
//						
//						System.out.println("Player " + player + " wins!");
//						System.exit(0);
//					}
//					else if(!input.equals(""))
//						temp = Integer.parseInt(input) - 1;
//					
//				}while((input.equals("") || temp < 0 || temp > 2) && !flag);
//				
//				bNum = temp;
//				b = boards[bNum];
//				do{
//
//					System.out.print("Choose row: ");
//					do{
//						input = sc.nextLine();
//						temp = Integer.parseInt(input) - 1;
//					}while(input.equals("") || temp < 0 || temp > 2);
//					row = temp;
//	
//					System.out.print("Choose col: ");
//					do{
//						input = sc.nextLine();
//						temp = Integer.parseInt(input) - 1;
//					}while(input.equals("") || temp < 0 || temp > 2);
//					col = temp;
//					if(col == 1 && row == 1)
//						System.out.println("Center block cannot be a Flip! Block");
//					else
//						break;
//				
//				}while(true);
//				
//				b.getBlock(row, col).setFlipBlock(true);
//				System.out.println("Row " + (row+1) +" and Col "+ (col+1) +" in Board "+(bNum+1)+" is now a Flip! Block!");
//				Player2Flips++;
//				System.out.println("Flip! Blocks assignments have been done! Now for the game! \n\n\n\n");
//			}
			
			for(int i = 0; i < boards.length; i++){
				System.out.println("Board " + (i + 1));
				boards[i].drawBoard();
				System.out.println();
			}
			
			//regular game
			do{
				System.out.print("Choose board: ");
				do{
					input = sc.nextLine();

					if(input.equals("F") || input.equals("f")){
						if(player == 1)
							player = 2;
						else
							player = 1;
						
						System.out.println("Player " + player + " wins!");
						System.exit(0);
					}
					else if(!input.equals(""))
						temp = Integer.parseInt(input) - 1;
					
				}while((input.equals("") || temp < 0 || temp > 2) && !flag);
				
				bNum = temp;
				b = boards[bNum];
				
				do{

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
					if(col == 1 && row == 1 && firstTrn)
						System.out.println("Center block is disabled on the first turn");
					else
						firstTrn = false;
				
				}while(firstTrn);

				if(b.getBlock(row, col).getMarker().equals("_"))
					flag = true;
				else if(b.getBlock(row, col).isFlipBlock())
				{
					int check = 0;
					switch(player)
					{
						case 1: check = Player1Flips; break;
						case 2: check = Player2Flips; break;
					}
					if(check > 0)
					{
						int yesNo;
						System.out.print("This block is occupied but you are able to Flip! it, would you like to Flip?[1=Yes, 0=No]: ");
						yesNo = sc.nextInt();
						if(yesNo == 1){
							flag = true;
							switch(player)
							{
								case 1: Player1Flips--; break;
								case 2: Player2Flips--; break;
							}
						}
					}
				}
				else{
					System.out.println("Please enter a valid block.");
				}
			}while(!flag);

			b.setBlock(row, col, player);
			if(b.getBlock(row, col).isFlipBlock()){
				switch(player){
					case 1: Player1Flips++; break;
					case 2: Player2Flips++; break;
				}
				System.out.println("Bingo! That was a Flip! Block! Player "+ player +" gets 1 Flip!");
			}
			System.out.println("\nBoard " + (bNum+1));
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

		// check if 1 col is straight = xxx 
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
		
		// check diagonally across the board = xxx
		for(int i = 0; i < 3; i++){
			if(boards[0].getBlock(0, i).getMarker().equals(marker) &&
					boards[1].getBlock(1, i).getMarker().equals(marker) &&
					boards[2].getBlock(2, i).getMarker().equals(marker))
				return true;
		}

		return false;
	}
}
