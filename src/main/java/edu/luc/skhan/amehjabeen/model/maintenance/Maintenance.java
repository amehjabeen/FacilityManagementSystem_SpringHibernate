package edu.luc.skhan.amehjabeen.model.maintenance;

import java.util.Date;

import edu.luc.skhan.amehjabeen.model.facility.IFacility;

public class Maintenance implements IMaintenance {

	private long maintenanceId;
	private double cost;
	private Date startTime;
	private Date endTime;
	IFacility facility;
	
	public Maintenance(){}

	public long getMaintenanceId() {
		return maintenanceId;
	}

	public void setMaintenanceId(long maintenanceId) {
		this.maintenanceId = maintenanceId;
	}
	
	@Override
	public long calcDownTimeForFacility() {		
		return endTime.getTime() - startTime.getTime();
	}

	@Override
	public double getCost() {
		return cost;
	}

	@Override
	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public Date getStartTime() {
		return startTime;
	}

	@Override
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@Override
	public Date getEndTime() {
		return endTime;
	}

	@Override
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Override
	public void setFacility(IFacility facility) {
		this.facility = facility;

	}

	@Override
	public IFacility getFacility() {
		return facility;
	}
}
