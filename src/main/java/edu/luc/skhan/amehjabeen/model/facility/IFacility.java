package edu.luc.skhan.amehjabeen.model.facility;

import java.util.List;

import edu.luc.skhan.amehjabeen.model.maintenance.IProblem;
import edu.luc.skhan.amehjabeen.model.use.IUse;


public interface IFacility{
	public long getId();
	public void setId(long id);	
	public IInformation getInformation();
	public void setInformation(IInformation information);
	public String getName();
	public void setName(String name);
}
