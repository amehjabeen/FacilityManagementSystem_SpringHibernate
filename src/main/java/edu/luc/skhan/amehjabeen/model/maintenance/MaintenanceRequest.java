package edu.luc.skhan.amehjabeen.model.maintenance;

import java.util.Date;

import edu.luc.skhan.amehjabeen.common.Constants;
import edu.luc.skhan.amehjabeen.model.facility.IFacility;

public class MaintenanceRequest implements IMaintenanceRequest {
	
	private long requestId;
	private Date requestDate;
	private String inspectionStatus;
	private IFacility facility;
	
	public MaintenanceRequest(){}
	
	@Override
	public String getInspectionStatus() {
		return inspectionStatus;
	}

	@Override
	public void setInspectionStatus(String inspectionStatus) {
		this.inspectionStatus = inspectionStatus;
	}

	@Override
	public Date getRequestDate() {
		return requestDate;
	}

	@Override
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	@Override
	public IFacility getFacility() {
		return facility;
	}

	@Override
	public void setFacility(IFacility facility) {
		this.facility = facility;
	}


	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

}
