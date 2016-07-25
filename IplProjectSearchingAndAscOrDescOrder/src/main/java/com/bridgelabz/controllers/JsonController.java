package com.bridgelabz.controllers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.bridgelabz.dao.JsonControllerDaoImpl;
import com.bridgelabz.dao.JsonDao;
import com.bridgelabz.form.LoginForm;
import com.bridgelabz.form.Registration;
import com.bridgelabz.model.PlayerDto;
import com.bridgelabz.model.TeamDto;
import com.bridgelabz.model.Users;
import com.bridgelabz.service.LoginService;
import com.fasterxml.jackson.databind.ObjectMapper;
@RestController
@EnableWebMvc
public class JsonController 
{
		//the @Autowired annotation tells Spring where an injection needs to occur.
		@Autowired
		public JsonDao play;
		//the @Autowired annotation tells Spring where an injection needs to occur.
		@Autowired
		public LoginService loginService;
		@Autowired
		public  RegistrationValidation registrationValidation;
		/* here matching with respective url pattern and open their respective view pages*/ 
		@RequestMapping(value="/ipl.html", method = RequestMethod.GET)
		public ModelAndView iplHome() 
		{
			Map<String, Object> model = new HashMap<String, Object>();
			return new ModelAndView("iplhome",model);
		}
		@RequestMapping(value="searching", method = RequestMethod.GET)
		public ModelAndView searchpage() 
		{
			System.out.println("search url match 1");
			return new ModelAndView("search");
		}
		/*@RequestMapping(value="teamname/search.html?{search_field}/",method = RequestMethod.GET)
		public ModelAndView searchList(@RequestParam(value="search_field", required=true) String search_field) 
		{
			System.out.println("search url match");
			Map<String, Object> model = new HashMap<String, Object>();
			return new ModelAndView("search",model);
		}*/
		@RequestMapping(value="/sort", method = RequestMethod.GET)
		public ModelAndView sortOrder(@RequestParam(value="sort_field", required=true) String sort_field,@RequestParam(value="sort_order", required=true) String sort_order) 
		{
			System.out.println("sort url match 1");
			Map<String, Object> model = new HashMap<String, Object>();
			System.out.println(sort_field);
			System.out.println(sort_order);
			model.put("playerlist", play.sort_Player_Info(sort_field,sort_order));
			return new ModelAndView("asc_desc",model);
			
		}
		@RequestMapping(value="/search{search_field}/{search_item}", method = RequestMethod.GET)
		public ModelAndView search(@RequestParam(value="search_field", required=true) String search_field,@RequestParam(value="search_item", required=true) String search_item)
		{
			System.out.println("search url match 2");
			Map<String, Object> model = new HashMap<String, Object>();
			System.out.println(search_field);
			System.out.println(search_item);
			model.put("playerlist", play.search_Info(search_field,search_item));
			return new ModelAndView("search",model);
		}
		@RequestMapping(value="loginform.html",method = RequestMethod.GET)
		public ModelAndView showForm(Map<String, LoginForm> model) {
			System.out.println("login url match");
			LoginForm loginForm = new LoginForm();
			model.put("loginForm", loginForm);
			return new ModelAndView("loginform");
		}
		@RequestMapping(value="loginform.html",method = RequestMethod.POST)
		public ModelAndView processForm(@Valid LoginForm loginForm, BindingResult result) {
			// here if the user name and password not matched generate errors in login form page
			if (result.hasErrors()) {
				return new ModelAndView("loginform");
			}
			// checking if the user name exist in data base generate error message otherwise stored in database
			boolean userExists = loginService.checkLogin(loginForm.getUserName(),loginForm.getPassword());
			if(userExists){
				return new ModelAndView("loginsuccess");
			}else{
				result.rejectValue("userName","invaliduser");
				return new ModelAndView("loginform");
			}
		}
		public void setRegistrationValidation(RegistrationValidation registrationValidation) 
		{
			this.registrationValidation = registrationValidation;
		}
		@RequestMapping(value="registrationform.html",method = RequestMethod.POST)
		public ModelAndView saveUsers(@ModelAttribute("registration") @Valid Registration registration, 
				BindingResult result,Map<String, Registration> model) {
			// set custom Validation by user
			registrationValidation.validate(registration, result);
			if (result.hasErrors()) 
			{
				return new ModelAndView("registrationform");
			}
			// checking if the user email exist in data base generate error message otherwise stored in database
			boolean userEmailExists = loginService.checkEmail(registration.getEmail());
			if(userEmailExists)
			{
				model.put("registration",registration);
				result.rejectValue("email","invalidemail");
				return new ModelAndView("registrationform");
			}
			// checking if the user name exist in data base generate error message otherwise stored in database
			boolean userNameExists = loginService.checkUserName(registration.getUserName());
			if(userNameExists)
			{
				model.put("registration",registration);
				result.rejectValue("userName","invalidusername");
				return new ModelAndView ("registrationform");
			}
			else
			{
				//here new user registration data is add to method
				Users user = prepareModel(registration);
				loginService.addUser(user);
				return new ModelAndView("registrationsuccess");
			}
		}
		// Display the form on the get request
		@RequestMapping(value="/registrationform.html",method = RequestMethod.GET)
		public ModelAndView showRegistration(Map<String, Registration> model) {
			System.out.println("registration url match");
			Registration registration = new Registration();
			model.put("registration", registration);
			return new ModelAndView("registrationform");
		}
		//here set  users class fields to match with registration class fields
		private Users prepareModel(Registration registration){
			Users user = new Users();
			user.setUserName(registration.getUserName());
			user.setUserPassword(registration.getPassword());
			user.setConfirmPassword(registration.getConfirmPassword());
			user.setEmail(registration.getEmail());
			user.setMobile(registration.getMobile());
			user.setId(null);
			return user;
		}
		@RequestMapping(value="teamname/{each_team_player_info}",method=RequestMethod.GET)
		public ModelAndView eachTeamDetails(@PathVariable("each_team_player_info") String teamname )
		{
			System.out.println("player team name url match here");
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("playerlist",play.player_Info(teamname));
			return new ModelAndView("playerlist",model);
		}
		@RequestMapping(value="teamnameinfo/{each_team_info}",method=RequestMethod.GET)
		public ModelAndView allplayerdetails(@PathVariable("each_team_info")String teamname)
		{
			System.out.println("team name url match here");
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("team",play.team_Info(teamname));
			return new ModelAndView("ddTeamPlayer",model);	
		}
	}
	