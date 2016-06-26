package lin.linorder.models.goods;

import net.sf.json.JSONString;

public class Food implements JSONString  {
	private int id;
	private String foodName;//��Ʒ����
	private String description;//��Ʒ������
	private String img;
	private String price;
	private FoodStyle foodStyle;//��ϵ
//	private String foodStyleId;
	
	public Food(){
		
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public FoodStyle getFoodStyle() {
		return foodStyle;
	}

	public void setFoodStyle(FoodStyle foodStyle) {
		this.foodStyle = foodStyle;
	}
	
//	public String getFoodStyleId() {
//		//foodStyleId = foodStyle.getFoodStyleId();
//		return foodStyleId;
//	}
//
//	public void setFoodStyleId(String foodStyleId) {
//		this.foodStyleId = foodStyleId;
//		System.out.println("food==="+foodStyleId);
//	}

		//����json���hibernate�м��������ӳټ�������
		@Override
		public String toJSONString() {
			// TODO Auto-generated method stub
			return "{id:'"+id+"',foodName:'"+foodName+"',description:'"+description+"',img:'"+img+"',price:'"+price+"',foodStyle:'"+foodStyle+"',foodStyleId:'"+foodStyle.getFoodStyleId()+"'}";
		}
}
