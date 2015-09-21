package edu.luc.skhan.amehjabeen.model.maintenance;

import edu.luc.skhan.amehjabeen.model.facility.IFacilityGetterSetter;

public interface IProblem extends IFacilityGetterSetter {
	public String getTypeOfProblem();
	public void setTypeOfProblem(String typeOfProblem);
	public String getMaintenanceRequestStatus();
	public void setMaintenanceRequestStatus(String maintenanceRequestStatus);
}
