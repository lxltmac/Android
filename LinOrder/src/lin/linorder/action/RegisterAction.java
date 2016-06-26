package lin.linorder.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lin.linorder.models.Staff;
import lin.linorder.models.user.User;
import lin.linorder.service.StaffService;
import lin.linorder.service.user.UserService;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
	private UserService userService;
	private User user;
	private String username;
	private String password;
	private String phone;
	private String sex;
	
	public void registerHttp(){
		try{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		//获得响应的输出流
		PrintWriter pw = response.getWriter();
		//获取客户端请求
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String sex = request.getParameter("sex");
		//实例化数据访问对象
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setSex(sex);
		if(userService.addUser(user)){
			 pw.print(build(user));
		}else{
			pw.print("0");
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}
	} 
	private String build(User user) {
        String userMsg = "";
        userMsg += "id=" + user.getId();
        userMsg += ";";
        userMsg += "name=" + user.getUsername();
        return userMsg;
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
