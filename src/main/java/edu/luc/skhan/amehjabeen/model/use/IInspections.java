package edu.luc.skhan.amehjabeen.model.use;

import java.util.Date;

import edu.luc.skhan.amehjabeen.model.facility.IFacilityGetterSetter;

public interface IInspections extends IFacilityGetterSetter{

	String getProblemStatus();

	Date getInspectionDate();

	void setInspectionDate(Date inspectionDate);

	void setProblemStatus(String problemStatus);

}
