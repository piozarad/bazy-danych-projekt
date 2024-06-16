package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.DatabaseStructure;

public class Add extends JPanel{
	
	//text field default dimension
		static final Dimension TEXTDIM = new Dimension(125,25);
		
		
		JLabel locationLabel;
		JLabel districtLabel;
		JTextField location;
		JTextField district;
		JLabel statusLabel;
		JComboBox<String> statusCombo;
		ComboBoxModel<String> statusModel;
		JButton back;
		
		final MainWindow parent;
		
		
		public Add(Dimension dim, MainWindow parent,DatabaseStructure structure)
		{
			this.parent=parent;
			setPreferredSize(dim);
			setVisible(true);
			
			
			//layout
			GridBagLayout bagLayout = new GridBagLayout();
			setLayout(bagLayout);
			GridBagConstraints constraints = new GridBagConstraints();
			constraints.insets = new Insets(5, 10, 5, 10);
			
			
			//adding elements
			constraints.gridx=0;
			constraints.gridy=0;
			locationLabel = new JLabel("Ulica");
			add(locationLabel,constraints);
			
			constraints.gridx++;
			location = new JTextField();
			location.setPreferredSize(TEXTDIM);
			add(location,constraints);
			
			constraints.gridx=0;
			constraints.gridy++;
			districtLabel = new JLabel("Dzielnica");
			add(districtLabel,constraints);
			
			constraints.gridx++;
			district = new JTextField();
			district.setPreferredSize(TEXTDIM);
			add(district,constraints);
			
			constraints.gridx=0;
			constraints.gridy++;
			statusLabel = new JLabel("status");
			add(statusLabel,constraints);
			
			constraints.gridx++;
			statusCombo = new JComboBox<>();
			statusCombo.setPreferredSize(TEXTDIM);
			statusModel = new DefaultComboBoxModel<>(structure.getStatuses().toArray(String[]::new));
			statusCombo.setModel(statusModel);
			add(statusCombo,constraints);

			constraints.gridx=1;
			constraints.gridy++;
			back = new JButton("<--");
			back.setPreferredSize(TEXTDIM);
			back.addActionListener(e->{
				parent.remove(MainWindow.content);
				MainWindow.content=MainWindow.mainPanel;
				parent.add(MainWindow.content);
				parent.repaint();
				parent.pack();
				
			});
			add(back,constraints);
		}
	
	
}
