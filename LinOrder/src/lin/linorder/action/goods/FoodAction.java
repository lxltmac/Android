package lin.linorder.action.goods;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;

import lin.linorder.dao.goods.FoodDao;
import lin.linorder.models.goods.Food;
import lin.linorder.service.goods.FoodService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class FoodAction extends ActionSupport {
	private int id;
	private String foodName;
	private String description;
	private String img;
	private String price;
	private String foodStyleId;
	private String foodStyle;
	
	private Food food;
	private FoodDao foodDao;
	private FoodService foodService;
	
	private static final int BUFFER_SIZE = 40*40;
	private File upload;				//图片文件
	private String uploadContentType;	//图片文本类型
	private String uploadFileName;		//图片名字
	private String savePath;			//图片存储路径
	
	private HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session;
	
	public FoodAction(){
		
	}
	
	/**
	 * 图片文件上传
	 */
	private static void copy(File source, File target){
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			//实例化输入流
			inputStream = new BufferedInputStream(new FileInputStream(source), BUFFER_SIZE);
			//实例化输出流
			outputStream = new BufferedOutputStream(new FileOutputStream(target), BUFFER_SIZE);
			byte[] buffer = new byte[BUFFER_SIZE];
			int length = 0;
			while((length = inputStream.read(buffer)) > 0){
				//字节形式写入
				outputStream.write(buffer, 0, length);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(null!=inputStream){
				try {
					inputStream.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if(null!=outputStream){
				try {
					outputStream.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 添加菜图
	 * @return
	 */
	public String addFood(){
		food.setId(id);
		food.setFoodName(foodName);
		food.setDescription(description);
		food.setPrice(price);
		food.setFoodStyle(foodService.getFoodStyle(foodStyle));
		//图片上传
		String path = ServletActionContext.getServletContext().getRealPath(this.getSavePath()) + "\\"  + this.getUploadFileName();
		File target = new File(path);
		copy(this.upload, target);
		//food.setImg("http://localhost:8080/LinOrder/image/foodImg/"+this.uploadFileName);
		food.setImg(this.uploadFileName);
		System.out.println("路径："+food.getImg());
		
		if(foodService.addFood(food)){
			return "addFoodSuccess";
		}else{
		    return "addFoodInput";
		}
	}
	
	/**
	 * 删除菜品
	 * @return
	 */
	public void deleteFood(){
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = response.getWriter();
			food.setId(id);
			int del_id= Integer.valueOf(id).intValue();
			if(foodService.deleteFoodById(del_id)){
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
	public String queryFood(){
		food.setId(id);
		int del_id= Integer.valueOf(id).intValue();
		System.out.print(del_id);
		food = foodService.queryFoodById(del_id);
		if(food!=null){
			return "query";
		}else{
			return "queryInput";
		}
	}
	
	/**
	 * 更新菜品
	 * @return
	 */
	public String updateFood(){
		food.setId(food.getId());
		food.setFoodName(foodName);
		food.setPrice(price);
		if(food.getFoodName() != null){
			food.setFoodName(food.getFoodName());
			System.out.println("\nfoodName!=null food.getFoodName="+food.getFoodName());
		}else{
			String foodName = foodService.queryFoodById(food.getId()).getFoodName();
			food.setFoodName(foodName);
			System.out.println("\nfoodName==null food.getFoodName="+foodName);
		}
		food.setDescription(description);
		food.setFoodStyle(foodService.getFoodStyle(foodStyle));
		System.out.println("");
		//图片更新
		String path = ServletActionContext.getServletContext().getRealPath(this.getSavePath()) + "\\"  + this.getUploadFileName();
		File target = new File(path);
		if(upload != null){
			copy(this.upload, target);
		}
		if(upload != null){
			//food.setImg("http://localhost:8080/LinOrder/image/foodImg/"+this.uploadFileName);
			food.setImg(this.uploadFileName);
			System.out.println("\nipload!=null food.getImg()="+food.getImg());
		}else{
			String img = foodService.queryFoodById(food.getId()).getImg();
			food.setImg(img);
			System.out.println("\nupload == null food.getImg()="+img);
		}
		
		if(foodService.updateFood(food)){
			return "addFoodSuccess";
		}else{
			return "query";
		}
	}
	
	/**
	 * 检查是菜名是不是已经存在
	 * 
	 */
	public void checkFoodName(){
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = response.getWriter();
		    if(foodService.checkFoodName(foodName)){
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
	
	//初始化菜品展示页面
	public void initShowFood(){
		System.out.println("initShowFood: in");
		List<?> foodStyles = foodService.getFoodStyles();
		request.setAttribute("foodStyles", foodStyles);
		System.out.println("点击菜系"+foodStyles);
	}
	
	/**
	 * 获取菜品json
	 */
	public void getFoods(){
		/* 获得response */
        HttpServletResponse response = ServletActionContext.getResponse();
        /*设置字符集为'UTF-8'*/
        response.setCharacterEncoding("UTF-8");
		
		List<?> foods = foodService.getFoods(foodStyleId);
		System.out.println("foodaction_getfood: in foods="+foods);
		JsonConfig jsonConfig = new JsonConfig();  //建立配置文件
		jsonConfig.setIgnoreDefaultExcludes(false);  //设置默认忽略
		jsonConfig.setExcludes(new String[]{"foodStyle","hibernateLazyInitializer"}); //设置忽略字段
		JSONArray jsonFoods = JSONArray.fromObject(foods, jsonConfig);
		System.out.println(jsonFoods);
		try {
			PrintWriter out = response.getWriter();
			out.print(jsonFoods);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}

	public FoodDao getFoodDao() {
		return foodDao;
	}
	public void setFoodDao(FoodDao foodDao) {
		this.foodDao = foodDao;
	}
	public FoodService getFoodService() {
		return foodService;
	}
	public void setFoodService(FoodService foodService) {
		this.foodService = foodService;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getFoodStyleId() {
		return foodStyleId;
	}

	public void setFoodStyleId(String foodStyleId) {
		this.foodStyleId = foodStyleId;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getFoodStyle() {
		return foodStyle;
	}

	public void setFoodStyle(String foodStyle) {
		this.foodStyle = foodStyle;
	}
	
	
}
