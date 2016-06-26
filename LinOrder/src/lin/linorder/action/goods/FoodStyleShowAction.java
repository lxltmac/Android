package lin.linorder.action.goods;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lin.linorder.models.goods.FoodStyle;
import lin.linorder.service.goods.FoodStyleService;


import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.mail.iap.Response;

@SuppressWarnings("serial")
public class FoodStyleShowAction extends ActionSupport implements ServletRequestAware {
	List<FoodStyle> foodStyles;
	private String foodStyleId; //������ʾ���ݵ�����
	private final int pageSize=17; //ÿҳ��ʾ��¼�ĸ���
	private int pageNo=1; //������
	private int currentPage; //��ǰҳ
	private int totalPage; //��ҳ��
	
	private FoodStyle foodStyle;
	private FoodStyleService foodStyleService;
	
	private HttpSession session;
	private HttpServletRequest request;
	
	public FoodStyleShowAction() {
		
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
	}
	
	public String getFoodStyleId() {
		return foodStyleId;
	}

	public void setFoodStyleId(String foodStyleId) {
		this.foodStyleId = foodStyleId;
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
	
	public List<FoodStyle> getFoodStyles() {
		return foodStyles;
	}

	public void setFoodStyles(List<FoodStyle> foodStyles) {
		this.foodStyles = foodStyles;
	}

	public FoodStyle getFoodStyle() {
		return foodStyle;
	}

	public void setFoodStyle(FoodStyle foodStyle) {
		this.foodStyle = foodStyle;
	}

	public FoodStyleService getFoodStyleService() {
		return foodStyleService;
	}

	public void setFoodStyleService(FoodStyleService foodStyleService) {
		this.foodStyleService = foodStyleService;
	}

	public String show() throws Exception{
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        foodStyles=foodStyleService.queryAllFoodStyles();
		//������ҳ��
		if(foodStyles.size()%pageSize==0){
			totalPage=foodStyles.size()/pageSize;
		}else{
			totalPage=foodStyles.size()/pageSize+1;
		}
		if(pageNo<=0){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo=totalPage;
		}
		//���ݵ�ǰҳ��ѯҪ�ڸ�ҳ����ʾ������
		foodStyles=foodStyleService.queryByPage(pageNo,pageSize);
		currentPage=pageNo;
			return SUCCESS;
	}
	/**
	 * json
	 * @return
	 * @throws Exception
	 */
	public String showJson() throws Exception{
		foodStyles=foodStyleService.queryAllFoodStyles();
		JSONArray arr = JSONArray.fromObject(foodStyles);
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
