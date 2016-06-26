package lin.linorder.action.user;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import lin.linorder.dao.user.UserDao;
import lin.linorder.models.user.User;
import lin.linorder.service.user.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport {
	private int id;
	private String username;
	private String password;
	private String sex;
	private String phone;
	 
	private User user;
	private UserDao userDao;
	private UserService userService;
	
	HttpServletRequest request;
	HttpSession session;
	
	public UserAction(){
		
	}
	
	/**
	 * 添加后台用户
	 * @return
	 */
	public String addUser(){
		user.setId(id);
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setSex(sex);
		
		if(userService.addUser(user)){
			return "addUserSuccess";
		}else{
		    return "addUserInput";
		}
	}
	
	/**
	 * 删除前台用户
	 * @return
	 */
	public void deleteUser(){
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = response.getWriter();
			user.setId(id);
			int del_id= Integer.valueOf(id).intValue();
			if(userService.deleteUserById(del_id)){
				System.out.print(del_id);
	//			return "addUserSuccess";
				out.print("true");
			}else{
	//			return "userShowAction";
				out.print("false");
			}
			out.flush();
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据id查找前台用户
	 * @return
	 */
	public String queryUser(){
		user.setId(id);
		int del_id= Integer.valueOf(id).intValue();
		System.out.print(del_id);
		user = userService.queryUserById(del_id);
		if(user!=null){
			return "query";
		}else{
			return "queryInput";
		}
	}
	
	/**
	 * 更新前台用户
	 * @return
	 */
	public String updateUser(){
		user.setId(user.getId());
		user.setUsername(username);
		user.setPassword(password);
		if(sex != null && sex != ""){
			user.setSex(sex.equals("1")?"男":"女");
		}
		user.setPhone(phone);
		
		if(userService.updateUser(user)){
			return "addUserSuccess";
		}else{
			return "query";
		}
	}
	
	/**
	 * 检查是前台用户是不是已经存在
	 * 
	 */
	public void checkUsername(){
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = response.getWriter();
		    if(userService.checkUsername(username)){
		    	out.print("true");
		    }else{
		    	out.print("false");
		    }
		    out.flush();
		    out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	} 
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
