package edu.luc.skhan.amehjabeen.model.facility;

import java.util.List;
import java.util.Set;

import edu.luc.skhan.amehjabeen.model.maintenance.IProblem;
import edu.luc.skhan.amehjabeen.model.use.IUse;

public class Facility implements IFacility {
	private String name;
	private long id;
	private IInformation information;
	
	public Facility(){}
	
	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public IInformation getInformation(){
		if (information!=null){
			return information;
		}
		else
			return null;
	}

	@Override
	public void setInformation(IInformation information){
		this.information = information;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
}
