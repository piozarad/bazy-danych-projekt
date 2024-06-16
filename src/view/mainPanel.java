package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import model.DatabaseStructure;

public class mainPanel extends JPanel {

	MainWindow parent;
	
	static final Dimension BUTTONSIZE = new Dimension(150,30);
	
	JButton Search;
	JButton Add;
	JButton Exit;
	JLabel connectionStatus;
	
	
	public mainPanel(Dimension dim,MainWindow parent,DatabaseStructure structure)
	{
		
		GridBagLayout bagLayout = new GridBagLayout();
		setLayout(bagLayout);
		setVisible(true);
		setMaximumSize(dim);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 10, 10, 10);
		constraints.weightx=0;
		constraints.weighty=0;
		
		
		this.setBorder(BorderFactory.createTitledBorder(
				   BorderFactory.createEtchedBorder(), "Menu", TitledBorder.LEFT, TitledBorder.TOP));
		
		//adding elements
		constraints.gridx=1;
		constraints.gridy=1;
		Search = new JButton("Szukaj");
		Search.setPreferredSize(BUTTONSIZE);
		Search.addActionListener(e->{
			parent.remove(MainWindow.content);
			MainWindow.content=MainWindow.search;
			parent.add(MainWindow.content);
			parent.repaint();
			parent.pack();
		});
		add(Search,constraints);
		
		constraints.gridy++;
		Add= new JButton("Add");
		Add.setPreferredSize(BUTTONSIZE);
		Add.addActionListener(e->{
			parent.remove(MainWindow.content);
			MainWindow.content=MainWindow.add;
			parent.add(MainWindow.content);
			parent.repaint();
			parent.pack();
		});
		add(Add,constraints);
		
		constraints.gridy++;
		Exit = new JButton("Exit");
		Exit.addActionListener(e->parent.exitApp());
		Exit.setPreferredSize(BUTTONSIZE);
		add(Exit,constraints);
		
		
		
	}
	
	
	
	
}
