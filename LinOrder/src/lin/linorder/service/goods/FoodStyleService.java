package lin.linorder.service.goods;

import java.util.List;

import lin.linorder.dao.goods.FoodStyleDao;
import lin.linorder.models.goods.FoodStyle;

public class FoodStyleService {
	private FoodStyleDao foodStyleDao;
	
	/**
	 * 菜系添加
	 * @param food
	 * @return
	 */
	public boolean addFoodStyle(FoodStyle foodStyle){
		return foodStyleDao.addFoodStyle(foodStyle);
	}

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public boolean deleteFoodStyleById(int id){
		if(foodStyleDao.deleteFoodStyleById(id)){
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
	public FoodStyle queryFoodStyleById(int id){
		FoodStyle foodStyle;
		foodStyle = foodStyleDao.queryFoodStyleById(id);
		return foodStyle;
	}
	/**
	 * 更新操作
	 * @param newFood
	 * @return
	 */
	public boolean updateFoodStyle(FoodStyle foodStyle){
		return foodStyleDao.updateFoodStyle(foodStyle);
	}
	
	/**
	 * 查询数据
	 * @return
	 */
	public List<FoodStyle> queryAllFoodStyles(){
		List<FoodStyle> foodStyles;
		foodStyles=foodStyleDao.queryAllFoodStyles();
	    return foodStyles;
	}
	
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
		public List<FoodStyle> queryByPage(int pageNo,int pageSize){
			List<FoodStyle> foodStyles;
			foodStyles=foodStyleDao.queryByPage(pageNo,pageSize);
			return foodStyles;
		}
	
	/**
	 * 检查菜名是否存在
	 * @return
	 */
	public boolean checkFoodStyleName(String styleName){
		FoodStyle foodStyle = foodStyleDao.loadFoodStyle(styleName);
		if(foodStyle == null){
			return true;
		}else{
			return false;
		}
	}

	public FoodStyleDao getFoodStyleDao() {
		return foodStyleDao;
	}

	public void setFoodStyleDao(FoodStyleDao foodStyleDao) {
		this.foodStyleDao = foodStyleDao;
	}
	
	
}
