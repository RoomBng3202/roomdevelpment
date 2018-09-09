package com.amar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amar.dao.RoomRegistrationDAO;
import com.amar.forms.RoomLoginForm;
import com.amar.model.RoomRegistration;
import com.amar.service.RoomRegistrationService;
@Service
@Transactional
public class RoomRegistrationServiceImpl implements RoomRegistrationService {
	
	@Autowired
	private RoomRegistrationDAO roomRegistrationDAO;
	
	@Transactional
	public void addRegistration(RoomRegistration roomRegistration) {
		
		getRoomRegistrationDAO().addRegistration(roomRegistration);
		
	}

	@Transactional
	public List<RoomRegistration> getAllRoomUsers() {
		return getRoomRegistrationDAO().getAllRoomUsers();
	}
	
	

	public RoomRegistrationDAO getRoomRegistrationDAO() {
		return roomRegistrationDAO;
	}

	public void setRoomRegistrationDAO(RoomRegistrationDAO roomRegistrationDAO) {
		this.roomRegistrationDAO = roomRegistrationDAO;
	}

	@Override
	@Transactional
	public RoomRegistration getLoginUser(RoomLoginForm roomLoginForm) {
		
		return getRoomRegistrationDAO().getLoginUser(roomLoginForm);
	}



	
	
	
	
}
