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

import controller.ConnectionUtils;
import model.DatabaseStructure;
import model.SearchQuery;

public class Search extends JPanel{

	
	//text field default dimension
	static final Dimension TEXTDIM = new Dimension(125,25);
	
	
	JLabel locationLabel;
	JLabel districtLabel;
	JTextField location;
	JTextField district;
	JLabel statusLabel;
	JLabel typeLabel;
	JComboBox<String> statusCombo;
	JComboBox<String> typeCombo;
	ComboBoxModel<String> model;
	ComboBoxModel<String> typeModel;
	JButton back;
	JButton search;
	
	final MainWindow parent;
	
	
	public Search(Dimension dim,MainWindow parent,DatabaseStructure structure)
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
		statusLabel = new JLabel("Status");
		add(statusLabel,constraints);
		
		constraints.gridx++;
		statusCombo = new JComboBox<>();
		statusCombo.setPreferredSize(TEXTDIM);
		model = new DefaultComboBoxModel<>(structure.getStatuses().toArray(String[]::new));
		
		statusCombo.setModel(model);
		add(statusCombo,constraints);
		
		constraints.gridx=0;
		constraints.gridy++;
		typeLabel = new JLabel("Typ");
		add(typeLabel,constraints);
		
		constraints.gridx++;
		typeCombo = new JComboBox<>();
		typeCombo.setPreferredSize(TEXTDIM);
		typeModel = new DefaultComboBoxModel<>(structure.getTypes().toArray(String[]::new));
		
		typeCombo.setModel(typeModel);
		add(typeCombo,constraints);
		
		constraints.gridx=1;
		constraints.gridy++;
		search = new JButton("Szukaj");
		search.setPreferredSize(TEXTDIM);
		search.addActionListener(e->{
			 SearchQuery query = new SearchQuery(getAdress(),getDistrict(),getType(),getStatus());
			 ConnectionUtils.search(query, structure);
			
			 parent.showResults();
			
		});
		add(search,constraints);
		
		
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
	
	public String getDistrict()
	{
		return this.district.getText();
	}
	
	public String getAdress()
	{
		
		return this.location.getText();
	}
	
	public String getType() 
	{
		if(this.typeCombo.getSelectedIndex() == this.typeModel.getSize()-1) return "";
		
		return  (String)this.typeCombo.getSelectedItem();
		
	} 
	
	public String getStatus() 
	{
				
		if(this.statusCombo.getSelectedIndex() == this.model.getSize()-1) return "";
		
		return  (String)this.statusCombo.getSelectedItem();
		
	} 
	
	
	
}
