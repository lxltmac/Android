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
public class DeleteTableNumAction extends ActionSupport {
	private OrderService orderService;
	private OrderList orderList;
	private String tableNum;
	private int id;
	
	public void deleteOrderHttp(){
		try{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		//�����Ӧ�������
		PrintWriter pw = response.getWriter();
		//��ȡ�ͻ�������
		String tableNum = request.getParameter("tableNum");
		System.out.println("����====="+tableNum);
		//ʵ�������ݷ��ʶ���
//		order.setId(orderService.checkOrderId(orderName).getId());
		orderList.setTableNum(tableNum);
		//order.setId(orderService.checkOrderId(orderName,tableNum).getId());
			if(orderService.deleteTableById(orderService.checkOrderListId(tableNum).getId())){
				 pw.print(build(orderList));
			}else{
				pw.print(0);
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
