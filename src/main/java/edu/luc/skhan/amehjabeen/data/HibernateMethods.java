package edu.luc.skhan.amehjabeen.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import edu.luc.skhan.amehjabeen.model.classes.IManager;
import edu.luc.skhan.amehjabeen.model.classes.IUser;
import edu.luc.skhan.amehjabeen.model.facility.Facility;
import edu.luc.skhan.amehjabeen.model.facility.IFacility;
import edu.luc.skhan.amehjabeen.model.facility.IInformation;
import edu.luc.skhan.amehjabeen.model.facility.Information;
import edu.luc.skhan.amehjabeen.model.maintenance.IMaintenance;
import edu.luc.skhan.amehjabeen.model.maintenance.IMaintenanceRequest;
import edu.luc.skhan.amehjabeen.model.maintenance.IProblem;
import edu.luc.skhan.amehjabeen.model.use.IInspections;
import edu.luc.skhan.amehjabeen.model.use.IUse;
import edu.luc.skhan.amehjabeen.model.use.Inspections;
import edu.luc.skhan.amehjabeen.model.use.Use;


public class HibernateMethods implements IManager,IUser{

	private static HibernateMethods instance;

	public static HibernateMethods getInstance(){
		if(instance == null){
			instance = new HibernateMethods();
		}
		return instance;
	}


	@Override
	public void removeFacility(IFacility facility){
		Session session = HibernateHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(facility);
		session.getTransaction().commit();
	}

	@Override
	public IFacility retrieveFacility(long id){
		try {
			Session session = HibernateHelper.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query getFacilityQuery = session.createQuery("From Facility where id=:id");		
			getFacilityQuery.setLong("id", id);
			System.out.println("*************** Retrieve Query is ....>>\n" + getFacilityQuery.toString()); 
			List facilities = getFacilityQuery.list();
			System.out.println("Getting Facility Details using HQL. \n" + facilities);
			session.getTransaction().commit();
			return (IFacility)facilities.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void assignFacilityToUse(IUse use) {
		Session session = HibernateHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(use);
		session.getTransaction().commit();

	}

	@Override
	public void addNewFacility(IFacility facility) {
		Session session = HibernateHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(facility);
		session.getTransaction().commit();
	}


	@Override
	public ArrayList<IFacility> listFacilities() {
		try {
			Session session = HibernateHelper.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query getFacilityQuery = session.createQuery("From Facility");				
			System.out.println("*************** Retrieve Query is ....>>\n" + getFacilityQuery.toString()); 
			ArrayList<IFacility> facilities = (ArrayList<IFacility>) getFacilityQuery.list();
			System.out.println("Getting Facility Details using HQL. \n" + facilities);
			session.getTransaction().commit();
			return (ArrayList<IFacility>)facilities;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addFacilityDetail(IInformation information) {
		try {
			Session session = HibernateHelper.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Criteria cri = session.createCriteria(Information.class);
			cri = cri.add(Restrictions.eq("id", information.getId()));
			List list = cri.list();
			IInformation info = (Information)list.iterator().next();
			info.setAvailableCapacity(information.getAvailableCapacity());
			info.setDescription(information.getDescription());
			info.setStatus(information.getStatus());
			info.setTotalCapacity(information.getTotalCapacity());
			session.update(info);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void removeFacilityDetail(IInformation information) {
		try {
			Session session = HibernateHelper.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Criteria cri = session.createCriteria(Information.class);
			cri = cri.add(Restrictions.eq("id", information.getId()));
			List list = cri.list();
			IInformation info = (Information)list.iterator().next();
			info.setAvailableCapacity(0);
			info.setDescription(null);
			info.setStatus(null);
			info.setTotalCapacity(0);
			session.update(info);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}	

	}

	@Override
	public int requestAvailableCapacity(IFacility facility) {
		return 0;
	}

	@Override
	public void addFacilityProblem(IProblem problem) {
		Session session = HibernateHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(problem);
		session.getTransaction().commit();		
	}

	@Override
	public ArrayList<IProblem> listFacilityProblems(IFacility facility) {
		try {
			Session session = HibernateHelper.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query getFacilityQuery = session.createQuery("From Problem where facility =:facilityid ");		
			getFacilityQuery.setLong("facilityid", facility.getId());
			System.out.println("*************** Retrieve Query is ....>>\n" + getFacilityQuery.toString()); 
			ArrayList<IProblem> problems = (ArrayList<IProblem>) getFacilityQuery.list();
			for(IProblem problem: problems){ problem.setFacility(facility);}
			System.out.println("Getting Facility Details using HQL. \n" + problems);
			session.getTransaction().commit();
			return (ArrayList<IProblem>)problems;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<IMaintenance> listMaintenance() {
		try {
			Session session = HibernateHelper.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query getFacilityQuery = session.createQuery("From Maintenance");				
			System.out.println("*************** Retrieve Query is ....>>\n" + getFacilityQuery.toString()); 
			ArrayList<IMaintenance> maintenance = (ArrayList<IMaintenance>) getFacilityQuery.list();
			
			System.out.println("Getting Maintenance Details using HQL. \n" + maintenance);
			session.getTransaction().commit();
			return (ArrayList<IMaintenance>)maintenance;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void scheduleMaintenance(IMaintenance maintenance) {
		Session session = HibernateHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(maintenance);
		session.getTransaction().commit();	
	}

	@Override
	public void makeFacilityMaintenanceRequest(
			IMaintenanceRequest maintenanceRequest) {
		Session session = HibernateHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(maintenanceRequest);
		session.getTransaction().commit();

	}

	@Override
	public ArrayList<IMaintenanceRequest> listMaintenanceRequests() {
		try {
			Session session = HibernateHelper.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query getFacilityQuery = session.createQuery("From MaintenanceRequest");				
			System.out.println("*************** Retrieve Query is ....>>\n" + getFacilityQuery.toString()); 
			ArrayList<IMaintenanceRequest> maintenanceRequest = (ArrayList<IMaintenanceRequest>) getFacilityQuery.list();
			System.out.println("Getting Maintenance Requests using HQL. \n" + maintenanceRequest);
			session.getTransaction().commit();
			return (ArrayList<IMaintenanceRequest>)maintenanceRequest;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void vacateFacility(IUse use) {
		try {
			Session session = HibernateHelper.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			IUse myuse = (IUse)session.get(Use.class, use.getUseId()); 
			myuse.setIsInUse(false);
			session.update(myuse);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void enterFacility(IUse use) {	
		try {
			Session session = HibernateHelper.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			IUse myuse = (IUse)session.get(Use.class, use.getUseId()); 
			myuse.setIsInUse(true);
			myuse.setIsInUseDuringInterval(true);
			session.update(myuse);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<IUse> listActualUsage(IFacility facility) {
		try {
			Session session = HibernateHelper.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query getFacilityQuery = session.createQuery("From Use where facility = :facilityId");		
			getFacilityQuery.setLong("facilityId", facility.getId());
			System.out.println("*************** Retrieve Query is ....>>\n" + getFacilityQuery.toString()); 
			ArrayList<IUse> use = (ArrayList<IUse>) getFacilityQuery.list();
			System.out.println("Getting Facility Details using HQL. \n" + use);
			for(IUse use1: use){
				use1.setFacility(facility);
			}
			session.getTransaction().commit();
			return (ArrayList<IUse>)use;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public ArrayList<IInspections> listInspections() {
		try {
			Session session = HibernateHelper.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query getFacilityQuery = session.createQuery("From Inspections");				
			System.out.println("*************** Retrieve Query is ....>>\n" + getFacilityQuery.toString()); 
			ArrayList<IInspections> inspections = (ArrayList<IInspections>) getFacilityQuery.list();
			System.out.println("Getting Inspections using HQL. \n" + inspections);
			session.getTransaction().commit();
			return (ArrayList<IInspections>)inspections;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addInspections(IInspections inspections) {
		Session session = HibernateHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(inspections);
		session.getTransaction().commit();

	}

}
