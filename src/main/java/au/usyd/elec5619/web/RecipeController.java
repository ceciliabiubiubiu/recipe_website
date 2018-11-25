package au.usyd.elec5619.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import au.usyd.elec5619.service.Usercreater;


public class RecipeController implements Controller {
	protected final Log logger = LogFactory.getLog(getClass());
	
	private Usercreater recipecreater;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,HttpServletResponse arg1) throws ServletException, IOException {
		String now = (new java.util.Date()).toString();
		logger.info("Returning hello view with " + now);
		Map<String, Object> myModel = new HashMap<String, Object>(); //ӳ�䣬�е����ֵ�
		myModel.put("now", now); //��ָ����ֵ���ֵ����
		myModel.put("recipes", recipecreater.getUser());
		
		return new ModelAndView("hello", "model", myModel);
	}
	
	public void setRecipecreater(Usercreater recipecreater) {
		this.recipecreater = recipecreater;
	} //���캯��
}