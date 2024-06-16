package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.DatabaseStructure;

public class ConnectionStatusPanel extends JPanel{

	JLabel connectionStatus;
	
	public ConnectionStatusPanel(Dimension mainWindowDimension, DatabaseStructure structure)
	{
		setVisible(true);
		setPreferredSize(new Dimension((int) mainWindowDimension.getWidth(), 50));
		setLayout(new BorderLayout());
		
		connectionStatus = new JLabel(structure.getConnectionState());
		add(connectionStatus,BorderLayout.CENTER);
	}
}
