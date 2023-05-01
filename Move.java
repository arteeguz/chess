package application;

public interface Move {
	  
    public boolean isValidMove(int startX, int startY, int endX, int endY);
    public void makeMove(int startX, int startY, int endX, int endY);
    public void undoMove(int startX, int startY, int endX, int endY);
    
}