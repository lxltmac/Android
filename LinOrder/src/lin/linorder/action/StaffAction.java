package lin.linorder.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import lin.linorder.models.Province;
import lin.linorder.models.Staff;
import lin.linorder.service.CommonService;
import lin.linorder.service.StaffService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class StaffAction extends ActionSupport implements ServletRequestAware{
	private int id;
	private String name;
	private String password;
	private String address;
	private String city;
	private String sex;
	private String email;
	private String duty;
	private String phone;
	private String newPwd;
	
	private Staff staff;
	private StaffService staffService;
	private CommonService commonService;
	
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpSession session;
	
	public StaffAction(){
		
	}
	
	/**
	 * ��¼���
	 * @return
	 */
	public void loginCheck(){
//		System.out.println(staffService.login(name, password));
//		if(staffService.login(name, password)){
//			return "success";
//		}else{
//			return "loginInput";
//		}
		System.out.println("staffAction_loginCheck: in name="+name+" password="+password);
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = response.getWriter();
			if(staffService.login(name, password)){
				out.print("true");
				out.flush();
				out.close();
			}else {
				out.print("false");
				out.flush();
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * �˳�
	 * @return
	 */
	public String logout(){
		ActionContext.getContext().getSession().clear();
		return "loginInput";
	}
//	/**
//	 * Json
//	 * @return
//	 */
//	public String queryAllUser(){
//		List<Staff> list=staffService.queryAllUsers();
//		JSONArray arr = JSONArray.fromObject(list);
//		String returnStr = arr.toString();
//		System.out.println(returnStr);
//		return null;
//	}
	/**
	 * ������û����ǲ����Ѿ�ע����
	 * 
	 */
	public void checkName(){
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = response.getWriter();
		    if(staffService.checkName(name)){
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
	//��ʼ�����ҳ��
	public void initAddUser(){
		System.out.println("initAddUser: in");
		List<?> provinces = commonService.getProvinces();
		request.setAttribute("provinces", provinces);
		System.out.println("���ʡ��"+provinces);
	}
	
	/**
	 * ��Ӻ�̨�û�
	 * @return
	 */
	public String addUser(){
		staff.setId(id);
		staff.setName(name);
      	staff.setPassword(password);
      	staff.setDuty(duty);
      	staff.setEmail(email);
      	staff.setPhone(phone);
      	staff.setSex(sex);
      	staff.setAddress(address);
		staff.setCity(commonService.getCity(city));
		System.out.println(staff.getPhone());
		if(staffService.addUser(staff)){
			System.out.println(staff.getCity());
			return "aSuccess";
		}else{
		    return "addInput";
		}
	}
	
	/**
	 * ɾ���û�
	 * @return
	 */
	public void deleteStaff(){
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = response.getWriter();
			staff.setId(id);
			int del_id= Integer.valueOf(id).intValue();
			if(staffService.deleteUserById(del_id)){
				System.out.print(del_id);
				//return "aSuccess";
				out.print("true");
			}else{
				//return "staffShowAction";
				out.print("false");
			}
			 out.flush();
			 out.close();
		}catch(Exception e){
				e.printStackTrace();
			}
		}
	
	/**
	 * ����id�����û�
	 * @return
	 */
	public String queryStaff(){
		staff.setId(id);
		int del_id= Integer.valueOf(id).intValue();
		System.out.print(del_id);
		staff = staffService.queryUserById(del_id);
		if(staff!=null){
			return "query";
		}else{
			return "queryInput";
		}
	}
	
	/**
	 * ����name�����û�
	 * @return
	 */
	public String queryNameStaff(){
		staff.setName(name);
		ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
        String name = (String) session.get("name");
		System.out.print(name);
		staff = staffService.queryUserByName(name);
		if(staff!=null){
			return "queryStaff";
		}else{
			return "queryNameInput";
		}
	}
	
	/**
	 * ����name�����û�
	 * @return
	 */
	public String queryNameStaffSelf(){
		staff.setName(name);
		ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
        String name = (String) session.get("name");
		System.out.print(name);
		staff = staffService.queryUserByName(name);
		if(staff!=null){
			return "queryStaffSelf";
		}else{
			return "queryNameInput";
		}
	}
	
	/**
	 * �����û�
	 * @return
	 */
	public String updateStaff(){
		staff.setId(staff.getId());
		staff.setName(name);
		staff.setDuty(staff.getDuty());
		staff.setPassword(password);
		staff.setEmail(email);
		staff.setPhone(phone);
		staff.setCity(commonService.getCity(city));
		if(sex != null && !sex.equals("")){
			staff.setSex(sex.equals("1")?"��":"Ů");
		}
		System.out.println("ID�ţ�"+staff.getId());
		System.out.println("�Ա�"+staff.getSex());
		if(staffService.updateUser(staff)){
			return "aSuccess";
		}else{
			return "query";
		}
	}
	
	/**
	 * ��������
	 * @return
	 */
	public String updateStaffPassword(){
		ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
        name = (String) session.get("name");
		System.out.println("��ǰ����Ա�û�====="+name);
		staff = staffService.queryUserByName(name);
		staff.setId(staff.getId());
		staff.setPassword(newPwd);
		if(staffService.updateUser(staff)){
			return "mPSuccess";
		}else{
			return "query";
		}
	}
	
	/**
	 * ��̨���� �����û�
	 */
	public void freezeStaff(){
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = response.getWriter();
			System.out.println("freezeStaff: in");
			Staff staff = staffService.queryUserById(id);
			staff.setFreeBuff(1);	//��ʾɾ���û�
			staffService.updateUser(staff);
			//		return "aSuccess";
			out.print("true");
			out.flush();
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * ��̨���� �ⶳ�û�
	 */
	public void unfreezeStaff(){
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = response.getWriter();
			System.out.println("unfreezeStaff: in");
			Staff staff = staffService.queryUserById(id);
			staff.setFreeBuff(0);	//��ʾ�ⶳ�û�
			staffService.updateUser(staff);
	//		return "aSuccess";
			out.print("true");
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public StaffService getStaffService() {
		return staffService;
	}

	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	
	

	public CommonService getCommonService() {
		return commonService;
	}

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	
}
