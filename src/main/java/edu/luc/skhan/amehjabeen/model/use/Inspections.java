package edu.luc.skhan.amehjabeen.model.use;

import java.util.Date;

import edu.luc.skhan.amehjabeen.common.Constants;
import edu.luc.skhan.amehjabeen.model.facility.IFacility;

public class Inspections implements IInspections {
	
	private long inspectionId;
	private Date inspectionDate;
	private String problemStatus;
	private IFacility facility;
	
	public Inspections(){}
	
	@Override
	public void setFacility(IFacility facility) {
		this.facility = facility;
		
	}

	@Override
	public IFacility getFacility() {
		return facility;
	}

	@Override
	public Date getInspectionDate() {
		return inspectionDate;
	}

	@Override
	public void setInspectionDate(Date inspectionDate) {
		this.inspectionDate = inspectionDate;
	}

	@Override
	public String getProblemStatus() {
		return problemStatus;
	}

	@Override
	public void setProblemStatus(String problemStatus) {
		this.problemStatus = problemStatus;
	}

	public long getInspectionId() {
		return inspectionId;
	}

	public void setInspectionId(long inspectionId) {
		this.inspectionId = inspectionId;
	}
	
	
}
