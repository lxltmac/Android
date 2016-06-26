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
	 * Android用户端的登陆
	 * @param user
	 * @return
	 */
	public Staff loginAndroid(String name, String password) {
		Staff staff = staffDao.loadUser(name);
//		System.out.println("userservice_login: user="+user);
		if(staff != null){
			//核对密码，是否冻结和删除
			if(staff.getPassword().equals(password)){
				return staff;
			}
		}
		return null;
	}
	
	
	/**
	 * 查询数据
	 * @return
	 */
	public List<Staff> queryAllUsers(){
		List<Staff> staffs;
		staffs=staffDao.queryAllUsers();
	    return staffs;
	}
	
	/**
	 * 分页查询
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
		 * 添加用户
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
		 * 删除
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
		 * 根据id获取信息
		 * @param id
		 * @return
		 */
		public Staff queryUserById(int id){
			Staff staff;
			staff = staffDao.queryUserById(id);
			return staff;
		}
		
		/**
		 * 更新操作
		 * @param newStaff
		 * @return
		 */
		public boolean updateUser(Staff staff){
			return staffDao.updateUser(staff);
		}
		
		/**
		 * 根据name获取信息
		 * @param name
		 * @return
		 */
		public Staff queryUserByName(String name){
			Staff staff;
			staff = staffDao.queryUserByName(name);
			return staff;
		}
		/**
		 * 检查用户是否存在
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
