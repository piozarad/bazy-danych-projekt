package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Optional;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import model.DatabaseStructure;
import model.Defect;

public class DefectPanel extends JPanel{
	
	JLabel userName;
	JLabel district;
	JLabel type;
	JLabel priority;
	JLabel date_added;
	JLabel last_modified;
	JLabel comment;
	JLabel gpsLocation;
	JLabel adress;
	JLabel feedback;
	JLabel status;
	
	JLabel userNameLabel;
	JLabel districtLabel; 
	JLabel typeLabel;
	JLabel priorityLabel;
	JLabel date_addedLabel;
	JLabel last_modifiedLabel;
	JLabel commentLabel;
	JLabel gpsLocationLabel;
	JLabel adressLabel;
	JLabel feedbackLabel;
	JLabel statusLabel;
	
	JTextArea txt;
	
	
	final MainWindow parent;
	
	public DefectPanel(Dimension dim, MainWindow parent,DatabaseStructure structure)
	{
		final Dimension panelSize = new Dimension((int)dim.getWidth() /2 , (int) dim.getHeight()-50); 
		this.parent=parent;
		setPreferredSize(panelSize);
		setVisible(true);
		
		//layout
		GridBagLayout bagLayout = new GridBagLayout();
		setLayout(bagLayout);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(5, 10, 5, 10);
		constraints.anchor=GridBagConstraints.CENTER;
		
		
		//adding elements to first column
		constraints.gridx=0;
		constraints.gridy=2;
		typeLabel = new JLabel("Typ zg³oszenia:");
		add(typeLabel,constraints);
		
		
		constraints.gridy++;
		priorityLabel = new JLabel("Priorytet:");
		add(priorityLabel,constraints);
		
		
		constraints.gridy++;
		adressLabel = new JLabel("Adres:");
		add(adressLabel,constraints);
		
		constraints.gridy++;
		districtLabel = new JLabel("Dzielnica:");
		add(districtLabel,constraints);
		
		constraints.gridy++;
		gpsLocationLabel = new JLabel("GPS:");
		add(gpsLocationLabel,constraints);
		
		constraints.gridy++;
		date_addedLabel = new JLabel("Data dodania:");
		add(date_addedLabel,constraints);
		
		constraints.gridy++;
		last_modifiedLabel = new JLabel("Data Modyfikacji:");
		add(last_modifiedLabel,constraints);
		
	
		constraints.gridy++;
		userNameLabel = new JLabel("Zg³oszony przez:");
		add(userNameLabel,constraints);
		
		//adding elements to second column		
				
			
			
			constraints.gridx=1;
			constraints.gridy=2;
			type = new JLabel("---");
			add(type,constraints);
			
			constraints.gridy++;
			priority = new JLabel("---");
			add(priority,constraints);
				
				
			constraints.gridy++;
			adress = new JLabel("---");
			add(adress,constraints);
				
			constraints.gridy++;
			district= new JLabel("---");
			add(district,constraints);
				
			constraints.gridy++;
			gpsLocation = new JLabel("---");
			add(gpsLocation,constraints);
				
			constraints.gridy++;
			date_added = new JLabel("---");
			add(date_added,constraints);
				
			constraints.gridy++;
			last_modified= new JLabel("---");
			add(last_modified,constraints);
				
			constraints.gridy++;
			userName = new JLabel("---");
			add(userName,constraints);
				
			
		
		
		
		constraints.gridx=0;
		constraints.gridy++;
		constraints.gridwidth=3;
		constraints.gridheight=3;
		
		
		txt = new JTextArea(10,25);
		txt.setEditable(false);
		txt.setBorder(BorderFactory.createTitledBorder(
				   BorderFactory.createEtchedBorder(), "Informacje", TitledBorder.LEFT, TitledBorder.TOP));
		txt.setPreferredSize(new Dimension(200,200));
		JScrollPane sp = new JScrollPane(txt,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		add(sp,constraints);
		
		
		
		
		
		
		
		
		
//		ufferedImage myPicture = ImageIO.read(new File("path-to-file"));
//		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
//		add(picLabel);
		
		
	}
	
	void refreshSelection()
	{
		type.setText(DatabaseStructure.SELECTED_DEFECT.getType());
		priority.setText(DatabaseStructure.SELECTED_DEFECT.getPriority());
		adress.setText(DatabaseStructure.SELECTED_DEFECT.getAdress());
		district.setText(DatabaseStructure.SELECTED_DEFECT.getDistrict());
		gpsLocation.setText(DatabaseStructure.SELECTED_DEFECT.getGpsLocation());
		last_modified.setText(DatabaseStructure.SELECTED_DEFECT.getLast_modified());
		date_added.setText(DatabaseStructure.SELECTED_DEFECT.getDate_added());
		userName.setText(DatabaseStructure.SELECTED_DEFECT.getUserName());
		
		String info = "Komentarz:\n" + DatabaseStructure.SELECTED_DEFECT.getComment() + "\n"
				+ "Informacja zwrotna:\n" + DatabaseStructure.SELECTED_DEFECT.getFeedback();
		txt.setText(info);
			
		this.repaint();
		
	}
	

}
