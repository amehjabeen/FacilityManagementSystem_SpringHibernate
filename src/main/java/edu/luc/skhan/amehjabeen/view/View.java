package edu.luc.skhan.amehjabeen.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.luc.skhan.amehjabeen.common.Constants;
import edu.luc.skhan.amehjabeen.model.use.IUse;
import edu.luc.skhan.amehjabeen.model.maintenance.IMaintenance;
import edu.luc.skhan.amehjabeen.model.maintenance.IMaintenanceRequest;
import edu.luc.skhan.amehjabeen.model.maintenance.Maintenance;
import edu.luc.skhan.amehjabeen.model.maintenance.MaintenanceRequest;
import edu.luc.skhan.amehjabeen.model.maintenance.Problem;
import edu.luc.skhan.amehjabeen.model.use.IInspections;
import edu.luc.skhan.amehjabeen.model.use.Inspections;
import edu.luc.skhan.amehjabeen.model.use.Use;
import edu.luc.skhan.amehjabeen.model.classes.Manager;
import edu.luc.skhan.amehjabeen.model.classes.User;
import edu.luc.skhan.amehjabeen.model.facility.IFacility;
import edu.luc.skhan.amehjabeen.model.facility.IInformation;
import edu.luc.skhan.amehjabeen.model.maintenance.IProblem;

public class View {
	public static void main(String args[]){

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("***************** Application Context instantiated! ******************");

		Manager manager = (Manager)context.getBean("manager");
		manager.setPersonId("ManagerXYZ123");

		User user = (User)context.getBean("user");
		user.setPersonId("User167");

		System.out.println(" Adding the first facility....");
		IFacility facility = (IFacility)context.getBean("facility");
		facility.setName("Science Hall");
		facility.setId(1);

		IInformation information = (IInformation) facility.getInformation();
		information.setTotalCapacity(10);
		information.setAvailableCapacity(10);
		information.setStatus(Constants.STATUS_AVAILABLE);
		information.setDescription("Hello World");

		System.out.println("*************** Saving Facility ***********************");
		manager.addNewFacility(facility);

		IFacility facility2 = (IFacility) user.retrieveFacility(1);

		try{
			System.out.println("Printing the first facility's information: \n"
					+"Facility Name: "+facility2.getName()+"\n"
					+"Total Capacity: "+facility2.getInformation().getTotalCapacity()+"\n"
					//+"Available Capacity: "+manager.requestAvailableCapacity(facility)+"\n"
					+"Description: "+facility2.getInformation().getDescription()+"\n"
					+"Status: "+facility2.getInformation().getStatus()+"\n");
		}catch(Exception e){
			e.printStackTrace();
		}

		System.out.println(" ADDING A SECOND FACILITY------------------------------------------------------------");
		IFacility facility3 = (IFacility)context.getBean("facility");
		facility3.setName("Math Hall");

		IInformation information2 = facility3.getInformation();
		information2.setTotalCapacity(21);
		information2.setStatus(Constants.STATUS_AVAILABLE);
		information2.setDescription("This is our second facility");

		manager.addNewFacility(facility3);

		System.out.println(" LISTING FACILITIES-------------------------------------------------------------------");
		ArrayList<IFacility> facilities = manager.listFacilities();
		for(IFacility theFacility: facilities){
			System.out.println("id: "+theFacility.getId()+" name: "+theFacility.getName());
		}
		manager.removeFacility(facility);

		System.out.println(" LISTING FACILITIES AFTER REMOVING THE FIRST FACILITY---------------------------------");
		facilities.clear();
		facilities = manager.listFacilities();
		for(IFacility theFacility: facilities){
			System.out.println("id: "+theFacility.getId()+" name: "+theFacility.getName());
		}

		System.out.println(" USER: ADDING A PROBLEM---------------------------------");
		String type = "cooling";
		String maintenanceRequestStatus = Constants.MAINTENANCE_NOT_REQUESTED;
		IProblem problem = (IProblem)context.getBean("problem");
		problem.setTypeOfProblem(type);
		problem.setMaintenanceRequestStatus(maintenanceRequestStatus);
		problem.setFacility(facility3);
		user.addFacilityProblem(problem);

		System.out.println(" LISTING PROBLEMS--------------------------------");
		ArrayList<IProblem> problems = new ArrayList<IProblem>();
		problems = manager.listFacilityProblems(facility3);
		if(!problems.isEmpty()){
			for(IProblem p:problems){
				System.out.println(p.getFacility().getId()+". "+p.getFacility().getName()
						+" Problem Type: "+p.getTypeOfProblem());
			}
		}else{
			System.out.println("List is empty!");
		}



		/*----------------------------------------------USE MODULE---------------------------------------------------*/
		System.out.print("\nAn estimate of end Date in format --> yyyy-MM-dd HH:mm:ss");
		String input;
		Date startDate = null;
		Date endDate = null;

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			input = "1991-10-10 10:10:10";
			endDate= sdf.parse(input);
			input = "1991-10-10 10:10:00";
			startDate = sdf.parse(input);
		}catch (ParseException e) {
			e.printStackTrace();
		}

		IUse use = (IUse) context.getBean("use");
		use.setFacility(facility3);
		use.setStartTime(startDate);
		use.setEndTime(endDate);
		use.setIsInUse(false);	
		use.setIsInUseDuringInterval(false);

		manager.assignFacilityToUse(use);
		user.enterFacility(use);

		System.out.println("\nUSER ENTER FACILITY_____________________________________________________________...");
		ArrayList<IUse> use1 = new ArrayList<IUse>();
		use1 = manager.listActualUsage(facility3);
		if(!use1.isEmpty()){
			for(IUse p:use1){
				System.out.println(p.getFacility().getId()+". "+p.getFacility().getName()
						+" Start Time: "+p.getStartTime()+" EndTime: "+p.getEndTime()+ " Is in use: "+p.getIsInUse()+" In Use During Interval: "+p.getIsInUseDuringInterval());
			}
		}else{
			System.out.println("List is empty!");
		}

		System.out.println("\nUSER VACATE FACILITY_____________________________________________________________...");
		user.vacateFacility(use);
		System.out.println("\n Listing use for faclity 3...");
		use1.clear();
		use1 = new ArrayList<IUse>();
		use1 = manager.listActualUsage(facility3);
		if(!use1.isEmpty()){
			for(IUse p:use1){
				System.out.println(p.getFacility().getId()+". "+p.getFacility().getName()
						+" Start Time: "+p.getStartTime()+" EndTime: "+p.getEndTime()+ " Is in use: "+p.getIsInUse()+" In Use During Interval: "+p.getIsInUseDuringInterval());
			}
		}else{
			System.out.println("List is empty!");
		}

		System.out.println("Is in use: "+manager.isInUseDuringInterval(facility2, startDate, endDate));


		/*-------------------------Maintenance Module-----------------------------------*/
		
		
		IMaintenanceRequest maintenanceRequest = (IMaintenanceRequest) context.getBean("maintenanceRequest");
		maintenanceRequest.setRequestDate(startDate);
		maintenanceRequest.setFacility(facility3);
		user.makeFacilityMaintenanceRequest(maintenanceRequest);


		System.out.println("\n USER::::::::::::::::::::::::::::List all maintenance requests_______________________________..");	
		ArrayList<IMaintenanceRequest> list3 = new ArrayList<IMaintenanceRequest>();
		list3 = user.listMaintenanceRequests();
		if(!list3.isEmpty()){
			for(IMaintenanceRequest m:list3){
				System.out.println(m.getFacility().getId()+". "+m.getFacility().getName()
						+" Date: "+m.getRequestDate());
			}
		}

		System.out.println("\n Scheduling the maintenance request_______________________________________________...");	
		double cost=50;	


		Maintenance maintenance = new Maintenance();
		maintenance.setCost(cost);
		maintenance.setStartTime(startDate);
		maintenance.setEndTime(endDate);
		maintenance.setFacility(facility3);
		manager.scheduleMaintenance(maintenance);

		System.out.println("\n List all maintenance requests with their name, id and date---------------------------------------...");	
		ArrayList<IMaintenanceRequest> list4 = new ArrayList<IMaintenanceRequest>();
		list4 = user.listMaintenanceRequests();
		if(!list4.isEmpty()){
			for(IMaintenanceRequest m:list4){
				System.out.println(m.getFacility().getId()+". "+m.getFacility().getName()
						+" Date: "+m.getRequestDate());
			}
		}else{
			System.out.println("List is empty!");
		}

		System.out.println("\n List all scheduled maintenance with their name, id , start date, end date, cost...");	
		ArrayList<IMaintenance> list5 = new ArrayList<IMaintenance>();
		list5 = manager.listMaintenance();
		if(!list5.isEmpty()){
			for(IMaintenance m:list5){
				System.out.println(m.getFacility().getId()+". "+m.getFacility().getName()
						+" Start Date: "+m.getStartTime()+" End Date: "+m.getEndTime()
						+" Cost: "+m.getCost() );
			}
		}

		System.out.println("\n------------------ Calculating DownTime-----------------------------------------------------------");	
		System.out.println(" Downtime: "+maintenance.calcDownTimeForFacility());	


		System.out.println("\n----------------- Calculating Maintenance Cost-------------------------------------");	
		double cost2 = manager.calcMaintenanceCostForFacility(maintenance);
		System.out.println(" Cost: "+cost2);	
		if(cost2 == Constants.DEFAULT_COST){
			System.out.println("Only base charges applied since facility does not have any problems!");
		}


		System.out.println("\n Adding a problem to the facility 2-----------------------------------------");	
		System.out.print("Enter the type of problem: ");
		String type1 = "heating";
		String maintenanceRequestStatus1 = Constants.MAINTENANCE_NOT_REQUESTED;
		IProblem problem1 = new Problem();
		problem1.setTypeOfProblem(type1);
		problem1.setMaintenanceRequestStatus(maintenanceRequestStatus1);
		problem1.setFacility(facility3);
		user.addFacilityProblem(problem1);

		System.out.println("\n MANAGER:::::::::::::::::::::::Listing problems for faclity 2...");
		ArrayList<IProblem> list6 = new ArrayList<IProblem>();
		list6= manager.listFacilityProblems(facility2);
		if(!list6.isEmpty()){
			for(IProblem p:list6){
				System.out.println(p.getFacility().getId()+". "+p.getFacility().getName()
						+" Problem Type: "+p.getTypeOfProblem());
			}
		}else{
			System.out.println("List is empty!");
		}

		System.out.println("\n Calculating Maintenance Cost for facility 2...");
		double cost3 = manager.calcMaintenanceCostForFacility(maintenance);
		System.out.println(" Cost: "+cost3);	
		if(cost3 == Constants.DEFAULT_COST){
			System.out.println("Only base charges applied since facility does not have any problems!");
		}


	
		System.out.println("Add inspections---------------------------------------------------------------------");
		IInspections inspection = (IInspections) context.getBean("inspection");
		inspection.setInspectionDate(startDate);
		inspection.setProblemStatus(null);
		inspection.setFacility(facility3);
		manager.addInspections(inspection);

		System.out.println("\n Listing inspections for faclity 2...");
		ArrayList<IInspections> list9 = new ArrayList<IInspections>();
		list9= manager.listInspections();
		if(!list9.isEmpty()){
			for(IInspections p:list9){
				System.out.println(p.getFacility().getId()+". "+p.getFacility().getName()
						+" Date: "+p.getInspectionDate());
			}
		}else{
			System.out.println("List is empty!");
		}

	}
}
