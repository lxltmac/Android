package lin.linorder.action.pay;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lin.linorder.models.pay.Pay;
import lin.linorder.service.pay.PayService;


import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AddPayAction extends ActionSupport {
	private PayService payService;
	private Pay pay;
	private String payTableNum;
	private String payPrice;
	private int id;
	private int month;
	
	
	public void addPayHttp(){
		try{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		//获得响应的输出流
		PrintWriter pw = response.getWriter();
		//获取客户端请求
		String payTableNum = request.getParameter("tableNum");
		String payPrice = request.getParameter("payPrice");
		String month = request.getParameter("month");
		System.out.println("桌号====="+payTableNum);
		//System.out.println("idsd==========="+orderService.checkOrderId(orderName,tableNum).getId());
		//实例化数据访问对象
//		order.setId(orderService.checkOrderId(orderName).getId());
		pay.setPayTableNum(payTableNum);
		pay.setPayPrice(payPrice);
		pay.setMonth(Integer.valueOf(month));
			if(payService.addPay(pay)){
				 pw.print(build(pay));
			}else{
				pw.print("0");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	} 
	private String build(Pay pay) {
        String userMsg = "";
        userMsg += "id=" + pay.getId();
        userMsg += ";";
        userMsg += "payTableNum=" + pay.getPayTableNum();
        userMsg += "payprice=" + pay.getPayPrice();
        userMsg += "month=" + pay.getMonth();
        return userMsg;
    }
	public PayService getPayService() {
		return payService;
	}
	public void setPayService(PayService payService) {
		this.payService = payService;
	}
	public Pay getPay() {
		return pay;
	}
	public void setPay(Pay pay) {
		this.pay = pay;
	}
	public String getPayTableNum() {
		return payTableNum;
	}
	public void setPayTableNum(String payTableNum) {
		this.payTableNum = payTableNum;
	}
	public String getPayPrice() {
		return payPrice;
	}
	public void setPayPrice(String payPrice) {
		this.payPrice = payPrice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	
}
