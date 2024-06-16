package controller;

import java.awt.Dimension;

import model.DatabaseStructure;
import view.MainWindow;
import view.Search;

public class Controller {

	private MainWindow mainWindow;

	
	
	static final Dimension WINDOWSIZE = new Dimension(600,800);
	
	public Controller()
	{
		
		DatabaseStructure structure = new DatabaseStructure();
		InitialConnection.connect(structure);
		
		
		mainWindow = new MainWindow(structure,WINDOWSIZE);
	}
	
	
	
}
