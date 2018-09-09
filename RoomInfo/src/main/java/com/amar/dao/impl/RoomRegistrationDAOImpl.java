package com.amar.dao.impl;

import java.util.List;





import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.amar.dao.RoomRegistrationDAO;
import com.amar.forms.RoomLoginForm;
import com.amar.model.RoomRegistration;

public class RoomRegistrationDAOImpl implements RoomRegistrationDAO {
	
	//@Autowired
	private SessionFactory sessionFactory;
	
	

	public void addRegistration(RoomRegistration roomRegistration) {
		
		getSessionFactory().getCurrentSession().saveOrUpdate(roomRegistration);
		
	}

	@SuppressWarnings("unchecked")
	public List<RoomRegistration> getAllRoomUsers() {
		return getSessionFactory().getCurrentSession().createQuery("from RoomRegistration").list();
	}
	
	@SuppressWarnings("unchecked")
	public RoomRegistration getLoginUser(RoomLoginForm roomLoginForm){
		
		RoomRegistration roomRegistration = null;
		/*List<RoomRegistration> listRoomRegistrations = getAllRoomUsers();
		for(RoomRegistration r : listRoomRegistrations ){
			
			if(r.getEmail().equalsIgnoreCase(roomLoginForm.getEmail())){
				roomRegistration = r;
				System.out.println("Email ID from RoomRegistration Table :"+r.getEmail());
			}
		}*/
		
		String hql = "FROM RoomRegistration WHERE email = :email";
		Query query =getSessionFactory().getCurrentSession().createQuery(hql);
		query.setParameter("email", roomLoginForm.getEmail());
		List<RoomRegistration> result =query.list();
		for(RoomRegistration r : result ){
			
			if(r.getEmail().equalsIgnoreCase(roomLoginForm.getEmail())){
				roomRegistration = r;
				System.out.println("Email ID from RoomRegistration Table :"+r.getEmail());
			}
		}
		
		//productsList.stream().filter(f->f.price < 30000).map(km -> km.price).forEach(System.out::println);
		//listRoomRegistrations.stream().filter(r -> r ).map(r -> r.email.).forEach(System.out::println);
		return roomRegistration;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	

}
