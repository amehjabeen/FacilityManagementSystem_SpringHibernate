package edu.luc.skhan.amehjabeen.model.classes;

import java.util.ArrayList;

import edu.luc.skhan.amehjabeen.model.facility.IFacility;
import edu.luc.skhan.amehjabeen.model.maintenance.IMaintenanceRequest;
import edu.luc.skhan.amehjabeen.model.maintenance.IProblem;
import edu.luc.skhan.amehjabeen.model.use.IUse;

public interface IUser {
	
	public ArrayList<IFacility> listFacilities();	
	public int requestAvailableCapacity(IFacility facility);

	IFacility retrieveFacility(long id);
	
	public ArrayList<IProblem> listFacilityProblems(IFacility facility);
	public void addFacilityProblem(IProblem problem);	
	
	void enterFacility(IUse use);
	void vacateFacility(IUse use);	
	
	public void makeFacilityMaintenanceRequest(IMaintenanceRequest maintenanceRequest);
	public ArrayList<IMaintenanceRequest> listMaintenanceRequests();
	

}
