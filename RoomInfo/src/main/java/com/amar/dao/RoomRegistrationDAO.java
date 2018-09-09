package com.amar.dao;

import java.util.List;

import com.amar.forms.RoomLoginForm;
import com.amar.model.RoomRegistration;

public interface RoomRegistrationDAO {
	
	public void addRegistration(RoomRegistration roomRegistration);
	
	public List<RoomRegistration> getAllRoomUsers();
	
	public RoomRegistration getLoginUser(RoomLoginForm roomLoginForm);

}
