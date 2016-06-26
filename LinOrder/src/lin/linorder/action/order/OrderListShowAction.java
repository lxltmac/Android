package lin.linorder.action.order;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lin.linorder.models.order.Order;
import lin.linorder.service.order.OrderService;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.mail.iap.Response;

@SuppressWarnings("serial")
public class OrderListShowAction extends ActionSupport implements ServletRequestAware {
	List<Order> orders;
	private int id; //界面显示数据的索引
	private final int pageSize=17; //每页显示记录的个数
	private int pageNo=1; //计数器
	private int currentPage; //当前页
	private int totalPage; //总页数
	private String tableNum;
	
	private Order order;
	private OrderService orderService;
	
	private HttpSession session;
	private HttpServletRequest request;
	
	public OrderListShowAction() {
		
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
	
	public String getTableNum() {
		return tableNum;
	}

	public void setTableNum(String tableNum) {
		this.tableNum = tableNum;
	}

	public List<Order> getOrders() {
		return orders;
	}
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public String show() throws Exception{
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        orders=orderService.queryOrderByNum(tableNum);
		//计算总页数
		if(orders.size()%pageSize==0){
			totalPage=orders.size()/pageSize;
		}else{
			totalPage=orders.size()/pageSize+1;
		}
		if(pageNo<=0){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo=totalPage;
		}
		//根据当前页查询要在该页上显示的数据
		orders=orderService.queryByPageNum(pageNo,pageSize,tableNum);
		System.out.println("sdsd====="+pageNo);
		System.out.println("s====="+pageSize);
		System.out.println("d====="+tableNum);
		currentPage=pageNo;
			return "successOrder";
	}
	/**
	 * json
	 * @return
	 * @throws Exception
	 */
	public String showJson() throws Exception{
		orders=orderService.queryOrderByNum(tableNum);
		JSONArray arr = JSONArray.fromObject(orders);
		String returnStr = arr.toString();
		//页面上打印出JSON
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
