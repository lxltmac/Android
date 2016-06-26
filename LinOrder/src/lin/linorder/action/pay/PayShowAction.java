package lin.linorder.action.pay;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lin.linorder.models.pay.Pay;
import lin.linorder.service.pay.PayService;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.mail.iap.Response;

@SuppressWarnings("serial")
public class PayShowAction extends ActionSupport implements ServletRequestAware {
	List<Pay> pays;
	private int id; //������ʾ���ݵ�����
	private final int pageSize=17; //ÿҳ��ʾ��¼�ĸ���
	private int pageNo=1; //������
	private int currentPage; //��ǰҳ
	private int totalPage; //��ҳ��
	
	private Pay pay;
	private PayService payService;
	
	private HttpSession session;
	private HttpServletRequest request;
	
	public PayShowAction() {
		
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
	
	public List<Pay> getPays() {
		return pays;
	}

	public void setPays(List<Pay> pays) {
		this.pays = pays;
	}

	public Pay getPay() {
		return pay;
	}

	public void setPay(Pay pay) {
		this.pay = pay;
	}

	public PayService getPayService() {
		return payService;
	}

	public void setPayService(PayService payService) {
		this.payService = payService;
	}

	public String show() throws Exception{
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
		pays=payService.queryAllPays();
		//������ҳ��
		if(pays.size()%pageSize==0){
			totalPage=pays.size()/pageSize;
		}else{
			totalPage=pays.size()/pageSize+1;
		}
		if(pageNo<=0){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo=totalPage;
		}
		//���ݵ�ǰҳ��ѯҪ�ڸ�ҳ����ʾ������
		pays=payService.queryByPage(pageNo,pageSize);
		currentPage=pageNo;
			return "successPay";
	}
	/**
	 * json
	 * @return
	 * @throws Exception
	 */
	public String showJson() throws Exception{
		pays=payService.queryAllPays();
		JSONArray arr = JSONArray.fromObject(pays);
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
