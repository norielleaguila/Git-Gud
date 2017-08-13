

public class Block {
	private String marker;
	private boolean flipBlock;
	private int row, col;

	public Block(){
		marker = "_";
		flipBlock = false;
	}

	public Block(int r, int c){
		marker = "_";
		flipBlock = false;
		row = r;
		col = c;
	}

	public Block(boolean f, int r, int c){
		marker = "_";
		flipBlock = f;
		row = r;
		col = c;
	}

	public String getMarker() {
		return marker;
	}

	public void setMarker(String marker) {
		this.marker = marker;
	}

	public boolean isFlipBlock() {
		return flipBlock;
	}

	public void setFlipBlock(boolean flipBlock) {
		this.flipBlock = flipBlock;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
}
