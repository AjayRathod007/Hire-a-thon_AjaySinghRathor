package assessment.utilities;

import java.util.Comparator;

public class EfficiencyPair implements Comparator<EfficiencyPair> {

	private double hours;
	private String owner;
	
	public EfficiencyPair()
	{}
	
	public EfficiencyPair(double hours, String owner) {
		super();
		this.hours = hours;
		this.owner = owner;
	}
	
	public double getHours() {
		return hours;
	}
	public void setHours(double hours) {
		this.hours = hours;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "EfficiencyPair [hours=" + hours + ", owner=" + owner + "]";
	}

	

	@Override
	public int compare(EfficiencyPair o1, EfficiencyPair o2) {

       if(o1.getHours() > o2.getHours())
	    	return 1;
       
       return 0; 
	}

	
	
}
