package model;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MagicSquareTest {
	
	private MagicSquare  magicSquare;

	private void setupScenary1() {
	
	}
	
	private void setupScenary2() {
		
		int order = 3;
		int[][] matrix = new int[order][order];
		
		magicSquare = new MagicSquare(order, matrix);
	}
	
	@Test
	void test() {
		setupScenary1();
		
		int order = 5;
		int[][] matrix = new int[order][order];
		
		MagicSquare newMagicSquare = new MagicSquare(order, matrix);
		
		assertNotNull(newMagicSquare, "El cuadrado mágico es null");
		assertTrue(newMagicSquare.getMatrix().length==5, "No fue posible crear un cuadrado mágico de orden "+ order);
		
	}
	
	@Test
	void testConstant() {
		setupScenary2();
		
		assertEquals(15, magicSquare.findConstant(), "Hay un problema al hallar la constatne");
	}
	
	@Test
	void testGeneration() {
		setupScenary2();
		
		magicSquare.generateNumberOne(magicSquare.UP);
		assertTrue(magicSquare.getMatrix()[0][magicSquare.getMatrix().length/2]==1, "El número 1 no está correctamente asignado en la parte superior");
		
		magicSquare.generateNumberOne(magicSquare.BOTTOM);
		assertTrue(magicSquare.getMatrix()[magicSquare.getMatrix().length-1][magicSquare.getMatrix().length/2]==1, "El número 1 no está correctamente asignado en la parte inferior");

		magicSquare.generateNumberOne(magicSquare.RIGHT);
		assertTrue(magicSquare.getMatrix()[magicSquare.getMatrix().length/2][magicSquare.getMatrix().length-1]==1, "El número 1 no está correctamente asignado en la parte derecha");
		
		magicSquare.generateNumberOne(magicSquare.LEFT);
		assertTrue(magicSquare.getMatrix()[magicSquare.getMatrix().length/2][0]==1, "El número 1 no está correctamente asignado en la parte izquierda");
	}
	
	@Test
	void testNER() {
		setupScenary2();
		
		magicSquare.northeastRight();
		
		assertTrue(magicSquare.getMatrix()[magicSquare.getMatrix().length-1][0]==4, "No se está llevando a cabalidad la completación del cuadrado mágico");
	}
	
	@Test
	void testNEU() {
		setupScenary2();
		
		magicSquare.northeastUp();
			
		assertTrue(magicSquare.getMatrix()[magicSquare.getMatrix().length-1][0]==4, "No se está llevando a cabalidad la completación del cuadrado mágico");
	}
	
	@Test
	void testNWU() {
		setupScenary2();
		
		magicSquare.northwestUp();
			
		assertTrue(magicSquare.getMatrix()[magicSquare.getMatrix().length-1][magicSquare.getMatrix().length-1]==4, "No se está llevando a cabalidad la completación del cuadrado mágico");
	}
	
	@Test
	void testNWL() {
		setupScenary2();
		
		magicSquare.northwestUp();
			
		assertTrue(magicSquare.getMatrix()[magicSquare.getMatrix().length-1][magicSquare.getMatrix().length-1]==4, "No se está llevando a cabalidad la completación del cuadrado mágico");
	}

	@Test
	void testSEB() {
		setupScenary2();
		
		magicSquare.southeastBottom();
			
		assertTrue(magicSquare.getMatrix()[0][0]==4, "No se está llevando a cabalidad la completación del cuadrado mágico");
	}
	
	@Test
	void testSER() {
		setupScenary2();
		
		magicSquare.southeastBottom();
			
		assertTrue(magicSquare.getMatrix()[0][0]==4, "No se está llevando a cabalidad la completación del cuadrado mágico");
	}
	
	@Test
	void testSWB() {
		setupScenary2();
		
		magicSquare.southwestBottom();
			
		assertTrue(magicSquare.getMatrix()[0][magicSquare.getMatrix().length-1]==4, "No se está llevando a cabalidad la completación del cuadrado mágico");
	}
	
	@Test
	void testSWL() {
		setupScenary2();
		
		magicSquare.southwestBottom();
			
		assertTrue(magicSquare.getMatrix()[0][magicSquare.getMatrix().length-1]==4, "No se está llevando a cabalidad la completación del cuadrado mágico");
	
	}
	
	@Test
	void testPlusRows() {
		setupScenary2();
		
		magicSquare.northeastUp();
		
		int constant = magicSquare.findConstant();
		
		assertTrue(magicSquare.plusRows(constant), "La suma de filas no es igual a la cosntante");
		
		
	}
	
	@Test
	void testPlusColums() {
		setupScenary2();
		
		magicSquare.northeastRight();
		
		int constant = magicSquare.findConstant();
		
		assertTrue(magicSquare.plusColums(constant), "La suma de las columnas no es igual a la cosntante");
		
		
	}
	
	@Test
	void testPlusDiagons() {
		setupScenary2();
		
		magicSquare.southeastBottom();
		
		int constant = magicSquare.findConstant();
		
		assertTrue(magicSquare.plusDiagonlas(constant), "La suma de las diagonales no es igual a la cosntante");
		
		
	}
	
	@Test
	void testIsMagic() {
		setupScenary2();
		
		magicSquare.southeastRight();;
		
		int constant = magicSquare.findConstant();
		boolean pRows = magicSquare.plusRows(constant);
		boolean pCols = magicSquare.plusColums(constant);
		boolean pDiag = magicSquare.plusDiagonlas(constant);
		
		assertTrue(magicSquare.isMagic(pRows, pCols, pDiag), "El cuadrado no es mágico");
		
		
	}
	
}
