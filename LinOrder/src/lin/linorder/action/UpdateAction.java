package lin.linorder.action;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lin.linorder.models.user.User;

import lin.linorder.service.user.UserService;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UpdateAction extends ActionSupport {
	private UserService userService;
	private User user;
	private String username;
	private String password;
	private String phone;
	private String sex;
	
	public String updateHttp() {
		try{
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html");
			//获取客户端请求
			username = request.getParameter("username");
			user = userService.queryUserByName(username);
			user.setUsername(username);
			JSONArray arr = JSONArray.fromObject(user);
			String returnStr = arr.toString();
			//页面上打印出JSON
			HttpServletResponse responses = ServletActionContext.getResponse();
			responses.setContentType("text/html;charset=UTF-8");
			PrintWriter out = responses.getWriter();
			out.print(returnStr);
			out.flush();
			out.close();
			System.out.println(returnStr);
			}catch(Exception e){
				e.printStackTrace();
			}
		return null;
    }
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
