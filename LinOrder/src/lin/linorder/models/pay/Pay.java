package lin.linorder.models.pay;

public class Pay {
	private int id;
	private String payTableNum;
	private String payPrice;
	private int year;
	private int month;
	private int day;
	
	private Pay(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPayTableNum() {
		return payTableNum;
	}

	public void setPayTableNum(String payTableNum) {
		this.payTableNum = payTableNum;
	}

	public String getPayPrice() {
		return payPrice;
	}

	public void setPayPrice(String payPrice) {
		this.payPrice = payPrice;
	}


	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}


	
}
