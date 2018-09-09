package com.amar.service;

import java.util.List;

import com.amar.forms.RoomLoginForm;
import com.amar.model.RoomRegistration;

public interface RoomRegistrationService {
	
	public void addRegistration(RoomRegistration roomRegistration);
	
	public List<RoomRegistration> getAllRoomUsers();
	
	public RoomRegistration getLoginUser(RoomLoginForm roomLoginForm);

}
