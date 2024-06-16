package model;


import java.util.ArrayList;
import java.util.List;

public class DatabaseStructure {

	
	private List<String> priorities;
	private List<String> statuses;
	private List<String> types;
	private List<Defect> defects;
	public static Defect SELECTED_DEFECT;
	
	
	private String connectionState;
	
	public DatabaseStructure()
	{
		  priorities = new ArrayList<String>();
		  statuses= new ArrayList<String>();
		  types= new ArrayList<String>();
		  defects = new ArrayList<Defect>();
		
	}
	
	public void setDefects(List<Defect> d)
	{
		this.defects.clear();
		this.defects.addAll(d);
	}
	
	public  void setPriorities(List<String> priorities) {
		
		this.priorities.addAll(priorities);
	}
	public  void setStatuses(List<String> statuses) {
		
		this.statuses.addAll(statuses);
	}
	public  void setTypes(List<String> types) {
		this.types.addAll(types);
	}

	public  List<String> getPriorities() {
		return priorities;
	}
	public  List<String> getStatuses() {
		return statuses;
	}
	public  List<String> getTypes() {
		return types;
	}

	public List<Defect> getDefects(){
		return this.defects;
	}
	
	public void setConnectionState(String newState)
	{
		this.connectionState=newState;
	}
	
	public String getConnectionState()
	{
		return connectionState;
	}	
	
	
	
	
	
	
	
	
	
	
}
