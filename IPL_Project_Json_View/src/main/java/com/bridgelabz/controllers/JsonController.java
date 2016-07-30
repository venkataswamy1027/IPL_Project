package com.bridgelabz.controllers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import com.bridgelabz.dao.JsonDao;
import com.bridgelabz.form.LoginForm;
import com.bridgelabz.form.Registration;
import com.bridgelabz.model.Users;
import com.bridgelabz.service.LoginService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@RestController
@EnableWebMvc
public class JsonController implements HandlerExceptionResolver
{
		//the @Autowired annotation tells Spring where an injection needs to occur.
		@Autowired
		public JsonDao play;
		@Autowired
		public LoginService loginService;
		@Autowired
		public  RegistrationValidation registrationValidation;
		/* here matching with respective url pattern and open their respective view pages*/ 
		@RequestMapping(value="/ipl.html", method = RequestMethod.GET)
		public ModelAndView iplHome(Model model) 
		{
			return new ModelAndView("iplhome");
		}
		@SuppressWarnings({"unchecked" })
		@RequestMapping(value="/sort",method = RequestMethod.GET)
		public String sortOrder(@RequestParam(value="sort_field", required=true) String sort_field,@RequestParam(value="sort_order", required=true) String sort_order) throws JsonProcessingException 
		{
			
			ArrayList<Object> sortlist=new ArrayList<Object>();
			System.out.println("sort url match");
			System.out.println(sort_field);
			System.out.println(sort_order);
			sortlist=(ArrayList<Object>)play.sort_Player_Info(sort_field,sort_order);
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(sortlist);
		}
		@SuppressWarnings({ "unchecked" })
		@RequestMapping(value="/search", method = RequestMethod.GET)
		public String search(@RequestParam(value="search_field", required=true) String search_field,@RequestParam(value="search_item", required=true) String search_item) throws JsonProcessingException
		{
			ArrayList<Object> searchlist=new ArrayList<Object>();
			System.out.println("search url match");
			System.out.println(search_field);
			System.out.println(search_item);
			searchlist=(ArrayList<Object>)play.search_Info(search_field,search_item);
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(searchlist);
		}
		@RequestMapping(value="loginform.html",method = RequestMethod.GET)
		public ModelAndView showLoginForm(){
			Map<String, Object> model = new HashMap<String, Object>();
			System.out.println("login url");
			LoginForm loginForm = new LoginForm();
			model.put("loginForm", loginForm);
			return new ModelAndView("loginform",model);
		}
		@RequestMapping(method = RequestMethod.POST)
		public ModelAndView loginProcessForm(@Valid LoginForm loginForm, BindingResult result
				) {
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
		// Display the form on the get request
		@RequestMapping(value="registrationform.html",method = RequestMethod.GET)
		public ModelAndView showRegistration() {
			Map<String, Object> model = new HashMap<String, Object>();
			System.out.println("registration url");
			Registration registration = new Registration();
			model.put("registration", registration);
			return new ModelAndView("registrationform",model);
		}
		@SuppressWarnings("unchecked")
		@RequestMapping(value="registrationform.html",method = RequestMethod.POST)
		public ModelAndView saveUers(@ModelAttribute("registration") @Valid Registration registration, 
				BindingResult result,@SuppressWarnings("rawtypes") Map model) {
			// set custom Validation by user
			registrationValidation.validate(registration, result);
			if (result.hasErrors()) 
			{
				return new ModelAndView("registrationform");
			}
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
				return new ModelAndView("registrationform");
			}
			else
			{
				//here new user registration data is add to method
				Users user = prepareModel(registration);
				loginService.addUser(user);
				return new ModelAndView("registrationsuccess");
			}
		}
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
		@RequestMapping(value="teamname/{each_team_player_info}",method=RequestMethod.GET,headers="Accept=application/json")
		public String eachTeamDetails(@PathVariable("each_team_player_info") String teamname )throws IOException
		{
			System.out.println("player team name url match here");
			@SuppressWarnings("rawtypes")
			ArrayList playersteam=new ArrayList();
			playersteam=play.player_Info(teamname);
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString( playersteam);	
		}
		@RequestMapping(value="teamnameinfo/{each_team_info}",method=RequestMethod.GET,headers="Accept=application/json")
		public String allplayerdetails(@PathVariable("each_team_info")String teamname)throws IOException
		{
			System.out.println("team name url match here");
			@SuppressWarnings("rawtypes")
			ArrayList playersteam=new ArrayList();
			playersteam=play.team_Info(teamname);
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString( playersteam);	
		}
		/* exception handling code */
		@RequestMapping(method = RequestMethod.GET)
	    public ResponseEntity<Object> get(){
	        throw new RuntimeException("response not yet supported");
	    }
	    public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse resp, Object handler, Exception ex) {
	        System.out.println("controller local exception handling HandlerExceptionResolver");
	        resp.reset();
	        resp.setCharacterEncoding("UTF-8");
	        resp.setContentType("text/json");

	        ModelAndView model = new ModelAndView(new MappingJackson2JsonView());
	        if (ex instanceof RuntimeException){
	            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	            model.addObject("error code", HttpStatus.INTERNAL_SERVER_ERROR.value());
	            model.addObject("message", ex.getMessage());
	        } else {
	            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	            model.addObject("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
	            model.addObject("message", ex.getMessage());
	        }
	        return model;
	    }
	}
	