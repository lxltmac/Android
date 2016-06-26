package lin.linorder.dao.table;

import java.util.List;

import lin.linorder.models.table.Table;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TableDao {
	private SessionFactory sessionFactory;
	/**
	 * ��������
	 * @param userName
	 * @return
	 */
	public Table loadTable(String tableName) {
		try{
			Session session = sessionFactory.openSession();
			String queryString = "from Table where tableName=?";
			Query queryObject = session.createQuery(queryString);
			queryObject.setParameter(0, tableName);
			List<?> list = queryObject.list();
			session.close();
			if(list.size() > 0){
				Table table = (Table)list.get(0);
				return table;
			}else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * ���ű���
	 * @param tableNum
	 * @return
	 */
	public Table loadTableNum(String tableNum) {
		try{
			Session session = sessionFactory.openSession();
			String queryString = "from Table where tableNum=?";
			Query queryObject = session.createQuery(queryString);
			queryObject.setParameter(0, tableNum);
			List<?> list = queryObject.list();
			session.close();
			if(list.size() > 0){
				Table table = (Table)list.get(0);
				return table;
			}else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * �������
	 * @param table
	 * @return
	 */
	public boolean addTable(Table table){
		try{
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction(); 
			int row = Integer.parseInt(session.save(table).toString());
			transaction.commit();
			session.close();
			if(row > 0){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * ����idɾ������
	 * @param id
	 * @return
	 */
	public boolean deleteTableById(int id){
		//����session
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Table where id=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, id);
			List<Table> list=queryObject.list();
			if(list.size()>0){
				transaction=session.beginTransaction();
				for(int i=0;i<list.size();i++){
					Table table=list.get(i);
					session.delete(table);
				}
				transaction.commit();
				session.close();
				return true;
			}else{
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * ����id��������
	 * @param id
	 * @return
	 */
	public Table queryTableById(int id){
		//session
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Table where id=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, id);
			List<Table> list=queryObject.list();
			Table table=list.get(0);
			session.close();
			return table;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * ��������
	 * @param newTable
	 * @return
	 */
	public boolean updateTable(Table table){
		//session
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
				transaction=session.beginTransaction();
				session.update(table);
				transaction.commit();
				session.close();
				return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * ��ѯ
	 * @return
	 */
	public List<Table> queryAllTables(){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Table";
			Query queryObject=session.createQuery(queryString);
			List<Table> list=queryObject.list();
			session.close();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * ��ҳ��ѯ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Table> queryByPage(int pageNo,int pageSize){
		//session
		Session session=null;
		String hql="from Table ";
		try{
			session=sessionFactory.openSession();
			Query queryObject = session.createQuery(hql);
			queryObject.setFirstResult((pageNo-1)*pageSize); //
			queryObject.setMaxResults(pageSize); //
			List<Table> list=queryObject.list();
			session.close();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
		
}
