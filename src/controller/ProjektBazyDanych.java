package controller;

import javax.swing.SwingUtilities;

import model.DatabaseStructure;
import view.MainWindow;

public class ProjektBazyDanych {

	public static void main(String[] args) {
		
		
		
		
		SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
            	  new Controller();
            }
        });
		
	}

}
