package ui;

import javax.swing.JOptionPane;
import customExceptions.NotOddException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import model.MagicSquare;

public class MagicSquareController {
	
	private GridPane grid;
	
    @FXML
    private TextField orderTextField;

    @FXML
    private ComboBox<?> ubicationComboBox;

    @FXML
    private ComboBox<?> orientationComboBox;

    @FXML
    private BorderPane containerBoarderPane;
    
    private MagicSquare myMagicSquare;
    
    public void initialize() {
    	
    	grid = new GridPane();
    	myMagicSquare = new MagicSquare(0, null);
    	
    }
    
    @FXML
    public void play(ActionEvent event) {
    	String option = "";
    	String option2 = "";
    	int order = 0;
    	try {
    		order = Integer.parseInt(orderTextField.getText());
			myMagicSquare.setOrder(order);
			option = (String) ubicationComboBox.getValue();
        	option2 = (String) orientationComboBox.getValue();
		} catch (NotOddException e) {
			JOptionPane.showMessageDialog(null, "Por favor digite un número impar");
			orderTextField.setText(null);
    		orientationComboBox.setValue(null);
    		ubicationComboBox.setValue(null);
		}catch (NullPointerException ex) {
			JOptionPane.showMessageDialog(null, "Por favor seleccione todos los campos");
			orderTextField.setText(null);
    		orientationComboBox.setValue(null);
    		ubicationComboBox.setValue(null);
		}catch (NumberFormatException exc) {
			JOptionPane.showMessageDialog(null, "Por favor digite un número");
			orderTextField.setText(null);
    		orientationComboBox.setValue(null);
    		ubicationComboBox.setValue(null);
		}
    	myMagicSquare.setMatrix(order, order);
    	int constant = myMagicSquare.findConstant();
		if ((option.equals(myMagicSquare.UP) && (option2.equals(myMagicSquare.NORTHEAST) || option2.equals(myMagicSquare.NORTHWEST))) || (option.equals(myMagicSquare.BOTTOM) && (option2.equals(myMagicSquare.SOUTHEAST) || option2.equals(myMagicSquare.SOUTHWEST))) || (option.equals(myMagicSquare.RIGHT) && (option2.equals(myMagicSquare.NORTHEAST) || option2.equals(myMagicSquare.SOUTHEAST))) || (option.equals(myMagicSquare.LEFT) && (option2.equals(myMagicSquare.SOUTHWEST) || option2.equals(myMagicSquare.NORTHWEST)))) {
    	   	myMagicSquare.generateNumberOne(option);
    	   	if (option2.equals(myMagicSquare.NORTHEAST)) {
    	   		if (option.equals(myMagicSquare.UP)) {
    	   			myMagicSquare.northeastUp();
				}
    	   		if (option.equals(myMagicSquare.RIGHT)) {
    	   			myMagicSquare.northeastRight();
				}
			} else {
				if (option2.equals(myMagicSquare.NORTHWEST)) {
					if (option.equals(myMagicSquare.UP)) {
						myMagicSquare.northwestUp();
					}
					if (option.equals(myMagicSquare.LEFT)) {
						myMagicSquare.northwestLeft();
					}
				}else {
					if (option2.equals(myMagicSquare.SOUTHEAST)) {
						if (option.equals(myMagicSquare.BOTTOM)) {
							myMagicSquare.southeastBottom();
						}
						if (option.equals(myMagicSquare.RIGHT)) {
							myMagicSquare.southeastRight();
						}
					}else {
						if (option2.equals(myMagicSquare.SOUTHWEST)) {
							if (option.equals(myMagicSquare.BOTTOM)) {
								myMagicSquare.southwestBottom();
							}
							if (option.equals(myMagicSquare.LEFT)) {
								myMagicSquare.southwestLeft();
							}
						}
					}
				}
				
			}
        	int [][] matrix = myMagicSquare.getMatrix();
        	boolean pRows = myMagicSquare.plusRows(constant);
        	boolean pCols = myMagicSquare.plusColums(constant);
        	boolean pDiag = myMagicSquare.plusDiagonlas(constant);
        	boolean magic = myMagicSquare.isMagic(pRows, pCols, pDiag);
    		grid.setVgap(5);
    	    grid.setHgap(5);
    	    grid.setAlignment(Pos.CENTER);
    		GridPane.setColumnIndex(grid, order);
    		GridPane.setRowIndex(grid, order);
    		containerBoarderPane.setCenter(grid);
    		
    		Button[][] buttons = new Button[order][order];
    			
    		for (int i = 0; i < order; i++) {
    			for (int j = 0; j < order; j++) {
    				buttons[i][j] = new Button(""+matrix[i][j]);
    				grid.add(buttons[i][j], j, i);
    			}	
    		}
    		if (magic == true) {
    			JOptionPane.showMessageDialog(null, "¡El cuadrado es mágico! \nLa constante es "+constant);
    		} else {
    			JOptionPane.showMessageDialog(null, "¡El cuadrado no es mágico! \nLa constante es "+constant);
    		}
		} else {
			orderTextField.setText(null);
    		orientationComboBox.setValue(null);
    		ubicationComboBox.setValue(null);
			JOptionPane.showMessageDialog(null, "Por favor seleccione una combinación válida. \nEjemplo: \nArriba y NE ó NO\nAbajo y SO ó SE\nDerecha y SE ó NE\nIzquierda y NO ó SO");
		}
    }

}
