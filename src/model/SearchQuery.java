package model;

public class SearchQuery {
	
	
  private String address;
  private String district;
  private String type;
  private String status;
	
	
	public SearchQuery(  String address, String district,String type,String status) 
	{
		this.address=address;
		this.district=district;
		this.type=type;
		this.status=status;
	}
	
	public String getSearchQuery()
	{
		String result= "SELECT * from get_defects() WHERE";
				
		if(address.length()>0) result += " adress like '" + address + "' ";
			else  result += " adress like 'Rzeszów' ";
		if(district.length()>0) result += " AND district like '" + district + "' ";
		if(type.length()>0) result += "AND type_name like '" + type + "' ";
		if(status.length()>0) result += "AND status_name like '" + status + "' ";
		
		result += " LIMIT 20;";
		System.out.println(result);
		
		return result;
	}

}
