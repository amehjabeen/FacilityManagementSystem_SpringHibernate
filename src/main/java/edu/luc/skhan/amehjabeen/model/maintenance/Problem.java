package edu.luc.skhan.amehjabeen.model.maintenance;

import edu.luc.skhan.amehjabeen.model.facility.IFacility;

public class Problem implements IProblem {
	
	private long problemId;
	private String typeOfProblem;
	private String maintenanceRequestStatus;
	private IFacility facility;
	
	public Problem(){}
		
	@Override
	public String getTypeOfProblem() {
		return typeOfProblem;
	}

	@Override
	public void setTypeOfProblem(String typeOfProblem) {
		this.typeOfProblem = typeOfProblem;
	}

	@Override
	public String getMaintenanceRequestStatus() {
		return maintenanceRequestStatus;
	}

	@Override
	public void setMaintenanceRequestStatus(String maintenanceRequestStatus) {
		this.maintenanceRequestStatus = maintenanceRequestStatus;
	}

	public long getProblemId() {
		return problemId;
	}

	public void setProblemId(long problemId) {
		this.problemId = problemId;
	}

	@Override
	public IFacility getFacility() {
		return facility;
	}

	@Override
	public void setFacility(IFacility facility) {
		this.facility = facility;
	}

}
