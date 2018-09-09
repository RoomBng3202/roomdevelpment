package com.amar.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.amar.forms.RoomLoginForm;
import com.amar.forms.RoomRegistrationForm;
import com.amar.model.RoomRegistration;
import com.amar.service.RoomRegistrationService;
import com.amar.validation.RoomRegistrationValidation;

@Controller
@RequestMapping(value="/room")
public class RoomRegistrationController {
	
	//@Resource(name="roomRegistrationService")
	@Autowired
	private RoomRegistrationService roomRegistrationService;
	
	//@Resource(name= "roomRegistrationValidation")
	@Autowired
	private RoomRegistrationValidation roomRegistrationValidation;
	
	

	public RoomRegistrationValidation getRoomRegistrationValidation() {
		return roomRegistrationValidation;
	}

	public void setRoomRegistrationValidation(
			RoomRegistrationValidation roomRegistrationValidation) {
		this.roomRegistrationValidation = roomRegistrationValidation;
	}

	public RoomRegistrationService getRoomRegistrationService() {
		return roomRegistrationService;
	}

	public void setRoomRegistrationService(
			RoomRegistrationService roomRegistrationService) {
		this.roomRegistrationService = roomRegistrationService;
	}
	
	
	@RequestMapping(value = "/registration", method=RequestMethod.GET)
	public String getReistration(Model model){
		
		RoomRegistrationForm roomRegistrationForm = new RoomRegistrationForm();
		model.addAttribute("roomRegistrationForm", roomRegistrationForm);
		//model.addAttribute("newRoomRegistration");
		return "newRoomRegistration";
	}
	
	@RequestMapping(value = "/registrationProcess", method=RequestMethod.POST)
	public String addRoomReistration(@ModelAttribute  RoomRegistrationForm roomRegistrationForm, Model model,BindingResult bindingResult){

		getRoomRegistrationValidation().validate(roomRegistrationForm,bindingResult);
		
		if (bindingResult.hasErrors()) {
            return "newRoomRegistration";
        }
		String roomPerson = roomRegistrationForm.getFirstName()+" "+roomRegistrationForm.getLastName();
		model.addAttribute("roomPerson", roomPerson);
		RoomRegistration roomRegistration = new RoomRegistration();
		roomRegistration.setFirstName(roomRegistrationForm.getFirstName());
		roomRegistration.setLastName(roomRegistrationForm.getLastName());
		roomRegistration.setEmail(roomRegistrationForm.getEmail());
		roomRegistration.setPassword(roomRegistrationForm.getPassword());
		
		getRoomRegistrationService().addRegistration(roomRegistration);
		
		//model.addAttribute("roomRegistrationForm", roomRegistrationForm);
		//model.addAttribute("newRoomRegistration");
		return "RigistrationSuccess";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String roomLogin(Model model){
		
		RoomLoginForm roomLoginForm = new RoomLoginForm();
		model.addAttribute("roomLoginForm", roomLoginForm);
		
		return "roomLogin";
	}
	
	@RequestMapping(value="/loginSuccess" , method=RequestMethod.POST)
	public String loginRoom(@ModelAttribute RoomLoginForm roomLoginForm,Model model){
		
		RoomRegistration roomRegistration =getRoomRegistrationService().getLoginUser(roomLoginForm);
		List<RoomRegistration> allRoomUsers = getRoomRegistrationService().getAllRoomUsers();
		if(roomLoginForm.getEmail().equalsIgnoreCase(roomRegistration.getEmail()) && roomLoginForm.getPassward().equals(roomRegistration.getPassword())){
			System.out.println("Login Successfully");
			String roomPerson = roomRegistration.getFirstName()+" "+roomRegistration.getLastName();
			model.addAttribute("roomPerson", roomPerson);
			model.addAttribute("usersList", allRoomUsers);
			return "RigistrationSuccess";
		}
		
		System.out.println("Login Failed due to incorrect email and password");	
			return "roomLogin";
	}
	
	

	
	
	
	
	

}
