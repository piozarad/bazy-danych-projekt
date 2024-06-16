package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import model.DatabaseStructure;


public class MainWindow extends JFrame {
		




//content
static JPanel content;
static JPanel mainPanel;
static JPanel add;
static JPanel search;
static JPanel connectionStatus;
static Result result;


//menu
static JMenuBar menuBar;
static JMenu menu;
static JMenuItem exit;

	


	
public MainWindow(DatabaseStructure structure, Dimension dim)
{

	
	setPreferredSize(dim);
	setTitle("Projekt bazy Danych - aplikacja raportujaca usterki");
	setVisible(true);
	setLayout(new BorderLayout());
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	//set window at the center of screen more or less
	setLocation(screenSize.width/2 - dim.width +75,0);
	
	
	//close app
	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	this.addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) 
		{
			exitApp();
		}	
	});
	
	
	
	//initialize menu
	menuBar = new JMenuBar();
	
	menu = new JMenu("Aplikacja");
	
	exit= new JMenuItem("Zakoncz");
	exit.addActionListener(e->exitApp());
	
	
	//add whole menu	
	menu.add(exit);
	menuBar.add(menu);
	
	setJMenuBar(menuBar);
	
	
	//add=new Add(WINDOWSIZE,this,structure);
	add = new Add(dim,this,structure);
	search = new Search(dim, this, structure);
	mainPanel= new mainPanel(dim,this,structure);
	content = mainPanel;	
	result = new Result(dim,this,structure);
	add(content, BorderLayout.CENTER);
	connectionStatus = new ConnectionStatusPanel(dim,structure);
	
	add(connectionStatus,BorderLayout.SOUTH);
	
	pack();
}


void exitApp()
{	
	if(JOptionPane.
		showConfirmDialog(MainWindow.this,"Czy na pewno wyjsc z programu?","Wyjscie",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.YES_OPTION)				
		{
			dispose();
		}
}


public void showResults() {
	result.updateDefects();
	remove(MainWindow.content);
	MainWindow.content=MainWindow.result;
	add(MainWindow.content);
	repaint();
	pack();
	
}




}


	
	

