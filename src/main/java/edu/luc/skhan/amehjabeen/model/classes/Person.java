package edu.luc.skhan.amehjabeen.model.classes;

import java.util.ArrayList;

import edu.luc.skhan.amehjabeen.data.HibernateMethods;
import edu.luc.skhan.amehjabeen.model.facility.IFacility;
import edu.luc.skhan.amehjabeen.model.maintenance.IMaintenanceRequest;
import edu.luc.skhan.amehjabeen.model.maintenance.IProblem;
import edu.luc.skhan.amehjabeen.model.use.IUse;

public class Person implements IUser {
	
	HibernateMethods hibernateMethods = HibernateMethods.getInstance();
	
	private String personId;
	
	public String getPersonId(){
		return personId;
	}
	public void setPersonId(String personId){
		this.personId = personId;
	}
	
	@Override
	public ArrayList<IFacility> listFacilities() {
		try {
			return hibernateMethods.listFacilities();
		} catch (Exception se) {
			System.err.println(se.getMessage());
			se.printStackTrace();
			return null;
		}	
	}
	
	@Override
	public int requestAvailableCapacity(IFacility facility) {
		try {
			return hibernateMethods.requestAvailableCapacity(facility);
		} catch (Exception se) {
			System.err.println(se.getMessage());
			se.printStackTrace();
			return 0;
		}	
	}
	
	@Override
	public ArrayList<IProblem> listFacilityProblems(IFacility facility) {
		try {
			return hibernateMethods.listFacilityProblems(facility);
		} catch (Exception se) {
			System.err.println(se.getMessage());
			se.printStackTrace();
			return null;
		}	
	}
	
	@Override
	public void addFacilityProblem(IProblem problem) {
		try {
			hibernateMethods.addFacilityProblem(problem);
		} catch (Exception se) {
			System.err.println(se.getMessage());
			se.printStackTrace();
		}
	}
	
	@Override
	public void enterFacility(IUse use) {
		try {
			hibernateMethods.enterFacility(use);
		} catch (Exception se) {
			System.err.println(se.getMessage());
			se.printStackTrace();
		}
	}

	@Override
	public void vacateFacility(IUse use) {
		try {
			hibernateMethods.vacateFacility(use);
		} catch (Exception se) {
			System.err.println(se.getMessage());
			se.printStackTrace();
		}

	}

	@Override
	public void makeFacilityMaintenanceRequest(
			IMaintenanceRequest maintenanceRequest) {
		try {
			hibernateMethods.makeFacilityMaintenanceRequest(maintenanceRequest);
		} catch (Exception se) {
			System.err.println(se.getMessage());
			se.printStackTrace();
		}	

	}

	@Override
	public ArrayList<IMaintenanceRequest> listMaintenanceRequests() {
		try {
			return hibernateMethods.listMaintenanceRequests();
		} catch (Exception se) {
			System.err.println(se.getMessage());
			se.printStackTrace();
			return null;
		}	
	}


	@Override
	public IFacility retrieveFacility(long id) {
		try {
			return hibernateMethods.retrieveFacility(id);
		} catch (Exception se) {
			System.err.println(se.getMessage());
			se.printStackTrace();
			return null;
		}	
	}

}
