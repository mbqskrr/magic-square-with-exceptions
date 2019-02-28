package model;

import customExceptions.NotOddException;

public class MagicSquare {
	private int order;
	private int[][] matrix;
	public static final String UP = "Arriba";
	public static final String BOTTOM = "Abajo";
	public static final String RIGHT = "Derecha";
	public static final String LEFT = "Izquierda";
	public static final String SOUTHEAST = "SE";
	public static final String SOUTHWEST = "SO";
	public static final String NORTHEAST = "NE";
	public static final String NORTHWEST = "NO";
	
	public MagicSquare(int order, int[][] matrix) {
		this.order = order;
		this.matrix = matrix;
	}
	
	public void setOrder(int order) throws NotOddException, NumberFormatException{
		if (order%2!=1) {
			throw new NotOddException(order);
		} else {
			this.order = order;
		}
		
	}
	
	public int getOrder() {
		return order;
	}
	
	public void setMatrix(int rows, int colums){
		matrix = new int[rows][colums];
	}
	
	public int[][] getMatrix(){
		return matrix;	
	}
	
	public int findConstant() {
		int constant;
		
		constant = (order*((order*order) + 1)) /2;
		
		return constant;
	}
	
	public void generateNumberOne(String option) {
		int position;
		position = order/2;
		switch (option) {
		case "Arriba":		
				matrix[0][position] = 1;
			break;
		case "Abajo":
				matrix[matrix.length-1][position] = 1;
			break;
		case "Derecha":
				matrix[position][matrix.length-1] = 1;
			break;
		case "Izquierda":
				matrix[position][0] = 1;
			break;
		default:
			break;
		}
	}
	
	public void northeastUp() {
		int lastCol = 0;
		int lastRow = 0;
		int nextRow = 0;
		int nextCol = order/2; 
		int one = 1;
		
		for (int i = 0; i < order; i++){
            for (int j = 0; j < order; j++){
                matrix[nextRow][nextCol] = one;
 
                lastCol = nextCol;
                lastRow= nextRow;
 
                nextRow = lastRow-1;
                nextCol = lastCol+1;
 
                if(nextRow < 0){
                    nextRow = order - 1;
                }
                if(nextCol >= order){
                    nextRow = lastRow - 1;
                    nextCol = 0;
                }
 
                if(nextRow == -1 || matrix[nextRow][nextCol] != 0){
                    nextRow = lastRow + 1;
                    nextCol = lastCol ;
                }
                one++;
            }
        }
		
	}
	
	public void northeastRight() {
		int lastCol = 0;
		int lastRow = 0;
		int nextRow = order/2;
		int nextCol = matrix.length-1; 
		int one = 1;
		
		for (int i = 0; i < order; i++){
            for (int j = 0; j < order; j++){
                matrix[nextRow][nextCol] = one;
 
                lastCol = nextCol;
                lastRow= nextRow;
 
                nextRow = lastRow-1;
                nextCol = lastCol+1;
 
                if(nextRow < 0){
                    nextRow = order - 1;
                }
                if(nextCol >= order){
                    nextRow = lastRow - 1;
                    nextCol = 0;
                }
 
                if(nextRow == -1 || matrix[nextRow][nextCol] != 0){
                    nextRow = lastRow;
                    nextCol = lastCol - 1;
                }
                one++;
            }
        }
	}
	
	public void northwestUp() {
		int lastCol = 0;
		int lastRow = 0;
		int nextRow = 0;
		int nextCol = order/2; 
		int one = 1;
		
		for (int i = 0; i < order; i++){
            for (int j = 0; j < order; j++){
                matrix[nextRow][nextCol] = one;
 
                lastCol = nextCol;
                lastRow= nextRow;
 
                nextRow = lastRow - 1;
                nextCol = lastCol - 1;
 
                if(nextRow < 0){
                    nextRow = order - 1;
                }
                if(nextCol < 0){
                    nextRow = lastRow - 1;
                    nextCol = order - 1;
                }
 
                if(nextRow == -1 || matrix[nextRow][nextCol] != 0){
                    nextRow = lastRow + 1;
                    nextCol = lastCol;
                }
                one++;
            }
        }
	}
	
	public void northwestLeft() {
		int lastCol = 0;
		int lastRow = 0;
		int nextRow = order/2;
		int nextCol = 0; 
		int one = 1;
		
		for (int i = 0; i < order; i++){
            for (int j = 0; j < order; j++){
                matrix[nextRow][nextCol] = one;
 
                lastCol = nextCol;
                lastRow= nextRow;
 
                nextRow = lastRow - 1;
                nextCol = lastCol - 1;
 
                if(nextRow < 0){
                    nextRow = order - 1;
                }
                if(nextCol < 0){
                    nextRow = lastRow - 1;
                    nextCol = order - 1;
                }
 
                if(nextRow == -1 || matrix[nextRow][nextCol] != 0){
                    nextRow = lastRow;
                    nextCol = lastCol + 1;
                }
                one++;
            }
        }
	}
	
	public void southeastBottom() {
		int lastCol = 0;
		int lastRow = 0;
		int nextRow = matrix.length-1;
		int nextCol = order/2; 
		int one = 1;
		
		for (int i = 0; i < order; i++){
            for (int j = 0; j < order; j++){
                matrix[nextRow][nextCol] = one;
 
                lastCol = nextCol;
                lastRow= nextRow;
 
                nextRow = lastRow+1;
                nextCol = lastCol+1;
 
                if(nextRow >=  order){
                    nextRow = 0;
                }
                if(nextCol >= order){
                    nextRow = lastRow + 1;
                    nextCol = 0;
                }
 
                if(nextRow == order || matrix[nextRow][nextCol] != 0){
                    nextRow = lastRow - 1;
                    nextCol = lastCol;
                }
                one++;
            }
        }
	}
	
	public void southeastRight() {
		int lastCol = 0;
		int lastRow = 0;
		int nextRow = order/2;
		int nextCol = matrix.length-1; 
		int one = 1;
		
		for (int i = 0; i < order; i++){
            for (int j = 0; j < order; j++){
                matrix[nextRow][nextCol] = one;
 
                lastCol = nextCol;
                lastRow= nextRow;
 
                nextRow = lastRow+1;
                nextCol = lastCol+1;
 
                if(nextRow >=  order){
                    nextRow = 0;
                }
                if(nextCol >= order){
                    nextRow = lastRow + 1;
                    nextCol = 0;
                }
 
                if(nextRow == order || matrix[nextRow][nextCol] != 0){
                    nextRow = lastRow;
                    nextCol = lastCol - 1;
                }
                one++;
            }
        }
	} 
	
	public void southwestBottom() {
		int lastCol = 0;
		int lastRow = 0;
		int nextRow = matrix.length-1;
		int nextCol = order/2; 
		int one = 1;
		
		for (int i = 0; i < order; i++){
            for (int j = 0; j < order; j++){
                matrix[nextRow][nextCol] = one;
 
                lastCol = nextCol;
                lastRow= nextRow;
 
                nextRow = lastRow+1;
                nextCol = lastCol-1;
 
                if(nextRow >=  order){
                    nextRow = 0;
                }
                if(nextCol < 0){
                    nextRow = lastRow + 1;
                    nextCol = order - 1;
                }
 
                if(nextRow == order || matrix[nextRow][nextCol] != 0){
                    nextRow = lastRow - 1;
                    nextCol = lastCol;
                }
                one++;
            }
        }
	} 

	public void southwestLeft() {
		int lastCol = 0;
		int lastRow = 0;
		int nextRow = order/2;
		int nextCol = 0; 
		int one = 1;
		
		for (int i = 0; i < order; i++){
            for (int j = 0; j < order; j++){
                matrix[nextRow][nextCol] = one;
 
                lastCol = nextCol;
                lastRow= nextRow;
 
                nextRow = lastRow+1;
                nextCol = lastCol-1;
 
                if(nextRow >=  order){
                    nextRow = 0;
                }
                if(nextCol < 0){
                    nextRow = lastRow + 1;
                    nextCol = order - 1;
                }
 
                if(nextRow == order || matrix[nextRow][nextCol] != 0){
                    nextRow = lastRow;
                    nextCol = lastCol + 1;
                }
                one++;
            }
        }
	} 
	
	public boolean plusRows(int constant) {
		boolean tr = true;
		int pRows = 0;
		int k = 0;
		while (k < order && tr) {
			for (int i = 0; i < order; i++) {
				pRows += matrix[k][i];
			}
			if (pRows != constant) {
				tr = false;
			} 
			k++;
			pRows = 0;
		}
		
		return tr;
	}
	
	public boolean plusColums(int constant) {
		boolean tc = true;
		int pCols = 0;
		int k = 0;
		while (k < order && tc) {
			for (int i = 0; i < order; i++) {
				pCols += matrix[k][i];
			}
			if (pCols != constant) {
				tc = false;
			} 
			k++;
			pCols = 0;
		}
		
		return tc;
	}
	
	public boolean plusDiagonlas(int constant){
		boolean td = true;
		int pDiag = 0;
		int k = 0;
		int l = 0;
		while (k < order && l < order) {
			pDiag += matrix[k][l];
			k++;
			l++;
		}
		
		if (pDiag != constant) {
			td = false;
		} else {
			int pDiag1 = 0;
			int i = 0;
			int j = order - 1;
			while (i < order && j >= 0) {
				pDiag1 += matrix[i][j];
				i++;
				j--;
			}
			if (pDiag1 != constant) {
				td = false;
			}
		}
		
		return td;
	}
	
	public boolean isMagic(boolean pRows, boolean pCols, boolean pDiag) {
		boolean magic = true;
		
		if (pRows == true && pCols == true && pDiag == true) {
			magic = true;
		}else {
			magic = false;
		}
		
		return magic;
		
	}
	
}
