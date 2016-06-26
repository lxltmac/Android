package lin.linorder.action.table;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import lin.linorder.dao.table.TableDao;
import lin.linorder.models.table.Table;
import lin.linorder.service.table.TableService;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class TableAction extends ActionSupport {
	private int id;
	private String tableName;
	private String tableInfo;
	private String tableNum;
	 
	private Table table;
	private TableDao tableDao;
	private TableService tableService;
	
	HttpServletRequest request;
	HttpSession session;
	
	public TableAction(){
		
	}
	
	/**
	 * �������
	 * @return
	 */
	public String addTable(){
		table.setId(id);
		table.setTableInfo(tableInfo);
		table.setTableName(tableName);
		table.setTableNum(tableNum);
		
		if(tableService.addTable(table)){
			return "addTableSuccess";
		}else{
		    return "addTableInput";
		}
	}
	
	/**
	 * ɾ������
	 * @return
	 */
	public void deleteTable(){
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = response.getWriter();
			table.setId(id);
			int del_id= Integer.valueOf(id).intValue();
			if(tableService.deleteTableById(del_id)){
				System.out.print(del_id);
	//			return "addUserSuccess";
				out.print("true");
			}else{
	//			return "userShowAction";
				out.print("false");
			}
			out.flush();
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * ����id��������
	 * @return
	 */
	public String queryTable(){
		table.setId(id);
		int del_id= Integer.valueOf(id).intValue();
		System.out.print(del_id);
		table = tableService.queryTableById(del_id);
		if(table!=null){
			return "query";
		}else{
			return "queryInput";
		}
	}
	
	/**
	 * ��������
	 * @return
	 */
	public String updateTable(){
		table.setId(table.getId());
		table.setTableInfo(tableInfo);
		table.setTableName(tableName);
		table.setTableNum(tableNum);
		
		if(tableService.updateTable(table)){
			return "addTableSuccess";
		}else{
			return "query";
		}
	}
	
	/**
	 * ��������ǲ����Ѿ�����
	 * 
	 */
	public void checkTableName(){
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = response.getWriter();
		    if(tableService.checkTablename(tableName)){
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
	
	/**
	 * ��������ǲ����Ѿ�����
	 * 
	 */
	public void checkTableNum(){
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = response.getWriter();
		    if(tableService.checkTablenum(tableNum)){
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

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public TableDao getTableDao() {
		return tableDao;
	}

	public void setTableDao(TableDao tableDao) {
		this.tableDao = tableDao;
	}

	public TableService getTableService() {
		return tableService;
	}

	public void setTableService(TableService tableService) {
		this.tableService = tableService;
	}
	
	
}
