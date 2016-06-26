package lin.linorder.action.pay;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import lin.linorder.dao.order.OrderDao;
import lin.linorder.dao.pay.PayDao;
import lin.linorder.models.order.Order;
import lin.linorder.models.pay.Pay;
import lin.linorder.service.order.OrderService;
import lin.linorder.service.pay.PayService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class PayAction extends ActionSupport {
	private int id;
	private String payTableNum;
	private String payPrice;
	private int month;
	 
	private Pay pay;
	private PayDao payDao;
	private PayService payService;
	
	HttpServletRequest request;
	HttpSession session;
	
	public PayAction(){
		
	}
	

	
	/**
	 * É¾³ý¶©µ¥
	 * @return
	 */
	public void deletePay(){
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = response.getWriter();
			pay.setId(id);
			int del_id= Integer.valueOf(id).intValue();
			if(payService.deletePayById(del_id)){
				System.out.print(del_id);
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



	public Pay getPay() {
		return pay;
	}



	public void setPay(Pay pay) {
		this.pay = pay;
	}



	public PayDao getPayDao() {
		return payDao;
	}



	public void setPayDao(PayDao payDao) {
		this.payDao = payDao;
	}



	public PayService getPayService() {
		return payService;
	}



	public void setPayService(PayService payService) {
		this.payService = payService;
	}



	public int getMonth() {
		return month;
	}



	public void setMonth(int month) {
		this.month = month;
	}




	
	
}
