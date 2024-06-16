package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import model.DatabaseStructure;
import model.Defect;
import model.Defect.DefectBuilder;

public class Result extends JPanel {
	
	JList<Defect> defectList;
	DefectPanel defectInfoPanel;
	JButton back;
	DefaultListModel<Defect> model;
	DatabaseStructure structure;
	
	static final Dimension TEXTDIM = new Dimension(125,25);
	
	public Result(Dimension dim, MainWindow parent,DatabaseStructure structure) {
		
		this.structure=structure;
		final Dimension panelSize = new Dimension((int)dim.getWidth() /2 -90, (int) dim.getHeight()-100); 
		
		setVisible(true);
		setPreferredSize(new Dimension(panelSize));
		setLayout(new BorderLayout());
		
		
		//test
//		Defect d = new DefectBuilder(1)
//				.setAdress("ul Brydaka")
//				.setComment("kokodzambo")
//				.setDistrict("Drabinianka")
//				.setDateAdded("10-10-1998")
//				.setType("2")
//				.setUseName(" ziomek")
//				.setDateLastModified("12-10-1999")
//				.setpriority("1")
//				.setStatusId("status")
//				.setGpsLocation("20,20.1")
//				.setFeedback("Oczekiwanie na przypisanie technikowi")
//				.build();
//		
		
		
		
		//
		 model = new DefaultListModel<>();
//		model.add(0, d);
		
		
		defectList = new JList<>(model);
		defectList.setPreferredSize(panelSize);
		defectList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				DatabaseStructure.SELECTED_DEFECT = defectList.getSelectedValue();
				defectInfoPanel.refreshSelection();
				defectInfoPanel.repaint();
				parent.pack();
				
			}
		});
		JScrollPane scroll = new JScrollPane(defectList);
		add(scroll,BorderLayout.WEST);
		
		
		defectInfoPanel = new DefectPanel(dim,parent,structure);
		add(defectInfoPanel,BorderLayout.EAST);
		
		back = new JButton("<--");
		back.setPreferredSize(TEXTDIM);
		back.addActionListener(e->{
			parent.remove(MainWindow.content);
			MainWindow.content=MainWindow.mainPanel;
			parent.add(MainWindow.content);
			parent.repaint();
			parent.pack();
			
		});
		add(back,BorderLayout.SOUTH);
		
		parent.pack();
		
	}
	
	
	public void updateDefects()
	{
		int i=0;
		this.model.clear();
		for (Defect d : this.structure.getDefects())
		{
			this.model.add(i++,d);
		}
	
		this.defectList.setModel(model);
		
	}
}
