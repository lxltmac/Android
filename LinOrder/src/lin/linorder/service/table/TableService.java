package lin.linorder.service.table;

import java.util.List;

import lin.linorder.dao.table.TableDao;
import lin.linorder.models.table.Table;



public class TableService {
	private TableDao tableDao;
	
	/**
	 * �������
	 * @param table
	 * @return
	 */
	public boolean addTable(Table table){
		return tableDao.addTable(table);
	}

	/**
	 * ɾ��
	 * @param id
	 * @return
	 */
	public boolean deleteTableById(int id){
		if(tableDao.deleteTableById(id)){
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
	public Table queryTableById(int id){
		Table table;
		table = tableDao.queryTableById(id);
		return table;
	}
	/**
	 * ���²���
	 * @param newTable
	 * @return
	 */
	public boolean updateTable(Table table){
		return tableDao.updateTable(table);
	}
	
	/**
	 * ��ѯ����
	 * @return
	 */
	public List<Table> queryAllTables(){
		List<Table> tables;
		tables=tableDao.queryAllTables();
	    return tables;
	}
	
	/**
	 * ��ҳ��ѯ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
		public List<Table> queryByPage(int pageNo,int pageSize){
			List<Table> tables;
			tables=tableDao.queryByPage(pageNo,pageSize);
			return tables;
		}
	
	/**
	 * ��鵱ǰ�����Ƿ����
	 * @return
	 */
	public boolean checkTablename(String tableName){
		Table table = tableDao.loadTable(tableName);
		if(table == null){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * ��鵱ǰ�����Ƿ����
	 * @return
	 */
	public boolean checkTablenum(String tableNum){
		Table table = tableDao.loadTableNum(tableNum);
		if(table == null){
			return true;
		}else{
			return false;
		}
	}

	public TableDao getTableDao() {
		return tableDao;
	}

	public void setTableDao(TableDao tableDao) {
		this.tableDao = tableDao;
	}

	
	
	
}
