package edu.luc.skhan.amehjabeen.model.use;

import java.util.Date;

import edu.luc.skhan.amehjabeen.model.facility.IFacilityGetterSetter;

public interface IUse extends IFacilityGetterSetter{

	Date getEndTime();
	Date getStartTime();
	void setEndTime(Date endTime);
	void setStartTime(Date startTime);
	void setIsInUse(boolean isInUse);
	boolean getIsInUse();
	boolean getIsInUseDuringInterval();
	void setIsInUseDuringInterval(boolean isInUseDuringInterval);
	long getUseId();
	void setUseId(long useId);
	
}
