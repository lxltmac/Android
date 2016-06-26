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
	 * ��Ʒ���
	 * @param food
	 * @return
	 */
	public boolean addFood(Food food){
		return foodDao.addFood(food);
	}

	/**
	 * ɾ��
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
	 * ����id��ȡ��Ϣ
	 * @param id
	 * @return
	 */
	public Food queryFoodById(int id){
		Food food;
		food = foodDao.queryFoodById(id);
		return food;
	}
	/**
	 * ���²���
	 * @param newFood
	 * @return
	 */
	public boolean updateFood(Food food){
		return foodDao.updateFood(food);
	}
	
	/**
	 * ��ѯ����
	 * @return
	 */
	public List<Food> queryAllFoods(){
		List<Food> foods;
		foods=foodDao.queryAllFoods();
	    return foods;
	}
	
	/**
	 * ��ҳ��ѯ
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
	 * �������Ƿ����
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
	 * ��ȡ��ϵ
	 * @return
	 */
	public List<?> getFoodStyles(){
		System.out.println("foodservice_getfoodStyles: in ");
		List<?> foodStyles = foodDao.loadFoodStyle();
		System.out.println("lxl"+foodStyles);
		return foodStyles;
	}
	
	/**
	 * ͨ��id��ȡ��ϵ
	 * @param foodStyleId
	 * @return
	 */
	public FoodStyle getFoodStyle(String foodStyleId){
		return foodDao.loadFoodStyle(foodStyleId);
	}
	
	/**
	 * ���ݲ�ϵID��ȡ��Ʒ
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
	 * ���ݲ�ƷID��ȡ��Ʒ
	 * @param foodId
	 * @return
	 */
	public Food getFood(String id){
		System.out.println("foodservice_foods: in ");
		Food food = foodDao.loadFoods(id);
		System.out.println("��Ʒ"+food);
		return food;
	}
	
	
	public FoodDao getFoodDao() {
		return foodDao;
	}

	public void setFoodDao(FoodDao foodDao) {
		this.foodDao = foodDao;
	}
	
}
