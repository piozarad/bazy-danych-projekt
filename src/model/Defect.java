package model;

public class Defect {

	final int defectId;
	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public int getTechnicanId() {
		return technicanId;
	}



	public void setTechnicanId(int technicanId) {
		this.technicanId = technicanId;
	}



	public String getDistrict() {
		return district;
	}



	public void setDistrict(String district) {
		this.district = district;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getPriority() {
		return priority;
	}



	public void setPriority(String priority) {
		this.priority = priority;
	}



	public String getDate_added() {
		return date_added;
	}



	public void setDate_added(String date_added) {
		this.date_added = date_added;
	}



	public String getLast_modified() {
		return last_modified;
	}



	public void setLast_modified(String last_modified) {
		this.last_modified = last_modified;
	}



	public String getComment() {
		return comment;
	}



	public void setComment(String comment) {
		this.comment = comment;
	}



	public String getGpsLocation() {
		return gpsLocation;
	}



	public void setGpsLocation(String gpsLocation) {
		this.gpsLocation = gpsLocation;
	}



	public String getAdress() {
		return adress;
	}



	public void setAdress(String adress) {
		this.adress = adress;
	}



	public String getFeedback() {
		return feedback;
	}



	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public int getDefectId() {
		return defectId;
	}

	String userName;
	int technicanId;
	String district;
	String type;
	String priority;
	String date_added;
	String last_modified;
	String comment;
	String gpsLocation;
	String adress;
	String feedback;
	String status;
	
	@Override
	public String toString()
	{
		return defectId + " " + type+ " " +adress;
		
	}
	
	public Defect() 
	{
		this.defectId=0;
		this.adress="";
		this.comment="";
		this.date_added="";
		this.last_modified="";
		this.district="";
		this.feedback="";
		this.technicanId=-1;
		this.userName="";
		this.type="";
		this.priority="";
		this.gpsLocation="";
		this.feedback="";
		this.status="";
	
	}
	
	//Builder 
	private Defect(DefectBuilder d, int id)
	{
		this.defectId=id;
		this.adress=d.adress;
		this.comment=d.comment;
		this.date_added=d.date_added;
		this.last_modified=d.last_modified;
		this.district=d.district;
		this.feedback=d.feedback;
		this.technicanId=d.technicanId;
		this.userName=d.userName;
		this.type=d.type;
		this.priority=d.priority;
		this.gpsLocation=d.gpsLocation;
		this.feedback=d.feedback;
		this.status=d.status;

	}
	
	public static class DefectBuilder
	{
		final int defectId;
		String userName;
		int technicanId;
		String district;
		String type;
		String priority;
		String date_added;
		String last_modified;
		String comment;
		String gpsLocation;
		String adress;
		String feedback;
		String status;
		
		public DefectBuilder(int defect_id)
		{
			this.defectId=defect_id;
		}
		public DefectBuilder setTechnicanId(int technican_id)
		{
			this.technicanId=technican_id;
			return this;
		}
		public DefectBuilder setDistrict(String districtName)
		{
			this.district=districtName;
			return this;
		}
		public DefectBuilder setType(String type)
		{
			this.type=type;
			return this;
		}
		public DefectBuilder setpriority(String priority)
		{
			this.priority=priority;
			return this;
		}
		public DefectBuilder setDateAdded(String date_added)
		{
			this.date_added=date_added;
			return this;
		}
		public DefectBuilder setDateLastModified(String last_modified)
		{
			this.last_modified=last_modified;
			return this;
		}
		public DefectBuilder setComment(String comment)
		{
			this.comment=comment;
			return this;
		}
		public DefectBuilder setGpsLocation(String gpsLocation)
		{
			this.gpsLocation=gpsLocation;
			return this;
		}
		public DefectBuilder setAdress(String adress)
		{
			this.adress=adress;
			return this;
		}
		public DefectBuilder setFeedback(String feedback)
		{
			this.feedback=feedback;
			return this;
		}
		public DefectBuilder setStatusId(String status)
		{
			this.status=status;
			return this;
		}
		public DefectBuilder setUseName(String userName)
		{
			this.userName=userName;
			return this;
		}
		public Defect build()
		{
			return new Defect(this,defectId);
		}

	}

}
