
public class Board {

	private Block[][] blocks = new Block[3][3];

	public Board(){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				blocks[i][j] = new Block(i, j);
				
			}
		}
	}

	public void drawBoard(){
		for(int i = 0; i < 3; i++){
			System.out.print(" |");
			for(int j = 0; j < 3; j++){
				System.out.print(" " + blocks[i][j].getMarker() + " |");
			}
			System.out.println();
		}
	}

	public Block getBlock(int row, int col){
		return blocks[row][col];
	}

	public void setBlock(int row, int col, int player){
		if(player == 1){
			blocks[row][col].setMarker("x");
		}
		else{
			blocks[row][col].setMarker("o");
		}
	}
	
	public void initializeFlipBlocks(){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if((i == 1 && j == 1)||(i==0 && j==1)||(i==1 && j==0)||(i==1 && j==2)||(i==2&&j==1))
					blocks[i][j].setFlipBlock(true);
			}
		}
		
	}

}
