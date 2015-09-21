package edu.luc.skhan.amehjabeen.model.use;

import java.util.Date;

import edu.luc.skhan.amehjabeen.model.facility.IFacility;

public class Use implements IUse  {
	private long useId;
	private Date startTime;
	private Date endTime;
	private boolean isInUse;
	private boolean isInUseDuringInterval;
	private IFacility facility;
	
	public Use(){}
	
	@Override
	public Date getEndTime() {
		return endTime;
	}

	@Override
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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
	public boolean getIsInUse() {
		return isInUse;
	}

	@Override
	public void setIsInUse(boolean isInUse) {
		this.isInUse = isInUse;
	}

	@Override
	public long getUseId() {
		return useId;
	}

	@Override
	public void setUseId(long useId) {
		this.useId = useId;
	}

	@Override
	public boolean getIsInUseDuringInterval() {
		return isInUseDuringInterval;
	}

	@Override
	public void setIsInUseDuringInterval(boolean isInUseDuringInterval) {
		this.isInUseDuringInterval = isInUseDuringInterval;
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
