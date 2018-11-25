package au.usyd.elec5619.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import au.usyd.elec5619.domain.User;
import au.usyd.elec5619.DAO.*;
import au.usyd.elec5619.service.*;
//all need to use the userDAO class
@Transactional
@Service(value="recipecreater")
public class UserService implements Usercreater{

	@Autowired
	public UserDAO userDAO;
	
	private List<User> users;
	
	public void setRecipeDAO(UserDAO userDAO) {
	
		this.userDAO=userDAO;
	}
	
	public void setUser(List<User> users) {
		this.users=users;
	}
	
	public void addUser(User user) {
		userDAO.addUser(user);
	}
	
	public User getUserById(int id) {
		User user=userDAO.getUserById(id);
		return user;
	}
	
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}
	
	public void deleteUserById(String id) {
	    userDAO.deleteUserById(id);
	}
	
	public List<User> getallusers(){
		List<User> userlist=userDAO.getallusers();
		System.out.println("1111");
		return userlist;
	}
	
	//将图片文件存到server的制定文件夹中
		public String uploadpicture(MultipartFile file) throws Exception, IOException{
			//String localpath = "D:\\apache-tomcat-8.0.53\\webapps\\elec5619Springapp\\img\\";
			String localpath = "F:\\ELEC5619\\images";
			String originalFilename = file.getOriginalFilename();
			String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
			File newFile = new File(localpath,newFileName);
			//File newFile = new File(serverpath+'\\'+newFileName);
			file.transferTo(newFile);
			String url = newFileName;
			return url;
		}
	
		
	

	@Override
	public String test() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String uploadpicture(MultipartFile file, String serverpath) throws Exception, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		
	}

	
}
