package assessment.utilities;

public class Data {

	private String date;
	private String projectName;
	private double hours;
	private String owner;
	private String team;
	private String billingStatus;
	
	
	
	public Data() {};
	
	public Data(Object object, Object object2, Object object3, Object object4, Object object5, Object object6) {
		super();
		this.date = (String) object;
		this.projectName = (String) object2;
		this.hours = (double) object3;
		this.owner = (String) object4;
		this.team = (String) object5;
		this.billingStatus = (String) object6;
	}

	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getBillingStatus() {
		return billingStatus;
	}
	public void setBillingStatus(String billingStatus) {
		this.billingStatus = billingStatus;
	}
	public double getHours() {
		return hours;
	}
	public void setHours(double hours) {
		this.hours = hours;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Data [owner=" + owner + ", team=" + team + ", billingStatus=" + billingStatus + ", hours=" + hours
				+ ", projectName=" + projectName + ", date=" + date + "]";
	}
	
	
	
}
