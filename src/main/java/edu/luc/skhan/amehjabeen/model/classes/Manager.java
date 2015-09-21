package edu.luc.skhan.amehjabeen.model.classes;

import java.util.ArrayList;
import java.util.Date;

import edu.luc.skhan.amehjabeen.common.Constants;
import edu.luc.skhan.amehjabeen.data.HibernateMethods;
import edu.luc.skhan.amehjabeen.model.facility.IFacility;
import edu.luc.skhan.amehjabeen.model.facility.IInformation;
import edu.luc.skhan.amehjabeen.model.maintenance.IMaintenance;
import edu.luc.skhan.amehjabeen.model.maintenance.IMaintenanceRequest;
import edu.luc.skhan.amehjabeen.model.maintenance.IProblem;
import edu.luc.skhan.amehjabeen.model.use.IInspections;
import edu.luc.skhan.amehjabeen.model.use.IUse;

public class Manager extends Person implements IManager{

	public Manager(){}

	HibernateMethods hibernateMethods = HibernateMethods.getInstance();

	@Override
	public void addNewFacility(IFacility facility) {
		try {
			hibernateMethods.addNewFacility(facility);
		} catch (Exception se) {
			System.err.println(se.getMessage());
			se.printStackTrace();
		}
	}

	@Override
	public void removeFacility(IFacility facility) {
		try {
			hibernateMethods.removeFacility(facility);
		} catch (Exception se) {
			System.err.println(se.getMessage());
			se.printStackTrace();
		}	
	}


	@Override
	public void addFacilityDetail(IInformation information) {
		try {
			hibernateMethods.addFacilityDetail(information);
		} catch (Exception se) {
			System.err.println(se.getMessage());
			se.printStackTrace();
		}

	}
	
	@Override
	public void removeFacilityDetail(IInformation information) {
		try {
			hibernateMethods.removeFacilityDetail(information);
		} catch (Exception se) {
			System.err.println(se.getMessage());
			se.printStackTrace();
		}	

	}


	public double calcProblemRateForFacility(IFacility facility) {
		try {
			int numberOfTimesUsed = listActualUsage(facility).size();	
			return  listFacilityProblems(facility).size()/numberOfTimesUsed;
		} catch (Exception se) {
			System.err.println(se.getMessage());
			se.printStackTrace();
			return 0.0;
		}	
	}


	public double calcMaintenanceCostForFacility(IMaintenance maintenance) {
		try {
			return (Constants.DEFAULT_COST+ (listFacilityProblems(maintenance.getFacility()).size()*
					maintenance.getCost()));
		} catch (Exception se) {
			System.err.println(se.getMessage());
			se.printStackTrace();
			return 0.0;
		}	
	}

	@Override
	public ArrayList<IMaintenance> listMaintenance() {
		try {
			return hibernateMethods.listMaintenance();
		} catch (Exception se) {
			System.err.println(se.getMessage());
			se.printStackTrace();
			return null;
		}	
	}

	@Override
	public void scheduleMaintenance(IMaintenance maintenance) {
		try {
			hibernateMethods.scheduleMaintenance(maintenance);
		} catch (Exception se) {
			System.err.println(se.getMessage());
			se.printStackTrace();
		}	
	}


	public boolean isInUseDuringInterval(IFacility facility, Date startTime,
			Date endTime) {
		try{
			ArrayList<IUse> list = listActualUsage(facility);
			for(IUse use:list){
				if(startTime.getTime() <= use.getEndTime().getTime() && use.getStartTime().getTime() <= endTime.getTime()){
					return true;
				}

			}
		} catch (Exception se) {
			System.err.println(se.getMessage());
			se.printStackTrace();
		}
		return false;	
	}

	@Override
	public void assignFacilityToUse(IUse use) {
		try {
			hibernateMethods.assignFacilityToUse(use);
		} catch (Exception se) {
			System.err.println(se.getMessage());
			se.printStackTrace();
		}

	}
	

	@Override
	public ArrayList<IUse> listActualUsage(IFacility facility) {
		try {
			return hibernateMethods.listActualUsage(facility);
		} catch (Exception se) {
			System.err.println(se.getMessage());
			se.printStackTrace();
			return null;
		}
	}

	public double calcUsageRate(IFacility facility) {
		try {
			double usageRate = 0;
			ArrayList<IUse> list = listActualUsage(facility);
			//number of times the facility was used
			int count=0;
			for(IUse use:list){
				if(use.getIsInUseDuringInterval()){count++;}
			}
			//Total number of times it was assigned to use
			int n = list.size();
			usageRate = count/n;
			return usageRate;
		} catch (Exception se) {
			System.err.println(se.getMessage());
			se.printStackTrace();
		}
		return 0.0;
	}


	@Override
	public ArrayList<IInspections> listInspections() {
		try {
			return hibernateMethods.listInspections();
		} catch (Exception se) {
			System.err.println(se.getMessage());
			se.printStackTrace();
			return null;
		}
	}

	@Override
	public void addInspections(IInspections inspections) {
		try {
			hibernateMethods.addInspections(inspections);
		} catch (Exception se) {
			System.err.println(se.getMessage());
			se.printStackTrace();
		}

	}

}
