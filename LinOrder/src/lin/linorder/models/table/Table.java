package lin.linorder.models.table;

public class Table {
	private int id;
	private String tableName;
	private String tableInfo;
	private String tableNum;
	
	private Table(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableInfo() {
		return tableInfo;
	}

	public void setTableInfo(String tableInfo) {
		this.tableInfo = tableInfo;
	}

	public String getTableNum() {
		return tableNum;
	}

	public void setTableNum(String tableNum) {
		this.tableNum = tableNum;
	}
	


}
