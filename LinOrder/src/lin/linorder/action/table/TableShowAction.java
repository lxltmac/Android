package lin.linorder.action.table;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lin.linorder.models.table.Table;
import lin.linorder.service.table.TableService;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.mail.iap.Response;

@SuppressWarnings("serial")
public class TableShowAction extends ActionSupport implements ServletRequestAware {
	List<Table> tables;
	private int id; //界面显示数据的索引
	private final int pageSize=17; //每页显示记录的个数
	private int pageNo=1; //计数器
	private int currentPage; //当前页
	private int totalPage; //总页数
	
	private Table table;
	private TableService tableService;
	
	private HttpSession session;
	private HttpServletRequest request;
	
	public TableShowAction() {
		
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public List<Table> getTables() {
		return tables;
	}
	public void setTables(List<Table> tables) {
		this.tables = tables;
	}
	public Table getTable() {
		return table;
	}
	public void setTable(Table table) {
		this.table = table;
	}
	public TableService getTableService() {
		return tableService;
	}
	public void setTableService(TableService tableService) {
		this.tableService = tableService;
	}
	public String show() throws Exception{
		ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
		tables=tableService.queryAllTables();
		//计算总页数
		if(tables.size()%pageSize==0){
			totalPage=tables.size()/pageSize;
		}else{
			totalPage=tables.size()/pageSize+1;
		}
		if(pageNo<=0){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo=totalPage;
		}
		//根据当前页查询要在该页上显示的数据
		tables=tableService.queryByPage(pageNo,pageSize);
		currentPage=pageNo;
			return SUCCESS;
	}
	/**
	 * json
	 * @return
	 * @throws Exception
	 */
	public String showJson() throws Exception{
		tables=tableService.queryAllTables();
		JSONArray arr = JSONArray.fromObject(tables);
		String returnStr = arr.toString();
		//页面上打印出JSON
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(returnStr);
			out.flush();
			out.close();
			System.out.println(returnStr);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
