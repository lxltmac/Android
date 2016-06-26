package lin.linorder.service;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import lin.linorder.dao.StaffDao;
import lin.linorder.models.Staff;

public class StaffService {
	private StaffDao staffDao;
	
	public boolean login(String name,String password){
		Staff staff = staffDao.loadUser(name);
		if(staffDao.loginCheck(name, password) && staff.getFreeBuff() == 0 && staff.getDeleteFlag() == 0){
			Map m;
			m=ActionContext.getContext().getSession();
			m.put("name", name);
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Android�û��˵ĵ�½
	 * @param user
	 * @return
	 */
	public Staff loginAndroid(String name, String password) {
		Staff staff = staffDao.loadUser(name);
//		System.out.println("userservice_login: user="+user);
		if(staff != null){
			//�˶����룬�Ƿ񶳽��ɾ��
			if(staff.getPassword().equals(password)){
				return staff;
			}
		}
		return null;
	}
	
	
	/**
	 * ��ѯ����
	 * @return
	 */
	public List<Staff> queryAllUsers(){
		List<Staff> staffs;
		staffs=staffDao.queryAllUsers();
	    return staffs;
	}
	
	/**
	 * ��ҳ��ѯ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
		public List<Staff> queryByPage(int pageNo,int pageSize){
			List<Staff> staffs;
			staffs=staffDao.queryByPage(pageNo,pageSize);
			return staffs;
		}
	
		/**
		 * ����û�
		 * @param staff
		 * @return
		 */
		public boolean addUser(Staff staff){
			if(staffDao.addUser(staff)){
				return true;
			}else{
				return false;
			}
		}	
	
		/**
		 * ɾ��
		 * @param id
		 * @return
		 */
		public boolean deleteUserById(int id){
			if(staffDao.deleteUserById(id)){
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
		public Staff queryUserById(int id){
			Staff staff;
			staff = staffDao.queryUserById(id);
			return staff;
		}
		
		/**
		 * ���²���
		 * @param newStaff
		 * @return
		 */
		public boolean updateUser(Staff staff){
			return staffDao.updateUser(staff);
		}
		
		/**
		 * ����name��ȡ��Ϣ
		 * @param name
		 * @return
		 */
		public Staff queryUserByName(String name){
			Staff staff;
			staff = staffDao.queryUserByName(name);
			return staff;
		}
		/**
		 * ����û��Ƿ����
		 * @return
		 */
		public boolean checkName(String name){
			Staff staff = staffDao.loadUser(name);
			if(staff == null){
				return true;
			}else{
				return false;
			}
		}
	public StaffDao getStaffDao() {
		return staffDao;
	}

	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}
	
}
