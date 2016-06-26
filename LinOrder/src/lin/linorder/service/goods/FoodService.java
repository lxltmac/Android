package lin.linorder.service.goods;

import java.util.List;

import lin.linorder.dao.goods.FoodDao;
import lin.linorder.models.City;
import lin.linorder.models.Province;
import lin.linorder.models.goods.Food;
import lin.linorder.models.goods.FoodStyle;

public class FoodService {
	private FoodDao foodDao;
	
	/**
	 * 菜品添加
	 * @param food
	 * @return
	 */
	public boolean addFood(Food food){
		return foodDao.addFood(food);
	}

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public boolean deleteFoodById(int id){
		if(foodDao.deleteFoodById(id)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 根据id获取信息
	 * @param id
	 * @return
	 */
	public Food queryFoodById(int id){
		Food food;
		food = foodDao.queryFoodById(id);
		return food;
	}
	/**
	 * 更新操作
	 * @param newFood
	 * @return
	 */
	public boolean updateFood(Food food){
		return foodDao.updateFood(food);
	}
	
	/**
	 * 查询数据
	 * @return
	 */
	public List<Food> queryAllFoods(){
		List<Food> foods;
		foods=foodDao.queryAllFoods();
	    return foods;
	}
	
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
		public List<Food> queryByPage(int pageNo,int pageSize){
			List<Food> foods;
			foods=foodDao.queryByPage(pageNo,pageSize);
			return foods;
		}
	
	/**
	 * 检查菜名是否存在
	 * @return
	 */
	public boolean checkFoodName(String foodName){
		Food food = foodDao.loadFood(foodName);
		if(food == null){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 读取菜系
	 * @return
	 */
	public List<?> getFoodStyles(){
		System.out.println("foodservice_getfoodStyles: in ");
		List<?> foodStyles = foodDao.loadFoodStyle();
		System.out.println("lxl"+foodStyles);
		return foodStyles;
	}
	
	/**
	 * 通过id读取菜系
	 * @param foodStyleId
	 * @return
	 */
	public FoodStyle getFoodStyle(String foodStyleId){
		return foodDao.loadFoodStyle(foodStyleId);
	}
	
	/**
	 * 根据菜系ID读取菜品
	 * @param foodStyleId
	 * @return
	 */
	public List<?> getFoods(String foodStyleId){
		System.out.println("foodservice_foods: in ");
		FoodStyle foodStyle= foodDao.loadFoodStyle(foodStyleId);
		System.out.println("foodservice_foods="+foodStyle.getFoods());
		return foodStyle.getFoods();
	}
	/**
	 * 根据菜品ID读取菜品
	 * @param foodId
	 * @return
	 */
	public Food getFood(String id){
		System.out.println("foodservice_foods: in ");
		Food food = foodDao.loadFoods(id);
		System.out.println("菜品"+food);
		return food;
	}
	
	
	public FoodDao getFoodDao() {
		return foodDao;
	}

	public void setFoodDao(FoodDao foodDao) {
		this.foodDao = foodDao;
	}
	
}
