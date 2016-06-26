package lin.linorder.action.goods;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;


import lin.linorder.dao.goods.FoodStyleDao;
import lin.linorder.models.goods.FoodStyle;
import lin.linorder.service.goods.FoodStyleService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class FoodStyleAction extends ActionSupport {
	private int id;
	private String foodStyleId;
	private String styleName;
	
	 
	private FoodStyle foodStyle;
	private FoodStyleDao foodStyleDao;
	private FoodStyleService foodStyleService;
	
	
	HttpServletRequest request;
	HttpSession session;
	
	public FoodStyleAction(){
		
	}
	
	
	/**
	 * 添加菜图
	 * @return
	 */
	public String addFoodStyle(){
		foodStyle.setId(id);
		foodStyle.setFoodStyleId(foodStyleId);
		foodStyle.setStyleName(styleName);
		
		if(foodStyleService.addFoodStyle(foodStyle)){
			return "addFoodSuccess";
		}else{
		    return "addFoodInput";
		}
	}
	
	/**
	 * 删除菜品
	 * @return
	 */
	public void deleteFoodStyle(){
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = response.getWriter();
			foodStyle.setId(id);
			int del_id= Integer.valueOf(id).intValue();
			if(foodStyleService.deleteFoodStyleById(del_id)){
				System.out.print(del_id);
	//			return "addFoodSuccess";
				out.print("true");
			}else{
	//			return "foodShowAction";
				out.print("true");
			}
			out.flush();
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据id查找菜品
	 * @return
	 */
	public String queryFoodStyle(){
		foodStyle.setId(id);
		int del_id= Integer.valueOf(id).intValue();
		System.out.print(del_id);
		foodStyle = foodStyleService.queryFoodStyleById(del_id);
		if(foodStyle!=null){
			return "query";
		}else{
			return "queryInput";
		}
	}
	
	/**
	 * 更新菜品
	 * @return
	 */
	public String updateFoodStyle(){
		foodStyle.setId(foodStyle.getId());
		foodStyle.setFoodStyleId(foodStyleId);
		foodStyle.setStyleName(styleName);
		if(foodStyle.getStyleName() != null){
			foodStyle.setStyleName(foodStyle.getStyleName());
			System.out.println("\nfoodName!=null food.getFoodStyleName="+foodStyle.getStyleName());
		}else{
			String styleName = foodStyleService.queryFoodStyleById(foodStyle.getId()).getStyleName();
			foodStyle.setStyleName(styleName);
			System.out.println("\nstyleName==null foodStyle.getStyleName="+styleName);
		}
		if(foodStyleService.updateFoodStyle(foodStyle)){
			return "addFoodSuccess";
		}else{
			return "query";
		}
	}
	
	/**
	 * 检查是菜名是不是已经存在
	 * 
	 */
	public void checkFoodStyleName(){
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = response.getWriter();
		    if(foodStyleService.checkFoodStyleName(styleName)){
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


	public String getFoodStyleId() {
		return foodStyleId;
	}


	public void setFoodStyleId(String foodStyleId) {
		this.foodStyleId = foodStyleId;
	}


	public String getStyleName() {
		return styleName;
	}


	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}


	public FoodStyle getFoodStyle() {
		return foodStyle;
	}


	public void setFoodStyle(FoodStyle foodStyle) {
		this.foodStyle = foodStyle;
	}


	public FoodStyleDao getFoodStyleDao() {
		return foodStyleDao;
	}


	public void setFoodStyleDao(FoodStyleDao foodStyleDao) {
		this.foodStyleDao = foodStyleDao;
	}


	public FoodStyleService getFoodStyleService() {
		return foodStyleService;
	}


	public void setFoodStyleService(FoodStyleService foodStyleService) {
		this.foodStyleService = foodStyleService;
	} 
}