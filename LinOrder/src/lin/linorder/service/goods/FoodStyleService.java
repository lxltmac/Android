package lin.linorder.service.goods;

import java.util.List;

import lin.linorder.dao.goods.FoodStyleDao;
import lin.linorder.models.goods.FoodStyle;

public class FoodStyleService {
	private FoodStyleDao foodStyleDao;
	
	/**
	 * ��ϵ���
	 * @param food
	 * @return
	 */
	public boolean addFoodStyle(FoodStyle foodStyle){
		return foodStyleDao.addFoodStyle(foodStyle);
	}

	/**
	 * ɾ��
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
	 * ����id��ȡ��Ϣ
	 * @param id
	 * @return
	 */
	public FoodStyle queryFoodStyleById(int id){
		FoodStyle foodStyle;
		foodStyle = foodStyleDao.queryFoodStyleById(id);
		return foodStyle;
	}
	/**
	 * ���²���
	 * @param newFood
	 * @return
	 */
	public boolean updateFoodStyle(FoodStyle foodStyle){
		return foodStyleDao.updateFoodStyle(foodStyle);
	}
	
	/**
	 * ��ѯ����
	 * @return
	 */
	public List<FoodStyle> queryAllFoodStyles(){
		List<FoodStyle> foodStyles;
		foodStyles=foodStyleDao.queryAllFoodStyles();
	    return foodStyles;
	}
	
	/**
	 * ��ҳ��ѯ
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
	 * �������Ƿ����
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
