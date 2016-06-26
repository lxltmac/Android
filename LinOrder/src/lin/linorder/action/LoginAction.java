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

public class LoginAction extends ActionSupport {
	private UserService userService;
	
	public void loginHttp(){
		try{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		//获得响应的输出流
		PrintWriter pw = response.getWriter();
		//获取客户端请求
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//实例化数据访问对象
		User user = userService.loginAndroid(username, password);
		if(user != null){
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
	
}
