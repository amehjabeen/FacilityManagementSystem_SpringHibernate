package edu.luc.skhan.amehjabeen.model.maintenance;

import java.util.Date;

import edu.luc.skhan.amehjabeen.model.facility.IFacilityGetterSetter;

public interface IMaintenanceRequest extends IFacilityGetterSetter {

	void setRequestDate(Date requestDate);
	Date getRequestDate();
	void setInspectionStatus(String inspectionStatus);
	String getInspectionStatus();
}
