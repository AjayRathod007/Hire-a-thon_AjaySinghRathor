package assessment.utilities;

import java.util.HashSet;
import java.util.Set;

public class Pair
{
  private Set<String> employeesWorkedOnProject = new HashSet<>();
  private double totalHoursSpentByTeam;
  
  public Pair()
  {}

public Pair(Set<String> employeesWorkedOnProject, double totalHoursSpentByTeam) {
	super();
	this.employeesWorkedOnProject = employeesWorkedOnProject;
	this.totalHoursSpentByTeam = totalHoursSpentByTeam;
}

public Set<String> getEmployeesWorkedOnProject() {
	return employeesWorkedOnProject;
}

public void setEmployeesWorkedOnProject(Set<String> employeesWorkedOnProject) {
	this.employeesWorkedOnProject = employeesWorkedOnProject;
}

public double getTotalHoursSpentByTeam() {
	return totalHoursSpentByTeam;
}

public void setTotalHoursSpentByTeam(double totalHoursSpentByTeam) {
	this.totalHoursSpentByTeam = totalHoursSpentByTeam;
}

@Override
public String toString() {
	return "Pair [employeesWorkedOnProject=" + employeesWorkedOnProject + ", totalHoursSpentByTeam="
			+ totalHoursSpentByTeam + ", meanHours :" + getMeanHours() + "]";
}
  
  public double getMeanHours()
  {
	  return totalHoursSpentByTeam/employeesWorkedOnProject.size();
  }

}