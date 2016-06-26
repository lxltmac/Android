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
	private String foodStyleId; //界面显示数据的索引
	private final int pageSize=17; //每页显示记录的个数
	private int pageNo=1; //计数器
	private int currentPage; //当前页
	private int totalPage; //总页数
	
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
		//计算总页数
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
		//根据当前页查询要在该页上显示的数据
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
