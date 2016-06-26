package lin.linorder.action.order;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lin.linorder.models.order.Order;
import lin.linorder.models.order.OrderList;
import lin.linorder.service.order.OrderService;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AddOrderNumAction extends ActionSupport {
	private OrderService orderService;
	private OrderList orderList;
	private String tableNum;
	
	public void addOrderHttp(){
		try{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		//�����Ӧ�������
		PrintWriter pw = response.getWriter();
		//��ȡ�ͻ�������
		String tableNum = request.getParameter("tableNum");
		//ʵ�������ݷ��ʶ���
		orderList.setTableNum(tableNum);
		if(orderService.checkTableNum(tableNum)){
			if(orderService.addOrderList(orderList)){
				 pw.print(build(orderList));
			}else{
				pw.print("0");
			}
		}else{
			System.out.println("���²���===========");
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	} 
	private String build(OrderList order) {
        String userMsg = "";
        userMsg += "id=" + order.getId();
        userMsg += ";";
        userMsg += "tableNum=" + order.getTableNum();
        return userMsg;
    }
	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	public OrderList getOrderList() {
		return orderList;
	}
	public void setOrderList(OrderList orderList) {
		this.orderList = orderList;
	}
	public String getTableNum() {
		return tableNum;
	}
	public void setTableNum(String tableNum) {
		this.tableNum = tableNum;
	}
	
}
