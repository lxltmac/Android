package lin.linorder.action.user;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lin.linorder.models.user.User;
import lin.linorder.service.user.UserService;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.mail.iap.Response;

@SuppressWarnings("serial")
public class UserShowAction extends ActionSupport implements ServletRequestAware {
	List<User> users;
	private int id; //������ʾ���ݵ�����
	private final int pageSize=17; //ÿҳ��ʾ��¼�ĸ���
	private int pageNo=1; //������
	private int currentPage; //��ǰҳ
	private int totalPage; //��ҳ��
	
	private User user;
	private UserService userService;
	
	private HttpSession session;
	private HttpServletRequest request;
	
	public UserShowAction() {
		
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserService getUserervice() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String show() throws Exception{
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
		users=userService.queryAllUsers();
		//������ҳ��
		if(users.size()%pageSize==0){
			totalPage=users.size()/pageSize;
		}else{
			totalPage=users.size()/pageSize+1;
		}
		if(pageNo<=0){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo=totalPage;
		}
		//���ݵ�ǰҳ��ѯҪ�ڸ�ҳ����ʾ������
		users=userService.queryByPage(pageNo,pageSize);
		currentPage=pageNo;
			return SUCCESS;
	}
	/**
	 * json
	 * @return
	 * @throws Exception
	 */
	public String showJson() throws Exception{
		users=userService.queryAllUsers();
		JSONArray arr = JSONArray.fromObject(users);
		String returnStr = arr.toString();
		//ҳ���ϴ�ӡ��JSON
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(returnStr);
			out.flush();
			out.close();
			System.out.println(returnStr);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
