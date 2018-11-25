package au.usyd.elec5619.web;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;


import au.usyd.elec5619.domain.User;
import au.usyd.elec5619.service.Usercreater;
import au.usyd.elec5619.service.UserService;

@Controller
@RequestMapping(value="/user/**")
public class Usermanagecontroller {
	
	@Autowired
	private Usercreater usercreater;
	//1
	@RequestMapping(value="/showcreateuserform", method=RequestMethod.GET)
	public String showcreateuserform() {
		return "newrecipecreater";
	}
	
	//2
	
	
	//3
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String adduserhandler(HttpServletRequest request,HttpServletResponse response) {
		return "home";
	}
	
	//4
	@RequestMapping(value="/getuserbyid", method=RequestMethod.GET)
	public String getrecipebyid() {
		return "getrecipebyid";
	}
	
	//5 change the type of userid from int to string
	@RequestMapping(value="/deleteuser/{userID}", method=RequestMethod.GET)
	public String deleterecipe(@PathVariable("userID") int userID, HttpServletRequest request,HttpServletResponse response) {
		usercreater.deleteUser(userID);
		return "redirect:/recipe/userrecipe/1";
	}
	

	
	
     //7 add user
	@RequestMapping(value="/adduser", method=RequestMethod.POST)
	@ResponseBody
	public String adduser(HttpServletRequest request,HttpServletResponse response, String[] userName, String[] email, String[] password)  throws Exception, IOException {
		//生成ingredient list
		List<User> users = new ArrayList<User>();
		int userID = 1;
		User user = new User(request.getParameter("userName"),request.getParameter("password"),request.getParameter("email"));
		usercreater.addUser(user);
		return "verifyemail";
		
	}
		@RequestMapping(value="/register", method=RequestMethod.GET)
		public String createrecipe() {
			return "createuser";
		}
	

		//update information
		//加载更新页面 需要recipeid
		@RequestMapping(value="/updateinformation/{userID}", method=RequestMethod.GET)
		public ModelAndView updatepage(@PathVariable("userID") int userID, HttpServletRequest request,HttpServletResponse response) {
			User user = usercreater.getUserById(userID);
			Map<String, Object> myModel = new HashMap<String, Object>();
			myModel.put("user", user);
			//myModel.put("userName", user.getName());
			//myModel.put("password", user.getPassword());
			//myModel.put("email", user.getEmail());
			return new ModelAndView("updateinformation","model",myModel);
		}

		
		//更新菜谱
		@RequestMapping(value="/updateinformation", method=RequestMethod.POST)
		//the parameter which need to send to updaterecipe(i dont know)
		public String updaterecipe(HttpServletRequest request,HttpServletResponse response,int userid, String userName, String password, String email) throws Exception, IOException{
			User user=new User();
			user.setName(userName);
			user.setPassword(password);
			user.setEmail(email);
			user.setId(userid);
			

//			int userID = 1;
//			User user1 = new User(request.getParameter("userName"),request.getParameter("password"),request.getParameter("email"));
			usercreater.updateUser(user);
			return "redirect:/user/updateinformation/"+userid;
		}
		
		
		//verify if the email has been used
		@RequestMapping(value="/register/{userID}", method=RequestMethod.GET)
		public ModelAndView toverifyemail(@PathVariable("userID") int userID, HttpServletRequest request,HttpServletResponse response) {
			User user = usercreater.getUserById(userID);
			Map<String, Object> myModel = new HashMap<String, Object>();
			myModel.put("email", user.getEmail());
			//myModel.put("userName", user.getName());
			//myModel.put("password", user.getPassword());
			//myModel.put("email", user.getEmail());
			return new ModelAndView("verifyemail","model",myModel);
		}
		
		//verify if the email has been used
		@RequestMapping(value="/verifyemail", method=RequestMethod.POST)
		//the parameter which need to send to updaterecipe(i dont know)
		public boolean verifyemail(HttpServletRequest request,HttpServletResponse response, String email) throws Exception, IOException{
			boolean verification=true;
			User user=new User();
		    List<User> userlist=new ArrayList<User>();
		    for(User usr:userlist) {
		    	if(email.equals(usr.getEmail())){
		    		 verification= false;
		    }else{
		    	 verification= true;
		    }
		}
			return verification;
}
		
		@RequestMapping(value="/personalinformation/{userID}", method=RequestMethod.GET)
		public ModelAndView personalpage(@PathVariable("userID") int userID, HttpServletRequest request,HttpServletResponse response) {
			User user = usercreater.getUserById(userID);
			Map<String, Object> myModel = new HashMap<String, Object>();
			myModel.put("user", user);
			//myModel.put("userName", user.getName());
			//myModel.put("password", user.getPassword());
			//myModel.put("email", user.getEmail());
			return new ModelAndView("personalinformation","model",myModel);
		}

		
		//personal information
		@RequestMapping(value="/personalinformation", method=RequestMethod.POST)
		//the parameter which need to send to updaterecipe(i dont know)
		public String personalinfor(HttpServletRequest request,HttpServletResponse response,int userid, String userName, String password, String email,  @RequestParam("dish_img") MultipartFile dishfile,@RequestParam("steppicture") MultipartFile[] file) throws Exception, IOException{
			//icon, male/female/points/my feeling
			
			User user=new User();
			
			//upload icon
			String serverpath = request.getSession().getServletContext().getRealPath("img");
			String dishpath = usercreater.uploadpicture(dishfile,serverpath);
			
			usercreater.updateUser(user);
			return "redirect:/user/updateinformation/"+userid;
		}
}
