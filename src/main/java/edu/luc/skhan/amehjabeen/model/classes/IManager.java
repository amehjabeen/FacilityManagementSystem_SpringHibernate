package edu.luc.skhan.amehjabeen.model.classes;

import java.util.ArrayList;
import java.util.Date;

import edu.luc.skhan.amehjabeen.model.facility.IFacility;
import edu.luc.skhan.amehjabeen.model.facility.IInformation;
import edu.luc.skhan.amehjabeen.model.maintenance.IMaintenance;
import edu.luc.skhan.amehjabeen.model.use.IInspections;
import edu.luc.skhan.amehjabeen.model.use.IUse;

public interface IManager {

	public void addNewFacility(IFacility facility);
	public void removeFacility(IFacility facility);
	
	public void removeFacilityDetail(IInformation information);
	void addFacilityDetail(IInformation information);
	
	public ArrayList<IInspections> listInspections();
	public void addInspections(IInspections inspections);
	
	public ArrayList<IUse> listActualUsage(IFacility facility);
	void assignFacilityToUse(IUse use);
	
	public ArrayList<IMaintenance> listMaintenance();
	public void scheduleMaintenance(IMaintenance maintenance);
	
}
