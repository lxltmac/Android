package lin.linorder.models.goods;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONString;


public class FoodStyle implements JSONString {
	private int id;
	private String foodStyleId;
	private String styleName;
	private List<Food> foods = new ArrayList<Food>();
	
	public FoodStyle(){
		
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

	public List<Food> getFoods() {
		return foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toJSONString() {
		// TODO Auto-generated method stub
		return "{id:'"+id+"',foodStyleId:'"+foodStyleId+"',styleName:'"+styleName+"'}";
	}
}
